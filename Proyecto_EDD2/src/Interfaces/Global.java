/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Estructuras.HashTable;
import Estructuras.ListaSimpleUsuarios;
import Estructuras.MonticuloBinario;
import Estructuras.NodoSimple;
import Estructuras.Usuario;

/**
 *
 * @author Ana Blanco
 */
public class Global {
    
    //Parámetros de la clase Global
    private ListaSimpleUsuarios<Usuario> ListaUsuarios;
    private HashTable hashtable;
    private MonticuloBinario monticulobinario;
    
    public Global(ListaSimpleUsuarios ListaUsuarios, MonticuloBinario monticulo){
        this.ListaUsuarios = ListaUsuarios;
        this.monticulobinario = monticulo;
        this.hashtable = null;
    }
    
    public ListaSimpleUsuarios<Usuario> getListaUsuarios() {
        return ListaUsuarios;
    }

    public void setListaUsuarios(ListaSimpleUsuarios<Usuario> ListaUsuarios) {
        this.ListaUsuarios = ListaUsuarios;
    }

    public MonticuloBinario getMonticulobinario() {
        return monticulobinario;
    }

    public void setMonticulobinario(MonticuloBinario monticulobinario) {
        this.monticulobinario = monticulobinario;
    }
    
    public HashTable getHashtable() {
        return hashtable;
    }

    public void setHashtable(HashTable hashtable) {
        this.hashtable = hashtable;
    }
    
    
    
    
}
