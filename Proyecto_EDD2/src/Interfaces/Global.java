/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Estructuras.HashTable;
import Estructuras.ListaSimpleUsuarios;
import Estructuras.NodoSimple;
import Estructuras.Usuario;

/**
 *
 * @author Ana Blanco
 */
public class Global {
    
    //Parámetros de la clase Global
    private static HashTable hashtable = new HashTable(16);
    private static ListaSimpleUsuarios<Usuario> ListaUsuarios = new ListaSimpleUsuarios();
    
    public static HashTable getHashtable() {
        return hashtable;
    }
    
    public static void setHashtable(HashTable hashtable) {
        Global.hashtable = hashtable;
    }

    public static ListaSimpleUsuarios<Usuario> getListaUsuarios() {
        return ListaUsuarios;
    }

    public static void setListaUsuarios(ListaSimpleUsuarios<Usuario> ListaUsuarios) {
        Global.ListaUsuarios = ListaUsuarios;
    }
    
    
}
