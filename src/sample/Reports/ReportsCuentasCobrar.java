package sample.Reports;

import logic.Model.Calculos;
import logic.Model.ReportFill;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import sample.DAOs.DAOsReportes.ExtraClass.RegistroCuenta;

import java.util.List;

public class ReportsCuentasCobrar implements JRDataSource {
    private List<ReportFill>  listaLlenado;
    private int totalesv;
    private List<Double>  totales;
    private String mes = "";
    private int index;


    public ReportsCuentasCobrar(String mes,int año) {
        Calculos calculos = new Calculos();
        index = -1;
        listaLlenado= calculos.getCuentascobrar(mes,año);
        totales = calculos.getTotales(listaLlenado);
        System.out.println(listaLlenado);

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
                value = "marzo";
                break;
            case "totalSemanas":
                value = totales.get(5);
                break;
        }
        totalesv++;
        return value;
    }

    public static JRDataSource getDataSource(String mes, int año) {
        return new ReportsCuentasCobrar(mes, año);
    }
}


