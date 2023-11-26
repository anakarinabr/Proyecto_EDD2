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
    
    //Constructor
    public ListaSimpleDocumentos() {
        this.pFirst = null;
        this.pLast = null;
        this.size = 0;
    }
    
    //Getters and Setters
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
    
    /**
         * Método que se encarga de ingresar al final de la lista
         * Realizado por: Luis Rivera.
         * Versión: 11/25/2023
         */
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

    
     /**
         * Método que se encarga de comprobar que existe un valor
         * Realizado por: Luis Rivera.
         * Versión: 11/25/2023
         */

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
    
     /**
         * Método que se encarga deeliminar dado un String de refeencia
         * Realizado por: Luis Rivera.
         * Versión: 11/25/2023
         */
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
    
    
     /**
         * Método que se encarga de buscar los documentos dado un string de referencia
         * Realizado por: Luis Rivera.
         * Versión: 11/25/2023
         */
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
