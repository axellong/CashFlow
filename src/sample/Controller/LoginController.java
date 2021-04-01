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
import sample.Main;
import sample.Util.Utils;

import java.io.IOException;
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
    void MouseClickedMin(MouseEvent event) { Main.primaryStage.setIconified(true); }

    @FXML
    void MouseClickedClose(MouseEvent event) {
        System.exit(0);
    }

    // metodos para ingresar y verificacion
    @FXML
    void MouseClickedIngresar(MouseEvent event) {
        clean();
        cambiarScene("Dash","DashView");
    }

    @FXML
    void MouseClickedVerificar(MouseEvent event) {
        makefadeOut(1);
    }

    // metodos de recuperar contraseña y reenvio de codigo
    @FXML
    void MouseClickedForget(MouseEvent event) {

    }

    @FXML
    void MouseClikedForgetCode(MouseEvent event) {

    }

    // metodos para regresar, cambiar scene
    @FXML
    void MouseClickedBack(MouseEvent event) {
        clean();
        makefadeOut(2);
    }

    private void changePane(int option){
        switch(option){
            case 1:
                paneVerificar.setVisible(false);
                paneVerificar.setDisable(true);
                paneIngresar.setVisible(true);
                paneIngresar.setDisable(false);
                break;
            case 2:
                paneIngresar.setVisible(false);
                paneIngresar.setDisable(true);
                paneVerificar.setVisible(true);
                paneVerificar.setDisable(false);
                break;
        }
    }

    private void makefadeOut(int option){
        FadeOut fade = new FadeOut();
        fade.setResetOnFinished(true);
        if(option == 1) {
            fade.setNode(paneVerificar);
        }else{
            fade.setNode(paneIngresar);
        }
        fade.play();
        fade.setOnFinished((ActionEvent event)-> changePane(option));
    }

    private void cambiarScene(String carpeta, String fxml) {
        try {
            Main.setFXML(carpeta,fxml);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //metodo de limpieza

    public void clean(){
        inputCode.setText(null);
        inputEmail.setText(null);
        inputPassword.setText(null);
    }

}
