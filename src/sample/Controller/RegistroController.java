package sample.Controller;

import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.MouseEvent;
import javafx.util.converter.IntegerStringConverter;
import sample.Util.Utils;

import java.net.URL;
import java.util.ResourceBundle;

public class RegistroController implements Initializable {

    @FXML
    private JFXTextField inputSemana_1,  inputSemana_2;

    @FXML
    private JFXTextField inputMonto_1,  inputMonto_2;

    @FXML
    private JFXTextField inputRazonSocial, inputDescripcionBanco;

    @FXML
    private JFXRadioButton radioCobrar,radioPagar;


    private ObservableList<JFXTextField> numeric ,text;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        numeric = FXCollections.observableArrayList();
        numeric.addAll(inputSemana_2,inputSemana_1,inputMonto_2,inputMonto_1);
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


    }

    @FXML
    void MouseClickedSaveCobrarPagar(MouseEvent event) {

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
    }
}
