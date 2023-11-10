/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_edd2;

/**
 *
 * @author luisr
 */
public class Proyecto_EDD2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("hola");
        
        ListaSimple <Integer> Lista = new ListaSimple<Integer>();
        
        Lista.addend(5);
        Lista.addend(4);
        Lista.addend(8);
        Lista.addend(512);
        Lista.addend(100);
        
        Lista.print();
        Lista.invertirlista();
        Lista.print();
        
        
    }
    
}
