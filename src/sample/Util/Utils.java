package sample.Util;

import javafx.scene.control.TextFormatter;
import sample.Main;

import java.io.IOException;
import java.util.function.UnaryOperator;

public class Utils {

    public static UnaryOperator<TextFormatter.Change> integerFilter = change -> {
        String newText = change.getControlNewText();
        if (newText.matches("-?([1-9][0-9]*)?")) {
            return change;
        }
        return null;
    };

    public static void minimize() {
        Main.primaryStage.setIconified(true);
    }

    public static void close(){
        System.exit(0);
    }

    public static void changeScene(String carpeta, String fxml){
        try {
            Main.setFXML(carpeta,fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
