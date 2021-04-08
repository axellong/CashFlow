package sample.DAOs;

import entity.Categoria;
import hibernete.ConexionHibernete;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class CategoriaDAO {

    private static SessionFactory factory;

    public static SessionFactory getFactory() {
        return factory;
    }

    public void setFactory(SessionFactory factory){
        CategoriaDAO.factory = factory;
    }

    @SuppressWarnings("deprecation")

    public CategoriaDAO(){
        ConexionHibernete.setDriver("postgresql");
        ConexionHibernete.generarConexion();
        factory = ConexionHibernete.getFactory();
    }

    public void saveCategoria(Categoria categoria) throws HibernateException {
        Session session = factory.openSession();
        session.beginTransaction();
        int id = 0;
        id = (int) session.save(categoria);
        session.getTransaction().commit();
        session.close();
    }


    public void updateCategoria(Categoria categoria) throws HibernateException {
        Session session = factory.openSession();
        session.beginTransaction();
        session.update(categoria);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteCategoria(Categoria categoria) throws HibernateException {
        Session session = factory.openSession();
        session.beginTransaction();
        session.delete(categoria);
        session.getTransaction();
        session.close();
    }

    public Categoria getCategoria(String nombreCategoria) throws HibernateException {
        Categoria categoria = null;
        Session session = factory.openSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(Categoria.class);
        criteria.add(Restrictions.eq("nombreCategoria", nombreCategoria));
        categoria = (Categoria) session.get(Categoria.class, nombreCategoria);

        session.close();
        return categoria;
    }

    public List<Categoria> getListCategorias() throws HibernateException {
        List <Categoria> listaCategorias = null;
        Session session = factory.openSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(Categoria.class);
        listaCategorias = criteria.list();

        session.getTransaction();
        //session.close();
        return listaCategorias;
    }
}