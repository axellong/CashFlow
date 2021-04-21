package sample.DAOs;

import sample.DAOs.DAOsReportes.ReportesEfectivoDAO;
import sample.DAOs.DAOsReportes.ReportesIndicadoresDAO;

public class InitializerDAOs {

    private CategoriaDAO categoriaDAO;
    private ClasificacionDAO clasificacionDAO;
    private ClasificacionIdicadoresDAO clasificacionIdicadoresDAO;
    private RegistrosEfectivoDAO registrosEfectivoDAO;
    private RegistroIndicadoresDAO registroIndicadoresDAO;
    private ReportesEfectivoDAO reportesEfectivoDAO;
    private ReportesIndicadoresDAO reportesIndicadoresDAO;
    private SubCategoriasDAO subCategoriasDAO;
    private UsuarioDAO usuarioDAO;
    private static InitializerDAOs initializerDAOs;

    private InitializerDAOs(){
            categoriaDAO = new CategoriaDAO();
            clasificacionDAO = new ClasificacionDAO();
            clasificacionIdicadoresDAO = new ClasificacionIdicadoresDAO();
            registrosEfectivoDAO = new RegistrosEfectivoDAO();
            registroIndicadoresDAO = new RegistroIndicadoresDAO();
            reportesEfectivoDAO = new ReportesEfectivoDAO();
            reportesIndicadoresDAO = new ReportesIndicadoresDAO();
            subCategoriasDAO = new SubCategoriasDAO();
            usuarioDAO = new UsuarioDAO();
    }

    public static InitializerDAOs getInitializerDAOs(){
        if(initializerDAOs == null){
            initializerDAOs = new InitializerDAOs();
        }
        return initializerDAOs;
    }

    public CategoriaDAO getCategoriaDAO() {
        return categoriaDAO;
    }

    public ClasificacionDAO getClasificacionDAO() {
        return clasificacionDAO;
    }

    public ClasificacionIdicadoresDAO getClasificacionIdicadoresDAO() {
        return clasificacionIdicadoresDAO;
    }

    public RegistrosEfectivoDAO getRegistrosEfectivoDAO() {
        return registrosEfectivoDAO;
    }

    public RegistroIndicadoresDAO getRegistroIndicadoresDAO() {
        return registroIndicadoresDAO;
    }

    public ReportesEfectivoDAO getReportesEfectivoDAO() {
        return reportesEfectivoDAO;
    }

    public ReportesIndicadoresDAO getReportesIndicadoresDAO() {
        return reportesIndicadoresDAO;
    }

    public SubCategoriasDAO getSubCategoriasDAO() {
        return subCategoriasDAO;
    }

    public UsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }
}
