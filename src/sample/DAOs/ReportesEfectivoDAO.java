package sample.DAOs;

import entity.ReportesEfectivo;
import hibernete.ConexionHibernete;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;
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

    public int saveReporteEfectivo(ReportesEfectivo reporteEfectivo) throws HibernateException {
        Session session = factory.openSession();
        session.beginTransaction();
        int id = 0;
        id = (int) session.save(reporteEfectivo);
        session.getTransaction().commit();
        session.close();
        return id;
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

        reporteEfectivo = (ReportesEfectivo) session.get(ReportesEfectivo.class, idReporteEfectivo);
        session.getTransaction();
        session.close();
        return reporteEfectivo;
    }

    public List<ReportesEfectivo> getListReportesEfectivos() throws HibernateException {
        List <ReportesEfectivo> listaReportesEfectivos = null;
        Session session = factory.openSession();
        session.beginTransaction();
        listaReportesEfectivos = session.createQuery("from reportesEfectivo").list();
        session.getTransaction();
        session.close();
        return listaReportesEfectivos;
    }
}
