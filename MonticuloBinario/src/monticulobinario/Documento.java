/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package monticulobinario;

/**
 *
 * @author Ana Blanco
 */
public class Documento {
    private String titulo;
    private int tamaño;
    private boolean tipo;
    private boolean encola;
    private int time;

    public Documento(String titulo, int tamaño) {
        this.titulo = titulo;
        this.tamaño = tamaño;
        this.tipo = false;
        this.encola = false;
        this.time = 0;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
    
    

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    public boolean isTipo() {
        return tipo;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }

    public boolean isEncola() {
        return encola;
    }

    public void setEncola(boolean encola) {
        this.encola = encola;
    }
    
    
}
