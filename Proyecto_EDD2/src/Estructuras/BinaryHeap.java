/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author Ana Blanco
 */
public class BinaryHeap {

    BinaryNode raiz;

    public void insertar(int valor) {
        BinaryNode nuevoNodo = new BinaryNode(valor);
        if (raiz == null) {
            raiz = nuevoNodo;
        } else {
            BinaryNode actual = raiz;
            BinaryNode padre = null;
            while (actual != null) {
                padre = actual;
                if (valor < actual.valor) {
                    actual = actual.izquierda;
                } else {
                    actual = actual.derecha;
                }
            }
            if (valor < padre.valor) {
                padre.izquierda = nuevoNodo;
            } else {
                padre.derecha = nuevoNodo;
            }
        }
    }

    private void subir(BinaryNode actual, BinaryNode padre) {
        int valorPadre = padre.valor;
        padre.valor = actual.valor;
        actual.valor = valorPadre;
    }

    private void heapify(BinaryNode actual) {
        BinaryNode izquierda = actual.izquierda;
        BinaryNode derecha = actual.derecha;
        BinaryNode mayor = actual;
        if (izquierda != null && izquierda.valor > mayor.valor) {
            mayor = izquierda;
        }
        if (derecha != null && derecha.valor > mayor.valor) {
            mayor = derecha;
        }
        if (mayor != actual) {
            subir(mayor, actual);
            heapify(mayor);
        }
    }

    public void preOrden() {
        preOrden(raiz);
    }

    private void preOrden(BinaryNode actual) {
        if (actual != null) {
            System.out.print(actual.valor + " ");
            preOrden(actual.izquierda);
            preOrden(actual.derecha);
        }
    }

    public void postOrden() {
        postOrden(raiz);
    }

    private void postOrden(BinaryNode actual) {
        if (actual != null) {
            postOrden(actual.izquierda);
            postOrden(actual.derecha);
            System.out.print(actual.valor + " ");
        }
    }

    public void inOrden() {
        inOrden(raiz);
    }

    private void inOrden(BinaryNode actual) {
        if (actual != null) {
            inOrden(actual.izquierda);
            System.out.print(actual.valor + " ");
            inOrden(actual.derecha);
        }
    }

    public int getMaximo() {
        return getMaximo(raiz);
    }

    private int getMaximo(BinaryNode actual) {
        if (actual == null) {
            return Integer.MIN_VALUE;
        }
        int maximoIzquierda = getMaximo(actual.izquierda);
        int maximoDerecha = getMaximo(actual.derecha);
        return Math.max(Math.max(maximoIzquierda, maximoDerecha), actual.valor);
    }

    public int getMinimo() {
        return getMinimo(raiz);
    }

    private int getMinimo(BinaryNode actual) {
        if (actual == null) {
            return Integer.MAX_VALUE;
        }
        int minimoIzquierda = getMinimo(actual.izquierda);
        int minimoDerecha = getMinimo(actual.derecha);
        return Math.min(Math.min(minimoIzquierda, minimoDerecha), actual.valor);
    }
}
