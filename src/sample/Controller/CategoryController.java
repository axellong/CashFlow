package sample.Controller;


import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import entity.Person;
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

    @FXML
    private TableView<Person> tableViewCategoria;

    private Person selected;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Person person = new Person("HOLA","HOLA","HOLA");
        Person a = new Person("HOLA","HOLA","HOLA");
        colClasificacion.setCellValueFactory(new PropertyValueFactory<>("clasificacion"));
        colSubCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        colCategoria.setCellValueFactory(new PropertyValueFactory<>("subCategoria"));
        tableViewCategoria.getItems().addAll(person,a);
    }

    // metodo que se aactiva al seleccionar el boton guardar o Edit
    @FXML
    void MouseClickedSaveAndEdit(MouseEvent event) {
        if(selected != null){

        }else{

        }
        clean();
    }

    //metodo que se activa al seleccionar algo en la tabla
    @FXML
    void MouseClickeSelect(MouseEvent event) {
        selected = tableViewCategoria.getSelectionModel().getSelectedItem();
        if(selected != null){
            boxClasificacion.getItems().add("HOLA");
            boxClasificacion.getItems().add("HOLA2");
            boxClasificacion.setValue(selected.clasificacion);
            inputCategoria.setText(selected.categoria);
            inputSubCategoria.setText(selected.subCategoria);
        }
    }

    public void clean(){
        tableViewCategoria.getSelectionModel().clearSelection();
        boxClasificacion.getSelectionModel().clearSelection();
        inputCategoria.setText(null);
        inputSubCategoria.setText(null);
    }

}
