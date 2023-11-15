/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Estructuras.HashTable;
import Estructuras.ListaSimpleUsuarrios;
import Estructuras.NodoUsuario;

/**
 *
 * @author Ana Blanco
 */
public class Global {
    
    //Parámetros de la clase Global
    private static HashTable hashtable = new HashTable(16);
    private static ListaSimpleUsuarrios ListaUsuarios = new ListaSimpleUsuarrios();
    
    public static HashTable getHashtable() {
        return hashtable;
    }
    
    public static void setHashtable(HashTable hashtable) {
        Global.hashtable = hashtable;
    }
}
