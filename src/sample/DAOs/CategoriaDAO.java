package sample.DAOs;

import entity.Categoria;
import hibernete.ConexionHibernete;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import java.io.File;
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

    public int saveCategoria(Categoria categoria) throws HibernateException {
        Session session = factory.openSession();
        session.beginTransaction();
        int id = 0;
        id = (int) session.save(categoria);
        session.getTransaction().commit();
        session.close();
        return id;
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

    public Categoria getCategoria(int idCategoria) throws HibernateException {
        Categoria categoria = null;
        Session session = factory.openSession();
        session.beginTransaction();

        categoria = (Categoria) session.get(Categoria.class, idCategoria);
        session.getTransaction();
        session.close();
        return categoria;
    }

    public List<Categoria> getListCategorias() throws HibernateException {
        List <Categoria> listaCategorias = null;
        Session session = factory.openSession();
        session.beginTransaction();
        listaCategorias = session.createQuery("from categoria").list();
        session.getTransaction();
        session.close();
        return listaCategorias;
    }
}
