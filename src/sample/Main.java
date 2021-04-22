package sample;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.Util.SceneAssembler;

import java.util.Objects;


public class Main extends Application {
    public static Stage primaryStage;
    public static Scene scene;
    public static Parent root;

    //HILO START DE JAVAFX
    @Override
    public void start(Stage stage){
        primaryStage = stage;
        //SceneAssembler.setRoot("Login","LoginView");
        SceneAssembler.setRoot("Dash","DashView");
        scene.setFill(Color.TRANSPARENT);
        primaryStage.setTitle("CashFlow");
        primaryStage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("Resources/iconLogo.png"))));
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.centerOnScreen();
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    //METODO MAIN
    public static void main(String[] args) {
        launch(args);
    }


}
