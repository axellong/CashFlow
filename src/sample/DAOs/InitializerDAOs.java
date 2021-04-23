package sample.DAOs;

import sample.DAOs.DAOsReportes.CuentasPorCobrarDAO;
import sample.DAOs.DAOsReportes.CuentasPorPagarDAO;
import sample.DAOs.DAOsReportes.GastosDAO;
import sample.DAOs.DAOsReportes.IngresosDAO;

public class InitializerDAOs {

    private CategoriaDAO categoriaDAO;
    private ClasificacionDAO clasificacionDAO;
    private ClasificacionIdicadoresDAO clasificacionIdicadoresDAO;
    private RegistrosEfectivoDAO registrosEfectivoDAO;
    private RegistroIndicadoresDAO registroIndicadoresDAO;
    private SubCategoriasDAO subCategoriasDAO;
    private UsuarioDAO usuarioDAO;
    private static InitializerDAOs initializerDAOs;

    //DAOsReportes
    private CuentasPorCobrarDAO cuentasPorCobrarDAO;
    private CuentasPorPagarDAO cuentasPorPagarDAO;
    private GastosDAO gastosDAO;
    private IngresosDAO ingresosDAO;

    private InitializerDAOs() {
        categoriaDAO = new CategoriaDAO();
        clasificacionDAO = new ClasificacionDAO();
        clasificacionIdicadoresDAO = new ClasificacionIdicadoresDAO();
        registrosEfectivoDAO = new RegistrosEfectivoDAO();
        registroIndicadoresDAO = new RegistroIndicadoresDAO();
        subCategoriasDAO = new SubCategoriasDAO();
        usuarioDAO = new UsuarioDAO();

        //DAOsReportes
        cuentasPorCobrarDAO = new CuentasPorCobrarDAO();
        cuentasPorPagarDAO = new CuentasPorPagarDAO();
        gastosDAO = new GastosDAO();
        ingresosDAO = new IngresosDAO();
    }

    public static InitializerDAOs getInitializerDAOs() {
        if (initializerDAOs == null) {
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

    public SubCategoriasDAO getSubCategoriasDAO() {
        return subCategoriasDAO;
    }

    public UsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }

    //DAOsReportes

    public CuentasPorCobrarDAO getCuentasPorCobrarDAO() {
        return cuentasPorCobrarDAO;
    }

    public CuentasPorPagarDAO getCuentasPorPagarDAO() {
        return cuentasPorPagarDAO;
    }

    public GastosDAO getGastosDAO() {
        return gastosDAO;
    }

    public IngresosDAO getIngresosDAO() {
        return ingresosDAO;
    }
}
