/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Estructuras.Cronometro;
import Estructuras.Documento;
import Estructuras.HashTable;
import Estructuras.ListaSimpleUsuarios;
import Estructuras.MontículoBinario;
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
    private MontículoBinario<Documento> monticulobinario;
    private Cronometro cronometro;
    private String path;
    
    //Constructor
    public Global(ListaSimpleUsuarios ListaUsuarios, MontículoBinario monticulo, Cronometro cronometro) {

        this.ListaUsuarios = ListaUsuarios;
        this.monticulobinario = monticulo;
        this.cronometro = cronometro;
        this.hashtable = null;
        this.path = null;
    }
    
    //Getters and Setters
    public ListaSimpleUsuarios<Usuario> getListaUsuarios() {
        return ListaUsuarios;
    }

    public void setListaUsuarios(ListaSimpleUsuarios<Usuario> ListaUsuarios) {
        this.ListaUsuarios = ListaUsuarios;
    }

    public MontículoBinario getMonticulobinario() {
        return monticulobinario;
    }

    public void setMonticulobinario(MontículoBinario monticulobinario) {
        this.monticulobinario = monticulobinario;
    }

    public HashTable getHashtable() {
        return hashtable;
    }

    public void setHashtable(HashTable hashtable) {
        this.hashtable = hashtable;
    }

    public Cronometro getCronometro() {
        return cronometro;
    }

    public void setCronometro(Cronometro cronometro) {
        this.cronometro = cronometro;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}
