package sample.Reports;

import logic.Model.Calculos;
import logic.Model.ReportFill;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

import java.util.List;

public class ReporteJunto implements JRDataSource {
    private List<ReportFill> listaLlenadoCobrar;
    private List<Double> totalesCobrar;
    private String mesCobrar;
    private int indexCobrar;
    private List<ReportFill> listaCuentasPagar;
    private List<Double> totalesPagar;
    private String mesPagar;
    private int indexPagar;
    boolean cobrarsigue;
    boolean pagarsigue;
    boolean banderaCobrar;
    boolean banderaPagar;


    public ReporteJunto(String mes, int año) {

        banderaPagar=false;
        banderaCobrar=false;
        cobrarsigue = false;
        pagarsigue = false;
        this.mesPagar = mes;
        this.mesCobrar = mes;
        inicializarCobrar(año);
        inicializarPagar(año);
    }

    private void inicializarCobrar(int año) {
        indexCobrar = -1;
        Calculos calculos = new Calculos();
        listaLlenadoCobrar = calculos.getCuentascobrar(mesCobrar, año);
        System.out.println("COBRAR");
        System.out.println(listaLlenadoCobrar);
        totalesCobrar = calculos.getTotales(listaLlenadoCobrar);


    }

    private void inicializarPagar(int año) {
        indexPagar = -1;
        Calculos calculos = new Calculos();
        listaCuentasPagar = calculos.getCuentasPagar(mesPagar, año);
        System.out.println("PAGAR");
        System.out.println(listaCuentasPagar);
        totalesPagar = calculos.getTotales(listaCuentasPagar);

    }

    public static JRDataSource getDataSource(String mes, int año) {
        return new ReporteJunto(mes, año);
    }

    @Override
    public boolean next() throws JRException {
        boolean sigue = false;
        indexPagar++;
        indexCobrar++;

        if (indexCobrar < listaLlenadoCobrar.size() & banderaCobrar==false) {
            cobrarsigue = true;
        } else {
            banderaCobrar=true;
            cobrarsigue = false;
            indexCobrar = -1;
        }
        if (indexPagar < listaCuentasPagar.size() & banderaPagar==false) {
            pagarsigue = true;
        } else {
            banderaPagar=true;
            pagarsigue = false;
            indexPagar = -1;
        }

        if (pagarsigue == false & cobrarsigue == false) {
            sigue = false;
        } else {
            sigue = true;
        }

        return sigue;
    }

    @Override
    public Object getFieldValue(JRField jrField) throws JRException {
        Object value = null;
        String fieldName = jrField.getName();
        switch (fieldName) {
            case "cuentaPagar":
                if (pagarsigue) {
                    value = listaCuentasPagar.get(indexPagar).getNumeroCuenta();
                }
                break;
            case "semana1Pagar":
                if (pagarsigue) {
                    value = listaCuentasPagar.get(indexPagar).getSemana1();
                }
                break;
            case "semana2Pagar":
                if (pagarsigue) {
                    value = listaCuentasPagar.get(indexPagar).getSemana2();
                }
                break;
            case "semana3Pagar":
                if (pagarsigue) {
                    value = listaCuentasPagar.get(indexPagar).getSemana3();
                }
                break;
            case "semana4Pagar":
                if (pagarsigue) {
                    value = listaCuentasPagar.get(indexPagar).getSemana4();
                }
                break;
            case "semana5Pagar":
                if (pagarsigue) {
                    value = listaCuentasPagar.get(indexPagar).getSemana5();
                }
                break;
            case "cuentaFinalPagar":
                if (pagarsigue) {
                    value = listaCuentasPagar.get(indexPagar).getTotalSemana();
                }
                break;
            case "totalSemana1Pagar":
                value = totalesPagar.get(0);
                break;
            case "totalSemana2Pagar":
                value = totalesPagar.get(1);

                break;
            case "totalSemana3Pagar":

                value = totalesPagar.get(2);

                break;
            case "totalSemana4Pagar":

                value = totalesPagar.get(3);

                break;
            case "totalSemana5Pagar":

                value = totalesPagar.get(4);
                break;
            case "MESPagar":
                value = mesPagar;
                break;
            case "totalSemanasPagar":
                value = totalesPagar.get(5);
                break;

            // aqui empieza el de cobrar
            case "cuentaCobrar":
                if (cobrarsigue) {
                    value = listaLlenadoCobrar.get
                            (indexCobrar).getNumeroCuenta();
                }

                break;
            case "semana1Cobrar":

                if (cobrarsigue) {
                    value = listaLlenadoCobrar.get
                            (indexCobrar).getSemana1();
                }
                break;
            case "semana2Cobrar":
                if (cobrarsigue) {
                    value = listaLlenadoCobrar.get
                            (indexCobrar).getSemana2();
                }
                break;
            case "semana3Cobrar":
                if (cobrarsigue) {
                    value = listaLlenadoCobrar.get
                            (indexCobrar).getSemana3();
                }
                break;
            case "semana4Cobrar":
                if (cobrarsigue) {
                    value = listaLlenadoCobrar.get
                            (indexCobrar).getSemana4();
                }
                break;
            case "semana5Cobrar":
                if (cobrarsigue) {
                    value = listaLlenadoCobrar.get
                            (indexCobrar).getSemana5();
                }
                break;
            case "cuentasCobrarFinalCobrar":
                if (cobrarsigue) {
                    value = listaLlenadoCobrar.get
                            (indexCobrar).getTotalSemana();
                }
                break;
            case "totalSemana1Cobrar":

                value = totalesCobrar.get(0);
                break;
            case "totalSemana2Cobrar":

                value = totalesCobrar.get(1);

                break;
            case "totalSemana3Cobrar":

                value = totalesCobrar.get(2);
                break;
            case "totalSemana4Cobrar":
                value = totalesCobrar.get(3);

                break;
            case "totalSemana5Cobrar":

                value = totalesCobrar.get(4);


                break;
            case "MESCobrar": {

                value = "marzo";
            }
            break;
            case "totalSemanasCobrar":

                value = totalesCobrar.get(5);

                break;

        }
        return value;
    }
}
