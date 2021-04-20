package sample.Reports;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class ReportsCuentasPagar implements JRDataSource {
    private Object[][] listaPruebaSemanas;
    private int totalesv;
    private double[] totales;
    private String mes = "abril";
    private int index;


    public ReportsCuentasPagar() {
        index = -1;
        listaPruebaSemanas = new Object[][]{
                {"cuenta1", 100.00, 200.00, 300.000, 400.00, 500.00, 15000.00, 6.00, 7.00, 8.00, 9.00, 10.00},
                {"cuenta2", 100.00, 200.00, 300.000, 400.00, 500.00, 15000.00, 6.00, 7.00, 8.00, 9.00, 10.00},
                {"cuenta3", 100.00, 200.00, 300.000, 400.00, 500.00, 15000.00, 6.00, 7.00, 8.00, 9.00, 10.00},
                {"cuenta4", 100.00, 200.00, 300.000, 400.00, 500.00, 15000.00, 6.00, 7.00, 8.00, 9.00, 10.00},
                {"cuenta5", 100.00, 200.00, 300.000, 400.00, 500.00, 15000.00, 6.00, 7.00, 8.00, 9.00, 10.00},
                {"cuenta1", 100.00, 200.00, 300.000, 400.00, 500.00, 15000.00, 6.00, 7.00, 8.00, 9.00, 10.00},
                {"cuenta2", 100.00, 200.00, 300.000, 400.00, 500.00, 15000.00, 6.00, 7.00, 8.00, 9.00, 10.00},
                {"cuenta3", 100.00, 200.00, 300.000, 400.00, 500.00, 15000.00, 6.00, 7.00, 8.00, 9.00, 10.00},
                {"cuenta4", 100.00, 200.00, 300.000, 400.00, 500.00, 15000.00, 6.00, 7.00, 8.00, 9.00, 10.00},
                {"cuenta5", 100.00, 200.00, 300.000, 400.00, 500.00, 15000.00, 6.00, 7.00, 8.00, 9.00, 10.00},
                {"cuenta1", 100.00, 200.00, 300.000, 400.00, 500.00, 15000.00, 6.00, 7.00, 8.00, 9.00, 10.00},
                {"cuenta2", 100.00, 200.00, 300.000, 400.00, 500.00, 15000.00, 6.00, 7.00, 8.00, 9.00, 10.00},
                {"cuenta3", 100.00, 200.00, 300.000, 400.00, 500.00, 15000.00, 6.00, 7.00, 8.00, 9.00, 10.00},
                {"cuenta4", 100.00, 200.00, 300.000, 400.00, 500.00, 15000.00, 6.00, 7.00, 8.00, 9.00, 10.00},
                {"cuenta5", 100.00, 200.00, 300.000, 400.00, 500.00, 15000.00, 6.00, 7.00, 8.00, 9.00, 10.00},
                {"cuenta1", 100.00, 200.00, 300.000, 400.00, 500.00, 15000.00, 6.00, 7.00, 8.00, 9.00, 10.00},
                {"cuenta2", 100.00, 200.00, 300.000, 400.00, 500.00, 15000.00, 6.00, 7.00, 8.00, 9.00, 10.00},
                {"cuenta3", 100.00, 200.00, 300.000, 400.00, 500.00, 15000.00, 6.00, 7.00, 8.00, 9.00, 10.00},
                {"cuenta4", 100.00, 200.00, 300.000, 400.00, 500.00, 15000.00, 6.00, 7.00, 8.00, 9.00, 10.00},
                {"cuenta5", 100.00, 200.00, 300.000, 400.00, 500.00, 15000.00, 6.00, 7.00, 8.00, 9.00, 10.00},
        };

        totales = new double[]{
                1.00, 2.00, 3.00, 4.00, 9.00, 10000.99
        };
        totalesv = 0;
    }

    @Override
    public boolean next() throws JRException {
        index++;
        return (index < listaPruebaSemanas.length);
    }

    @Override
    public Object getFieldValue(JRField jrField) throws JRException {
        Object value = null;
        String fieldName = jrField.getName();
        switch (fieldName) {
            case "cuenta":
                value = listaPruebaSemanas[index][0];
                break;
            case "semana1":
                value = listaPruebaSemanas[index][1];
                break;
            case "semana2":
                value = listaPruebaSemanas[index][2];
                break;
            case "semana3":
                value = listaPruebaSemanas[index][3];
                break;
            case "semana4":
                value = listaPruebaSemanas[index][4];
                break;
            case "semana5":
                value = listaPruebaSemanas[index][5];
                break;
            case "cuentaFinal":
                value = listaPruebaSemanas[index][5];
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
                value = mes;
                break;
//            case "totalSemanas":
//                value = totales[5];
//                break;
        }
        totalesv++;
        return value;
    }

    public static JRDataSource getDataSource() {
        return new ReportsCuentasPagar()
                ;
    }
}
