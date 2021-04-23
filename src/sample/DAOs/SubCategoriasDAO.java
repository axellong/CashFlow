package sample.DAOs;

import entity.SubCategoria;
import hibernete.ConexionHibernete;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class SubCategoriasDAO {
    private static SessionFactory factory;

    public static SessionFactory getFactory() {
        return factory;
    }

    public void setFactory(SessionFactory factory) {
        SubCategoriasDAO.factory = factory;
    }

    @SuppressWarnings("deprecation")

    public SubCategoriasDAO() {
        ConexionHibernete.setDriver("postgresql");
        ConexionHibernete.generarConexion();
        factory = ConexionHibernete.getFactory();
    }

    public void saveSubCategoria(SubCategoria subCategoria) throws HibernateException {
        Session session = factory.openSession();
        session.beginTransaction();
        int id = 0;
        id = (int) session.save(subCategoria);
        session.getTransaction().commit();
        session.close();
    }


    public void updateSubCategoria(SubCategoria subCategoria) throws HibernateException {
        Session session = factory.openSession();
        session.beginTransaction();
        session.update(subCategoria);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteSubCategoria(SubCategoria subCategoria) throws HibernateException {
        Session session = factory.openSession();
        session.beginTransaction();
        session.delete(subCategoria);
        session.getTransaction();
        session.close();
    }

    public SubCategoria getSubCategoria(String nombreSubCategoria) throws HibernateException {
        SubCategoria subCategoria = null;
        Session session = factory.openSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(SubCategoria.class);
        criteria.add(Restrictions.eq("nombreSubCategoria", nombreSubCategoria));
        subCategoria = (SubCategoria) criteria.list().get(0);

        session.close();
        return subCategoria;
    }

    public List<SubCategoria> getListSubCategorias() throws HibernateException {
        List<SubCategoria> listaSubCategorias = null;
        Session session = factory.openSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(SubCategoria.class);
        listaSubCategorias = criteria.list();

        session.close();
        return listaSubCategorias;
    }


}
