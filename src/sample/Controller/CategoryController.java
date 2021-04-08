package sample.Controller;


import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import entity.Clasificacion;
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
import sample.DAOs.ClasificacionDAO;
import sample.DAOs.SubCategoriasDAO;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CategoryController implements Initializable {

    @FXML
    private JFXComboBox<Clasificacion> boxClasificacion;

    @FXML
    private JFXTextField inputCategoria, inputSubCategoria;

    @FXML
    private TableColumn<CategoryTable, String> colClasificacion, colCategoria, colSubCategoria;

    @FXML
    private TableView<CategoryTable> tableViewCategoria;

    private CategoryTable selected;

    private ObservableList<CategoryTable> categoriasList;

    private SubCategoriasDAO subCategoriasDAO;
    private ClasificacionDAO clasificacionDAO;
    List<Clasificacion> clasificacionList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        subCategoriasDAO = new SubCategoriasDAO();
        clasificacionDAO = new ClasificacionDAO();
        categoriasList = FXCollections.observableArrayList();
        colClasificacion.setCellValueFactory(new PropertyValueFactory<>("clasificacion"));
        colSubCategoria.setCellValueFactory(new PropertyValueFactory<>("SubCategoria"));
        colCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        fillTable();
        tableViewCategoria.getItems().addAll(categoriasList);
        fillbox();

    }

    // metodo que se aactiva al seleccionar el boton guardar o Edit
    @FXML
    void MouseClickedSaveAndEdit(MouseEvent event) {
        if(selected != null){
            selected.getSubCategoriaEntity().getId_Categoria().setNombreCategoria(inputCategoria.getText());
            selected.getSubCategoriaEntity().setNombreSubCategoria(inputSubCategoria.getText());
            selected.getSubCategoriaEntity().getId_Categoria().setClasificacion(boxClasificacion.getSelectionModel().getSelectedItem());
            subCategoriasDAO.updateSubCategoria(selected.getSubCategoriaEntity());

        }else{

        }
        clean();
    }

    //metodo que se activa al seleccionar algo en la tabla
    @FXML
    void MouseClickeSelect(MouseEvent event) {
        selected = tableViewCategoria.getSelectionModel().getSelectedItem();
        if(selected != null){
            inputCategoria.setText(selected.getCategoria());
            inputSubCategoria.setText(selected.getSubCategoria());
            Clasificacion clasificacionSelec = checkSelection(selected.getSubCategoriaEntity().getId_Categoria().getClasificacion());
            boxClasificacion.getSelectionModel().select(clasificacionSelec);
        }
    }

    @FXML
    void MouseClickedClearSelection(MouseEvent event) {
        clean();
    }


    private void fillTable(){
        List<SubCategoria> subCategoriaList = subCategoriasDAO.getListSubCategorias();
        List<CategoryTable> categoryTables = new ArrayList<>();
        categoriasList.clear();
        subCategoriaList.forEach((subCategoria -> categoryTables.add(new CategoryTable(subCategoria))));
        categoriasList.addAll(categoryTables);
    }
    private void fillbox(){
        clasificacionList = clasificacionDAO.getListClasificaciones();
        boxClasificacion.getItems().clear();
        boxClasificacion.getItems().addAll(clasificacionList);
    }

    private Clasificacion checkSelection(Clasificacion review){
        Clasificacion correct = null;
        if(!clasificacionList.isEmpty()){
            for (Clasificacion node : clasificacionList) {
                if (node.getNombreClasificacion().equals(review.getNombreClasificacion())) {
                    correct = node;
                }
            }
        }
        return correct;
    }

    public void clean(){
        tableViewCategoria.getSelectionModel().clearSelection();
        boxClasificacion.getSelectionModel().clearSelection();
        inputCategoria.setText(null);
        inputSubCategoria.setText(null);
    }

}
