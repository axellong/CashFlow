package logic.Model;

import sample.DAOs.DAOsReportes.CuentasPorCobrarDAO;
import sample.DAOs.DAOsReportes.CuentasPorPagarDAO;
import sample.DAOs.DAOsReportes.ExtraClass.RegistroCuenta;
import sample.DAOs.InitializerDAOs;

import java.util.ArrayList;
import java.util.List;

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


    public List<ReportFill> getCuentasPagar(String mes, int año) {
        CuentasPorPagarDAO dao = InitializerDAOs.getInitializerDAOs().getCuentasPorPagarDAO();
        List<ReportFill> reportFills = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            List<RegistroCuenta> lista = dao.getListCuentasPorSemanaDelMes(mes, i, año);
            switch (i) {
                case 1:
                    listaSemana1 = creacionListaLLenado(lista);
                    listaDeLista.add(listaSemana1);
                    break;
                case 2:
                    listaSemana2 = creacionListaLLenado(lista);
                    listaDeLista.add(listaSemana2);
                    break;
                case 3:
                    listaSemana3 = creacionListaLLenado(lista);
                    listaDeLista.add(listaSemana3);
                    break;
                case 4:
                    listaSemana4 = creacionListaLLenado(lista);
                    listaDeLista.add(listaSemana4);
                    break;
                case 5:
                    listaSemana5 = creacionListaLLenado(lista);
                    listaDeLista.add(listaSemana5);
                    break;
            }


        }


        return llenadoListasReportes();


    }

    public List<ReportFill> getCuentascobrar(String mes, int año) {
        CuentasPorCobrarDAO dao = InitializerDAOs.getInitializerDAOs().getCuentasPorCobrarDAO();
        List<ReportFill> reportFills = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            List<RegistroCuenta> lista = dao.getListCuentasPorSemanaDelMes(mes, i, año);
            switch (i) {
                case 1:
                    listaSemana1 = creacionListaLLenado(lista);
                    listaDeLista.add(listaSemana1);
                    break;
                case 2:
                    listaSemana2 = creacionListaLLenado(lista);
                    listaDeLista.add(listaSemana2);
                    break;
                case 3:
                    listaSemana3 = creacionListaLLenado(lista);
                    listaDeLista.add(listaSemana3);
                    break;
                case 4:
                    listaSemana4 = creacionListaLLenado(lista);
                    listaDeLista.add(listaSemana4);
                    break;
                case 5:
                    listaSemana5 = creacionListaLLenado(lista);
                    listaDeLista.add(listaSemana5);
                    break;
            }


        }


        return llenadoListasReportes();
    }


    public List<Double> getTotales(List<ReportFill> lista) {

        List<Double> totales = new ArrayList<>();
        double semana1 = 0.00;
        double semana2 = 0.00;
        double semana3 = 0.00;
        double semana4 = 0.00;
        double semana5 = 0.00;

        double totalSemanas = 00.00;

        for (ReportFill l : lista) {
            semana1 = semana1 + l.getSemana1();
            semana2 = semana2 + l.getSemana2();
            semana3 = semana3 + l.getSemana3();
            semana4 = semana4 + l.getSemana4();
            semana5 = semana5 + l.getSemana5();
        }

        totales.add(semana1);
        totales.add(semana2);
        totales.add(semana3);
        totales.add(semana4);
        totales.add(semana5);
        totalSemanas = semana1 + semana2 + semana3 + semana4 + semana5;
        totales.add(totalSemanas);

        return totales;

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


        return listaIdCuentas;
    }

    private List<ReportFill> llenadoListasReportes() {
        List<ReportFill> listaFinal = new ArrayList<>();

        for (int x = 0; x < listaDeLista.size(); x++) {
            for (int i = 0; i < listaDeLista.get(x).size(); i++) {
                if (listaFinal.isEmpty()) {
                    listaFinal.add(new ReportFill(listaDeLista.get(x).get(i).getCuenta()));
                } else {
                    boolean bandera = false;
                    for (ReportFill r : listaFinal) {
                        if (r.getNumeroCuenta() == listaDeLista.get(x).get(i).getCuenta()) {
                            bandera = true;
                        }
                    }
                    if (!bandera) {
                        listaFinal.add(new ReportFill(listaDeLista.get(x).get(i).getCuenta()));
                    }
                }

            }

        }
        int semana = 0;
        for (List<RegistroCuenta> lista : listaDeLista) {
            semana++;
            for (int i = 0; i < lista.size(); i++) {

                for (int x = 0; x < listaFinal.size(); x++) {

                    if (listaFinal.get(x).getNumeroCuenta() == lista.get(i).getCuenta()) {
                        switch (semana) {
                            case 1:
                                listaFinal.get(x).setSemana1(lista.get(i).getMonto());
                                break;
                            case 2:
                                listaFinal.get(x).setSemana2(lista.get(i).getMonto());
                                break;
                            case 3:
                                listaFinal.get(x).setSemana3(lista.get(i).getMonto());
                                break;
                            case 4:
                                listaFinal.get(x).setSemana4(lista.get(i).getMonto());
                                break;
                            case 5:
                                listaFinal.get(x).setSemana5(lista.get(i).getMonto());
                                break;
                        }

                    }

                }

            }
        }


        return listaFinal;
    }


}
