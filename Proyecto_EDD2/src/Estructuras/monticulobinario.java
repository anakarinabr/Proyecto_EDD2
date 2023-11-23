/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author Ana Blanco
 */
public class MonticuloBinario<T> {

    private NodoMonticuloBi<T> root;
    private int size;

    public MonticuloBinario() {
        this.root = null;
        this.size = 0;
    }

    public NodoMonticuloBi<T> getRoot() {
        return root;
    }

    public void setRoot(NodoMonticuloBi<T> root) {
        this.root = root;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public void Ingresar(T data) {       //NodoMonticuloBi Documento
        NodoMonticuloBi<T> nodo = new NodoMonticuloBi(data);
        if (isEmpty() == true) {
            this.root = nodo;
        } else {
            Queue<NodoMonticuloBi> cola = new Queue();
            cola.add(root);
            while (!cola.isEmpty()) {
                NodoMonticuloBi temp = cola.getpHead().getData();
                if (temp.getHijoIzq() == null) {
                    temp.setHijoIzq(nodo);
                    temp.getHijoIzq().setPadre(cola.getpHead().getData());
                    subir(nodo);
                    break;
                } else {
                    cola.add(temp.getHijoIzq());
                }
                if (temp.getHijoDer() == null) {
                    temp.setHijoDer(nodo);
                    temp.getHijoDer().setPadre(cola.getpHead().getData());
                    subir(nodo);
                    break;
                } else {
                    cola.add(temp.getHijoDer());
                }
                cola.poll();

            }
        }

    }

    public void subir(NodoMonticuloBi nodo) {
        NodoMonticuloBi padre = nodo.getPadre();
        if (padre != null) {
            int aux = (int) padre.getDato();
            if ((int) nodo.getDato() < (int) padre.getDato()) {
                padre.setDato(nodo.getDato());
                nodo.setDato(aux);
                nodo = nodo.getPadre();
                subir(nodo);
            }

        }
    }


    public void preOrden() {
        this.preorder(this.getRoot());
    }

    private void preorder(NodoMonticuloBi root) {
        if (root != null) {
            System.out.println(root.getDato().toString());
            this.preorder(root.getHijoIzq());
            this.preorder(root.getHijoDer());
        }
    }

    public void inOrden() {
        this.inorder(this.getRoot());
    }

    private void inorder(NodoMonticuloBi root) {
        if (root != null) {
            this.inorder(root.getHijoIzq());
            System.out.println(root.getDato().toString());
            this.inorder(root.getHijoDer());
        }
    }
}