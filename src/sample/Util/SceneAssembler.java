package sample.Util;

import animatefx.animation.FadeOut;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.Main;

import java.io.IOException;

public class SceneAssembler {

    private static double xOffset;
    private static double yOffset;

    //METODO PARA CARGAR UN NUEVO FXML
    public static Parent loadFXML(String carpeta, String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("View/" + carpeta + "/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }

    // METODO PARA ASIGNAR EL FXML AL Parent CON MOVIMIENTO
    public static void setRoot(String carpeta,String fxml){
        try {
            Main.root = loadFXML(carpeta,fxml);
            if (Main.scene == null) {
                Main.scene = new Scene(Main.root);
            } else {
                Main.scene.setRoot(Main.root);
            }
            // obtiene el origen al presionar
            Main.root.setOnMousePressed(event -> {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            });

            Main.root.setOnMouseDragged(event -> {
                Main.primaryStage.setX(event.getScreenX() - xOffset);
                Main.primaryStage.setY(event.getScreenY() - yOffset);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // METODO PARA ASIGNAR UNA SCENA NUEVA
    public static void setFXML(String carpeta,String fxml) throws IOException {
        FadeOut fade = new FadeOut();
        fade.setNode(Main.root);
        fade.setOnFinished((ActionEvent event) ->{
            setRoot(carpeta, fxml);
            Main.primaryStage.sizeToScene();
            Main.primaryStage.centerOnScreen();
        });
        fade.play();

    }

    //METODO PARA LA CREACION DE UNA NUEVA VENTANA
    public static void newStage(String carpeta, String fxml) {
        try {
            Parent node = loadFXML(carpeta,fxml);
            Stage secondStage = new Stage();
            Scene scene = new Scene(node);
            secondStage.setScene(scene);
            secondStage.initOwner(Main.primaryStage);
            secondStage.initModality(Modality.APPLICATION_MODAL);
            secondStage.centerOnScreen();
            //secondStage.showAndWait();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
