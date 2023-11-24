/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package monticulobinario;

/**
 *
 * @author Ana Blanco
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
