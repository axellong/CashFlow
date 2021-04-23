package logic.Model.Table;

import entity.RegistroBanco;
import entity.RegistroEfectivo;
import entity.RegistroIndicadores;
import sample.DAOs.DAOsReportes.CuentasPorCobrarDAO;
import sample.DAOs.DAOsReportes.CuentasPorPagarDAO;
import sample.DAOs.DAOsReportes.GastosDAO;
import sample.DAOs.DAOsReportes.IngresosDAO;
import sample.DAOs.InitializerDAOs;
import sample.DAOs.RegistroBancoDAO;

import java.util.ArrayList;
import java.util.List;

public class GetData {

    public static List<TableGeneral> Cobrar(String mes,int year){
        CuentasPorCobrarDAO cuentasPorCobrarDAO = InitializerDAOs.getInitializerDAOs().getCuentasPorCobrarDAO();
        List<RegistroIndicadores> listaCuentasPorCobrar = cuentasPorCobrarDAO.getListCuentasPorMes(mes,year);
        System.out.println(listaCuentasPorCobrar);
        listaCuentasPorCobrar = coincidenciasCobrar(listaCuentasPorCobrar);
        return crearGeneralCobrar(listaCuentasPorCobrar);
    }

    private static List<RegistroIndicadores> coincidenciasCobrar(List<RegistroIndicadores> listaCuentasPorCobrar){
        for(int i = 0;i<listaCuentasPorCobrar.size();i++){
            for (int j=i+1;j<listaCuentasPorCobrar.size();j++ ){

                if(listaCuentasPorCobrar.get(i).getId_Cuenta().getCuenta() == listaCuentasPorCobrar.get(j).getId_Cuenta().getCuenta()){
                    int[] intsem =listaCuentasPorCobrar.get(i).getSemanas();
                    switch (listaCuentasPorCobrar.get(j).getSemana()) {
                        case 1:
                            if(intsem[0]==0){
                                intsem[0]=(int)listaCuentasPorCobrar.get(j).getMonto();
                            }else{
                                intsem[0] = (int)(intsem[0] +listaCuentasPorCobrar.get(j).getMonto());
                            }
                            break;
                        case 2:
                            if(intsem[1]==0){
                            intsem[1]=(int)listaCuentasPorCobrar.get(j).getMonto();
                        }else{
                            intsem[1] = (int)(intsem[1] +listaCuentasPorCobrar.get(j).getMonto());
                        }
                            break ;
                        case 3:
                            if(intsem[2]==0){
                                intsem[2]=(int)listaCuentasPorCobrar.get(j).getMonto();
                            }else{
                                intsem[2] = (int)(intsem[2] +listaCuentasPorCobrar.get(j).getMonto());
                            }
                            break;
                        case 4:
                            if(intsem[3]==0){
                                intsem[3]=(int)listaCuentasPorCobrar.get(j).getMonto();
                            }else{
                                intsem[3] = (int)(intsem[3] +listaCuentasPorCobrar.get(j).getMonto());
                            }
                            break;
                        case 5:
                            if(intsem[4]==0){
                                intsem[4]=(int)listaCuentasPorCobrar.get(j).getMonto();
                            }else{
                                intsem[4] = (int)(intsem[4] +listaCuentasPorCobrar.get(j).getMonto());
                            }
                            break;
                    }
                    listaCuentasPorCobrar.get(i).setSemanas(intsem);
                    listaCuentasPorCobrar.remove(j);
                    j--;

                }
            }
        }
        System.out.println(listaCuentasPorCobrar);
        return listaCuentasPorCobrar;
    }

    private static List<TableGeneral> crearGeneralCobrar(List<RegistroIndicadores> listaCuentasPorCobrar){
        List<TableGeneral> cobrar = new ArrayList<>();
        for(int i = 0;i<listaCuentasPorCobrar.size();i++){
            TableGeneral temp = new TableGeneral();
            temp.setCuenta(String.valueOf(listaCuentasPorCobrar.get(i).getId_Cuenta().getCuenta()));
            int[] semanas = listaCuentasPorCobrar.get(i).getSemanas();
            switch (listaCuentasPorCobrar.get(i).getSemana()) {
                case 1:
                    temp.setSemana1(semanas[0]+(int)listaCuentasPorCobrar.get(i).getMonto());
                    temp.setSemana2(semanas[1]);
                    temp.setSemana3(semanas[2]);
                    temp.setSemana4(semanas[3]);
                    temp.setSemana5(semanas[4]);
                    break;
                case 2:
                    temp.setSemana1(semanas[0]);
                    temp.setSemana2(semanas[1]+(int)listaCuentasPorCobrar.get(i).getMonto());
                    temp.setSemana3(semanas[2]);
                    temp.setSemana4(semanas[3]);
                    temp.setSemana5(semanas[4]);
                    break ;
                case 3:
                    temp.setSemana1(semanas[0]);
                    temp.setSemana2(semanas[1]);
                    temp.setSemana3(semanas[2]+(int)listaCuentasPorCobrar.get(i).getMonto());
                    temp.setSemana4(semanas[3]);
                    temp.setSemana5(semanas[4]);
                    break;
                case 4:
                    temp.setSemana1(semanas[0]);
                    temp.setSemana2(semanas[1]);
                    temp.setSemana3(semanas[2]);
                    temp.setSemana4(semanas[3]+(int)listaCuentasPorCobrar.get(i).getMonto());
                    temp.setSemana5(semanas[4]);
                    break;
                case 5:
                    temp.setSemana1(semanas[0]);
                    temp.setSemana2(semanas[1]);
                    temp.setSemana3(semanas[2]);
                    temp.setSemana4(semanas[3]);
                    temp.setSemana5(semanas[4]+(int)listaCuentasPorCobrar.get(i).getMonto());
                    break;
            }
            temp.llenarfinal();
            cobrar.add(temp);
        }
        return cobrar;
    }

    public static List<TableGeneral> Pagar(String mes,int year){
        CuentasPorPagarDAO cuentasPorPagarDao = InitializerDAOs.getInitializerDAOs().getCuentasPorPagarDAO();
        List<RegistroIndicadores> listaCuentasPorPagar = cuentasPorPagarDao.getListCuentasPorMes(mes,year);
        System.out.println(listaCuentasPorPagar);
        listaCuentasPorPagar = coincidenciasPagar(listaCuentasPorPagar);
        return crearGeneralPagar(listaCuentasPorPagar);
    }

    private static List<RegistroIndicadores> coincidenciasPagar(List<RegistroIndicadores> listaCuentasPorPagar){
        for(int i = 0;i<listaCuentasPorPagar.size();i++){
            for (int j=i+1;j<listaCuentasPorPagar.size();j++ ){

                if(listaCuentasPorPagar.get(i).getId_Cuenta().getCuenta() == listaCuentasPorPagar.get(j).getId_Cuenta().getCuenta()){
                    int[] intsem =listaCuentasPorPagar.get(i).getSemanas();
                    switch (listaCuentasPorPagar.get(j).getSemana()) {
                        case 1:
                            if(intsem[0]==0){
                                intsem[0]=(int)listaCuentasPorPagar.get(j).getMonto();
                            }else{
                                intsem[0] = (int)(intsem[0] +listaCuentasPorPagar.get(j).getMonto());
                            }
                            break;
                        case 2:
                            if(intsem[1]==0){
                                intsem[1]=(int)listaCuentasPorPagar.get(j).getMonto();
                            }else{
                                intsem[1] = (int)(intsem[1] +listaCuentasPorPagar.get(j).getMonto());
                            }
                            break ;
                        case 3:
                            if(intsem[2]==0){
                                intsem[2]=(int)listaCuentasPorPagar.get(j).getMonto();
                            }else{
                                intsem[2] = (int)(intsem[2] +listaCuentasPorPagar.get(j).getMonto());
                            }
                            break;
                        case 4:
                            if(intsem[3]==0){
                                intsem[3]=(int)listaCuentasPorPagar.get(j).getMonto();
                            }else{
                                intsem[3] = (int)(intsem[3] +listaCuentasPorPagar.get(j).getMonto());
                            }
                            break;
                        case 5:
                            if(intsem[4]==0){
                                intsem[4]=(int)listaCuentasPorPagar.get(j).getMonto();
                            }else{
                                intsem[4] = (int)(intsem[4] +listaCuentasPorPagar.get(j).getMonto());
                            }
                            break;
                    }
                    listaCuentasPorPagar.get(i).setSemanas(intsem);
                    listaCuentasPorPagar.remove(j);
                    j--;

                }
            }
        }
        System.out.println(listaCuentasPorPagar);
        return listaCuentasPorPagar;
    }

    private static List<TableGeneral> crearGeneralPagar(List<RegistroIndicadores> listaCuentaPorPagar){
        List<TableGeneral> cobrar = new ArrayList<>();
        for(int i = 0;i<listaCuentaPorPagar.size();i++){
            TableGeneral temp = new TableGeneral();
            temp.setCuenta(String.valueOf(listaCuentaPorPagar.get(i).getId_Cuenta().getCuenta()));
            int[] semanas = listaCuentaPorPagar.get(i).getSemanas();
            switch (listaCuentaPorPagar.get(i).getSemana()) {
                case 1:
                    temp.setSemana1(semanas[0]+(int)listaCuentaPorPagar.get(i).getMonto());
                    temp.setSemana2(semanas[1]);
                    temp.setSemana3(semanas[2]);
                    temp.setSemana4(semanas[3]);
                    temp.setSemana5(semanas[4]);
                    break;
                case 2:
                    temp.setSemana1(semanas[0]);
                    temp.setSemana2(semanas[1]+(int)listaCuentaPorPagar.get(i).getMonto());
                    temp.setSemana3(semanas[2]);
                    temp.setSemana4(semanas[3]);
                    temp.setSemana5(semanas[4]);
                    break ;
                case 3:
                    temp.setSemana1(semanas[0]);
                    temp.setSemana2(semanas[1]);
                    temp.setSemana3(semanas[2]+(int)listaCuentaPorPagar.get(i).getMonto());
                    temp.setSemana4(semanas[3]);
                    temp.setSemana5(semanas[4]);
                    break;
                case 4:
                    temp.setSemana1(semanas[0]);
                    temp.setSemana2(semanas[1]);
                    temp.setSemana3(semanas[2]);
                    temp.setSemana4(semanas[3]+(int)listaCuentaPorPagar.get(i).getMonto());
                    temp.setSemana5(semanas[4]);
                    break;
                case 5:
                    temp.setSemana1(semanas[0]);
                    temp.setSemana2(semanas[1]);
                    temp.setSemana3(semanas[2]);
                    temp.setSemana4(semanas[3]);
                    temp.setSemana5(semanas[4]+(int)listaCuentaPorPagar.get(i).getMonto());
                    break;
            }
            temp.llenarfinal();
            cobrar.add(temp);
        }
        return cobrar;
    }

    public static List<TableGeneral> Banco(String mes,int year){
        RegistroBancoDAO registroBanco = InitializerDAOs.getInitializerDAOs().getRegistroBancoDAO();
        List<RegistroBanco> listaBanco = registroBanco.getListRegistroBancosPorMes(mes,year);
        System.out.println(listaBanco);
        listaBanco = coincidenciasBanco(listaBanco);
        return crearGeneralBanco(listaBanco);
    }

    private static List<RegistroBanco> coincidenciasBanco(List<RegistroBanco> listaBanco){
        for(int i = 0;i<listaBanco.size();i++){
            for (int j=i+1;j<listaBanco.size();j++ ){

                if(listaBanco.get(i).getNumeroCuenta() == listaBanco.get(j).getNumeroCuenta()){
                    int[] intsem =listaBanco.get(i).getSemanas();
                    switch (listaBanco.get(j).getSemana()) {
                        case 1:
                            if(intsem[0]==0){
                                intsem[0]=(int)listaBanco.get(j).getMonto();
                            }else{
                                intsem[0] = (int)(intsem[0] +listaBanco.get(j).getMonto());
                            }
                            break;
                        case 2:
                            if(intsem[1]==0){
                                intsem[1]=(int)listaBanco.get(j).getMonto();
                            }else{
                                intsem[1] = (int)(intsem[1] +listaBanco.get(j).getMonto());
                            }
                            break ;
                        case 3:
                            if(intsem[2]==0){
                                intsem[2]=(int)listaBanco.get(j).getMonto();
                            }else{
                                intsem[2] = (int)(intsem[2] +listaBanco.get(j).getMonto());
                            }
                            break;
                        case 4:
                            if(intsem[3]==0){
                                intsem[3]=(int)listaBanco.get(j).getMonto();
                            }else{
                                intsem[3] = (int)(intsem[3] +listaBanco.get(j).getMonto());
                            }
                            break;
                        case 5:
                            if(intsem[4]==0){
                                intsem[4]=(int)listaBanco.get(j).getMonto();
                            }else{
                                intsem[4] = (int)(intsem[4] +listaBanco.get(j).getMonto());
                            }
                            break;
                    }
                    listaBanco.get(i).setSemanas(intsem);
                    listaBanco.remove(j);
                    j--;

                }
            }
        }
        System.out.println(listaBanco);
        return listaBanco;
    }

    private static List<TableGeneral> crearGeneralBanco(List<RegistroBanco> listaBanco){
        List<TableGeneral> cobrar = new ArrayList<>();
        for(int i = 0;i<listaBanco.size();i++){
            TableGeneral temp = new TableGeneral();
            temp.setCuenta(String.valueOf(listaBanco.get(i).getNumeroCuenta()));
            int[] semanas = listaBanco.get(i).getSemanas();
            switch (listaBanco.get(i).getSemana()) {
                case 1:
                    temp.setSemana1(semanas[0]+(int)listaBanco.get(i).getMonto());
                    temp.setSemana2(semanas[1]);
                    temp.setSemana3(semanas[2]);
                    temp.setSemana4(semanas[3]);
                    temp.setSemana5(semanas[4]);
                    break;
                case 2:
                    temp.setSemana1(semanas[0]);
                    temp.setSemana2(semanas[1]+(int)listaBanco.get(i).getMonto());
                    temp.setSemana3(semanas[2]);
                    temp.setSemana4(semanas[3]);
                    temp.setSemana5(semanas[4]);
                    break ;
                case 3:
                    temp.setSemana1(semanas[0]);
                    temp.setSemana2(semanas[1]);
                    temp.setSemana3(semanas[2]+(int)listaBanco.get(i).getMonto());
                    temp.setSemana4(semanas[3]);
                    temp.setSemana5(semanas[4]);
                    break;
                case 4:
                    temp.setSemana1(semanas[0]);
                    temp.setSemana2(semanas[1]);
                    temp.setSemana3(semanas[2]);
                    temp.setSemana4(semanas[3]+(int)listaBanco.get(i).getMonto());
                    temp.setSemana5(semanas[4]);
                    break;
                case 5:
                    temp.setSemana1(semanas[0]);
                    temp.setSemana2(semanas[1]);
                    temp.setSemana3(semanas[2]);
                    temp.setSemana4(semanas[3]);
                    temp.setSemana5(semanas[4]+(int)listaBanco.get(i).getMonto());
                    break;
            }
            temp.llenarfinal();
            cobrar.add(temp);
        }
        return cobrar;
    }

    public static List<TableGeneral> Ingreso(String mes,int year){
        IngresosDAO registrosEfectivoDAO = InitializerDAOs.getInitializerDAOs().getIngresosDAO();
        List<RegistroEfectivo> listaIngreso = registrosEfectivoDAO.getListIngresosPorMes(mes,year);
        System.out.println(listaIngreso);
        listaIngreso = coincidenciasIngreso(listaIngreso);
        return crearGeneralIngreso(listaIngreso);
    }

    private static List<RegistroEfectivo> coincidenciasIngreso(List<RegistroEfectivo> listaIngreso){
        for(int i = 0;i<listaIngreso.size();i++){
            for (int j=i+1;j<listaIngreso.size();j++ ){

                if(listaIngreso.get(i).getIdSubcategoria().getId_Categoria().getClasificacion().getIdClasificacion() == listaIngreso.get(j).getIdSubcategoria().getId_Categoria().getClasificacion().getIdClasificacion()){
                    int[] intsem =listaIngreso.get(i).getSemanas();
                    switch (listaIngreso.get(j).getSemana()) {
                        case 1:
                            if(intsem[0]==0){
                                intsem[0]=(int)listaIngreso.get(j).getMonto();
                            }else{
                                intsem[0] = (int)(intsem[0] +listaIngreso.get(j).getMonto());
                            }
                            break;
                        case 2:
                            if(intsem[1]==0){
                                intsem[1]=(int)listaIngreso.get(j).getMonto();
                            }else{
                                intsem[1] = (int)(intsem[1] +listaIngreso.get(j).getMonto());
                            }
                            break ;
                        case 3:
                            if(intsem[2]==0){
                                intsem[2]=(int)listaIngreso.get(j).getMonto();
                            }else{
                                intsem[2] = (int)(intsem[2] +listaIngreso.get(j).getMonto());
                            }
                            break;
                        case 4:
                            if(intsem[3]==0){
                                intsem[3]=(int)listaIngreso.get(j).getMonto();
                            }else{
                                intsem[3] = (int)(intsem[3] +listaIngreso.get(j).getMonto());
                            }
                            break;
                        case 5:
                            if(intsem[4]==0){
                                intsem[4]=(int)listaIngreso.get(j).getMonto();
                            }else{
                                intsem[4] = (int)(intsem[4] +listaIngreso.get(j).getMonto());
                            }
                            break;
                    }
                    listaIngreso.get(i).setSemanas(intsem);
                    listaIngreso.remove(j);
                    j--;

                }
            }
        }
        System.out.println(listaIngreso);
        return listaIngreso;
    }

    private static List<TableGeneral> crearGeneralIngreso(List<RegistroEfectivo> listaIngreso){
        List<TableGeneral> cobrar = new ArrayList<>();
        for(int i = 0;i<listaIngreso.size();i++){
            TableGeneral temp = new TableGeneral();
            temp.setCuenta(String.valueOf(listaIngreso.get(i).getIdSubcategoria().getId_Categoria().getClasificacion().getNombreClasificacion()));
            int[] semanas = listaIngreso.get(i).getSemanas();
            switch (listaIngreso.get(i).getSemana()) {
                case 1:
                    temp.setSemana1(semanas[0]+(int)listaIngreso.get(i).getMonto());
                    temp.setSemana2(semanas[1]);
                    temp.setSemana3(semanas[2]);
                    temp.setSemana4(semanas[3]);
                    temp.setSemana5(semanas[4]);
                    break;
                case 2:
                    temp.setSemana1(semanas[0]);
                    temp.setSemana2(semanas[1]+(int)listaIngreso.get(i).getMonto());
                    temp.setSemana3(semanas[2]);
                    temp.setSemana4(semanas[3]);
                    temp.setSemana5(semanas[4]);
                    break ;
                case 3:
                    temp.setSemana1(semanas[0]);
                    temp.setSemana2(semanas[1]);
                    temp.setSemana3(semanas[2]+(int)listaIngreso.get(i).getMonto());
                    temp.setSemana4(semanas[3]);
                    temp.setSemana5(semanas[4]);
                    break;
                case 4:
                    temp.setSemana1(semanas[0]);
                    temp.setSemana2(semanas[1]);
                    temp.setSemana3(semanas[2]);
                    temp.setSemana4(semanas[3]+(int)listaIngreso.get(i).getMonto());
                    temp.setSemana5(semanas[4]);
                    break;
                case 5:
                    temp.setSemana1(semanas[0]);
                    temp.setSemana2(semanas[1]);
                    temp.setSemana3(semanas[2]);
                    temp.setSemana4(semanas[3]);
                    temp.setSemana5(semanas[4]+(int)listaIngreso.get(i).getMonto());
                    break;
            }
            temp.llenarfinal();
            cobrar.add(temp);
        }
        return cobrar;
    }

    public static List<TableGeneral> Gastos(String mes,int year){
        GastosDAO gastosDAO = InitializerDAOs.getInitializerDAOs().getGastosDAO();
        List<RegistroEfectivo> listaGastos = gastosDAO.getListGastosPorMes(mes,year);
        System.out.println(listaGastos);
        listaGastos = coincidenciasGasto(listaGastos);
        return crearGeneralGasto(listaGastos);
    }

    private static List<RegistroEfectivo> coincidenciasGasto(List<RegistroEfectivo> listaGastos){
        for(int i = 0;i<listaGastos.size();i++){
            for (int j=i+1;j<listaGastos.size();j++ ){

                if(listaGastos.get(i).getIdSubcategoria().getId_Categoria().getClasificacion().getIdClasificacion() == listaGastos.get(j).getIdSubcategoria().getId_Categoria().getClasificacion().getIdClasificacion()){
                    int[] intsem =listaGastos.get(i).getSemanas();
                    switch (listaGastos.get(j).getSemana()) {
                        case 1:
                            if(intsem[0]==0){
                                intsem[0]=(int)listaGastos.get(j).getMonto();
                            }else{
                                intsem[0] = (int)(intsem[0] +listaGastos.get(j).getMonto());
                            }
                            break;
                        case 2:
                            if(intsem[1]==0){
                                intsem[1]=(int)listaGastos.get(j).getMonto();
                            }else{
                                intsem[1] = (int)(intsem[1] +listaGastos.get(j).getMonto());
                            }
                            break ;
                        case 3:
                            if(intsem[2]==0){
                                intsem[2]=(int)listaGastos.get(j).getMonto();
                            }else{
                                intsem[2] = (int)(intsem[2] +listaGastos.get(j).getMonto());
                            }
                            break;
                        case 4:
                            if(intsem[3]==0){
                                intsem[3]=(int)listaGastos.get(j).getMonto();
                            }else{
                                intsem[3] = (int)(intsem[3] +listaGastos.get(j).getMonto());
                            }
                            break;
                        case 5:
                            if(intsem[4]==0){
                                intsem[4]=(int)listaGastos.get(j).getMonto();
                            }else{
                                intsem[4] = (int)(intsem[4] +listaGastos.get(j).getMonto());
                            }
                            break;
                    }
                    listaGastos.get(i).setSemanas(intsem);
                    listaGastos.remove(j);
                    j--;

                }
            }
        }
        System.out.println(listaGastos);
        return listaGastos;
    }

    private static List<TableGeneral> crearGeneralGasto(List<RegistroEfectivo> listaGastos){
        List<TableGeneral> cobrar = new ArrayList<>();
        for(int i = 0;i<listaGastos.size();i++){
            TableGeneral temp = new TableGeneral();
            temp.setCuenta(String.valueOf(listaGastos.get(i).getIdSubcategoria().getId_Categoria().getClasificacion().getNombreClasificacion()));
            int[] semanas = listaGastos.get(i).getSemanas();
            switch (listaGastos.get(i).getSemana()) {
                case 1:
                    temp.setSemana1(semanas[0]+(int)listaGastos.get(i).getMonto());
                    temp.setSemana2(semanas[1]);
                    temp.setSemana3(semanas[2]);
                    temp.setSemana4(semanas[3]);
                    temp.setSemana5(semanas[4]);
                    break;
                case 2:
                    temp.setSemana1(semanas[0]);
                    temp.setSemana2(semanas[1]+(int)listaGastos.get(i).getMonto());
                    temp.setSemana3(semanas[2]);
                    temp.setSemana4(semanas[3]);
                    temp.setSemana5(semanas[4]);
                    break ;
                case 3:
                    temp.setSemana1(semanas[0]);
                    temp.setSemana2(semanas[1]);
                    temp.setSemana3(semanas[2]+(int)listaGastos.get(i).getMonto());
                    temp.setSemana4(semanas[3]);
                    temp.setSemana5(semanas[4]);
                    break;
                case 4:
                    temp.setSemana1(semanas[0]);
                    temp.setSemana2(semanas[1]);
                    temp.setSemana3(semanas[2]);
                    temp.setSemana4(semanas[3]+(int)listaGastos.get(i).getMonto());
                    temp.setSemana5(semanas[4]);
                    break;
                case 5:
                    temp.setSemana1(semanas[0]);
                    temp.setSemana2(semanas[1]);
                    temp.setSemana3(semanas[2]);
                    temp.setSemana4(semanas[3]);
                    temp.setSemana5(semanas[4]+(int)listaGastos.get(i).getMonto());
                    break;
            }
            temp.llenarfinal();
            cobrar.add(temp);
        }
        return cobrar;
    }
}
