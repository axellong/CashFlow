package sample.Reports;

import logic.Model.Calculos;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.*;

public class PruebaReports {
    public PruebaReports(){
        try {
//            System.out.println("entro");
//            JasperReport jasper = (JasperReport) JRLoader.loadObject(getClass().getResource("/sample/Reports/Jasper/ReportePagar.jasper"));
//            JasperPrint jasperPrint = JasperFillManager.fillReport(jasper,null, ReportsCuentasPagar.getDataSource());
//            JasperViewer viewer =  new JasperViewer(jasperPrint, false);
//            viewer.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
//            viewer.setVisible(true);

            JasperReport jas = (JasperReport) JRLoader.loadObject(getClass().getResource("/sample/Reports/Jasper/Reporte.jasper"));
            JasperPrint jsp = JasperFillManager.fillReport(jas,null, ReportsCuentasCobrar.getDataSource());
            JasperViewer vie =  new JasperViewer(jsp, false);
            vie.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            vie.setVisible(true);
            System.out.println("salio");
            Calculos calculos = new Calculos();
            calculos.llenadoCuentasPagar();
        }catch (Exception exception){
            exception.getMessage();
        }
    }


}
