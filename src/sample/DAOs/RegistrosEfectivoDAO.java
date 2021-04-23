package sample.DAOs;

import entity.RegistroEfectivo;
import hibernete.ConexionHibernete;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class RegistrosEfectivoDAO {
    private static SessionFactory factory;

    public static SessionFactory getFactory() {
        return factory;
    }

    public void setFactory(SessionFactory factory) {
        RegistrosEfectivoDAO.factory = factory;
    }

    @SuppressWarnings("deprecation")

    public RegistrosEfectivoDAO() {
        ConexionHibernete.setDriver("postgresql");
        ConexionHibernete.generarConexion();
        factory = ConexionHibernete.getFactory();
    }

    public void saveRegistroEfectivo(RegistroEfectivo registroEfectivo) throws HibernateException {
        Session session = factory.openSession();
        session.beginTransaction();
        int id = 0;
        id = (int) session.save(registroEfectivo);
        session.getTransaction().commit();
        session.close();
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

        Criteria criteria = session.createCriteria(RegistroEfectivo.class);
        criteria.add(Restrictions.eq("idRegistroEfectivo", idRegistroEfectivo));
        registroEfectivo = (RegistroEfectivo) criteria.list().get(0);

        session.close();
        return registroEfectivo;
    }

    public List<RegistroEfectivo> getListRegistrosEfectivos() throws HibernateException {
        List<RegistroEfectivo> listaRegistrosEfectivos = null;
        Session session = factory.openSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(RegistroEfectivo.class);
        listaRegistrosEfectivos = criteria.list();

        session.close();
        return listaRegistrosEfectivos;
    }
}
