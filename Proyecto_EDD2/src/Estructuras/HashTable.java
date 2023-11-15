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
    private ListaSimpleUsuarios[] table;
    private Integer size;
   
    // Constructor para la creacion de tablas hash  

    public HashTable(int size) {
        this.size = size;
        this.table = new ListaSimpleUsuarios[this.size];
        
        for (int i = 0 ; i < size; i++){
            ListaSimpleUsuarios lista = new ListaSimpleUsuarios();
            table[i]= lista;
        } 
    } //Cierre del constructor
    
    /**
     * Método para buscar un indice de un elemento en una tabla hash
     * @param reference String que será la referencia al que se le buscará el índice
     * @return Integer que es el índice a donde será ingresado en la tabla hash
     */
    public int Hash(String reference){
        int hash = 0;
        for(int i = 0; i < reference.length(); i++) {
            hash = (hash * 31 + reference.charAt(i)) % getSize();} // NO SE SI SE QUEDARA ASI
    
        return hash; 
    } //Cierre metodo
    
    /**
     * Método de inserción de un Objeto PalabraClave en una tabla Hash
     * @param Hash Integer que es el índice a donde será ingresado en la tabla hash
     * @param usuario Objeto Usuario que será el objeto al que se le realizará la inserción
     */
    public void Insert_Usuario(int hash,Usuario usuario){
        this.getTable()[hash].addend(usuario);
    } //Cierre metodo

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
