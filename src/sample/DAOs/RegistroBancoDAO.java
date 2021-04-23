package sample.DAOs;

import entity.RegistroBanco;
import hibernete.ConexionHibernete;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import sample.DAOs.DAOsReportes.ExtraClass.Banco;

import java.util.ArrayList;
import java.util.List;

public class RegistroBancoDAO {
    private static SessionFactory factory;

    public static SessionFactory getFactory() {
        return factory;
    }

    public void setFactory(SessionFactory factory){
        RegistroBancoDAO.factory = factory;
    }

    @SuppressWarnings("deprecation")

    public RegistroBancoDAO(){
        ConexionHibernete.setDriver("postgresql");
        ConexionHibernete.generarConexion();
        factory = ConexionHibernete.getFactory();
    }

    public void saveRegistroBanco(RegistroBanco registroBanco) throws HibernateException {
        Session session = factory.openSession();
        session.beginTransaction();
        int id = 0;
        id = (int) session.save(registroBanco);
        session.getTransaction().commit();
        session.close();
    }

    public void updateRegistroBanco(RegistroBanco registroBanco) throws HibernateException {
        Session session = factory.openSession();
        session.beginTransaction();
        session.update(registroBanco);
        session.getTransaction().commit();
        session.close();
    }


    public List<Banco> getListRegistroBancosPorMes(String mes, int anio) throws HibernateException {
        List <RegistroBanco> listaRegistrosBancos = new ArrayList<>();
        List<Banco> listaBancos = new ArrayList<>();
        Session session = factory.openSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(RegistroBanco.class);
        criteria.add(Restrictions.eq("mes", mes));
        criteria.add(Restrictions.eq("anio", anio));
        listaRegistrosBancos = criteria.list();

        for (int i = 0; i < listaRegistrosBancos.size(); i++) {
            int numeroBanco1 = listaRegistrosBancos.get(i).getNumeroCuenta();
            String mes1 = listaRegistrosBancos.get(i).getMes();
            int semana1 = listaRegistrosBancos.get(i).getSemana();
            int anio1 = listaRegistrosBancos.get(i).getAnio();
            double monto = listaRegistrosBancos.get(i).getMonto();

            Banco x = new Banco(numeroBanco1, monto, semana1, mes1, anio1);
            listaBancos.add(x);
        }

        session.getTransaction();
        session.close();
        return listaBancos;
    }

    public List<Banco> getListRegistroBancosPorSemanaDelMes(int semana, String mes, int anio) throws HibernateException {
        List <RegistroBanco> listaRegistrosBancos = new ArrayList<>();
        List<Banco> listaBancos = new ArrayList<>();
        Session session = factory.openSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(RegistroBanco.class);
        criteria.add(Restrictions.eq("semana", semana));
        criteria.add(Restrictions.eq("mes", mes));
        criteria.add(Restrictions.eq("anio", anio));
        listaRegistrosBancos = criteria.list();

        for (int i = 0; i < listaRegistrosBancos.size(); i++) {
            int numeroBanco1 = listaRegistrosBancos.get(i).getNumeroCuenta();
            String mes1 = listaRegistrosBancos.get(i).getMes();
            int semana1 = listaRegistrosBancos.get(i).getSemana();
            int anio1 = listaRegistrosBancos.get(i).getAnio();
            double monto = listaRegistrosBancos.get(i).getMonto();

            Banco x = new Banco(numeroBanco1, monto, semana1, mes1, anio1);
            listaBancos.add(x);
        }

        session.getTransaction();
        session.close();
        return listaBancos;
    }

}
