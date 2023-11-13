/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_edd2;

import Estructuras.ListaSimple;

/**
 *
 * @author Ana Blanco
 */
public class Proyecto_EDD2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        ListaSimple<Integer> lista1 = new ListaSimple<>();

        lista1.addend(5);
        lista1.addend(20);
        lista1.addend(30);
        lista1.addend(100);
        lista1.addend(50);
        lista1.addend(45);
        lista1.addend(85);
        
        lista1.print();
        lista1.invertirlista();
        lista1.print();
        

    }

}
