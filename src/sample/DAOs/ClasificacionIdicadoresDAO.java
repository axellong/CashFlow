package sample.DAOs;

import entity.ClasificacionIndicadores;
import hibernete.ConexionHibernete;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

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

    public void saveClasificacionIndicador(ClasificacionIndicadores clasificacionIndicadores) throws HibernateException {
        Session session = factory.openSession();
        session.beginTransaction();
        int id = 0;
        id = (int) session.save(clasificacionIndicadores);
        session.getTransaction().commit();
        session.close();
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

        Criteria criteria = session.createCriteria(ClasificacionIndicadores.class);
        criteria.add(Restrictions.eq("idClasificadoresIndicadores", idClasificacionIndicador));
        clasificacionIndicador = (ClasificacionIndicadores) criteria.list().get(0);

        session.close();
        return clasificacionIndicador;
    }

    public List<ClasificacionIndicadores> getListClasificacionIndicadores() throws HibernateException {
        List <ClasificacionIndicadores> listaClasificacionIndicadores = null;
        Session session = factory.openSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(ClasificacionIndicadores.class);
        listaClasificacionIndicadores = criteria.list();

        session.getTransaction();
        session.close();
        return listaClasificacionIndicadores;
    }
}
