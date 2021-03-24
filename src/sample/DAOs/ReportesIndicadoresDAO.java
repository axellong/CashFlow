package sample.DAOs;

import entity.ReportesIndicadores;
import hibernete.ConexionHibernete;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;
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

    public int saveReporteIndicador(ReportesIndicadores reporteIndicador) throws HibernateException {
        Session session = factory.openSession();
        session.beginTransaction();
        int id = 0;
        id = (int) session.save(reporteIndicador);
        session.getTransaction().commit();
        session.close();
        return id;
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

        reporteIndicador = (ReportesIndicadores) session.get(ReportesIndicadores.class, idReporteIndicador);
        session.getTransaction();
        session.close();
        return reporteIndicador;
    }

    public List<ReportesIndicadores> getListReportesIndicadores() throws HibernateException {
        List <ReportesIndicadores> listaReportesIndicadores = null;
        Session session = factory.openSession();
        session.beginTransaction();
        listaReportesIndicadores = session.createQuery("from reportesIndicadores").list();
        session.getTransaction();
        session.close();
        return listaReportesIndicadores;
    }
}
