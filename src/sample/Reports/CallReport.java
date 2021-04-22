package sample.Reports;

import logic.Model.Calculos;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.*;

public class CallReport {
    public CallReport() {

    }

    public void getReportPagar(String mes, int año) {
        try {
            JasperReport jas = (JasperReport) JRLoader.loadObject(getClass().getResource("/sample/Reports/Jasper/ReportePagar.jasper"));
            JasperPrint jsp = JasperFillManager.fillReport(jas, null, ReportsCuentasPagar.getDataSource(mes, año));
            JasperViewer vie = new JasperViewer(jsp, false);
            vie.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            vie.setVisible(true);
            System.out.println("salio");
        } catch (Exception exception) {
            exception.getMessage();
        }
    }

    public void getReportCobrar(String mes, int año) {
        try {
            JasperReport jas = (JasperReport) JRLoader.loadObject(getClass().getResource("/sample/Reports/Jasper/Reporte.jasper"));
            JasperPrint jsp = JasperFillManager.fillReport(jas, null, ReportsCuentasCobrar.getDataSource(mes, año));
            JasperViewer vie = new JasperViewer(jsp, false);
            vie.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            vie.setVisible(true);
            System.out.println("salio");
        } catch (Exception exception) {
            exception.getMessage();
        }
    }

}
