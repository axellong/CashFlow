package sample.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import logic.Model.Table.GetData;
import logic.Model.Table.TableGeneral;

import java.net.URL;
import java.util.ResourceBundle;

public class ReportePDFController implements Initializable {
    @FXML
    private ScrollPane scrollReport;

    @FXML
    private TableView<TableGeneral> tabCobrar;

    @FXML
    private TableColumn<?, ?> colCuentaCobrar,colSemana1Cob,colSemana2Cob,colSemana3Cob,colSemana4Cob,colSemana5Cob,colFinalCob;

    @FXML
    private Label totalCobSem1,totalCobSem2,totalCobSem3,totalCobSem4,totalCobSem5,totalCobFinal;

    @FXML
    private TableView<TableGeneral> tabPagar;

    @FXML
    private TableColumn<?, ?> colCuentaPagar,colSemana1Pag,colSemana2Pag,colSemana3Pag,colSemana4Pag,colSemana5Pag,colFinalPag;

    @FXML
    private Label totalPagSem1,totalPagSem2,totalPagSem3,totalPagSem4,totalPagSem5,totalPagFinal;

    @FXML
    private TableView<TableGeneral> tabIngresos;

    @FXML
    private TableColumn<?, ?> colCuentaIng,colSemana1Ing,colSemana2Ing,colSemana3Ing,colSemana4Ing,colSemana5Ing,colFinalIng;

    @FXML
    private Label totalIngSem1,totalIngSem2,totalIngSem3,totalIngSem4,totalIngSem5,totalIngFinal;


    @FXML
    private TableView<TableGeneral> tabGastos;

    @FXML
    private TableColumn<?, ?> colCuentaGas,colSemana1Gas,colSemana2Gas,colSemana3Gas,colSemana4Gas,colSemana5Gas,colFinalGas;

    @FXML
    private Label totalGasSem1,totalGasSem2,totalGasSem3,totalGasSem4,totalGasSem5,totalGasFinal;

    @FXML
    private TableView<TableGeneral> tabBancos;

    @FXML
    private TableColumn<?, ?> colCuentaBan,colSemana1Ban,colSemana2Ban,colSemana3Ban,colSemana4Ban,colSemana5Ban,colFinalBan;

    @FXML
    private Label totalBanSem1,totalBanSem2,totalBanSem3,totalBanSem4,totalBanSem5,totalBanFinal;

    @FXML
    private Label totalUtiSem1,totalUtiSem2,totalUtiSem3,totalUtiSem4,totalUtiSem5,totalUtiFinal;

    @FXML
    private Label labelMes,labelYear;

    ObservableList<TableGeneral> cobrar;
    ObservableList<TableGeneral> pagar;
    ObservableList<TableGeneral> ingresos;
    ObservableList<TableGeneral> gastos;
    ObservableList<TableGeneral> bancos;
    @FXML
    void MouseClickedClose(MouseEvent event) {
        scrollReport.getScene().getWindow().hide();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void inicializarTablaCobrar(){
        cobrar = FXCollections.observableArrayList();
        colCuentaCobrar.setCellValueFactory(new PropertyValueFactory<>("cuenta"));
        colSemana1Cob.setCellValueFactory(new PropertyValueFactory<>("semana1"));
        colSemana2Cob.setCellValueFactory(new PropertyValueFactory<>("semana2"));
        colSemana3Cob.setCellValueFactory(new PropertyValueFactory<>("semana3"));
        colSemana4Cob.setCellValueFactory(new PropertyValueFactory<>("semana4"));
        colSemana5Cob.setCellValueFactory(new PropertyValueFactory<>("semana5"));
        colFinalCob.setCellValueFactory(new PropertyValueFactory<>("finalT"));
        tabCobrar.setItems(cobrar);
    }

    public void inicializarTablaPagar(){
        pagar = FXCollections.observableArrayList();
        colCuentaPagar.setCellValueFactory(new PropertyValueFactory<>("cuenta"));
        colSemana1Pag.setCellValueFactory(new PropertyValueFactory<>("semana1"));
        colSemana2Pag.setCellValueFactory(new PropertyValueFactory<>("semana2"));
        colSemana3Pag.setCellValueFactory(new PropertyValueFactory<>("semana3"));
        colSemana4Pag.setCellValueFactory(new PropertyValueFactory<>("semana4"));
        colSemana5Pag.setCellValueFactory(new PropertyValueFactory<>("semana5"));
        colFinalPag.setCellValueFactory(new PropertyValueFactory<>("finalT"));
        tabPagar.setItems(pagar);
    }

    public void inicializarTablaIngresos(){
        ingresos = FXCollections.observableArrayList();
        colCuentaIng.setCellValueFactory(new PropertyValueFactory<>("cuenta"));
        colSemana1Ing.setCellValueFactory(new PropertyValueFactory<>("semana1"));
        colSemana2Ing.setCellValueFactory(new PropertyValueFactory<>("semana2"));
        colSemana3Ing.setCellValueFactory(new PropertyValueFactory<>("semana3"));
        colSemana4Ing.setCellValueFactory(new PropertyValueFactory<>("semana4"));
        colSemana5Ing.setCellValueFactory(new PropertyValueFactory<>("semana5"));
        colFinalIng.setCellValueFactory(new PropertyValueFactory<>("finalT"));
        tabIngresos.setItems(ingresos);
    }

    public void inicializarTablaGastos(){
        gastos = FXCollections.observableArrayList();
        colCuentaGas.setCellValueFactory(new PropertyValueFactory<>("cuenta"));
        colSemana1Gas.setCellValueFactory(new PropertyValueFactory<>("semana1"));
        colSemana2Gas.setCellValueFactory(new PropertyValueFactory<>("semana2"));
        colSemana3Gas.setCellValueFactory(new PropertyValueFactory<>("semana3"));
        colSemana4Gas.setCellValueFactory(new PropertyValueFactory<>("semana4"));
        colSemana5Gas.setCellValueFactory(new PropertyValueFactory<>("semana5"));
        colFinalGas.setCellValueFactory(new PropertyValueFactory<>("finalT"));
        tabGastos.setItems(gastos);
    }

    public void inicializarTablaBancos(){
        bancos = FXCollections.observableArrayList();
        colCuentaBan.setCellValueFactory(new PropertyValueFactory<>("cuenta"));
        colSemana1Ban.setCellValueFactory(new PropertyValueFactory<>("semana1"));
        colSemana2Ban.setCellValueFactory(new PropertyValueFactory<>("semana2"));
        colSemana3Ban.setCellValueFactory(new PropertyValueFactory<>("semana3"));
        colSemana4Ban.setCellValueFactory(new PropertyValueFactory<>("semana4"));
        colSemana5Ban.setCellValueFactory(new PropertyValueFactory<>("semana5"));
        colFinalBan.setCellValueFactory(new PropertyValueFactory<>("finalT"));
        tabBancos.setItems(bancos);
    }

    public  void llenarCobrar(String mes,int year){
        cobrar.addAll(GetData.Cobrar(mes,year));
        int semana1=0;
        int semana2=0;
        int semana3=0;
        int semana4=0;
        int semana5=0;
        for (TableGeneral node : cobrar) {
            semana1 = semana1 + node.getSemana1();
            semana2 = semana2 + node.getSemana2();
            semana3 = semana3 + node.getSemana3();
            semana4 = semana4 + node.getSemana4();
            semana5 = semana5 + node.getSemana5();
        }
        totalCobSem1.setText(String.valueOf(semana1));
        totalCobSem2.setText(String.valueOf(semana2));
        totalCobSem3.setText(String.valueOf(semana3));
        totalCobSem4.setText(String.valueOf(semana4));
        totalCobSem5.setText(String.valueOf(semana5));
        int total = semana1+semana2+semana3+semana4+semana5;
        totalCobFinal.setText(String.valueOf(total));
    }

    public  void llenarPagar(String mes,int year){
        pagar.addAll(GetData.Pagar(mes,year));
        int semana1=0;
        int semana2=0;
        int semana3=0;
        int semana4=0;
        int semana5=0;
        for (TableGeneral node : pagar) {
            semana1 = semana1 + node.getSemana1();
            semana2 = semana2 + node.getSemana2();
            semana3 = semana3 + node.getSemana3();
            semana4 = semana4 + node.getSemana4();
            semana5 = semana5 + node.getSemana5();
        }
        totalPagSem1.setText(String.valueOf(semana1));
        totalPagSem2.setText(String.valueOf(semana2));
        totalPagSem3.setText(String.valueOf(semana3));
        totalPagSem4.setText(String.valueOf(semana4));
        totalPagSem5.setText(String.valueOf(semana5));
        int total = semana1+semana2+semana3+semana4+semana5;
        totalPagFinal.setText(String.valueOf(total));
    }

    public  void llenarIngresos(String mes,int year){
        ingresos.addAll(GetData.Ingreso(mes,year));
        int semana1=0;
        int semana2=0;
        int semana3=0;
        int semana4=0;
        int semana5=0;
        for (TableGeneral node : ingresos) {
            semana1 = semana1 + node.getSemana1();
            semana2 = semana2 + node.getSemana2();
            semana3 = semana3 + node.getSemana3();
            semana4 = semana4 + node.getSemana4();
            semana5 = semana5 + node.getSemana5();
        }
        totalIngSem2.setText(String.valueOf(semana2));
        totalIngSem1.setText(String.valueOf(semana1));
        System.out.println(totalIngSem1.getText());
        totalIngSem3.setText(String.valueOf(semana3));
        totalIngSem4.setText(String.valueOf(semana4));
        totalIngSem5.setText(String.valueOf(semana5));
        int total = semana1+semana2+semana3+semana4+semana5;
        totalIngFinal.setText(String.valueOf(total));
    }

    public  void llenarGastos(String mes,int year){
        gastos.addAll(GetData.Gastos(mes,year));
        int semana1=0;
        int semana2=0;
        int semana3=0;
        int semana4=0;
        int semana5=0;
        for (TableGeneral node : gastos) {
            semana1 = semana1 + node.getSemana1();
            semana2 = semana2 + node.getSemana2();
            semana3 = semana3 + node.getSemana3();
            semana4 = semana4 + node.getSemana4();
            semana5 = semana5 + node.getSemana5();
        }
        totalGasSem1.setText(String.valueOf(semana1));
        totalGasSem2.setText(String.valueOf(semana2));
        totalGasSem3.setText(String.valueOf(semana3));
        totalGasSem4.setText(String.valueOf(semana4));
        totalGasSem5.setText(String.valueOf(semana5));
        int total = semana1+semana2+semana3+semana4+semana5;
        totalGasFinal.setText(String.valueOf(total));
    }

    public  void llenarBancos(String mes,int year){
        bancos.addAll(GetData.Banco(mes,year));
        int semana1=0;
        int semana2=0;
        int semana3=0;
        int semana4=0;
        int semana5=0;
        for (TableGeneral node : bancos) {
            semana1 = semana1 + node.getSemana1();
            semana2 = semana2 + node.getSemana2();
            semana3 = semana3 + node.getSemana3();
            semana4 = semana4 + node.getSemana4();
            semana5 = semana5 + node.getSemana5();
        }
        totalBanSem1.setText(String.valueOf(semana1));
        totalBanSem2.setText(String.valueOf(semana2));
        totalBanSem3.setText(String.valueOf(semana3));
        totalBanSem4.setText(String.valueOf(semana4));
        totalBanSem5.setText(String.valueOf(semana5));
        int total = semana1+semana2+semana3+semana4+semana5;
        totalBanFinal.setText(String.valueOf(total));
    }

    public void generarUtilidad(){
        int semana1=Integer.parseInt(totalIngSem1.getText()) - Integer.parseInt(totalGasSem1.getText());
        int semana2=Integer.parseInt(totalIngSem2.getText()) - Integer.parseInt(totalGasSem2.getText());
        int semana3=Integer.parseInt(totalIngSem3.getText()) - Integer.parseInt(totalGasSem3.getText());
        int semana4=Integer.parseInt(totalIngSem4.getText()) - Integer.parseInt(totalGasSem4.getText());
        int semana5=Integer.parseInt(totalIngSem5.getText()) - Integer.parseInt(totalGasSem5.getText());
        int finals=semana1+semana2+semana3+semana4+semana5;
        totalUtiSem1.setText(String.valueOf(semana1));
        totalUtiSem2.setText(String.valueOf(semana2));
        totalUtiSem3.setText(String.valueOf(semana3));
        totalUtiSem4.setText(String.valueOf(semana4));
        totalUtiSem5.setText(String.valueOf(semana5));
        totalUtiFinal.setText(String.valueOf(finals));
    }

    public void inicializarDatos(String mes,int year) {
        labelMes.setText(mes);
        labelYear.setText(String.valueOf(year));
        inicializarTablaBancos();
        inicializarTablaCobrar();
        inicializarTablaGastos();
        inicializarTablaIngresos();
        inicializarTablaPagar();
        llenarCobrar(mes,year);
        llenarPagar(mes,year);
        llenarBancos(mes,year);
        llenarIngresos(mes,year);
        llenarGastos(mes,year);
        generarUtilidad();
    }
}
