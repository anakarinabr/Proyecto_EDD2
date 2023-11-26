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
    private boolean tipo;
    private boolean encola;
    private int time;
    
    //Constructor
    public Documento(String titulo, int tamaño) {
        this.titulo = titulo;
        this.tamaño = tamaño;
        this.tipo = false;
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

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
    
    
     /**
         * Método que se encarga de actualizar el tiempo de los documentos
         * para el manejo dentro del monticulo
         * Realizado por: Luis Rivera.
         * Versión: 11/25/2023
         */
    
    public void ActualizarTime(String prioridad,int hora, int minuto, int segundos ){
        this.time = hora*3600 + minuto*60 + segundos;
        if (this.tipo){
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
