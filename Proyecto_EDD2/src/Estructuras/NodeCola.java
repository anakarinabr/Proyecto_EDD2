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
public class NodeCola<T> {
    
    private T data;
    private NodeCola<T> pNext;

    public NodeCola(T data) {
        this.data = data;
        this.pNext = null;
    }
    
    public NodeCola(T data, NodeCola<T> pNext) {
        this.data = data;
        this.pNext = pNext;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public NodeCola<T> getpNext() {
        return pNext;
    }

    public void setpNext(NodeCola<T> pNext) {
        this.pNext = pNext;
    }
    
    
}
