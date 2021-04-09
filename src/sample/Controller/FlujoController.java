package sample.Controller;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import entity.SubCategoria;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.MouseEvent;
import javafx.util.converter.IntegerStringConverter;
import logic.Model.Categoria_SubCategoria;
import sample.DAOs.SubCategoriasDAO;
import sample.Util.Utils;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class FlujoController implements Initializable {

    @FXML
    private TableColumn<?, ?> colFecha, colDescripcion, colCategoria, colSubCategoria;

    @FXML
    private JFXCheckBox checkEntrada, checkSalida;

    @FXML
    private JFXComboBox<Categoria_SubCategoria> boxCategoria;

    @FXML
    private JFXTextField inputDescripcion, inputCantidad;

    private SubCategoriasDAO subCategoriasDAO;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        subCategoriasDAO = new SubCategoriasDAO();
        onlyNumeric();
        checkSelection();
    }

    @FXML
    void MouseClickedSave(MouseEvent event) {
        clean();
    }

    private void onlyNumeric(){
        inputCantidad.setTextFormatter(new TextFormatter<>(new IntegerStringConverter(), null, Utils.integerFilter));
    }

    private void fillBox(){
        if(!boxCategoria.getItems().isEmpty()){
            boxCategoria.getItems().clear();
        }else{
            boxCategoria.setVisibleRowCount(3);
        }
        List<SubCategoria> subCategoriaList = subCategoriasDAO.getListSubCategorias();
        subCategoriaList.forEach((node)-> boxCategoria.getItems().add(new Categoria_SubCategoria(node)));
    }
    public void initializarData(){
        fillBox();
    }

    private void checkSelection(){
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

    public void clean(){
        checkEntrada.setSelected(false);
        checkSalida.setSelected(false);
        boxCategoria.getSelectionModel().clearSelection();
        inputCantidad.setText(null);
        inputDescripcion.setText(null);
    }
}
