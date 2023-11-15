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
public class NodoUsuario<T> {
    
    private T data;
    private String priority;
    private NodoUsuario pnext;

    public NodoUsuario(T data, String priority) {
        this.data = data;
        this.priority = priority;
        this.pnext = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public NodoUsuario getPnext() {
        return pnext;
    }

    public void setPnext(NodoUsuario pnext) {
        this.pnext = pnext;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
    
    
    
}
