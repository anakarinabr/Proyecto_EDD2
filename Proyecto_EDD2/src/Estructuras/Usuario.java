/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author Ana Blanco
 */
public class Usuario {
    
    private String name;
    private String prioridad;
    private ListaSimple docs;

    public Usuario(String name, String prioridad, ListaSimple docs) {
        this.name = name;
        this.prioridad = prioridad;
        this.docs = docs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public ListaSimple getDocs() {
        return docs;
    }

    public void setDocs(ListaSimple docs) {
        this.docs = docs;
    }
    
}
