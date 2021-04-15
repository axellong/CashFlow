package sample.Util;

import javafx.scene.Parent;

public class SceneAdd {

    private Parent node;
    private Object controller;

    public SceneAdd(Parent node, Object controller) {
        this.node = node;
        this.controller = controller;
    }

    public Parent getNode() {
        return node;
    }

    public void setNode(Parent node) {
        this.node = node;
    }

    public Object getController() {
        return controller;
    }

    public void setController(Object controller) {
        this.controller = controller;
    }

}
