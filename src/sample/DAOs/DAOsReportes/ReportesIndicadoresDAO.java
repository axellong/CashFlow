package sample.DAOs.DAOsReportes;

import entity.ReportesIndicadores;
import hibernete.ConexionHibernete;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class ReportesIndicadoresDAO {

    private static SessionFactory factory;

    public static SessionFactory getFactory() {
        return factory;
    }

    public void setFactory(SessionFactory factory){
        ReportesIndicadoresDAO.factory = factory;
    }

    @SuppressWarnings("deprecation")

    public ReportesIndicadoresDAO(){
        ConexionHibernete.setDriver("postgresql");
        ConexionHibernete.generarConexion();
        factory = ConexionHibernete.getFactory();
    }

    public void saveReporteIndicador(ReportesIndicadores reporteIndicador) throws HibernateException {
        Session session = factory.openSession();
        session.beginTransaction();
        int id = 0;
        id = (int) session.save(reporteIndicador);
        session.getTransaction().commit();
        session.close();
    }


    public void updateReporteIndicador(ReportesIndicadores reporteIndicador) throws HibernateException {
        Session session = factory.openSession();
        session.beginTransaction();
        session.update(reporteIndicador);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteReporteIndicador(ReportesIndicadores reporteIndicador) throws HibernateException {
        Session session = factory.openSession();
        session.beginTransaction();
        session.delete(reporteIndicador);
        session.getTransaction();
        session.close();
    }

    public ReportesIndicadores getReporteIndicador(int idReporteIndicador) throws HibernateException {
        ReportesIndicadores reporteIndicador = null;
        Session session = factory.openSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(ReportesIndicadores.class);
        criteria.add(Restrictions.eq("idReporte", idReporteIndicador));
        reporteIndicador = (ReportesIndicadores) criteria.list().get(0);
//        reporteIndicador.toString();
//        reporteIndicador.getIdRegistroIndicadores().toString();
        session.getTransaction().commit();
        session.close();
        return reporteIndicador;
    }

    public List<ReportesIndicadores> getListReportesIndicadores() throws HibernateException {
        List <ReportesIndicadores> listaReportesIndicadores = null;
        Session session = factory.openSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(ReportesIndicadores.class);
        listaReportesIndicadores = criteria.list();

        session.close();
        return listaReportesIndicadores;
    }
}
