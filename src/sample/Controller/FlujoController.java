package sample.Controller;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import entity.RegistroEfectivo;
import entity.SubCategoria;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.converter.IntegerStringConverter;
import logic.Model.Categoria_SubCategoria;
import logic.Model.FlujoTable;
import sample.DAOs.RegistrosEfectivoDAO;
import sample.DAOs.SubCategoriasDAO;
import sample.Util.Utils;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class FlujoController implements Initializable {

    @FXML
    private TableView<FlujoTable> tableViewFlujo;

    @FXML
    private TableColumn<FlujoTable, String> colFecha, colDescripcion, colCategoria, colSubCategoria;

    @FXML
    private JFXCheckBox checkEntrada, checkSalida;

    @FXML
    private JFXComboBox<Categoria_SubCategoria> boxCategoria;

    @FXML
    private JFXTextField inputDescripcion, inputCantidad;

    private SubCategoriasDAO subCategoriasDAO;
    private RegistrosEfectivoDAO registrosEfectivoDAO;

    private ObservableList<FlujoTable> flujoTables;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        subCategoriasDAO = new SubCategoriasDAO();
        registrosEfectivoDAO = new RegistrosEfectivoDAO();
        onlyNumeric();
        checkSelection();
        initializeTable();
    }

    @FXML
    void MouseClickedSave(MouseEvent event) {
        clean();
    }

    private void onlyNumeric(){
        inputCantidad.setTextFormatter(new TextFormatter<>(new IntegerStringConverter(), null, Utils.integerFilter));
    }

    private void initializeTable(){
        flujoTables = FXCollections.observableArrayList();
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        colDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        colCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        colSubCategoria.setCellValueFactory(new PropertyValueFactory<>("SubCategoria"));
        tableViewFlujo.setItems(flujoTables);
    }

    private void fillTable(){
        flujoTables.clear();
        List<RegistroEfectivo> registroEfectivos = registrosEfectivoDAO.getListRegistrosEfectivos();
        List<FlujoTable> flujo = new ArrayList<>();
        registroEfectivos.forEach((node -> flujo.add(new FlujoTable(node))));
        flujoTables.addAll(flujo);
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
        fillTable();
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
