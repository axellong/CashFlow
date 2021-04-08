package sample.DAOs;

import entity.Usuario;
import hibernete.ConexionHibernete;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.io.File;
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

    public boolean Validate(String Email, String Pass) throws HibernateException{
        boolean answer = true;
        Usuario users = null;
        String sentence = "FROM Usuario WHERE email='" + Email
                + "' and password='" + Pass + "'";
        try {
            Session session = factory.openSession();
            session.beginTransaction();
            List<Usuario> Listpeople = (List<Usuario>) session.createQuery(sentence).list();
            if (!Listpeople.isEmpty()){
                users = Listpeople.get(0);
                answer = true;
            }else{
                answer = false;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return answer;
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
        session.getTransaction();
        session.close();
    }

   public Usuario getUsuario(String email) throws HibernateException{
       Session session = factory.openSession();
       Criteria crit = session.createCriteria(Usuario.class);
       crit.add(Restrictions.eq("email",email));
       Usuario user = (Usuario) crit.list().get(0);
       session.close();
       return user;
   }

    public List<Usuario> getListUsuarios() throws HibernateException{
        Session session = factory.openSession();
        Criteria crit = session.createCriteria(Usuario.class);
        List<Usuario> listUsers = crit.list();
        session.close();
        return listUsers;
    }
}
