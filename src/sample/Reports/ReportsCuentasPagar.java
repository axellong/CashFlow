package sample.Reports;

import logic.Model.Calculos;
import logic.Model.ReportFill;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

import java.util.List;

public class ReportsCuentasPagar implements JRDataSource {

    private List<ReportFill> listaCuentasPagar;
    private List<Double> totalesPagar;
    private String mesPagar = "";
    private int indexPagar;


    public ReportsCuentasPagar(String mes, int año) {
        this.mesPagar = mes;
        indexPagar = -1;
        Calculos calculos = new Calculos();
        listaCuentasPagar = calculos.getCuentasPagar(mes, año);
        totalesPagar = calculos.getTotales(listaCuentasPagar);
    }

    @Override
    public boolean next() throws JRException {
        indexPagar++;
        return (indexPagar < listaCuentasPagar.size());
    }

    @Override
    public Object getFieldValue(JRField jrField) throws JRException {
        Object value = null;
        String fieldName = jrField.getName();
        switch (fieldName) {
            case "cuentaPagar":
                value = listaCuentasPagar.get(indexPagar).getNumeroCuenta();
                break;
            case "semana1Pagar":
                value = listaCuentasPagar.get(indexPagar).getSemana1();
                break;
            case "semana2Pagar":
                value = listaCuentasPagar.get(indexPagar).getSemana2();
                break;
            case "semana3Pagar":
                value = listaCuentasPagar.get(indexPagar).getSemana3();
                break;
            case "semana4Pagar":
                value = listaCuentasPagar.get(indexPagar).getSemana4();
                break;
            case "semana5Pagar":
                value = listaCuentasPagar.get(indexPagar).getSemana5();
                break;
            case "cuentaFinalPagar":
                value = listaCuentasPagar.get(indexPagar).getTotalSemana();
                break;
            case "totalSemana1Pagar":
                value = totalesPagar.get(0);
                break;
            case "totalSemana2Pagar":
                value = totalesPagar.get(1);

                break;
            case "totalSemana3Pagar":

                value = totalesPagar.get(2);

                break;
            case "totalSemana4Pagar":

                value = totalesPagar.get(3);

                break;
            case "totalSemana5Pagar":

                value = totalesPagar.get(4);
                break;
            case "MESPagar":
                value = mesPagar;
                break;
            case "totalSemanasPagar":
                value = totalesPagar.get(5);
                break;
        }

        return value;
    }

    public static JRDataSource getDataSource(String mes, int año) {
        return new ReportsCuentasPagar(mes, año);
    }
}
