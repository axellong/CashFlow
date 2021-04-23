package sample.DAOs;

import entity.Usuario;
import hibernete.ConexionHibernete;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class UsuarioDAO {

    private static SessionFactory factory;

    public static SessionFactory getFactory() {
        return factory;
    }

    public void setFactory(SessionFactory factory) {
        UsuarioDAO.factory = factory;
    }

    @SuppressWarnings("deprecation")

    public UsuarioDAO() {
        ConexionHibernete.setDriver("postgresql");
        ConexionHibernete.generarConexion();
        factory = ConexionHibernete.getFactory();
    }

    public int saveUsuario(Usuario usuario) throws HibernateException {
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
        session.getTransaction().commit();
        session.close();
    }

    public Usuario getUsuario(String email, String password) throws HibernateException {
        Session session = factory.openSession();
        Criteria crit = session.createCriteria(Usuario.class);
        crit.add(Restrictions.eq("email", email));
        crit.add(Restrictions.eq("password", password));
        Usuario user = null;
        if (!crit.list().isEmpty()) {
            user = (Usuario) crit.list().get(0);
        }
        session.close();
        return user;
    }

    public List<Usuario> getListUsuarios() throws HibernateException {
        Session session = factory.openSession();
        Criteria crit = session.createCriteria(Usuario.class);
        List<Usuario> listUsers = crit.list();
        session.close();
        return listUsers;
    }
}
