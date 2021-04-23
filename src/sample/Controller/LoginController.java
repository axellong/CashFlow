package sample.Controller;

import animatefx.animation.FadeOut;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import entity.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.converter.IntegerStringConverter;
import logic.Credential;
import logic.LoginSecure;
import sample.DAOs.InitializerDAOs;
import sample.DAOs.UsuarioDAO;
import sample.Util.Utils;

import java.net.URL;
import java.util.ResourceBundle;

import static sample.Util.Utils.nullOrEmpty;

public class LoginController implements Initializable {

    @FXML
    private Pane paneVerificar, paneIngresar;

    @FXML
    private JFXTextField inputEmail, inputCode;

    @FXML
    private JFXPasswordField inputPassword;

    LoginSecure segure;
    UsuarioDAO usuarioDAO;
    Usuario usuario;
    FadeOut fade = new FadeOut();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        segure = new LoginSecure();
        usuarioDAO = InitializerDAOs.getInitializerDAOs().getUsuarioDAO();
        inputCode.setTextFormatter(new TextFormatter<>(new IntegerStringConverter(), null, Utils.integerFilter));
    }

    //metodos para minimizar y cerrar
    @FXML
    void MouseClickedMin(MouseEvent event) { Utils.minimize(); }

    @FXML
    void MouseClickedClose(MouseEvent event) { Utils.close(); }

    // metodos para ingresar y verificacion
    @FXML
    void MouseClickedIngresar(MouseEvent event) {
        int code = Integer.parseInt(inputCode.getText());
        if( segure.CheckSecureCode(code)){
            clean();
            Utils.changeScene("Dash","DashView");
            Credential.setUser(usuario);
            //Guardar Credenciales de Usuario
        }
    }

    @FXML
    void MouseClickedVerificar(MouseEvent event) {
        String email = inputEmail.getText();
        String pass = inputPassword.getText();
        if(!nullOrEmpty(email) && !nullOrEmpty(pass)){
            usuario = usuarioDAO.getUsuario(email,pass);
            if(usuario != null){
                makefadeOut(true);
                sentEmailHilo(email);
            }else{
                System.out.println("No se encontro");
            }
        }

    }

    // metodos para regresar, cambiar scene
    @FXML
    void MouseClickedBack(MouseEvent event) {
        clean();
        makefadeOut(false);
    }

    // metodos de recuperar contraseña y reenvio de codigo
    @FXML
    void MouseClickedForget(MouseEvent event) {

    }

    @FXML
    void MouseClikedForgetCode(MouseEvent event) {
        String email = inputEmail.getText();
        sentEmailHilo(email);
    }

    private void changePane(boolean value) {
        paneVerificar.setVisible(!value);
        paneVerificar.setDisable(value);
        paneIngresar.setVisible(value);
        paneIngresar.setDisable(!value);
    }

    private void makefadeOut(boolean value){
        fade.setResetOnFinished(true);
        if(value) { fade.setNode(paneVerificar);
        }else{ fade.setNode(paneIngresar); }
        fade.play();
        fade.setOnFinished((ActionEvent event)-> changePane(value));
    }

    private void sentEmailHilo(String email){
        Runnable emailHilo =()-> segure.SendMail(email);
        Thread hilo = new Thread(emailHilo);
        hilo.start();
    }

    //metodo de limpieza

    public void clean(){
        inputCode.setText(null);
        inputEmail.setText(null);
        inputPassword.setText(null);
    }

}
