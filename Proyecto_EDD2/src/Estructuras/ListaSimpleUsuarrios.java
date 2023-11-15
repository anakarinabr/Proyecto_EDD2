/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

/**
 *
 * @author luisr
 * @param <T>
 */
public class ListaSimpleUsuarrios<T> {

    private NodoUsuario<T> pFrist;
    private NodoUsuario<T> pLast;
    private int size;

    public ListaSimpleUsuarrios() {
        this.pFrist = null;
        this.pLast = null;
        this.size = 0;
    }

    public NodoUsuario<T> getpFrist() {
        return pFrist;
    }

    public void setpFrist(NodoUsuario<T> pFrist) {
        this.pFrist = pFrist;
    }

    public NodoUsuario<T> getpLast() {
        return pLast;
    }

    public void setpLast(NodoUsuario<T> pLast) {
        this.pLast = pLast;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean EsVacia() {
        return this.pFrist == null;

    }

    public void addFrist(T dato, String priority) {

        NodoUsuario nodo = new NodoUsuario(dato, priority);
        if (EsVacia() == true) {
            this.pFrist = nodo;
            this.pLast = nodo;

        } else {
            nodo.setPnext(this.pFrist);
            this.setpFrist(nodo);

        }
        this.size++;

    }

    public void addend(T dato, String priority) {

        NodoUsuario nodo = new NodoUsuario(dato, priority);

        if (EsVacia() == true) {
            this.pFrist = nodo;
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
        NodoUsuario<T> pAux = this.pFrist;

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
            this.pFrist = this.pFrist.getPnext();

        }
        size--;
    }

    public void invertirlista() {

        if (EsVacia()) {
            System.out.println("La lista esta vacia");
        } else {
            NodoUsuario<T> pAux = this.pFrist;
            eliminaralinicio();
            invertirlista();
            addend(pAux.getData(), pAux.getPriority());
        }
    }
}