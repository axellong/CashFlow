package sample.Controller;

import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import entity.RegistroIndicadores;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.MouseEvent;
import javafx.util.converter.IntegerStringConverter;
import sample.DAOs.InitializerDAOs;
import sample.DAOs.RegistroIndicadoresDAO;
import sample.Util.Utils;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import static sample.Util.Utils.nullOrEmpty;

public class RegistroController implements Initializable {

    @FXML
    private JFXTextField inputSemana_1,  inputSemana_2;

    @FXML
    private JFXTextField inputMonto_1,  inputMonto_2, inputCuenta;

    @FXML
    private JFXTextField inputRazonSocial, inputDescripcionBanco;

    @FXML
    private JFXRadioButton radioCobrar,radioPagar;


    private ObservableList<JFXTextField> numeric ,text;

    private RegistroIndicadoresDAO registroIndicadoresDAO;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        registroIndicadoresDAO = InitializerDAOs.getInitializerDAOs().getRegistroIndicadoresDAO();
        numeric = FXCollections.observableArrayList();
        numeric.addAll(inputSemana_2,inputSemana_1,inputMonto_2,inputMonto_1,inputCuenta);
        onlyNumeric();
        text = FXCollections.observableArrayList();
        text.addAll(inputDescripcionBanco,inputRazonSocial);
        checkSelection();
    }

    private void onlyNumeric(){
        numeric.forEach((node)-> node.setTextFormatter(new TextFormatter<Integer>(new IntegerStringConverter(), null, Utils.integerFilter)));
    }

    @FXML
    void MouseClickedSaveBanco(MouseEvent event) {
        String semana = inputSemana_2.getText();
        String monto = inputMonto_2.getText();
        String descripcion = inputDescripcionBanco.getText();

        if(!nullOrEmpty(semana) && !nullOrEmpty(monto) && !nullOrEmpty(descripcion)){
            RegistroIndicadores add = new RegistroIndicadores();
            add.setSemana(Integer.parseInt(semana));
            add.setMonto(Double.parseDouble(monto));
            add.setDescripcion(descripcion);
            add.setAnio(LocalDate.now().getYear());
            add.setMes(LocalDate.now().getMonth().name());
            add.setConcepto("Banco");
            registroIndicadoresDAO.saveRegistroIndicador(add);
            clean();
        }
    }

    @FXML
    void MouseClickedSaveCobrarPagar(MouseEvent event) {
        System.out.println("h");
        String cuenta = inputCuenta.getText();
        String semana = inputSemana_1.getText();
        String monto = inputMonto_1.getText();
        String razonSocial = inputRazonSocial.getText();
        boolean pagar = radioPagar.isSelected();
        boolean cobro = radioCobrar.isSelected();
        if(!nullOrEmpty(semana) && !nullOrEmpty(cuenta) && !nullOrEmpty(monto) && !nullOrEmpty(razonSocial) && (pagar || cobro)){
            RegistroIndicadores add = new RegistroIndicadores();
            add.setSemana(Integer.parseInt(semana));
            add.setMonto(Double.parseDouble(monto));
            add.setRazonSocial(razonSocial);
            add.setAnio(LocalDate.now().getYear());
            add.setMes(LocalDate.now().getMonth().name());
            String concepto = pagar ? radioPagar.getText() : radioCobrar.getText();
            add.setConcepto(concepto);
            registroIndicadoresDAO.saveRegistroIndicador(add);
            clean();
        }

    }

    private void checkSelection(){
        radioCobrar.selectedProperty().addListener((ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
            if(radioPagar.isSelected()){
                radioPagar.setSelected(false);
                radioCobrar.setSelected(new_val);
            }
        });
        radioPagar.selectedProperty().addListener((ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
            if(radioCobrar.isSelected()){
                radioCobrar.setSelected(false);
                radioPagar.setSelected(new_val);
            }
        });
    }

    public void clean(){
        numeric.forEach((node)-> node.setText(null));
        text.forEach((node)-> node.setText(null));
        radioPagar.setSelected(false);
        radioCobrar.setSelected(false);
    }
}
