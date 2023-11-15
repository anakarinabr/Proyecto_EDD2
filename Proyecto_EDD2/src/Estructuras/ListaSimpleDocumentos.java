/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author Ana Blanco
 */
public class ListaSimpleDocumentos<T> {

    private NodoSimple pFirst;
    private NodoSimple pLast;
    private int size;

    public ListaSimpleDocumentos() {
        this.pFirst = null;
        this.pLast = null;
        this.size = 0;
    }

    public NodoSimple<T> getpFirst() {
        return pFirst;
    }

    public void setpFirst(NodoSimple<T> pFirst) {
        this.pFirst = pFirst;
    }

    public NodoSimple<T> getpLast() {
        return pLast;
    }

    public void setpLast(NodoSimple<T> pLast) {
        this.pLast = pLast;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean EsVacia() {
        return this.pFirst == null;

    }

    public void addFirst(Documento documento) {

        NodoSimple nodo = new NodoSimple(documento);
        if (EsVacia() == true) {
            this.pFirst = nodo;
            this.pLast = nodo;

        } else {
            nodo.setPnext(this.pFirst);
            this.setpFirst(nodo);

        }
        this.size++;

    }

    public void addend(Documento documento) {

        NodoSimple nodo = new NodoSimple(documento);

        if (EsVacia() == true) {
            this.pFirst = nodo;
            this.pLast = nodo;

        } else {
            this.pLast.setPnext(nodo);
            this.setpLast(nodo);
        }
        this.size++;
    }

    public void print() {
        if (EsVacia()) {
            System.out.println("La lista esta vacia");
        }
        NodoSimple<T> pAux = this.pFirst;

        while (pAux != null) {
            System.out.print(pAux.getData() + "->");
//            JOptionPane.showMessageDialog(null, pAux.getData());
            pAux = pAux.getPnext();
        }
        System.out.println("");
//        System.out.println(this.size);

    }

    public void eliminaralinicio() {
        if (EsVacia()) {
            System.out.println("La lista esta vacia");
        } else {
            this.pFirst = this.pFirst.getPnext();

        }
        size--;
    }

    public void invertirlista() {

        if (EsVacia()) {
            System.out.println("La lista esta vacia");
        } else {
            NodoSimple<T> pAux = this.pFirst;
            eliminaralinicio();
            invertirlista();
            this.addend((Documento) pAux.getData());
        }
    }
}

