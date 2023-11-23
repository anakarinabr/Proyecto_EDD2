/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author Artur
 */
public class NodoMonticuloBi<T> {
    private T dato;
    private NodoMonticuloBi Padre;
    private NodoMonticuloBi HijoDer;
    private NodoMonticuloBi HijoIzq;

    public NodoMonticuloBi(T dato) {
        this.dato = dato;
        this.Padre = null;
        this.HijoDer = null;
        this.HijoIzq = null;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public NodoMonticuloBi getPadre() {
        return Padre;
    }

    public void setPadre(NodoMonticuloBi Padre) {
        this.Padre = Padre;
    }

    public NodoMonticuloBi getHijoDer() {
        return HijoDer;
    }

    public void setHijoDer(NodoMonticuloBi HijoDer) {
        this.HijoDer = HijoDer;
    }

    public NodoMonticuloBi getHijoIzq() {
        return HijoIzq;
    }

    public void setHijoIzq(NodoMonticuloBi HijoIzq) {
        this.HijoIzq = HijoIzq;
    }
            
}
