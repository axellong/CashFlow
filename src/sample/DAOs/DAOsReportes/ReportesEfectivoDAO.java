package sample.DAOs.DAOsReportes;

import entity.ReportesEfectivo;
import hibernete.ConexionHibernete;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class ReportesEfectivoDAO {

    private static SessionFactory factory;

    public static SessionFactory getFactory() {
        return factory;
    }

    public void setFactory(SessionFactory factory){
        ReportesEfectivoDAO.factory = factory;
    }

    @SuppressWarnings("deprecation")

    public ReportesEfectivoDAO(){
        ConexionHibernete.setDriver("postgresql");
        ConexionHibernete.generarConexion();
        factory = ConexionHibernete.getFactory();
    }

    public void saveReporteEfectivo(ReportesEfectivo reporteEfectivo) throws HibernateException {
        Session session = factory.openSession();
        session.beginTransaction();
        int id = 0;
        id = (int) session.save(reporteEfectivo);
        session.getTransaction().commit();
        session.close();
    }


    public void updateReporteEfectivo(ReportesEfectivo reporteEfectivo) throws HibernateException {
        Session session = factory.openSession();
        session.beginTransaction();
        session.update(reporteEfectivo);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteReporteEfectivo(ReportesEfectivo reporteEfectivo) throws HibernateException {
        Session session = factory.openSession();
        session.beginTransaction();
        session.delete(reporteEfectivo);
        session.getTransaction();
        session.close();
    }

    public ReportesEfectivo getReporteEfectivo(int idReporteEfectivo) throws HibernateException {
        ReportesEfectivo reporteEfectivo = null;
        Session session = factory.openSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(ReportesEfectivo.class);
        criteria.add(Restrictions.eq("idReporte",idReporteEfectivo));
        reporteEfectivo = (ReportesEfectivo) criteria.list().get(0);

        session.close();
        return reporteEfectivo;
    }

    public List<ReportesEfectivo> getListReportesEfectivos() throws HibernateException {
        List <ReportesEfectivo> listaReportesEfectivos = null;
        Session session = factory.openSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(ReportesEfectivo.class);
        listaReportesEfectivos = criteria.list();

        session.close();
        return listaReportesEfectivos;
    }
}
