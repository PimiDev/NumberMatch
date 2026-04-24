package com.numbermatch.numbermatch;

import com.numbermatch.numbermatch.GUI.BotonesView;
import com.numbermatch.numbermatch.GUI.CuadriculaView;
import com.numbermatch.numbermatch.GUI.TableroView;
import com.numbermatch.numbermatch.Logica.Cuadricula;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;

public class Controlador {

    private TableroView tableroView;
    Cuadricula cuadricula;
    public Controlador(TableroView tableroView, Cuadricula cuadricula) {
        this.tableroView = tableroView;
        this.cuadricula = cuadricula;
    }

    public void asignarAccionesBotones(){

        Button pista = tableroView.getBotonesView().getPista();
        pista.setOnAction(e ->{
            cuadricula.generarPista();
            tableroView.actualizarVista();
        });

    }



}
