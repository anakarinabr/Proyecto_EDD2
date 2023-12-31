/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import Estructuras.Cronometro;
import Estructuras.Documento;
import Estructuras.ListaSimpleUsuarios;
import Estructuras.MonticuloBinario;
import Estructuras.Usuario;
import Interfaces.Global;
import Interfaces.start_interfaz;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.Timer;

/**
 *
 * @author Ana Blanco
 */
public class Proyecto_EDD2 {

    public static File selectedFile;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cronometro crono = new Cronometro();
        crono.Iniciar();
        ListaSimpleUsuarios<Usuario> ListaUsuarios = new ListaSimpleUsuarios<Usuario>();
        MonticuloBinario<Documento> monticulo = new MonticuloBinario<Documento>();
        Global global = new Global(ListaUsuarios, monticulo, crono);
        start_interfaz inicio = new start_interfaz(global);
        inicio.setVisible(true);

    }

}
