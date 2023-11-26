/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

/**
 *
 * @author Estudiante
 */
public class Queue<T> {

    private NodeCola<T> pHead;
    private NodeCola<T> pTail;
    private int size;
    
    //Constructor
    public Queue() {
        this.pHead = null;
        this.pTail = null;
        this.size = 0;
    }
    
    /**
         * Método que se comprobar si está vacia la cola
         * Realizado por: Luis Rivera.
         * Versión: 11/25/2023
         */
    public boolean isEmpty() {
        return this.pHead == null;
    }
    
    /**
         * Método que se encarga de ingresar datos a la cola
         * Realizado por: Luis Rivera.
         * Versión: 11/25/2023
         */
    public void add(T data) {
        NodeCola<T> node = new NodeCola(data);
        if (this.isEmpty()) {
            this.pHead = node;
            this.pTail = node;
        } else {
            this.pTail.setpNext(node);
            this.pTail = node;
        }
        this.size++;
    }
    
    /**
         * Método que se encarga de el primer objeto de la cola
         * Realizado por: Luis Rivera.
         * Versión: 11/25/2023
         */
    public NodeCola<T> poll() {
        NodeCola<T> node = this.pHead;
        if (!this.isEmpty()) {
            this.pHead = this.pHead.getpNext();
            size--;
        }
        return node;
    }
    
    /**
         * Método que se encarga de imprimir la cola
         * Realizado por: Luis Rivera.
         * Versión: 11/25/2023
         */
    public String print() {
        String output = "";
        for (int i = 0; i < this.size; i++) {
            T data = this.pHead.getData();
            output += data + "->";
            this.poll();
            this.add(data);
        }
        return output + "//";
    }
    
    
    // Getters and Setters
    public NodeCola<T> getpHead() {
        return pHead;
    }

    public void setpHead(NodeCola<T> pHead) {
        this.pHead = pHead;
    }

    public NodeCola<T> getpTail() {
        return pTail;
    }

    public void setpTail(NodeCola<T> pTail) {
        this.pTail = pTail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
