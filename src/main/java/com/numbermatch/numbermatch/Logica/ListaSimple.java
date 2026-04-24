package com.numbermatch.numbermatch.Logica;

public class ListaSimple{

    private Node inicio;//primer nodo del juego

    public ListaSimple() {
        this.inicio = null;
    }
    public void setInicio(Node inicio) {
        this.inicio = inicio;
    }
    public Node getInicio() {
        return inicio;
    }

    public Node agregar(int valor) {
        Node nuevo = new Node(valor);
        if (inicio == null) {
            inicio = nuevo;
        } else {
            Node temp = inicio;
            while (temp.getRight() != null) {
                temp = temp.getRight();
            }
            temp.setRight(nuevo);
            nuevo.setLeft(temp);
        }
        return nuevo;
    }
}
