package com.numbermatch.numbermatch.GUI;

import javafx.scene.control.Label;
import com.numbermatch.numbermatch.Logica.Node;

public class CasillaView extends Label {
    private Node nodoAsociado;

    public CasillaView(Node nodo) {
        super("" + nodo.getCasilla().getValor());
        this.nodoAsociado = nodo;


        this.getStyleClass().add("label-casilla");


        this.setMinWidth(50);
        this.setMinHeight(50);
        this.setAlignment(javafx.geometry.Pos.CENTER);
        actualizarEstado();
    }

    public void actualizarEstado() {
        // Si se resalta se pinta amarillo
        if (nodoAsociado.getCasilla().getResaltada()) {
            this.setStyle("-fx-background-color: #ffff00; -fx-text-fill: black;");
        }

        // Si la casilla esta vacía es que se hizo un match
        if (nodoAsociado.getCasilla().isVacia()) {
            this.setText("");
            this.setStyle("-fx-background-color: transparent;");
            this.setDisable(true); // Para que ya no se pueda clickear
        }
    }
}