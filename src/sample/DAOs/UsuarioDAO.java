package sample.DAOs;

import sample.Entitys.Usuario;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.util.List;

public class UsuarioDAO {

    private static SessionFactory factory;

    public static SessionFactory getFactory() {
        return factory;
    }

    public void setFactory(SessionFactory factory){
        UsuarioDAO.factory = factory;
    }

    @SuppressWarnings("deprecation")

    public UsuarioDAO(String nombre){
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

    public int saveUsuario (Usuario usuario) throws HibernateException {
        Session session = factory.openSession();
        session.beginTransaction();
        int id = 0;
        id = (int) session.save(usuario);
        session.getTransaction().commit();
        session.close();
        return id;
    }


    public void updateUsuario(Usuario usuario) throws HibernateException {
        Session session = factory.openSession();
        session.beginTransaction();
        session.update(usuario);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteUsuario(Usuario usuario) throws HibernateException {
        Session session = factory.openSession();
        session.beginTransaction();
        session.delete(usuario);
        session.getTransaction();
        session.close();
    }

    public Usuario getUsuario(int idUsuario) throws HibernateException {
        Usuario usuario = null;
        Session session = factory.openSession();
        session.beginTransaction();

        usuario = (Usuario) session.get(Usuario.class, idUsuario);
        session.getTransaction();
        session.close();
        return usuario;
    }

    public List<Usuario> getListUsuarios() throws HibernateException {
        List <Usuario> listaUsuarios = null;
        Session session = factory.openSession();
        session.beginTransaction();
        listaUsuarios = session.createQuery("from usuario").list();
        session.getTransaction();
        session.close();
        return listaUsuarios;
    }
}
