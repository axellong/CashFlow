package sample.Controller;


import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import entity.SubCategoria;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import logic.Model.CategoryTable;
import sample.DAOs.SubCategoriasDAO;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CategoryController implements Initializable {

    @FXML
    private JFXComboBox<String> boxClasificacion;

    @FXML
    private JFXTextField inputCategoria, inputSubCategoria;

    @FXML
    private TableColumn<CategoryTable, String> colClasificacion, colCategoria, colSubCategoria;

    @FXML
    private TableView<CategoryTable> tableViewCategoria;

    private CategoryTable selected;

    private ObservableList<CategoryTable> categoriasList;

    private SubCategoriasDAO subCategoriasDAO = new SubCategoriasDAO();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        categoriasList = FXCollections.observableArrayList();
        colClasificacion.setCellValueFactory(new PropertyValueFactory<CategoryTable,String>("clasificacion"));
        colSubCategoria.setCellValueFactory(new PropertyValueFactory<CategoryTable,String>("SubCategoria"));
        colCategoria.setCellValueFactory(new PropertyValueFactory<CategoryTable,String>("categoria"));
        fillTable();
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


    private void fillTable(){
        List<SubCategoria> subCategoriaList = subCategoriasDAO.getListSubCategorias();
        List<CategoryTable> categoryTables = new ArrayList<>();
        subCategoriaList.forEach((subCategoria -> categoryTables.add(new CategoryTable(subCategoria))));
        categoriasList.addAll(categoryTables);
    }

    public void clean(){
        tableViewCategoria.getSelectionModel().clearSelection();
        boxClasificacion.getSelectionModel().clearSelection();
        inputCategoria.setText(null);
        inputSubCategoria.setText(null);
    }

}
