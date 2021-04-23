package sample.DAOs;

import entity.Clasificacion;
import hibernete.ConexionHibernete;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class ClasificacionDAO {
    private static SessionFactory factory;

    public static SessionFactory getFactory() {
        return factory;
    }

    public void setFactory(SessionFactory factory) {
        ClasificacionDAO.factory = factory;
    }

    @SuppressWarnings("deprecation")

    public ClasificacionDAO() {
        ConexionHibernete.setDriver("postgresql");
        ConexionHibernete.generarConexion();
        factory = ConexionHibernete.getFactory();
    }

    public void saveClasificacion(Clasificacion clasificacion) throws HibernateException {
        Session session = factory.openSession();
        session.beginTransaction();
        int id = 0;
        id = (int) session.save(clasificacion);
        session.getTransaction().commit();
        session.close();
    }


    public void updateClasificacion(Clasificacion clasificacion) throws HibernateException {
        Session session = factory.openSession();
        session.beginTransaction();
        session.update(clasificacion);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteClasificacion(Clasificacion clasificacion) throws HibernateException {
        Session session = factory.openSession();
        session.beginTransaction();
        session.delete(clasificacion);
        session.getTransaction();
        session.close();
    }

    public Clasificacion getClasificacion(String nombreClasificacion) throws HibernateException {
        Clasificacion clasificacion = null;
        Session session = factory.openSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(Clasificacion.class);
        criteria.add(Restrictions.eq("nombreClasificacion", nombreClasificacion));
        clasificacion = (Clasificacion) criteria.list().get(0);

        session.close();
        return clasificacion;
    }

    public List<Clasificacion> getListClasificaciones() throws HibernateException {
        List<Clasificacion> listaClasificaciones = null;
        Session session = factory.openSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(Clasificacion.class);
        listaClasificaciones = criteria.list();

        session.getTransaction();
        session.close();
        return listaClasificaciones;
    }
}
