package sample.DAOs.DAOsReportes;

import entity.RegistroEfectivo;
import entity.RegistroIndicadores;
import hibernete.ConexionHibernete;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import sample.DAOs.DAOsReportes.ExtraClass.Ingresos;
import sample.DAOs.RegistrosEfectivoDAO;

import java.util.ArrayList;
import java.util.List;

public class IngresosDAO {

    private static SessionFactory factory;

    public static SessionFactory getFactory() {
        return factory;
    }

    public void setFactory(SessionFactory factory){
        IngresosDAO.factory = factory;
    }

    @SuppressWarnings("deprecation")

    public IngresosDAO(){
        ConexionHibernete.setDriver("postgresql");
        ConexionHibernete.generarConexion();
        factory = ConexionHibernete.getFactory();
    }

    public List<Ingresos> getListIngresosPorMes(String mes, int anio){
        List<RegistroEfectivo> listRegistroEfectivo = new ArrayList<>();
        List<Ingresos> listaIngresos = new ArrayList<>();

        Session session = factory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(RegistroEfectivo.class);
        criteria.add(Restrictions.eq("tipoMovimiento", "Entrada"));
        criteria.add(Restrictions.eq("mes", mes));
        criteria.add(Restrictions.eq("anio", anio));
        listRegistroEfectivo = criteria.list();

        for (int i = 0; i < listRegistroEfectivo.size(); i++) {
            String nombreCategoria = listRegistroEfectivo.get(i).getIdSubcategoria().getId_Categoria().getNombreCategoria();
            double monto = listRegistroEfectivo.get(i).getMonto();
            String mes1 = listRegistroEfectivo.get(i).getMes();
            int semana1 = listRegistroEfectivo.get(i).getSemana();
            int anio1 = listRegistroEfectivo.get(i).getAnio();

            Ingresos ingresos = new Ingresos(nombreCategoria, monto, mes1, semana1, anio1);
            listaIngresos.add(ingresos);
        }

        session.getTransaction();
        session.close();

        return listaIngresos;
    }

    public List<Ingresos> getListIngresosPorSemanaDelMes(int semana, String mes, int anio){
        List<RegistroEfectivo> listRegistroEfectivo = new ArrayList<>();
        List<Ingresos> listaIngresos = new ArrayList<>();

        Session session = factory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(RegistroEfectivo.class);
        criteria.add(Restrictions.eq("tipoMovimiento", "Entrada"));
        criteria.add(Restrictions.eq("semana", semana));
        criteria.add(Restrictions.eq("mes", mes));
        criteria.add(Restrictions.eq("anio", anio));
        listRegistroEfectivo = criteria.list();

        for (int i = 0; i < listRegistroEfectivo.size(); i++) {
            String nombreCategoria = listRegistroEfectivo.get(i).getIdSubcategoria().getId_Categoria().getNombreCategoria();
            double monto = listRegistroEfectivo.get(i).getMonto();
            String mes1 = listRegistroEfectivo.get(i).getMes();
            int semana1 = listRegistroEfectivo.get(i).getSemana();
            int anio1 = listRegistroEfectivo.get(i).getAnio();

            Ingresos ingresos = new Ingresos(nombreCategoria, monto, mes1, semana1, anio1);
            listaIngresos.add(ingresos);
        }

        session.getTransaction();
        session.close();


        return listaIngresos;
    }

}
