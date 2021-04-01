package sample.Controller;

import animatefx.animation.FadeOut;
import hibernete.ConexionHibernete;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import logic.LoginSecure;
import sample.DAOs.UsuarioDAO;
import sample.Main;

import java.io.IOException;

public class LoginController {
    LoginSecure loginSecure = new LoginSecure();

    @FXML
    private Pane paneVerificar;

    @FXML
    private Pane paneIngresar;

    @FXML
    void MouseClickedMin(MouseEvent event) {
        Main.primaryStage.setIconified(true);
    }

    @FXML
    void MouseClickedClose(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    void MouseClickedIngresar(MouseEvent event) {
        cambiarScene("Dash", "DashView");
    }

    @FXML
    void MouseClickedVerificar(MouseEvent event) {
        makefadeOut(1);
        UsuarioDAO dao = new UsuarioDAO();
        System.out.println(dao.getUsuario("Eduardo93").getNombre());
    }

    @FXML
    void MouseClickedBack(MouseEvent event) {
        makefadeOut(2);
    }

    private void changePane(int option) {
        switch (option) {
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

    private void makefadeOut(int option) {
        FadeOut fade = new FadeOut();
        fade.setResetOnFinished(true);
        if (option == 1) {
            fade.setNode(paneVerificar);
        } else {
            fade.setNode(paneIngresar);
        }
        fade.play();
        fade.setOnFinished((ActionEvent event) -> changePane(option));
    }

    private void cambiarScene(String carpeta, String fxml) {
        try {
            Main.setFXML(carpeta, fxml);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
