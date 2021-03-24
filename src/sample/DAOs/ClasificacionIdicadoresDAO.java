package sample.DAOs;

import entity.ClasificacionIndicadores;
import hibernete.ConexionHibernete;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import java.io.File;
import java.util.List;

public class ClasificacionIdicadoresDAO {
    private static SessionFactory factory;

    public static SessionFactory getFactory() {
        return factory;
    }

    public void setFactory(SessionFactory factory){
        ClasificacionIdicadoresDAO.factory = factory;
    }

    @SuppressWarnings("deprecation")

    public ClasificacionIdicadoresDAO(){
        ConexionHibernete.setDriver("postgresql");
        ConexionHibernete.generarConexion();
        factory = ConexionHibernete.getFactory();
    }

    public int saveClasificacionIndicador(ClasificacionIndicadores clasificacionIndicadores) throws HibernateException {
        Session session = factory.openSession();
        session.beginTransaction();
        int id = 0;
        id = (int) session.save(clasificacionIndicadores);
        session.getTransaction().commit();
        session.close();
        return id;
    }


    public void updateClasificacion(ClasificacionIndicadores clasificacionIndicadores) throws HibernateException {
        Session session = factory.openSession();
        session.beginTransaction();
        session.update(clasificacionIndicadores);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteClasificacion(ClasificacionIndicadores clasificacionIndicadores) throws HibernateException {
        Session session = factory.openSession();
        session.beginTransaction();
        session.delete(clasificacionIndicadores);
        session.getTransaction();
        session.close();
    }

    public ClasificacionIndicadores getClasificacion(int idClasificacionIndicador) throws HibernateException {
        ClasificacionIndicadores clasificacionIndicador = null;
        Session session = factory.openSession();
        session.beginTransaction();

        clasificacionIndicador = (ClasificacionIndicadores) session.get(ClasificacionIndicadores.class, idClasificacionIndicador);
        session.getTransaction();
        session.close();
        return clasificacionIndicador;
    }

    public List<ClasificacionIndicadores> getListClasificacionIndicadores() throws HibernateException {
        List <ClasificacionIndicadores> listaClasificacionIndicadores = null;
        Session session = factory.openSession();
        session.beginTransaction();
        listaClasificacionIndicadores = session.createQuery("from clasificacionIndicadores").list();
        session.getTransaction();
        session.close();
        return listaClasificacionIndicadores;
    }
}
