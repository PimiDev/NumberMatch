package com.numbermatch.numbermatch.GUI;

import javafx.scene.layout.HBox;

public class TableroView extends HBox {

    private BotonesView botonesView;
    private CuadriculaView cuadriculaView;

    public TableroView(BotonesView botonesView, CuadriculaView cuadriculaView){
        this.cuadriculaView = cuadriculaView;
        this.botonesView = botonesView;
        this.setStyle("-fx-padding: 20; -fx-background-color: #2c3e50;");

        this.getChildren().addAll(botonesView,cuadriculaView);
    }

    public BotonesView getBotonesView(){
        return botonesView;
    }

    public CuadriculaView cuadriculaView(){
        return cuadriculaView;
    }

    public void actualizarVista(){
        cuadriculaView.refrescarCasillas();
    }

}
