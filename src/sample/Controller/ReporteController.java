package sample.Controller;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class ReporteController implements Initializable {

    @FXML
    private DatePicker datePickerReporte;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    void MouseClickedClose(MouseEvent event) {
        datePickerReporte.getScene().getWindow().hide();
    }


    @FXML
    void MouseClickedReporte(MouseEvent event) {
        LocalDate date = datePickerReporte.getValue();
        if(date != null) {
            String mes = date.getMonth().getDisplayName(TextStyle.FULL, new Locale("es", "ES"));
            int año = date.getYear();

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(Date.from(date.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
            calendar.setFirstDayOfWeek( Calendar.MONDAY);
            calendar.setMinimalDaysInFirstWeek( 4 );

            int numberWeekOfYear = calendar.get(Calendar.WEEK_OF_MONTH);
            System.out.println(numberWeekOfYear+" "+ mes +" "+año);
        }

    }

}