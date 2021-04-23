package sample.Controller;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import entity.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import logic.Model.UserTable;
import sample.DAOs.UsuarioDAO;
import sample.Util.SceneAssembler;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import static sample.Util.Utils.nullOrEmpty;


public class UserController implements Initializable {

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

    @FXML
    private JFXCheckBox checkAdmin;

    private UserTable selected;
    private ObservableList<UserTable> usuariosList;
    private UsuarioDAO usuarioDAO;

    @FXML
    void MouseClickedClearSelection(MouseEvent event) {
        clean();
    }

    @FXML
    void MouseClickedDelete(MouseEvent event) {
        if (selected != null) {
            UserTable delete = selected;
            //Dialogo de Confirmacion
            Optional<ButtonType> result = SceneAssembler.sceneAlert("Eliminar Usuario", "¿Desea eliminar este usuario? No son reversibles los cambios");
            if (result.get().equals(ButtonType.OK)) {
                usuarioDAO.deleteUsuario(delete.getUsuario());
                //limpiar los campos
                clean();
                //refrescar la tabla
                initializarData();
                SceneAssembler.closeAlert();
            }

        }
    }

    @FXML
    void MouseClickedSaveAndEdit(MouseEvent event) {
        String nombre = inputNombre.getText();
        String usuario = inputNombredeUsuario.getText();
        String email = inputEmail.getText();
        String contrasena = inputContrasena.getText();
        boolean permisos = checkAdmin.isSelected();
        if (!nullOrEmpty(nombre) && !nullOrEmpty(usuario) && !nullOrEmpty(email) && !nullOrEmpty(contrasena)) {
            if (selected != null) {
                usuariosList.remove(selected);
                UserTable update = selected;
                update.setNombre(nombre);
                update.setNombreUsuario(usuario);
                update.setEmail(email);
                update.setContrasena(contrasena);
                update.getUsuario().setCredencial(permisos);
                update.setUsuario(new Usuario(update));
                usuarioDAO.updateUsuario(update.getUsuario());
                usuariosList.add(update);
                clean();
            } else {
                Usuario newUser = new Usuario();
                newUser.setNombre(nombre);
                newUser.setUsername(usuario);
                newUser.setPassword(contrasena);
                newUser.setCredencial(permisos);
                newUser.setEmail(email);

                boolean usuarioEncontrado = searchUser(newUser.getUsername());

                if (!usuarioEncontrado) {
                    //si el usuario no existe, se agrega el nuevo usuario
                    usuarioDAO.saveUsuario(newUser);
                    usuariosList.add(new UserTable(newUser));
                    labelWarningUsuario.setVisible(false);
                    clean();
                } else
                    labelWarningUsuario.setVisible(true);
            }
        }


    }

    @FXML
    void MouseClickedSelect(MouseEvent event) {
        selected = tableViewUsuario.getSelectionModel().getSelectedItem();
        if (selected != null) {
            inputNombre.setText(selected.getNombre());
            inputNombredeUsuario.setText(selected.getNombreUsuario());
            inputContrasena.setText(selected.getContrasena());
            inputEmail.setText(selected.getEmail());
            checkAdmin.setSelected(selected.getUsuario().isCredencial());
        }

    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        usuarioDAO = new UsuarioDAO();
        initializeTable();
    }

    public void clean() {
        selected = null;
        tableViewUsuario.getSelectionModel().clearSelection();
        inputNombre.setText(null);
        inputNombredeUsuario.setText(null);
        inputContrasena.setText(null);
        inputEmail.setText(null);
        labelWarningUsuario.setVisible(false);
        checkAdmin.setSelected(false);
    }

    public void initializarData() {
        fillTable();
    }

    private void initializeTable() {
        usuariosList = FXCollections.observableArrayList();
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colUsuario.setCellValueFactory(new PropertyValueFactory<>("nombreUsuario"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tableViewUsuario.setItems(usuariosList);
    }

    private void fillTable() {
        usuariosList.clear();
        List<Usuario> usuarioLista = usuarioDAO.getListUsuarios();
        List<UserTable> userTable = new ArrayList<>();
        usuarioLista.forEach((usuario -> userTable.add(new UserTable(usuario))));
        usuariosList.addAll(userTable);
    }


    private boolean searchUser(String nombreUsuario) {
        for (int i = 0; i < usuarioDAO.getListUsuarios().size(); i++)
            if (usuarioDAO.getListUsuarios().get(i).getUsername().equals(nombreUsuario))
                return true;
        return false;
    }

}
