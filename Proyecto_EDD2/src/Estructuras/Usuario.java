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
    private String priority;
    private ListaSimpleDocumentos docs;
    
    //Constructor
    public Usuario(String name, String priority) {
        this.name = name;
        this.priority = priority;
        this.docs = new ListaSimpleDocumentos();
    }
    
    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrioridad() {
        return priority;
    }

    public void setPriority(String prioridad) {
        this.priority = prioridad;
    }

    public ListaSimpleDocumentos getDocs() {
        return docs;
    }

    public void setDocs(ListaSimpleDocumentos docs) {
        this.docs = docs;
    }
    
}
