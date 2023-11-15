/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

/**
 *
 * @author luisr
 */
public class Nodo<T> {
    
    private T data;
    private T priority;
    private Nodo pnext;

    public Nodo(T data) {
        this.data = data;
        this.pnext = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Nodo getPnext() {
        return pnext;
    }

    public void setPnext(Nodo pnext) {
        this.pnext = pnext;
    }

    public T getPriority() {
        return priority;
    }

    public void setPriority(T priority) {
        this.priority = priority;
    }
    
    
    
}
