package sample.Controller;


import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import entity.Categoria;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import sample.DAOs.CategoriaDAO;

import java.net.URL;
import java.util.ResourceBundle;

public class CategoryController implements Initializable {

    @FXML
    private JFXComboBox<String> boxClasificacion;

    @FXML
    private JFXTextField inputCategoria, inputSubCategoria;

    @FXML
    private TableColumn<Categoria, String> colClasificacion, colCategoria, colSubCategoria;

    @FXML
    private TableView<Categoria> tableViewCategoria;

    private Categoria selected;

    private ObservableList<Categoria> categoriasList;

    private CategoriaDAO categoriaDAO = new CategoriaDAO();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        categoriasList = FXCollections.observableArrayList();
        colClasificacion.setCellValueFactory(new PropertyValueFactory<Categoria,String>("clasificacion"));
        //colSubCategoria.setCellValueFactory(new PropertyValueFactory<Categoria,String>("subcategoria"));
        colCategoria.setCellValueFactory(new PropertyValueFactory<Categoria,String>("nombreCategoria"));
        categoriasList.addAll(categoriaDAO.getListCategorias());
        tableViewCategoria.getItems().addAll(categoriasList);
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

        }
    }

    @FXML
    void MouseClickedClearSelection(MouseEvent event) {
        clean();
    }

    public void clean(){
        tableViewCategoria.getSelectionModel().clearSelection();
        boxClasificacion.getSelectionModel().clearSelection();
        inputCategoria.setText(null);
        inputSubCategoria.setText(null);
    }

}
