package com.numbermatch.numbermatch.Logica;

public class Casilla implements Comparable<Casilla> {
    private int valor;
    private boolean marcado; // saber si el usuario lo esta seleccionando
    private boolean vacia;   // cuando se hace match para eliminar
    private boolean resaltada; // si se llega a pedir pista resalta
    public Casilla(int valor) {
        this.valor = valor;
        this.marcado = false;
        this.vacia = false;
        this.resaltada = false;
    }

    @Override
    public int compareTo(Casilla otra) {
        if (this.valor == otra.getValor() || (this.valor + otra.getValor() == 10)) {
            return 0;
        }
        else {
            return Integer.compare(this.valor, otra.getValor());
        }
    }

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