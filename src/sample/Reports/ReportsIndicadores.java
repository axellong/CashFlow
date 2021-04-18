package sample.Reports;

import entity.RegistroIndicadores;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import sample.DAOs.RegistroIndicadoresDAO;


import java.util.List;

public class ReportsIndicadores implements JRDataSource {
     private Object [][] listaPruebaSemanas;
     private String mes = "MARZO";
     private int index;




    public ReportsIndicadores() {
        index = -1;
        listaPruebaSemanas = new Object[][] {
                {"cuenta1",100.00,200.00,300.000,400.00,500.00,15000,6.00,7.00,8.00,9.00,10.00},
                {"cuenta2",100.00,200.00,300.000,400.00,500.00,15000,6.00,7.00,8.00,9.00,10.00},
                {"cuenta3",100.00,200.00,300.000,400.00,500.00,15000,6.00,7.00,8.00,9.00,10.00},
                {"cuenta4",100.00,200.00,300.000,400.00,500.00,15000,6.00,7.00,8.00,9.00,10.00},
                {"cuenta5",100.00,200.00,300.000,400.00,500.00,15000,6.00,7.00,8.00,9.00,10.00}
        };
    }

    @Override
    public boolean next() throws JRException {
        index++;
        return (index< listaPruebaSemanas.length);
    }

    @Override
    public Object getFieldValue(JRField jrField) throws JRException {
        Object value = null;
        String fieldName= jrField.getName();
        switch (fieldName){
            case "cuentaCobrar":
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
            case "CuentasCobrarFinal":
                value = listaPruebaSemanas[index][6];
                break;
            case "totalSemana1":
                value = listaPruebaSemanas[index][7];
                break;
            case "totalSemana2":
                value = listaPruebaSemanas[index][8];
                break;
            case "totalSemana3":
                value = listaPruebaSemanas[index][9];
                break;
            case "totalSemana4":
                value = listaPruebaSemanas[index][10];
                break;
            case "totalSemana5":
                value = listaPruebaSemanas[index][11];
                break;
            case "MES":
                value = "marzo";
                break;

        }
        return value;
    }

    public static JRDataSource getDataSource(){
        return new ReportsIndicadores();
    }
}


