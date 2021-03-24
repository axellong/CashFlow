package sample.DAOs;

import entity.RegistroIndicadores;
import hibernete.ConexionHibernete;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import java.io.File;
import java.util.List;

public class RegistroIndicadoresDAO {

    private static SessionFactory factory;

    public static SessionFactory getFactory() {
        return factory;
    }

    public void setFactory(SessionFactory factory){
        RegistroIndicadoresDAO.factory = factory;
    }

    @SuppressWarnings("deprecation")

    public RegistroIndicadoresDAO(){
        ConexionHibernete.setDriver("postgresql");
        ConexionHibernete.generarConexion();
        factory = ConexionHibernete.getFactory();
    }

    public int saveRegistroIndicador (RegistroIndicadores registroIndicadores) throws HibernateException {
        Session session = factory.openSession();
        session.beginTransaction();
        int id = 0;
        id = (int) session.save(registroIndicadores);
        session.getTransaction().commit();
        session.close();
        return id;
    }


    public void updateRegistroIndicadores(RegistroIndicadores registroIndicadores) throws HibernateException {
        Session session = factory.openSession();
        session.beginTransaction();
        session.update(registroIndicadores);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteRegistroIndicador(RegistroIndicadores registroIndicadores) throws HibernateException {
        Session session = factory.openSession();
        session.beginTransaction();
        session.delete(registroIndicadores);
        session.getTransaction();
        session.close();
    }

    public RegistroIndicadores getRegistroIndicador(int idRegistroIndicador) throws HibernateException {
        RegistroIndicadores registroIndicador = null;
        Session session = factory.openSession();
        session.beginTransaction();

        registroIndicador = (RegistroIndicadores) session.get(RegistroIndicadores.class, idRegistroIndicador);
        session.getTransaction();
        session.close();
        return registroIndicador;
    }

    public List<RegistroIndicadores> getListRegistroIndicadores() throws HibernateException {
        List <RegistroIndicadores> listaRegistroIndicadores = null;
        Session session = factory.openSession();
        session.beginTransaction();
        listaRegistroIndicadores = session.createQuery("from registroIndicadores").list();
        session.getTransaction();
        session.close();
        return listaRegistroIndicadores;
    }
}