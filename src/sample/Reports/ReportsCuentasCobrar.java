package sample.Reports;

import logic.Model.Calculos;
import logic.Model.ReportFill;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

import java.util.List;

public class ReportsCuentasCobrar implements JRDataSource {
    private List<ReportFill> listaLlenadoCobrar;
    private List<Double> totalesCobrar;
    private String mesCobrar = "";
    private int indexCobrar;


    public ReportsCuentasCobrar(String mesCobrar, int año) {
        Calculos calculos = new Calculos();
        indexCobrar = -1;
        listaLlenadoCobrar = calculos.getCuentascobrar(mesCobrar, año);
        totalesCobrar = calculos.getTotales(listaLlenadoCobrar);
        System.out.println(listaLlenadoCobrar);

    }

    @Override
    public boolean next() throws JRException {
        indexCobrar++;
        return (indexCobrar < listaLlenadoCobrar.size());
    }

    @Override
    public Object getFieldValue(JRField jrField) throws JRException {
        Object value = null;
        String fieldName = jrField.getName();
        switch (fieldName) {
            case "cuentaCobrar":
                value = listaLlenadoCobrar.get(indexCobrar).getNumeroCuenta();
                break;
            case "semana1Cobrar":
                value = listaLlenadoCobrar.get(indexCobrar).getSemana1();
                break;
            case "semana2Cobrar":
                value = listaLlenadoCobrar.get(indexCobrar).getSemana2();
                break;
            case "semana3Cobrar":
                value = listaLlenadoCobrar.get(indexCobrar).getSemana3();
                break;
            case "semana4Cobrar":
                value = listaLlenadoCobrar.get(indexCobrar).getSemana4();
                break;
            case "semana5Cobrar":
                value = listaLlenadoCobrar.get(indexCobrar).getSemana5();
                break;
            case "cuentasCobrarFinalCobrar":
                value = listaLlenadoCobrar.get(indexCobrar).getTotalSemana();
                break;
            case "totalSemana1Cobrar":
                value = totalesCobrar.get(0);
                break;
            case "totalSemana2Cobrar":

                value = totalesCobrar.get(1);

                break;
            case "totalSemana3Cobrar":

                value = totalesCobrar.get(2);

                break;
            case "totalSemana4Cobrar":

                value = totalesCobrar.get(3);

                break;
            case "totalSemana5Cobrar":

                value = totalesCobrar.get(4);

                break;
            case "MESCobrar":
                value = "marzo";
                break;
            case "totalSemanasCobrar":
                value = totalesCobrar.get(5);
                break;
        }

        return value;
    }

    public static JRDataSource getDataSource(String mes, int año) {
        return new ReportsCuentasCobrar(mes, año);
    }
}


