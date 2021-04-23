package sample.Controller;


import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import entity.Categoria;
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
import sample.DAOs.CategoriaDAO;
import sample.DAOs.ClasificacionDAO;
import sample.DAOs.InitializerDAOs;
import sample.DAOs.SubCategoriasDAO;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static sample.Util.Utils.nullOrEmpty;

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
    private CategoriaDAO categoriaDAO;
    List<Clasificacion> clasificacionList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        subCategoriasDAO = InitializerDAOs.getInitializerDAOs().getSubCategoriasDAO();
        clasificacionDAO = InitializerDAOs.getInitializerDAOs().getClasificacionDAO();
        categoriaDAO = InitializerDAOs.getInitializerDAOs().getCategoriaDAO();
        initializeTable();
    }

    // metodo que se aactiva al seleccionar el boton guardar o Edit
    @FXML
    void MouseClickedSaveAndEdit(MouseEvent event) {
        String categoriaStr = inputCategoria.getText();
        String subCategoriaStr = inputSubCategoria.getText();
        Clasificacion clasificacionObj = boxClasificacion.getSelectionModel().getSelectedItem();
        if(!nullOrEmpty(categoriaStr) && !nullOrEmpty(subCategoriaStr) && clasificacionObj != null){
            if(selected != null){
                categoriasList.remove(selected);
                CategoryTable update = selected;
                update.getSubCategoriaEntity().getId_Categoria().setNombreCategoria(categoriaStr);
                update.getSubCategoriaEntity().setNombreSubCategoria(subCategoriaStr);
                update.getSubCategoriaEntity().getId_Categoria().setClasificacion(clasificacionObj);
                subCategoriasDAO.updateSubCategoria(update.getSubCategoriaEntity());
                categoriaDAO.updateCategoria(update.getSubCategoriaEntity().getId_Categoria());
                categoriasList.add(update);
            }else{
                SubCategoria add = new SubCategoria();
                add.setNombreSubCategoria(subCategoriaStr);
                Categoria categoria = new Categoria();
                categoria.setNombreCategoria(categoriaStr);
                categoria.setClasificacion(clasificacionObj);
                add.setId_Categoria(categoria);
                categoriaDAO.saveCategoria(categoria);
                subCategoriasDAO.saveSubCategoria(add);
                categoriasList.add(new CategoryTable(add));
            }
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

    public void initializarData(){
        fillTable();
        fillbox();
    }

    private void initializeTable(){
        categoriasList = FXCollections.observableArrayList();
        colClasificacion.setCellValueFactory(new PropertyValueFactory<>("clasificacion"));
        colSubCategoria.setCellValueFactory(new PropertyValueFactory<>("SubCategoria"));
        colCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        tableViewCategoria.setItems(categoriasList);
    }

    private void fillTable(){
        categoriasList.clear();
        List<SubCategoria> subCategoriaList = subCategoriasDAO.getListSubCategorias();
        List<CategoryTable> categoryTables = new ArrayList<>();
        subCategoriaList.forEach((subCategoria -> categoryTables.add(new CategoryTable(subCategoria))));
        categoriasList.addAll(categoryTables);
    }

    private void fillbox(){
        if(boxClasificacion.getItems().isEmpty()){
            clasificacionList = clasificacionDAO.getListClasificaciones();
            boxClasificacion.getItems().clear();
            boxClasificacion.getItems().addAll(clasificacionList);
        }
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
        selected = null;
        tableViewCategoria.getSelectionModel().clearSelection();
        boxClasificacion.getSelectionModel().clearSelection();
        inputCategoria.setText(null);
        inputSubCategoria.setText(null);
    }

}
