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
    private ListaSimpleUsuarrios docs;

    public Usuario(String name, String priority, ListaSimpleUsuarrios docs) {
        this.name = name;
        this.priority = priority;
        this.docs = docs;
    }

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

    public ListaSimpleUsuarrios getDocs() {
        return docs;
    }

    public void setDocs(ListaSimpleUsuarrios docs) {
        this.docs = docs;
    }
    
}
