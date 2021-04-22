package sample;

import entity.RegistroIndicadores;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.DAOs.DAOsReportes.GastosDAO;
import sample.DAOs.DAOsReportes.IngresosDAO;
import sample.DAOs.RegistroIndicadoresDAO;
import sample.Util.SceneAssembler;

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
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("Resources/iconLogo.png")));
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.centerOnScreen();
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    //METODO MAIN
    public static void main(String[] args) {
        launch(args);

        //PruebaReports pruebaReports = new PruebaReports();
    }

}
