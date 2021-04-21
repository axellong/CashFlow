package sample.DAOs;

import entity.Cuenta;
import entity.RegistroIndicadores;
import hibernete.ConexionHibernete;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RegistroIndicadoresDAO {

    private static SessionFactory factory;

    public static SessionFactory getFactory() {
        return factory;
    }

    public void setFactory(SessionFactory factory){
        RegistroIndicadoresDAO.factory = factory;
    }

    @SuppressWarnings("deprecation")

    public RegistroIndicadoresDAO(){
        ConexionHibernete.setDriver("postgresql");
        ConexionHibernete.generarConexion();
        factory = ConexionHibernete.getFactory();
    }

    public void saveRegistroIndicador (RegistroIndicadores registroIndicadores, int numeroCuenta) throws HibernateException {
       //añadir el numero de cuenta

        Cuenta cuenta1 = new Cuenta(numeroCuenta);

        for (int i = 0; i < getListRegistroIndicadores().size(); i++) {
            if (getListRegistroIndicadores().get(i).getId_Cuenta().getCuenta() == numeroCuenta){
                registroIndicadores.getId_Cuenta().setId_Cuenta(getListRegistroIndicadores().get(i).getId_Cuenta().getId_Cuenta());
            }
            else{
                registroIndicadores.setId_Cuenta(cuenta1);
            }
        }

       //inicializar la coleccion set para agregar registro dentro de cuenta
        Set<RegistroIndicadores> registroIndicadores1 = new HashSet<>();
        registroIndicadores1.add(registroIndicadores);
        //añadir el registroIndicadores1 a la cuenta
        cuenta1.setRegistroIndicadores(registroIndicadores1);

        try {
            Session session = factory.openSession();
            session.beginTransaction();

            for (int i = 0; i < getListRegistroIndicadores().size(); i++) {
                if (numeroCuenta == getListRegistroIndicadores().get(i).getId_Cuenta().getCuenta()){
                    session.save(registroIndicadores);
                    session.save(cuenta1);
                }
                else{
                    session.save(registroIndicadores);
                }
            }


            session.getTransaction().commit();
            session.close();

        }catch (Exception e){
            System.out.println("Process fail");
            System.out.println("Exception occured. "+ e.getMessage());
            e.printStackTrace();
        }


    }


    public void updateRegistroIndicadores(RegistroIndicadores registroIndicadores) throws HibernateException {
        Session session = factory.openSession();
        session.beginTransaction();
        session.update(registroIndicadores);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteRegistroIndicador(RegistroIndicadores registroIndicadores) throws HibernateException {
        Session session = factory.openSession();
        session.beginTransaction();
        session.delete(registroIndicadores);
        session.getTransaction();
        session.close();
    }

    public RegistroIndicadores getRegistroIndicador(int idRegistroIndicador) throws HibernateException {
        RegistroIndicadores registroIndicador = null;
        Session session = factory.openSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(RegistroIndicadores.class);
        criteria.add(Restrictions.eq("idRegistroIndicadores", idRegistroIndicador));
        registroIndicador = (RegistroIndicadores) criteria.list().get(0);

        session.close();
        return registroIndicador;
    }

    public List<RegistroIndicadores> getListRegistroIndicadores() throws HibernateException {
        List <RegistroIndicadores> listaRegistroIndicadores = null;
        Session session = factory.openSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(RegistroIndicadores.class);
        listaRegistroIndicadores = criteria.list();
        session.getTransaction();
        listaRegistroIndicadores.toString();
        session.close();


        return listaRegistroIndicadores;
    }
}