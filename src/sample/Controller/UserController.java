package sample.Controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import entity.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.StageStyle;
import logic.Model.UserTable;
import javafx.fxml.Initializable;
import sample.DAOs.UsuarioDAO;

import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class UserController implements  Initializable{

    @FXML
    private TableView<UserTable> tableViewUsuario;

    @FXML
    private TableColumn<UserTable, String> colNombre, colUsuario, colEmail;

    @FXML
    private JFXTextField inputNombre, inputNombredeUsuario, inputEmail;

    @FXML
    private JFXPasswordField inputContrasena;

    @FXML
    private Label labelWarningUsuario;

    private UserTable selected;
    private ObservableList<UserTable> usuariosList;
    private UsuarioDAO usuarioDAO;

    @FXML
    void MouseClickedClearSelection(MouseEvent event) {
        clean();
    }

    @FXML
    void MouseClickedDelete(MouseEvent event) {
        if (selected != null){
            UserTable delete = selected;
            delete.setNombre(inputNombre.getText());
            delete.setNombreUsuario(inputNombredeUsuario.getText());
            delete.setContrasena(inputContrasena.getText());
            delete.setEmail(inputEmail.getText());

            //Dialogo de Confirmacion
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Eliminar Usuario");
            alert.setHeaderText(null);
            alert.initStyle(StageStyle.TRANSPARENT);
            alert.setContentText("¿Desea eliminar este usuario? No son reversibles los cambios");
            Optional<ButtonType> result = alert.showAndWait();
            if(result.get()==ButtonType.OK) {
                usuarioDAO.deleteUsuario(delete.getUsuario());
                //limpiar los campos
                clean();
                //refrescar la tabla
                initializarData();
                alert.close();
            }

        }
    }

    @FXML
    void MouseClickedSaveAndEdit(MouseEvent event) {
        if(selected != null){
            usuariosList.remove(selected);
            UserTable update = selected;
            update.setNombre(inputNombre.getText());
            update.setNombreUsuario(inputNombredeUsuario.getText());
            update.setEmail(inputEmail.getText());
            update.setContrasena(inputContrasena.getText());
            update.setUsuario(new Usuario(update.getUsuario().getIdUsuario(),update.getNombre(), update.getNombreUsuario(), update.getContrasena(), update.getUsuario().isCredencial() ,update.getEmail()));
            usuarioDAO.updateUsuario(update.getUsuario());
            usuariosList.add(update);
            clean();
            initializarData();

        }else{
            Usuario newUser = new Usuario();
            newUser.setNombre(inputNombre.getText());
            newUser.setUsername(inputNombredeUsuario.getText());
            newUser.setPassword(inputContrasena.getText());
            newUser.setCredencial(true);
            newUser.setEmail(inputEmail.getText());

            boolean usuarioEncontrado = searchUser(newUser.getUsername());

            if(!usuarioEncontrado){
                //si el usuario no existe, se agrega el nuevo usuario
                usuarioDAO.saveUsuario(newUser);
                usuariosList.add(new UserTable(newUser));
                labelWarningUsuario.setVisible(false);
                clean();
            }
            else
                labelWarningUsuario.setVisible(true);
        }
    }

    @FXML
    void MouseClickedSelect(MouseEvent event) {
        selected = tableViewUsuario.getSelectionModel().getSelectedItem();
        if(selected != null){
            inputNombre.setText(selected.getNombre());
            inputNombredeUsuario.setText(selected.getNombreUsuario());
            inputContrasena.setText(selected.getContrasena());
            inputEmail.setText(selected.getEmail());

        }

    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        usuarioDAO = new UsuarioDAO();
        initializeTable();
        //ocultar label de warningUsuario
        labelWarningUsuario.setVisible(false);
    }

    public void clean(){
        selected = null;
        tableViewUsuario.getSelectionModel().clearSelection();
        inputNombre.setText(null);
        inputNombredeUsuario.setText(null);
        inputContrasena.setText(null);
        inputEmail.setText(null);
    }

    public void initializarData(){
        fillTable();
    }

    private void initializeTable(){
        usuariosList = FXCollections.observableArrayList();
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colUsuario.setCellValueFactory(new PropertyValueFactory<>("nombreUsuario"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tableViewUsuario.setItems(usuariosList);
    }

    private void fillTable(){
        usuariosList.clear();
        List<Usuario> usuarioLista = usuarioDAO.getListUsuarios();
        List<UserTable> userTable = new ArrayList<>();
        usuarioLista.forEach((usuario -> userTable.add(new UserTable(usuario))));
        usuariosList.addAll(userTable);
    };


    private boolean searchUser(String nombreUsuario){
        for (int i = 0; i < usuarioDAO.getListUsuarios().size() ; i++)
            if(usuarioDAO.getListUsuarios().get(i).getUsername().equals(nombreUsuario))
                return true;
        return false;
    };

}
