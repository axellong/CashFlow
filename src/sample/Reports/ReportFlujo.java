package sample.Reports;

import logic.Model.Calculos;
import logic.Model.ReportFillIngreso;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

import java.util.List;

public class ReportFlujo implements JRDataSource {

    private List<ReportFillIngreso> listaLlenadoFlujoIngreso;
    private List<ReportFillIngreso> listaLlenadoFlujoEgreso;
    private List<Double> totalesFlujo;
    private String mesFlujo;
    private int indexFlujoInrgeso;
    private int indexFlujoEgreso;
    boolean egresoSigue;
    boolean ingresoSigue;
    boolean banderaIngreso;
    boolean banderaEgreso;

    public ReportFlujo(String mes, int año) {
        Calculos calculos = new Calculos();
        Calculos calculos1 = new Calculos();
        indexFlujoInrgeso = -1;
        indexFlujoEgreso = -1;
        egresoSigue = false;
        ingresoSigue = false;
        banderaIngreso = false;
        banderaEgreso = false;
        listaLlenadoFlujoIngreso = calculos.getIngersos(mes, año);
        listaLlenadoFlujoEgreso = calculos1.getGastos(mes, año);

        totalesFlujo = calculos.getTotalesIngreso(listaLlenadoFlujoIngreso, listaLlenadoFlujoEgreso);

    }

    public static ReportFlujo getDataSource(String mes, int año) {
        return new ReportFlujo(mes, año);
    }

    @Override
    public boolean next() throws JRException {
        boolean sigue = false;
        indexFlujoEgreso++;
        indexFlujoInrgeso++;

        if (indexFlujoEgreso < listaLlenadoFlujoEgreso.size() & banderaEgreso == false) {
            egresoSigue = true;
        } else {
            banderaEgreso = true;
            egresoSigue = false;
        }
        if (indexFlujoInrgeso < listaLlenadoFlujoIngreso.size() & banderaIngreso == false) {
            ingresoSigue = true;
        } else {
            banderaIngreso = true;
            ingresoSigue = false;
        }

        if (!egresoSigue & !ingresoSigue) {
            sigue = false;
        } else {
            sigue = true;
        }


        return sigue;
    }

    @Override
    public Object getFieldValue(JRField jrField) throws JRException {
        Object value = null;
        String fieldName = jrField.getName();
        switch (fieldName) {
            case "nombreGastos":
                if (egresoSigue) {
                    value = listaLlenadoFlujoEgreso.get(indexFlujoEgreso).getNumeroCuenta();
                }
                break;
            case "semana1Gastos":
                if (egresoSigue) {
                    value = listaLlenadoFlujoEgreso.get(indexFlujoEgreso).getSemana1();
                }
                break;
            case "semana2Gastos":
                if (egresoSigue) {
                    value = listaLlenadoFlujoEgreso.get(indexFlujoEgreso).getSemana2();
                }
                break;
            case "semana3Gastos":
                if (egresoSigue) {
                    value = listaLlenadoFlujoEgreso.get(indexFlujoEgreso).getSemana3();
                }
                break;
            case "semana4Gastos":
                if (egresoSigue) {
                    value = listaLlenadoFlujoEgreso.get(indexFlujoEgreso).getSemana4();
                }
                break;
            case "semana5Gastos":
                if (egresoSigue) {
                    value = listaLlenadoFlujoEgreso.get(indexFlujoEgreso).getSemana5();
                }
                break;
            case "semanaTotalGastos":
                if (egresoSigue) {
                    value = listaLlenadoFlujoEgreso.get(indexFlujoEgreso).getTotalSemana();
                }
                break;

            case "nombreIngresos":
                if (ingresoSigue) {
                    value = listaLlenadoFlujoIngreso.get(indexFlujoInrgeso).getNumeroCuenta();
                }
                break;
            case "semana1Ingresos":
                if (ingresoSigue) {
                    value = listaLlenadoFlujoIngreso.get(indexFlujoInrgeso).getSemana1();
                }
                break;
            case "semana2Ingresos":
                if (ingresoSigue) {
                    value = listaLlenadoFlujoIngreso.get(indexFlujoInrgeso).getSemana2();
                }
                break;
            case "semana3Ingreso":
                if (ingresoSigue) {
                    value = listaLlenadoFlujoIngreso.get(indexFlujoInrgeso).getSemana3();
                }
                break;
            case "semana4Ingreso":
                if (ingresoSigue) {
                    value = listaLlenadoFlujoIngreso.get(indexFlujoInrgeso).getSemana4();
                }
                break;
            case "semana5Ingreso":
                if (ingresoSigue) {
                    value = listaLlenadoFlujoIngreso.get(indexFlujoInrgeso).getSemana5();
                }
                break;
            case "semanaTotalIngreso":
                if (ingresoSigue) {
                    value = listaLlenadoFlujoIngreso.get(indexFlujoInrgeso).getTotalSemana();
                }
                break;

            case "totalUtilidadSemana1":
                value = totalesFlujo.get(0);
                break;
            case "totalUtilidadSemana2":

                value = totalesFlujo.get(1);

                break;
            case "totalUtilidadSemana3":

                value = totalesFlujo.get(2);

                break;
            case "totalUtilidadSemana4":

                value = totalesFlujo.get(3);

                break;
            case "totalUtilidadSemana5":

                value = totalesFlujo.get(4);

                break;
            case "totalUtilidades":

                value = totalesFlujo.get(5);

                break;
            case "mes":
                value = mesFlujo;
                break;

        }

        return value;

    }
}
