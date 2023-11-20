/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author Ana Blanco
 */
public class HashTable {

    //Campos de la clase 
    private ListaSimpleUsuarios<Usuario>[] table;
    private Integer size;

    // Constructor para la creacion de tablas hash  
    public HashTable(int size) {
        this.size = size;
        this.table = new ListaSimpleUsuarios[size];

        for (int i = 0; i < size; i++) {
            ListaSimpleUsuarios lista = new ListaSimpleUsuarios();
            table[i] = lista;
        }
    } //Cierre del constructor

    /**
     * Método para buscar un indice de un elemento en una tabla hash
     *
     * @param reference String que será la referencia al que se le buscará el
     * índice
     * @return Integer que es el índice a donde será ingresado en la tabla hash
     */

    static long transformaClave(String clave) {
        long d;
        d = 0;
        for (int j = 0; j < clave.length(); j++) {
            d = d * 27 + (int) clave.charAt(j);
        }
        /*
        Para un valor mayor que el máximo entero genera un
        numero negativo.
         */
        if (d < 0) {
            d = -d;
        }
        return d;
    }

    public int hash(String name) {
        long valor = transformaClave(name);
        double t;
        int v;
        double R = 0.618034;
        t = R * valor - Math.floor(R * valor); // parte decimal
        v = (int) (this.size * t);
        return v;
    }

    /**
     * Método de inserción de un Objeto Usuario en una tabla Hash
     *
     * @param Hash Integer que es el índice a donde será ingresado en la tabla
     * hash
     * @param usuario Objeto Usuario que será el objeto al que se le realizará
     * la inserción
     */
    public void Insert_Usuario(int hash, Usuario usuario) {
        this.table[hash].addend(usuario);
    } //Cierre metodo
    
    public void delete_usuario(int hash, String referencia){
        ListaSimpleUsuarios lista = this.table[hash];
        
        lista.EliminarPorReferencia(referencia);
    }

    public ListaSimpleUsuarios[] getTable() {
        return table;
    }

    public void setTable(ListaSimpleUsuarios[] table) {
        this.table = table;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

}
