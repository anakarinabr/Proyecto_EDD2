/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_edd2;

/**
 *
 * @author luisr
 */
public class ListaSimple<T> {

    private Nodo<T> pFrist;
    private Nodo<T> pLast;
    private int size;

    public ListaSimple() {
        this.pFrist = null;
        this.pLast = null;
        this.size = 0;
    }

    public Nodo<T> getpFrist() {
        return pFrist;
    }

    public void setpFrist(Nodo<T> pFrist) {
        this.pFrist = pFrist;
    }

    public Nodo<T> getpLast() {
        return pLast;
    }

    public void setpLast(Nodo<T> pLast) {
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

    public void addFrist(T dato) {

        Nodo nodo = new Nodo(dato);
        if (EsVacia() == true) {
            this.pFrist = nodo;
            this.pLast = nodo;

        } else {
            nodo.setPnext(this.pFrist);
            this.setpFrist(nodo);

        }
        this.size++;

    }

    public void addend(T dato) {

        Nodo nodo = new Nodo(dato);

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
        Nodo<T> pAux = this.pFrist;

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
            Nodo<T> pAux = this.pFrist;
            eliminaralinicio();
            invertirlista();
            addend(pAux.getData());
        }
    }
}