package sample.DAOs.DAOsReportes;

import entity.RegistroIndicadores;
import hibernete.ConexionHibernete;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.*;
import sample.DAOs.DAOsReportes.ExtraClass.RegistroCuenta;

import java.util.*;

public class CuentasPorPagarDAO {
    private static SessionFactory factory;

    public static SessionFactory getFactory() {
        return factory;
    }

    public void setFactory(SessionFactory factory){
        CuentasPorPagarDAO.factory = factory;
    }

    @SuppressWarnings("deprecation")

    public CuentasPorPagarDAO(){
        ConexionHibernete.setDriver("postgresql");
        ConexionHibernete.generarConexion();
        factory = ConexionHibernete.getFactory();
    }

    public List <RegistroCuenta> getListCuentasPorMes(String mes, int anio) throws HibernateException {
        List <RegistroIndicadores> listaCuentasPorCobrar = null;
        //Inicializar un Set, es una colección para ayudar a obtener los datos correctamente
        Set<RegistroIndicadores> listaDeCuentas = new HashSet<RegistroIndicadores>();

        Session session = factory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(RegistroIndicadores.class);
        criteria.add(Restrictions.eq("clasificacion", "pagar"));
        criteria.add(Restrictions.eq("mes", mes));
        criteria.add(Restrictions.eq("anio", anio));

        //conseguir los datos
        listaCuentasPorCobrar =  criteria.list();

        //list to set - se hace esto, porque hay una incompatibilidad con list para conseguir datos especificos de la clase RegistroIndicadores
        for (RegistroIndicadores r : listaCuentasPorCobrar)
            listaDeCuentas.add(r);

        //Vaciar Lista, para reutilizarse
        listaCuentasPorCobrar.clear();
        //set to list - recuperar los datos y hacerlo compatible para List
        listaCuentasPorCobrar.addAll(listaDeCuentas);

        //Arreglo especial para el llenado de los reportes
        List<RegistroCuenta> listCuentas = new ArrayList<>();

        //llenar el arreglo especificamente para el llenado de los reportes
        for (int i = 0; i < listaCuentasPorCobrar.size(); i++) {
            int cuenta = listaCuentasPorCobrar.get(i).getId_Cuenta().getCuenta();
            String mes1 = listaCuentasPorCobrar.get(i).getMes();
            int semana1 = listaCuentasPorCobrar.get(i).getSemana();
            int anio1 = listaCuentasPorCobrar.get(i).getAnio();
            double monto = listaCuentasPorCobrar.get(i).getMonto();

            RegistroCuenta x = new RegistroCuenta(cuenta, monto, mes1, semana1, anio1);
            listCuentas.add(x);
        }

        session.getTransaction();
        session.close();

        return listCuentas;
    }

    public List <RegistroCuenta> getListCuentasPorSemanaDelMes(String mes,int semana, int anio) throws HibernateException {
        List <RegistroIndicadores> listaCuentasPorCobrar = null;
        //Inicializar un Set, es una colección para ayudar a obtener los datos correctamente
        Set<RegistroIndicadores> listaDeCuentas = new HashSet<RegistroIndicadores>();

        Session session = factory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(RegistroIndicadores.class);
        criteria.add(Restrictions.eq("clasificacion", "pagar"));
        criteria.add(Restrictions.eq("mes", mes));
        criteria.add(Restrictions.eq("semana", semana));
        criteria.add(Restrictions.eq("anio", anio));

        //conseguir los datos
        listaCuentasPorCobrar =  criteria.list();

        //list to set - se hace esto, porque hay una incompatibilidad con list para conseguir datos especificos de la clase RegistroIndicadores
        for (RegistroIndicadores r : listaCuentasPorCobrar)
            listaDeCuentas.add(r);

        //Vaciar Lista, para reutilizarse
        listaCuentasPorCobrar.clear();
        //set to list - recuperar los datos y hacerlo compatible para List
        listaCuentasPorCobrar.addAll(listaDeCuentas);

        //Arreglo especial para el llenado de los reportes
        List<RegistroCuenta> listCuentas = new ArrayList<>();

        //llenar el arreglo especificamente para el llenado de los reportes
        for (int i = 0; i < listaCuentasPorCobrar.size(); i++) {
            int cuenta = listaCuentasPorCobrar.get(i).getId_Cuenta().getCuenta();
            String mes1 = listaCuentasPorCobrar.get(i).getMes();
            int semana1 = listaCuentasPorCobrar.get(i).getSemana();
            int anio1 = listaCuentasPorCobrar.get(i).getAnio();
            double monto = listaCuentasPorCobrar.get(i).getMonto();

            RegistroCuenta x = new RegistroCuenta(cuenta, monto, mes1, semana1, anio1);
            listCuentas.add(x);
        }

        session.getTransaction();
        session.close();


        return listCuentas;
    }

}

