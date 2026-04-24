package com.numbermatch.numbermatch.GUI;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class



BotonesView extends VBox {

    private Button agregarFila;
    private Button pista;
    private Label concordancias;
    public BotonesView(){
        agregarFila = new Button("+");
        pista = new Button("?");
        concordancias = new Label("0");

        this.getChildren().addAll(agregarFila,pista,concordancias);
    }

    public Button getAgregarFila(){
        return agregarFila;
    }
    public Button getPista(){
        return pista;
    }

    public Label getConcordancias(){
        return concordancias;
    }
    public void setConcordancias(int n){
        concordancias.setText(""+n);
    }

}
