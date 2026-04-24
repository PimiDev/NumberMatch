package com.numbermatch.numbermatch.Logica;

import java.util.Random;

public class Cuadricula {

    private ListaSimple listaNodos;
    private Random rand;
    private int filas,columnas;


    public Cuadricula(int filas, int columnas) {
        listaNodos = new ListaSimple();
        rand = new Random();
        this.filas = filas;
        this.columnas = columnas;
    }

    public int numeroRandom() {
        return rand.nextInt(9) + 1;
    }

    public void inicializar(int filas, int columnas) {

        Node[] filaAnterior = new Node[columnas];

        for (int i = 0; i < filas; i++) {
            Node[] filaActual = new Node[columnas];
            for (int j = 0; j < columnas; j++) {
                //conecta left y right automaticamente
                Node nuevo = listaNodos.agregar(numeroRandom());
                filaActual[j] = nuevo;

                //si fila > 0 conecta up y down
                if(i>0) {
                    nuevo.setUp(filaAnterior[j]);
                    filaAnterior[j].setDown(nuevo);

                    //si columna > 0 conecta arriba izquierda y abajo derecha
                    if (j > 0) {
                        nuevo.setUpLeft(filaAnterior[j - 1]);
                        filaAnterior[j].setDownRight(nuevo);
                    }
                    // si columna no es la ultima conecta arriba derecha y abajo izquierda
                    if (j < columnas - 1) {
                        nuevo.setUpRight(filaAnterior[j + 1]);
                        filaAnterior[j].setDownLeft(nuevo);
                    }
                }
            }
            //actualiza la fila anterior
            filaAnterior = filaActual;
        }
    }
}