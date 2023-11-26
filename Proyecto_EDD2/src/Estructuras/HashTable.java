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
    
    /**
         * Método que se encarga de asignar un indice a partir de un nombre
         * Realizado por: Ana Blanco.
         * Versión: 11/25/2023
         */

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
         * Método que se encarga de insertar el usuario en el hashtable
         * Realizado por: Luis Rivera.
         * Versión: 11/25/2023
         */
    public void Insert_Usuario(int hash, Usuario usuario) {
        this.table[hash].addend(usuario);
    } 
    
    /**
         * Método que se encarga de eliminar un usuario
         * Realizado por: Luis Rivera.
         * Versión: 11/25/2023
         */    
    public void delete_usuario(int hash, String referencia){
        ListaSimpleUsuarios lista = this.table[hash];
        
        lista.EliminarPorReferencia(referencia);
    }
    
    //Getters and Setters
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
