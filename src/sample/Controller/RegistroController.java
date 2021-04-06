package sample.Controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class RegistroController implements Initializable {

    @FXML
    private JFXTextField inputSemana_1, inputSemana_2, inputSemana_3;

    @FXML
    private JFXTextField inputMonto_1, inputMonto_2, inputMonto_3;

    @FXML
    private JFXTextField inputRazonCobrar,inputRazonPagar, inputDescripcionBanco;

    private ObservableList<JFXTextField> numeric;
    private ObservableList<JFXTextField> text;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        numeric = FXCollections.observableArrayList();
        numeric.addAll(inputSemana_3,inputSemana_2,inputSemana_1,inputMonto_3,inputMonto_2,inputMonto_1);
        onlyNumeric();
        text = FXCollections.observableArrayList();
        text.addAll(inputDescripcionBanco,inputRazonPagar,inputRazonCobrar);
    }

    private void onlyNumeric(){
        numeric.forEach((node)-> node.textProperty().addListener((observableValue, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                node.setText(newValue.replaceAll("[^\\d]", ""));
            }
        }));
    }

    @FXML
    void MouseClickedSaveBanco(MouseEvent event) {

    }

    @FXML
    void MouseClickedSaveCobrar(MouseEvent event) {

    }

    @FXML
    void MouseClickedSavePagar(MouseEvent event) {

    }

    public void clean(){
        numeric.forEach((node)-> node.setText(""));
        text.forEach((node)-> node.setText(null));
    }
}
