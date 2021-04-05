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

    public void setFactory(SessionFactory factory){
        UsuarioDAO.factory = factory;
    }

    @SuppressWarnings("deprecation")

    public UsuarioDAO(){
        ConexionHibernete.setDriver("postgresql");
        ConexionHibernete.generarConexion();
        factory = ConexionHibernete.getFactory();
    }

    public void saveUsuario (Usuario usuario) throws HibernateException {
        Session session = factory.openSession();
        session.beginTransaction();
        int id = 0;
        id = (int) session.save(usuario);
        session.getTransaction().commit();
        session.close();
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

    public Usuario getUsuario(String email) throws HibernateException {
        Usuario usuario = null;
        Session session = factory.openSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(Usuario.class);
        criteria.add(Restrictions.eq("email", email));

        usuario = (Usuario) criteria.list().get(0);
        session.getTransaction();
        session.close();
        return usuario;
    }

    public List<Usuario> getListUsuarios() throws HibernateException {
        List <Usuario> listaUsuarios = null;
        Session session = factory.openSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(Usuario.class);

        listaUsuarios = criteria.list();

        session.getTransaction();
        session.close();
        return listaUsuarios;
    }
}
