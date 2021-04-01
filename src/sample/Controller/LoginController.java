package sample.Controller;

import animatefx.animation.FadeOut;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.converter.IntegerStringConverter;
import sample.Util.Utils;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private Pane paneVerificar, paneIngresar;

    @FXML
    private JFXTextField inputEmail, inputCode;

    @FXML
    private JFXPasswordField inputPassword;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        inputCode.setTextFormatter(new TextFormatter<Integer>(new IntegerStringConverter(), null, Utils.integerFilter));
    }

    //metodos para minimizar y cerrar
    @FXML
    void MouseClickedMin(MouseEvent event) { Utils.minimize(); }

    @FXML
    void MouseClickedClose(MouseEvent event) { Utils.close(); }

    // metodos para ingresar y verificacion
    @FXML
    void MouseClickedIngresar(MouseEvent event) {
        clean();
        Utils.changeScene("Dash","DashView");
        //Guardar Credenciales de Usuario
    }

    @FXML
    void MouseClickedVerificar(MouseEvent event) {
        makefadeOut(true);
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

    }

    private void changePane(boolean value) {
        paneVerificar.setVisible(!value);
        paneVerificar.setDisable(value);
        paneIngresar.setVisible(value);
        paneIngresar.setDisable(!value);
    }

    private void makefadeOut(boolean value){
        FadeOut fade = new FadeOut();
        fade.setResetOnFinished(true);
        if(value) { fade.setNode(paneVerificar);
        }else{ fade.setNode(paneIngresar); }
        fade.play();
        fade.setOnFinished((ActionEvent event)-> changePane(value));
    }

    //metodo de limpieza

    public void clean(){
        inputCode.setText(null);
        inputEmail.setText(null);
        inputPassword.setText(null);
    }

}
