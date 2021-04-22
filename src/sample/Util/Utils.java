package sample.Util;

import javafx.scene.control.TextFormatter;
import sample.Main;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
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
            SceneAssembler.setFXML(carpeta,fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean nullOrEmpty(String str){

        if(str == null){
            return true;
        }else{
            if(str.isBlank()){
                return true;
            }
        }
        return false;
    }

    public static int getSemana(LocalDate date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(Date.from(date.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        calendar.setFirstDayOfWeek( Calendar.MONDAY);
        calendar.setMinimalDaysInFirstWeek( 1 );
        int semana = calendar.get(Calendar.WEEK_OF_MONTH);
        return semana;
    }

    public static String getMes(LocalDate date){
        return date.getMonth().getDisplayName(TextStyle.FULL, new Locale("es", "ES"));
    }
}
