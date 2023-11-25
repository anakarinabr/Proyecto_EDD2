/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author luisr
 * @param <T>
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
                    temp.getHijoIzq().setPadre(temp);
                    this.subir(nodo);
                    break;
                } else {
                    cola.add(temp.getHijoIzq());
                }
                if (temp.getHijoDer() == null) {
                    temp.setHijoDer(nodo);
                    temp.getHijoDer().setPadre(temp);
                    this.subir(nodo);
                    break;
                } else {
                    cola.add(temp.getHijoDer());
                }
                cola.poll();

            }
        }

        size++;

    }

    private void subir(NodoMonticuloBi nodo) {
        Documento documentonodo = (Documento) nodo.getDato();
        NodoMonticuloBi padrenodo = nodo.getPadre();
        Documento padredocumento = (Documento) padrenodo.getDato();
        if (padrenodo != null) {
            Documento aux = (Documento) padrenodo.getDato();
            if ((documentonodo.getTime() < padredocumento.getTime())) {
                padrenodo.setDato(documentonodo);
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
            Documento doc = (Documento) root.getDato();
            System.out.println(doc.getTitulo() + doc.getTime());
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

    public void ImprimirComoCola() {
        Queue<NodoMonticuloBi> cola = new Queue();
        Queue<NodoMonticuloBi> cola2 = new Queue();
        cola.add(root);
        while (!cola.isEmpty()) {
            NodoMonticuloBi temp = cola.getpHead().getData();
            if (temp.getHijoIzq() != null) {
                cola.add(temp.getHijoIzq());
            }
            if (temp.getHijoDer() != null) {
                cola.add(temp.getHijoDer());

            }
            cola2.add(temp);
            cola.poll();
        }
        for (int i = 0; i < cola2.getSize(); i++) {
            NodoMonticuloBi aux = cola2.getpHead().getData();
            System.out.print("->" + aux.getDato());
            cola2.poll();
            cola2.add(aux);
        }

    }

    public void Eliminarprimero() {
        NodoMonticuloBi padre = root;
        NodoMonticuloBi izq = root.getHijoIzq();
        NodoMonticuloBi der = root.getHijoDer();
        while (true) {
            if (padre.getHijoIzq() == null && padre.getHijoDer() == null) {
                this.setRoot(null);
                System.out.println(root);
                break;
            }

            if (izq == null) {
                izq = der;
            }

            if (der == null) {
                Documento doc = (Documento) izq.getDato();
                padre.setDato(doc);
                Documento dochijo = (Documento) padre.getHijoIzq().getDato();
                if (padre.getHijoIzq() == null && padre.getHijoDer() == null || doc.getTime() == dochijo.getTime()) {
                    padre.setHijoIzq(null);
                    break;
                }
            }

            Documento docizq = (Documento) izq.getDato();
            Documento docder = (Documento) der.getDato();
            if (docizq.getTime() < docder.getTime()) {
                padre.setDato(docizq);
                padre = izq;
                izq = izq.getHijoIzq();
                der = padre.getHijoDer();

                if (padre.getHijoIzq() == null && padre.getHijoDer() == null) {
                    NodoMonticuloBi abuelo = padre.getPadre();
                    abuelo.setHijoIzq(null);
                    padre.setPadre(null);
                    padre.setHijoIzq(null);
                    break;
                }
            } else {
                padre.setDato(docder);
                padre = der;
                der = der.getHijoDer();
                izq = padre.getHijoIzq();
                Documento docpadre = (Documento) padre.getDato();
                Documento docabuelo = (Documento) padre.getPadre().getDato();
                if (padre.getHijoIzq() == null && padre.getHijoDer() == null && docpadre.getTime() == docabuelo.getTime()) {
                    NodoMonticuloBi abuelo = padre.getPadre();
                    abuelo.setHijoDer(null);
                    padre.setPadre(null);
                    padre.setHijoIzq(null);
                    break;
                }
            }

        }
        size--;
    }
}
