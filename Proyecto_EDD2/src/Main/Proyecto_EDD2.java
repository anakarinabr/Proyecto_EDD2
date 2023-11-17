/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;
import Estructuras.ListaSimpleUsuarios;
import Estructuras.MonticuloBinario;
import Estructuras.Usuario;
import Interfaces.Global;
import Interfaces.start_interfaz;
import java.io.File;

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
        // TODO code application logic here
        ListaSimpleUsuarios<Usuario> ListaUsuarios = new ListaSimpleUsuarios();
        MonticuloBinario monticulo = new MonticuloBinario();
        Global global = new Global(ListaUsuarios, monticulo);
        start_interfaz inicio = new start_interfaz(global);   
        inicio.setVisible(true);

    }

}
