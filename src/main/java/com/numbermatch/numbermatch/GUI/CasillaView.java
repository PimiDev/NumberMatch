package com.numbermatch.numbermatch.GUI;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import com.numbermatch.numbermatch.Logica.Node;

public class CasillaView extends StackPane {
    private Node nodoAsociado;
    private Label labelNumero;

    public CasillaView(Node nodo) {
        this.nodoAsociado = nodo;

        this.labelNumero = new Label(""+nodo.getNumber());


        this.getChildren().add(labelNumero);
    }

    public void actualizarEstado() {

        if (nodoAsociado.getCasilla().isVacia()) {
            this.labelNumero.setText("");
        }
    }
}