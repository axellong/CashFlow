package sample;

import animatefx.animation.FadeOut;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {
    static double xOffset;
    static double yOffset;
    public static Stage primaryStage;
    //private static Stage secondStage;
    private static Scene scene;
    private static Parent root;
    public static FXMLLoader fxmlLoader;

    //HILO START DE JAVAFX
    @Override
    public void start(Stage stage){
        primaryStage = stage;

        //setRoot("Login","LoginView");
        setRoot("Dash","DashView");
        scene.setFill(Color.TRANSPARENT);
        primaryStage.setTitle("CashFlow");
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("Resources/iconLogo.png")));
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.centerOnScreen();
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    // METODO PARA ASIGNAR EL FXML AL Parent CON MOVIMIENTO
    private static void setRoot(String carpeta,String fxml){
        try {
            root = loadFXML(carpeta,fxml);
            if (scene == null) {
                scene = new Scene(root);
            } else {
                scene.setRoot(root);
            }
            // obtiene el origen al presionar
            root.setOnMousePressed(event -> {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            });

            root.setOnMouseDragged(event -> {
                primaryStage.setX(event.getScreenX() - xOffset);
                primaryStage.setY(event.getScreenY() - yOffset);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // METODO PARA ASIGNAR UNA SCENA NUEVA
    public static void setFXML(String carpeta,String fxml) throws IOException {
        FadeOut fade = new FadeOut();
        fade.setNode(root);
        fade.setOnFinished((ActionEvent event) ->{
            setRoot(carpeta, fxml);
            primaryStage.sizeToScene();
            primaryStage.centerOnScreen();
        });
        fade.play();

    }

    //METODO PARA CARGAR UN NUEVO FXML
    private static Parent loadFXML(String carpeta,String fxml) throws IOException {
        fxmlLoader = new FXMLLoader(Main.class.getResource("View/"+carpeta+"/"+ fxml + ".fxml"));
        return fxmlLoader.load();
    }

    //METODO PARA LA CREACION DE UNA NUEVA VENTANA
    /*public static void newStage(String carpeta, String fxml) {
        try {
            Parent node = loadFXML(carpeta,fxml);
            secondStage = new Stage();
            Scene scene = new Scene(node);
            secondStage.setScene(scene);
            secondStage.initOwner(primaryStage);
            secondStage.initModality(Modality.APPLICATION_MODAL);
            secondStage.centerOnScreen();
            //secondStage.showAndWait();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }*/

    //METODO MAIN
    public static void main(String[] args) {
        launch(args);
    }
}
