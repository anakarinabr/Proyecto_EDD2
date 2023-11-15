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
public class NodoSimple<T> {
    
    private T data;
    private NodoSimple pnext;

    public NodoSimple(T data) {
        this.data = data;
        this.pnext = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public NodoSimple getPnext() {
        return pnext;
    }

    public void setPnext(NodoSimple pnext) {
        this.pnext = pnext;
    }   
    
    
}
