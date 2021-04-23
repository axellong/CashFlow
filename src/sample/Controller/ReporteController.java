package sample.Controller;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.input.MouseEvent;
import sample.Util.SceneAssembler;
import sample.Util.Utils;

import java.net.URL;
import java.time.LocalDate;
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
        if (date != null) {
            String mes = Utils.getMes(date);
            int año = date.getYear();

//            CallReport callReport = new CallReport();
//            callReport.getReportJunto(mes, año);

            ReportePDFController pdf = (ReportePDFController) SceneAssembler.newStage("Report","ReportePDF");
            pdf.inicializarDatos(mes,año);
            SceneAssembler.secondStageVisible();
        }

    }

}