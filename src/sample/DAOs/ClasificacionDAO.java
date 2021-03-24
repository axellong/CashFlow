package sample.DAOs;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sample.Entitys.Clasificacion;

import java.io.File;
import java.util.List;

public class ClasificacionDAO {
    private static SessionFactory factory;

    public static SessionFactory getFactory() {
        return factory;
    }

    public void setFactory(SessionFactory factory){
        ClasificacionDAO.factory = factory;
    }

    @SuppressWarnings("deprecation")

    public ClasificacionDAO(String nombre){
        System.err.println("Starting");
        try {
            Configuration configuration = new Configuration();
            System.err.println("Reading Configuration");
            configuration.configure();

            factory = new Configuration().configure(new File("/src/sample/"+nombre+".cfg.xml")).buildSessionFactory();
        } catch (Throwable ex){
            System.err.println("Session cannot be created ");
        }
    }

    public int saveClasificacion(Clasificacion clasificacion) throws HibernateException {
        Session session = factory.openSession();
        session.beginTransaction();
        int id = 0;
        id = (int) session.save(clasificacion);
        session.getTransaction().commit();
        session.close();
        return id;
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

    public Clasificacion getClasificacion(int idClasificacion) throws HibernateException {
        Clasificacion clasificacion = null;
        Session session = factory.openSession();
        session.beginTransaction();

        clasificacion = (Clasificacion) session.get(Clasificacion.class, idClasificacion);
        session.getTransaction();
        session.close();
        return clasificacion;
    }

    public List<Clasificacion> getListClasificaciones() throws HibernateException {
        List <Clasificacion> listaClasificaciones = null;
        Session session = factory.openSession();
        session.beginTransaction();
        listaClasificaciones = session.createQuery("from clasificacion").list();
        session.getTransaction();
        session.close();
        return listaClasificaciones;
    }
}
