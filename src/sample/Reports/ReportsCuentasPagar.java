package sample.Reports;

import logic.Model.Calculos;
import logic.Model.ReportFill;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

import java.util.List;

public class ReportsCuentasPagar implements JRDataSource {
    private List<ReportFill> listaCuentas;
    private int totalesv;
    private List<Double> totales;
    private String mes = "";
    private int index;



    public ReportsCuentasPagar(String mes,int año) {
        this.mes=mes;
        Calculos calculos = new Calculos();
        listaCuentas = calculos.getCuentasPagar(mes, año);
        index = -1;
        totales = calculos.getTotales(listaCuentas);
        totalesv = 0;
    }

    @Override
    public boolean next() throws JRException {
        index++;
        return (index < listaCuentas.size());
    }

    @Override
    public Object getFieldValue(JRField jrField) throws JRException {
        Object value = null;
        String fieldName = jrField.getName();
        switch (fieldName) {
            case "cuenta":
                value = listaCuentas.get(index).getNumeroCuenta();
                break;
            case "semana1":
                value = listaCuentas.get(index).getSemana1();
                break;
            case "semana2":
                value = listaCuentas.get(index).getSemana2();
                break;
            case "semana3":
                value = listaCuentas.get(index).getSemana3();
                break;
            case "semana4":
                value = listaCuentas.get(index).getSemana4();
                break;
            case "semana5":
                value = listaCuentas.get(index).getSemana5();
                break;
            case "cuentaFinal":
                value = listaCuentas.get(index).getTotalSemana();
                break;
            case "totalSemana1":
                value = totales.get(0);
                break;
            case "totalSemana2":
                value = totales.get(1);

                break;
            case "totalSemana3":

                value = totales.get(2);

                break;
            case "totalSemana4":

                value = totales.get(3);

                break;
            case "totalSemana5":

                value = totales.get(4);
                break;
            case "MES":
                value = mes;
                break;
            case "totalSemanas":
                value = totales.get(5);
                break;
        }
        totalesv++;
        return value;
    }

    public static JRDataSource getDataSource(String mes, int año) {
        return new ReportsCuentasPagar(mes,año);
    }
}
