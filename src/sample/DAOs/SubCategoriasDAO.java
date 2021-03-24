package sample.DAOs;

import entity.SubCategoria;
import hibernete.ConexionHibernete;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.util.List;

public class SubCategoriasDAO {
    private static SessionFactory factory;

    public static SessionFactory getFactory() {
        return factory;
    }

    public void setFactory(SessionFactory factory){
        SubCategoriasDAO.factory = factory;
    }

    @SuppressWarnings("deprecation")

    public SubCategoriasDAO(){
        ConexionHibernete.setDriver("postgresql");
        ConexionHibernete.generarConexion();
        factory = ConexionHibernete.getFactory();
    }

    public int saveSubCategoria(SubCategoria subCategoria) throws HibernateException {
        Session session = factory.openSession();
        session.beginTransaction();
        int id = 0;
        id = (int) session.save(subCategoria);
        session.getTransaction().commit();
        session.close();
        return id;
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

    public SubCategoria getSubCategoria(int idSubCategoria) throws HibernateException {
        SubCategoria subCategoria = null;
        Session session = factory.openSession();
        session.beginTransaction();

        subCategoria = (SubCategoria) session.get(SubCategoria.class, idSubCategoria);
        session.getTransaction();
        session.close();
        return subCategoria;
    }

    public List<SubCategoria> getListSubCategorias() throws HibernateException {
        List <SubCategoria> listaSubCategorias = null;
        Session session = factory.openSession();
        session.beginTransaction();
        listaSubCategorias = session.createQuery("from subCategoria").list();
        session.getTransaction();
        session.close();
        return listaSubCategorias;
    }
}
