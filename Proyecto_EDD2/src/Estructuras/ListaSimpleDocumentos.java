/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import javax.swing.JOptionPane;

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

    public boolean buscar(String referencia) {
        NodoSimple aux = this.pFirst;
        boolean encontrado = false;
        while (aux != null && encontrado != true) {
            Documento usuario = (Documento) aux.getData();
            if (usuario.getTitulo().equalsIgnoreCase(referencia)) {
                encontrado = true;
            } else {
                aux = aux.getPnext();
            }
        }
        return encontrado;

    }

    public boolean EliminarPorReferencia(String referencia) {
        boolean esta = buscar(referencia);
        if (esta) {
            Documento documento = (Documento) this.pFirst.getData();
            if (documento.getTitulo().equalsIgnoreCase(referencia)) {
                this.pFirst = this.pFirst.getPnext();

            } else {
                NodoSimple aux = this.pFirst;
                Documento nextaux = (Documento) aux.getPnext().getData();
                while (!nextaux.getTitulo().equalsIgnoreCase(referencia)) {
                    aux = aux.getPnext();
                    nextaux = (Documento) aux.getPnext().getData();
                }
                NodoSimple siguiente = aux.getPnext().getPnext();
                aux.setPnext(siguiente);
            }
            size--;
            return esta;

        } else {
            JOptionPane.showMessageDialog(null, "Ese documento no es perteneciente al usuario, debe hacer click en el botón de seleccionar");
            return esta;
        }

    }

    public Documento BuscarDocumento(String referencia) {
        if (buscar(referencia)) {
            Documento documento = (Documento) this.pFirst.getData();
            if (documento.getTitulo().equalsIgnoreCase(referencia)) {
                return documento;

            } else {
                NodoSimple aux = this.pFirst;
                Documento nextaux = (Documento) aux.getData();
                while (!nextaux.getTitulo().equalsIgnoreCase(referencia)) {
                    aux = aux.getPnext();
                    nextaux = (Documento) aux.getData();
                }

                return nextaux;

            }
        } else {
            return null;
        }

    }
}
