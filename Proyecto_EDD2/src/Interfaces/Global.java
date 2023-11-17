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
    private static ListaSimpleUsuarios<Usuario> ListaUsuarios = new ListaSimpleUsuarios();
    private HashTable hashtable;
    
    public Global(){
        this.hashtable = null;
    }
    public static ListaSimpleUsuarios<Usuario> getListaUsuarios() {
        return ListaUsuarios;
    }

    public static void setListaUsuarios(ListaSimpleUsuarios<Usuario> ListaUsuarios) {
        Global.ListaUsuarios = ListaUsuarios;
    }

    public HashTable getHashtable() {
        return hashtable;
    }

    public void setHashtable(HashTable hashtable) {
        this.hashtable = hashtable;
    }
    
    
    
    
}
