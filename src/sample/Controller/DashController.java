package sample.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import sample.Main;
import sample.Util.SceneAdd;
import sample.Util.Utils;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashController implements Initializable {

    private ObservableList<Parent> menu;

    private SceneAdd category, flow, register;
    @FXML
    private AnchorPane  panePrincipal;

    @FXML
    private ImageView initialLog;

    @FXML
    private Label labelUser,labelEmail;
    // metodo INITIALIZE
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        menu= FXCollections.observableArrayList();
        try {
            category = integratePanel("Dash","Category",275,45);
            flow = integratePanel("Dash","Flujo",275,45);
            register = integratePanel("Dash","Registro",275,45);
            menu.addAll(category.getNode(),flow.getNode(),register.getNode());
            panePrincipal.getChildren().addAll(menu);
            goBack(menu);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // METODOS PARA CERRAR Y MINIMAZAR LA VENTANA
    @FXML
    void MouseClickedMin(MouseEvent event) { Utils.minimize(); }

    @FXML
    void MouseClickedClose(MouseEvent event) { Utils.close(); }

    // Metodos de accion de botones del menu
    @FXML
    void MouseClickedCategory(MouseEvent event) { nodeChange(category.getNode()); }

    @FXML
    void MouseClickedFlujo(MouseEvent event) { nodeChange(flow.getNode()); }

    @FXML
    void MouseClickedRegistro(MouseEvent event) { nodeChange(register.getNode()); }

    private void nodeChange(Parent node){
        if(node != null){
            clean();
            notVisible();
            icoLog();
            visable(node);
        }
    }

    // metodo para cerrar la secion del Usuario
    @FXML
    void MouseClickedCerrarSesion(MouseEvent event) {
        //borrar credenciales del Usuario
        Utils.changeScene("Login","LoginView");
    }

    //metodo para agregar email and user
    /*public void setLabels(String user, String email){
        labelUser.setText(user);
        labelEmail.setText(email);
    }*/

    // metodos para integrar los Parent a las ESCENA
    private SceneAdd integratePanel(String carpeta, String fxml,int x , int y) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("View/"+carpeta+"/"+fxml+".fxml"));
        Parent root = fxmlLoader.load();
        Object controller= fxmlLoader.getController();
        root.setLayoutX(x);
        root.setLayoutY(y);
        root.setVisible(false);
        return new SceneAdd(root,controller);
    }
    // Metodo para enviar los nuevos nodos al fondo
    private void goBack(ObservableList<Parent> node){
        panePrincipal.getChildrenUnmodifiable().forEach((children)-> node.forEach((nodeMenu) -> {
            if (children == nodeMenu) { children.toBack(); }
        }));
   }
    // metodo para hacer un nodo visible
    private void visable(Parent node){
        panePrincipal.getChildrenUnmodifiable().forEach((childre)->{
            if(childre == node){ childre.setVisible(true); }
        });
    }
    // metodo para hacer todos los nodos nuevos no visibles
    private void notVisible(){
        panePrincipal.getChildrenUnmodifiable().forEach((children)-> menu.forEach((nodeMenu)->{
            if(children == nodeMenu){ children.setVisible(false); }
        }));
    }

    private void icoLog(){
        if (initialLog.isVisible()){ initialLog.setVisible(false); }
    }

    //metodo para borrar el contenido al momento de cambiar de scena
    private void clean(){
        ((CategoryController)category.getController()).clean();
        ((FlujoController)flow.getController()).clean();
        ((RegistroController)register.getController()).clean();
    }
}
