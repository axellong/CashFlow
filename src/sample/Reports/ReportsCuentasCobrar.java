package sample.Reports;

import logic.Model.ReportFill;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import sample.DAOs.DAOsReportes.ExtraClass.RegistroCuenta;

import java.util.List;

public class ReportsCuentasCobrar implements JRDataSource {
    private List<ReportFill>  listaLlenado;
    private int totalesv;
    private double[] totales;
    private String mes = "MARZO";
    private int index;


    public ReportsCuentasCobrar() {
        index = -1;
        totalesv = 0;
    }

    @Override
    public boolean next() throws JRException {
        index++;
        return (index < listaLlenado.size());
    }

    @Override
    public Object getFieldValue(JRField jrField) throws JRException {
        Object value = null;
        String fieldName = jrField.getName();
        switch (fieldName) {
            case "cuentaCobrar":
                value = listaLlenado.get(index).getNumeroCuenta();
                break;
            case "semana1":
                value = listaLlenado.get(index).getSemana1();
                break;
            case "semana2":
                value = listaLlenado.get(index).getSemana2();
                break;
            case "semana3":
                value = listaLlenado.get(index).getSemana3();
                break;
            case "semana4":
                value = listaLlenado.get(index).getSemana4();
                break;
            case "semana5":
                value = listaLlenado.get(index).getSemana5();
                break;
            case "cuentasCobrarFinal":
                value = listaLlenado.get(index).getTotalSemana();
                break;
            case "totalSemana1":
                value = totales[0];
                break;
            case "totalSemana2":

                value = totales[1];

                break;
            case "totalSemana3":

                value = totales[2];

                break;
            case "totalSemana4":

                value = totales[3];

                break;
            case "totalSemana5":

                value = totales[4];

                break;
            case "MES":
                value = "marzo";
                break;
            case "totalSemanas":
                value = totales[5];
                break;
        }
        totalesv++;
        return value;
    }

    public static JRDataSource getDataSource() {
        return new ReportsCuentasCobrar();
    }
}


