package sample.Reports;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import sample.Main;
import sample.Reports.ReportsIndicadores;

import javax.swing.*;

public class PruebaReports {
    public PruebaReports(){
        try {            JasperReport jasper = (JasperReport) JRLoader.loadObject(getClass().getResource("/sample/Reports/Jasper/Reporte.jasper"));
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasper,null, ReportsIndicadores.getDataSource());
            JasperViewer viewer =  new JasperViewer(jasperPrint, false);
            viewer.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            viewer.setVisible(true);
        }catch (Exception exception){
            exception.getMessage();
        }
    }


}
