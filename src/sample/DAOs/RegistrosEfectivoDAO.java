package sample.DAOs;

import entity.RegistroEfectivo;
import hibernete.ConexionHibernete;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import java.io.File;
import java.util.List;

public class RegistrosEfectivoDAO {
    private static SessionFactory factory;

    public static SessionFactory getFactory() {
        return factory;
    }

    public void setFactory(SessionFactory factory){
        RegistrosEfectivoDAO.factory = factory;
    }

    @SuppressWarnings("deprecation")

    public RegistrosEfectivoDAO(){
        ConexionHibernete.setDriver("postgresql");
        ConexionHibernete.generarConexion();
        factory = ConexionHibernete.getFactory();
    }

    public int saveRegistroEfectivo(RegistroEfectivo registroEfectivo) throws HibernateException {
        Session session = factory.openSession();
        session.beginTransaction();
        int id = 0;
        id = (int) session.save(registroEfectivo);
        session.getTransaction().commit();
        session.close();
        return id;
    }


    public void updateRegistroEfectivo(RegistroEfectivo registroEfectivo) throws HibernateException {
        Session session = factory.openSession();
        session.beginTransaction();
        session.update(registroEfectivo);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteRegistroEfectivo(RegistroEfectivo registroEfectivo) throws HibernateException {
        Session session = factory.openSession();
        session.beginTransaction();
        session.delete(registroEfectivo);
        session.getTransaction();
        session.close();
    }

    public RegistroEfectivo getRegistroEfectivo(int idRegistroEfectivo) throws HibernateException {
        RegistroEfectivo registroEfectivo = null;
        Session session = factory.openSession();
        session.beginTransaction();

        registroEfectivo = (RegistroEfectivo) session.get(RegistroEfectivo.class, idRegistroEfectivo);
        session.getTransaction();
        session.close();
        return registroEfectivo;
    }

    public List<RegistroEfectivo> getListRegistrosEfectivos() throws HibernateException {
        List <RegistroEfectivo> listaRegistrosEfectivos = null;
        Session session = factory.openSession();
        session.beginTransaction();
        listaRegistrosEfectivos = session.createQuery("from registroEfectivo").list();
        session.getTransaction();
        session.close();
        return listaRegistrosEfectivos;
    }
}
