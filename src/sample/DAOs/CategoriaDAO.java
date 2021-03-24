package sample.DAOs;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sample.Entitys.Categoria;

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

    public CategoriaDAO(String nombre){
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
