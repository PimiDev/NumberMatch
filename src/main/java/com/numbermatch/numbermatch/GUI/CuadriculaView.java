package com.numbermatch.numbermatch.GUI;

import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import com.numbermatch.numbermatch.Logica.Cuadricula;
import com.numbermatch.numbermatch.Logica.Node;

public class CuadriculaView extends GridPane {

    private Cuadricula cuadriculaLogica;

    public CuadriculaView(Cuadricula cuadriculaLogica) {
        this.cuadriculaLogica = cuadriculaLogica;
        cuadriculaLogica.inicializar();

        this.setAlignment(Pos.CENTER);
        this.setHgap(8);
        this.setVgap(8);
        this.setStyle("-fx-padding: 20; -fx-background-color: #2c3e50;"); // Un fondo oscuro para que resalten los círculos

        dibujarTablero();
    }

    public void dibujarTablero() {
        this.getChildren().clear();

        // Obtenemos los datos
        int filas = cuadriculaLogica.getFilas();
        int columnas = cuadriculaLogica.getColumnas();

        // nodo inicial ListaSimple
        Node actual = cuadriculaLogica.getListaNodos().getInicio();

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (actual != null) {
                    // Creamos la vista para este nodo específico
                    CasillaView casillaUI = new CasillaView(actual);

                    // GridPane.add(nodo, columna, fila)
                    this.add(casillaUI, j, i);

                    // Como es una ListaSimple, el siguiente siempre es el de la derecha
                    actual = actual.getRight();
                }
            }
        }
    }
}