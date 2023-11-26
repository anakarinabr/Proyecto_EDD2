/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author Ana Blanco
 */
public class Documento {

    private String titulo;
    private int tamaño;
    private boolean prioridad;
    private boolean encola;
    private int time;
    private String tipo;
    
    //Constructor
    public Documento(String titulo, int tamaño, String tipo) {
        this.titulo = titulo;
        this.tamaño = tamaño;
        this.tipo = tipo;
        this.prioridad = false;
        this.encola = false;
        this.time = 0;
    }
    
    //Getters and Setters
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

    public boolean isPrioridad() {
        return prioridad;
    }

    public void setPrioridad(boolean prioridad) {
        this.prioridad = prioridad;
    }

    public boolean isEncola() {
        return encola;
    }

    public void setEncola(boolean encola) {
        this.encola = encola;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
     /**
         * Método que se encarga de actualizar el tiempo de los documentos
         * para el manejo dentro del monticulo
         * Realizado por: Luis Rivera.
         * Versión: 11/25/2023
         */
    
    public void ActualizarTime(String prioridad,int hora, int minuto, int segundos ){
        this.time = hora*3600 + minuto*60 + segundos;
        if (this.prioridad){
            if (prioridad.equalsIgnoreCase("Prioridad_alta")){
                if(this.time >= 30){
                    this.time -= 30;
                }else{
                    this.time = 0;
                } 
            }else if(prioridad.equalsIgnoreCase("Prioridad_media")){
                if(this.time >= 20){
                    this.time -= 20;
                }else{
                    this.time = 0;
                }
            }else if(prioridad.equalsIgnoreCase("Prioridad_baja")){
                if(this.time >= 10){
                    this.time -= 10;
                }else{
                    this.time = 0;
                }
            }
        }    
    }
    
}
