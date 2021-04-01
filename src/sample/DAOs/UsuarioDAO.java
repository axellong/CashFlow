package sample.DAOs;

import entity.Usuario;
import hibernete.ConexionHibernete;
import org.hibernate.*;
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

    public boolean getlogueo(String emails, String Passw){
        Session session = factory.openSession();
        session.beginTransaction();
        try {
            Usuario users = (Usuario) session.createQuery("FROM Usuario");
            if (users!=null){
                if (users.getPassword().equals(Passw)){
                    System.out.println("Encontrado");
                    return true;
                }else{
                    System.out.println("No encontrado");
                    return false;
                }
            }else {
                System.out.println("No Existe");
                return false;
            }
        }catch (Exception e){
            System.out.println("Error" + e);
            return false;
        }
    }

    public void Mostrar(){
        try {
            Session session = factory.openSession();
            session.beginTransaction();
            Query query = session.createQuery("FROM Usuario");
            List<Usuario> people = query.list();
            for (Usuario users : people) {
                System.out.println(" La Lista es: \n" + users);
            }
        }catch (HibernateException e){
            System.out.println(e);
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
        listaUsuarios = session.createQuery("from Usuario").list();
        session.getTransaction();
        session.close();
        return listaUsuarios;
    }
}
