package com.numbermatch.numbermatch.Logica;

public class Casilla implements Comparable<Casilla> {
    private int valor;
    private boolean marcado; // Para saber si el usuario la seleccionó
    private boolean vacia;   // Para cuando haces match y el número "desaparece"
    private boolean resaltada; // si se llega a pedir pista resalta
    public Casilla(int valor) {
        this.valor = valor;
        this.marcado = false;
        this.vacia = false;
        this.resaltada = false;
    }

    @Override
    public int compareTo(Casilla otra) {
        /* Si devuelve 0, es que los números son iguales.
           En Number Match podrías expandir esto para que
           si suman 10 también sea un "match", pero por ahora
           lo dejamos con igualdad numérica.
        */
        return Integer.compare(this.valor, otra.getValor());
    }

    // --- Getters y Setters ---
    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public boolean isMarcado() {
        return marcado;
    }

    public void setMarcado(boolean marcado) {
        this.marcado = marcado;
    }

    public boolean isVacia() {
        return vacia;
    }

    public void setVacia(boolean vacia) {
        this.vacia = vacia;
    }

    public void setResaltada(boolean resaltada){
        this.resaltada = resaltada;
    }
    public boolean getResaltada(){
        return resaltada;
    }
}