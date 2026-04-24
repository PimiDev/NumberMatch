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

    public void inicializar() {

        Node[] filaAnterior = new Node[columnas];

        for (int i = 0; i < filas; i++) {
            Node[] filaActual = new Node[columnas];
            for (int j = 0; j < columnas; j++) {
                //conecta left y right automaticamente
                Node nuevo = listaNodos.agregar(new Casilla(numeroRandom()));
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

    public void generarPista() {
        Node[][] matriz = new Node[filas][columnas];
        Node aux = listaNodos.getInicio();

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = aux;
                if (aux != null) aux = aux.getRight();
            }
        }
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                Node actual = matriz[i][j];


                if (actual == null || actual.getCasilla().isVacia()) continue;

                Casilla casillaActual = actual.getCasilla();


                int[][] direcciones = {
                        {0, 1},
                        {1, 0},
                        {1, 1},
                        {1, -1}
                };

                for (int[] dir : direcciones) {
                    int nuevaFila = i + dir[0];
                    int nuevaCol = j + dir[1];


                    if (nuevaFila >= 0 && nuevaFila < filas && nuevaCol >= 0 && nuevaCol < columnas) {
                        Node vecino = matriz[nuevaFila][nuevaCol];

                        if (vecino != null && !vecino.getCasilla().isVacia()) {

                            if (casillaActual.compareTo(vecino.getCasilla()) == 0) {
                                casillaActual.setResaltada(true);
                                vecino.getCasilla().setResaltada(true);

                                System.out.println("Pista lógica encontrada en: [" + i + "," + j + "]");
                                return;
                            }
                        }
                    }
                }
            }
        }
        System.out.println("No hay pistas disponibles.");
    }

    public ListaSimple getListaNodos(){
        return listaNodos;
    }

    public int getFilas(){
        return filas;
    }
    public int getColumnas(){
        return columnas;
    }
}