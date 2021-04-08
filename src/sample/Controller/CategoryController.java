package sample.Controller;


import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class CategoryController implements Initializable {

    @FXML
    private JFXComboBox<String> boxClasificacion;

    @FXML
    private JFXTextField inputCategoria, inputSubCategoria;

    @FXML
    private TableColumn<?, ?> colClasificacion, colCategoria, colSubCategoria;

   /* @FXML
    private TableView< > tableViewCategoria;*/

//    private Person selected;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        colClasificacion.setCellValueFactory(new PropertyValueFactory<>("clasificacion"));
        colSubCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        colCategoria.setCellValueFactory(new PropertyValueFactory<>("subCategoria"));
//        tableViewCategoria.getItems().addAll();
    }

    // metodo que se aactiva al seleccionar el boton guardar o Edit
    @FXML
    void MouseClickedSaveAndEdit(MouseEvent event) {
        /*if(selected != null){

        }else{

        }*/
        clean();
    }

    //metodo que se activa al seleccionar algo en la tabla
    @FXML
    void MouseClickeSelect(MouseEvent event) {
        /*selected = tableViewCategoria.getSelectionModel().getSelectedItem();
        if(selected != null){

        }*/
    }

    @FXML
    void MouseClickedClearSelection(MouseEvent event) {
        clean();
    }

    public void clean(){
//        tableViewCategoria.getSelectionModel().clearSelection();
        boxClasificacion.getSelectionModel().clearSelection();
        inputCategoria.setText(null);
        inputSubCategoria.setText(null);
    }

}
