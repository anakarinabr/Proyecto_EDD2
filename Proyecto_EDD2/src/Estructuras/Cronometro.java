/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import java.awt.event.ActionEvent;
import javax.swing.Timer;

/**
 *
 * @author luisr
 */
public class Cronometro {

    private Timer crono;
    private int hora;
    private int minutos;
    private int segundos;
    private int milisegundos;

    public Cronometro() {
        this.hora = 0;
        this.minutos = 0;
        this.segundos = 0;
        this.milisegundos = 0;
        crono = new Timer(10, (ActionEvent e) -> {
            Iniciar();
        });

    }

    public void Iniciar() {
        crono.start();
        ActualizaTiempo();

    }

    private void ActualizaTiempo() {
        milisegundos++;
        if (milisegundos == 65) {
            milisegundos = 0;
            segundos++;
            System.out.println(hora + " : " + minutos + " : " + segundos);
        }

        if (segundos == 60) {
            segundos = 0;
            minutos++;

        }
        if (minutos == 60) {
            minutos = 0;
            hora++;

        }
    }

}
