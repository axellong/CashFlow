package sample.DAOs.DAOsReportes;

import entity.RegistroEfectivo;
import hibernete.ConexionHibernete;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import sample.DAOs.DAOsReportes.ExtraClass.Ingresos;

import java.util.ArrayList;
import java.util.List;

public class GastosDAO {
    private static SessionFactory factory;

    public static SessionFactory getFactory() {
        return factory;
    }

    public void setFactory(SessionFactory factory) {
        GastosDAO.factory = factory;
    }

    @SuppressWarnings("deprecation")

    public GastosDAO() {
        ConexionHibernete.setDriver("postgresql");
        ConexionHibernete.generarConexion();
        factory = ConexionHibernete.getFactory();
    }

    public List<RegistroEfectivo> getListGastosPorMes(String mes, int anio) {
        List<RegistroEfectivo> listRegistroEfectivo = new ArrayList<>();
        List<Ingresos> listaIngresos = new ArrayList<>();

        Session session = factory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(RegistroEfectivo.class);
        criteria.add(Restrictions.eq("tipoMovimiento", "Salida"));
        criteria.add(Restrictions.eq("mes", mes));
        criteria.add(Restrictions.eq("anio", anio));
        listRegistroEfectivo = criteria.list();


        session.getTransaction();
        session.close();

        return listRegistroEfectivo;
    }

    public List<Ingresos> getListGastosPorSemanaDelMes(int semana, String mes, int anio) {
        List<RegistroEfectivo> listRegistroEfectivo = new ArrayList<>();
        List<Ingresos> listaIngresos = new ArrayList<>();

        Session session = factory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(RegistroEfectivo.class);
        criteria.add(Restrictions.eq("tipoMovimiento", "Salida"));
        criteria.add(Restrictions.eq("semana", semana));
        criteria.add(Restrictions.eq("mes", mes));
        criteria.add(Restrictions.eq("anio", anio));
        listRegistroEfectivo = criteria.list();

        for (int i = 0; i < listRegistroEfectivo.size(); i++) {
            String nombreClasificacion = listRegistroEfectivo.get(i).getIdSubcategoria().getId_Categoria().getClasificacion().getNombreClasificacion();
            double monto = listRegistroEfectivo.get(i).getMonto();
            String mes1 = listRegistroEfectivo.get(i).getMes();
            int semana1 = listRegistroEfectivo.get(i).getSemana();
            int anio1 = listRegistroEfectivo.get(i).getAnio();

            Ingresos ingresos = new Ingresos(nombreClasificacion, monto, mes1, semana1, anio1);
            listaIngresos.add(ingresos);
        }

        session.getTransaction();
        session.close();

        return listaIngresos;
    }
}
