package sample.Controller;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.MouseEvent;
import javafx.util.converter.IntegerStringConverter;
import sample.Util.Utils;
import java.net.URL;
import java.util.ResourceBundle;

public class FlujoController implements Initializable {

    @FXML
    private TableColumn<?, ?> colFecha, colDescripcion, colCategoria, colSubCategoria;

    @FXML
    private JFXCheckBox checkEntrada, checkSalida;

    @FXML
    private JFXComboBox<?> boxCategoria;

    @FXML
    private JFXTextField inputDescripcion, inputCantidad;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        onlyNumeric();
        checkSalida.selectedProperty().addListener((ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
            if(checkEntrada.isSelected()){
                checkEntrada.setSelected(false);
                checkSalida.setSelected(new_val);
            }
        });
        checkEntrada.selectedProperty().addListener((ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
            if(checkSalida.isSelected()){
                checkSalida.setSelected(false);
                checkEntrada.setSelected(new_val);
            }
        });
    }

    @FXML
    void MouseClickedSave(MouseEvent event) {
        clean();
    }

    private void onlyNumeric(){
        inputCantidad.setTextFormatter(new TextFormatter<Integer>(new IntegerStringConverter(), null, Utils.integerFilter));
    }

    public void clean(){
        checkEntrada.setSelected(false);
        checkSalida.setSelected(false);
        boxCategoria.getSelectionModel().clearSelection();
        inputCantidad.setText(null);
        inputDescripcion.setText(null);
    }
}
