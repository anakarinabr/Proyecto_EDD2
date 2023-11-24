/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package monticulobinario;

/**
 *
 * @author Ana Blanco
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        MonticuloBinario monticulo = new MonticuloBinario();
        Documento a = new Documento("5", 5);
        Documento b = new Documento("10", 5);
        Documento c = new Documento("3", 5);
        Documento d = new Documento("90", 5);
        Documento e = new Documento("80", 5);
        Documento f = new Documento("1", 5);
        a.setTime(5);
        b.setTime(10);
        c.setTime(3);
        d.setTime(90);
        e.setTime(80);
        f.setTime(1);
        monticulo.insertar(a);
        monticulo.insertar(b);
        monticulo.insertar(c);
        monticulo.insertar(d);
        monticulo.insertar(e);
        monticulo.insertar(f);
        monticulo.print();
        monticulo.eliminarMinimo();
        monticulo.print();
    }
    
}
