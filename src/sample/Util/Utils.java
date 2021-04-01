package sample.Util;

import javafx.scene.control.TextFormatter;

import java.util.function.UnaryOperator;

public class Utils {

    public static UnaryOperator<TextFormatter.Change> integerFilter = change -> {
        String newText = change.getControlNewText();
        if (newText.matches("-?([1-9][0-9]*)?")) {
            return change;
        }
        return null;
    };


}
