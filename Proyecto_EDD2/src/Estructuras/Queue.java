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

    public Queue() {
        this.pHead = null;
        this.pTail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.pHead == null;
    }

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

    public NodeCola<T> poll() {
        NodeCola<T> node = this.pHead;
        if (!this.isEmpty()) {
            this.pHead = this.pHead.getpNext();
            size--;
        }
        return node;
    }

    public boolean exists(T valor) {
        boolean b = false;
        for (int i = 0; i < this.size; i++) {
            T data = this.pHead.getData();
            if(valor == data){
                b = true;
            }
            this.poll();
            this.add(data);
        }
        
        return b;
    }

    public void colearDePrimero(T data) {
        NodeCola<T> node = new NodeCola(data);
        if (this.isEmpty()) {
            this.pHead = node;
            this.pTail = node;
            this.size++;
        } else {
            this.add(data);
            for (int i = 0; i < this.size - 1; i++) {
                T auxData = this.pHead.getData();
                this.poll();
                this.add(auxData);
            }
        }
    }

    public void reverse() {
        if (!this.isEmpty()) {
            T data = this.pHead.getData();
            this.poll();
            this.reverse();
            this.add(data);
        }
    }

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
