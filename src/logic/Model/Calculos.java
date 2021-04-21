package logic.Model;

import entity.RegistroIndicadores;
import sample.DAOs.DAOsReportes.CuentasPorCobrarDAO;
import sample.DAOs.DAOsReportes.ExtraClass.RegistroCuenta;
import sample.DAOs.DAOsReportes.ReportesEfectivoDAO;

import java.util.*;

public class Calculos {
    List<RegistroCuenta> listaSemana1;
    List<RegistroCuenta> listaSemana2;
    List<RegistroCuenta> listaSemana3;
    List<RegistroCuenta> listaSemana4;
    List<RegistroCuenta> listaSemana5;
    List<List<RegistroCuenta>> listaDeLista;


    public Calculos() {
        listaSemana1 = null;
        listaSemana2 = null;
        listaSemana3 = null;
        listaSemana4 = null;
        listaSemana5 = null;
        listaDeLista = new ArrayList<>();

    }


//    public List<RegistroCuenta> LlenadoCuentasPorCobrar() {
//
//    }

    public List<ReportFill> geCuentas(CuentasPorCobrarDAO dao, String mes, int año) {
        List<ReportFill> reportFills = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            List<RegistroCuenta> lista = dao.getListCuentasPorSemanaDelMes(mes, i, año);
            switch (i) {
                case 1:
                    System.out.println(lista);
                    listaSemana1 = creacionListaLLenado(lista);
                    System.out.println(listaSemana1);
                    break;
                case 2:
                    System.out.println(lista);
                    listaSemana2 = creacionListaLLenado(lista);
                    System.out.println(listaSemana2);

                    break;
                case 3:
                    System.out.println(lista);
                    listaSemana3 = creacionListaLLenado(lista);
                    System.out.println(listaSemana3);
                    break;
                case 4:
                    System.out.println(lista);
                    listaSemana4 = creacionListaLLenado(lista);
                    System.out.println(listaSemana4);
                    break;
                case 5:
                    System.out.println(lista);
                    listaSemana5 = creacionListaLLenado(lista);
                    System.out.println(listaSemana5);
                    break;
            }
            listaDeLista.add(listaSemana1);
            listaDeLista.add(listaSemana2);
            listaDeLista.add(listaSemana3);
            listaDeLista.add(listaSemana4);
            listaDeLista.add(listaSemana5);


        }


        return reportFills;
    }

    private List<RegistroCuenta> creacionListaLLenado(List<RegistroCuenta> lista) {
        List<RegistroCuenta> listaIdCuentas = new ArrayList<>();
        RegistroCuenta valorComparar;
        double valorAgregar;

        for (int i = 0; i < lista.size(); i++) {
            valorComparar = lista.get(i);
            valorAgregar = lista.get(i).getMonto();
            for (int x = i + 1; x < lista.size(); x++) {
                if (valorComparar.getCuenta() == lista.get(x).getCuenta()) {
                    valorAgregar = valorAgregar + lista.get(x).getMonto();
                    lista.remove(x);
                }
            }
            valorComparar.setMonto(valorAgregar);
            listaIdCuentas.add(valorComparar);
        }
        System.out.println(listaIdCuentas);
        return listaIdCuentas;
    }

    private List<ReportFill> llenadoListasReportes() {
        List<ReportFill> listaReportes = new ArrayList<>();
        for (int i = 0; i < listaDeLista.size(); i++) {
            for (int x = 0; x < listaDeLista.get(i).size(); x++) {
                ReportFill reportFill = new ReportFill();
                reportFill.setNumeroCuenta(listaDeLista.get(i).get(x).getCuenta());
                for (int y = 0; y < listaDeLista.get(i + 1).size(); y++) {
                    if (listaDeLista.get(i).get(x).getCuenta() == listaDeLista.get(i+1).get(y).getCuenta()) {
                        reportFill.setSemana2(listaDeLista.get(i).get(x).getMonto());
                        reportFill.setSemana3(listaDeLista.get(i+1).get(y).getMonto());

                    }
                }
                listaReportes.add(reportFill);
            }


        }

        return listaReportes;

    }


}
