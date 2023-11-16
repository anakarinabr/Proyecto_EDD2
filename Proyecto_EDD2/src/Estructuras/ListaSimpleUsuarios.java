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
public class ListaSimpleUsuarios<T> {

    private NodoSimple<T> pFirst;
    private NodoSimple<T> pLast;
    private int size;

    public ListaSimpleUsuarios() {
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

    public void addFirst(Usuario usuario) {
        NodoSimple nodo = new NodoSimple(usuario);
        if (EsVacia() == true) {
            this.pFirst = nodo;
            this.pLast = nodo;

        } else {
            nodo.setPnext(this.pFirst);
            this.setpFirst(nodo);

        }
        this.size++;

    }

    public void addend(Usuario usuario) {

        NodoSimple nodo = new NodoSimple(usuario);

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
            pAux = pAux.getPnext();
        }
        System.out.println("");

    }

    public void eliminaralinicio() {
        if (EsVacia()) {
            System.out.println("La lista esta vacia");
        } else {
            this.pFirst = this.pFirst.getPnext();

        }
        size--;
    }
    
     public String getAllUsers() {
         String todo = "usuario,tipo";
        if (EsVacia()) {
            return todo;
        }
        NodoSimple<T> pAux = this.pFirst;

        while (pAux != null) {
            Usuario data=(Usuario)pAux.getData();
            todo +=  "\n" + data.getName() + ","+ data.getPrioridad()+"";
            pAux = pAux.getPnext();
        }
        
        System.out.println(todo);
        return todo;

    }
}