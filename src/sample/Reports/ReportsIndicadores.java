package sample.Reports;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class ReportsIndicadores implements JRDataSource {

    private int año;
    private String mes;
    private Object[] listaEfectivo;
    private Object[] listaTarjeta;
    private Object[] listaIngresos;
    private Object[] listaCostos;
    private Object[] listaGastos;
    private Object[] listaTotalGastos;
    private Object[] listaTotalUtilidad;
    private Object[] listaFinales;
    private boolean index;


    public ReportsIndicadores(String mes , int año) {
        listaEfectivo = new Object[]{
                0.00, 1.00, 2.00, 3.00, 4.00
        };
        listaTarjeta = new Object[]{
                0.00, 1.00, 2.00, 3.00, 4.00
        };
        listaIngresos = new Object[]{
                0.00, 1.00, 2.00, 3.00, 4.00
        };
        listaCostos = new Object[]{
                0.00, 1.00, 2.00, 3.00, 4.00
        };
        listaGastos = new Object[]{
                0.00, 1.00, 2.00, 3.00, 4.00
        };
        listaTotalGastos = new Object[]{
                0.00, 1.00, 2.00, 3.00, 4.00
        };
        listaTotalUtilidad = new Object[]{
                0.00, 1.00, 2.00, 3.00, 4.00
        };
        listaFinales = new Object[]{
                10.00, 2.00, 3.00, 4.00, 5.00, 6.00, 7.00
        };

        index = true;

    }


    @Override
    public boolean next() throws JRException {
        return index;

    }

    @Override
    public Object getFieldValue(JRField jrField) throws JRException {
        index = false;
        Object value = null;
        String fieldName = jrField.getName();
        switch (fieldName) {
            case "ingreso1":
                value = listaEfectivo[0];
                break;
            case "ingreso2":
                value = listaEfectivo[1];
                break;
            case "ingreso3":
                value = listaEfectivo[2];
                break;
            case "ingreso4":
                value = listaEfectivo[3];
                break;
            case "ingreso5":
                value = listaEfectivo[4];
                break;
            case "ingresoTarjeta1":
                value = listaTarjeta[0];
                break;
            case "ingresoTarjeta2":
                value = listaTarjeta[1];
                break;
            case "ingresoTarjeta3":
                value = listaTarjeta[2];
                break;
            case "ingresoTarjeta4":
                value = listaTarjeta[3];
                break;
            case "ingresoTarjeta5":
                value = listaTarjeta[4];
                break;
            case "ingresosTotal1":
                value = listaIngresos[0];
                break;
            case "ingresosTotal2":
                value = listaIngresos[1];
                break;
            case "ingresosTotal3":
                value = listaIngresos[2];
                break;
            case "ingresosTotal4":
                value = listaIngresos[3];
                break;
            case "ingresosTotal5":
                value = listaIngresos[4];
                break;
            case "totalUtilidad1":
                value = listaTotalUtilidad[0];
                break;
            case "totalUtilidad2":
                value = listaTotalUtilidad[1];
                break;
            case "totalUtilidad3":
                value = listaTotalUtilidad[2];
                break;
            case "totalUtilidad4":
                value = listaTotalUtilidad[3];
                break;
            case "totalUtilidad5":
                value = listaTotalUtilidad[4];
                break;
            case "mes":
                value = "abril";
                break;
            case "Costos1":
                value = listaCostos[0];
                break;
            case "Costos2":
                value = listaCostos[1];
                break;
            case "Costos3":
                value = listaCostos[2];
                break;
            case "Costos4":
                value = listaCostos[3];
                break;
            case "Costos5":
                value = listaCostos[4];
                break;
            case "finalTarjeta":
                value = listaFinales[0];
                break;
            case "finalIngreso":
                value = listaFinales[1];
                break;
            case "finalEfectivo":
                value = listaFinales[2];
                break;
            case "finalCostos":
                value = listaFinales[3];
                break;
            case "finalGastosOperativos":
                value = listaFinales[4];
                break;
            case "finalTotalGastos":
                value = listaFinales[5];
                break;
            case "finaUtilidad":
                value = listaFinales[6];
                break;
            case "gastos1":
                value = listaGastos[0];
                break;
            case "gastos2":
                value = listaGastos[1];
                break;
            case "gastos3":
                value = listaGastos[2];
                break;
            case "gastos4":
                value = listaGastos[3];
                break;
            case "gastos5":
                value = listaGastos[4];
                break;
            case "totalGastos1":
                value = listaTotalGastos[0];
                break;
            case "totalGastos2":
                value = listaTotalGastos[1];
                break;
            case "totalGastos3":
                value = listaTotalGastos[2];
                break;
            case "totalGastos4":
                value = listaTotalGastos[3];
                break;
            case "totalGastos5":
                value = listaTotalGastos[4];
                break;


        }


        return value;
    }

    public static JRDataSource getDataSource(String mes, int año) {
        return new ReportsIndicadores(mes,año);
    }
}
