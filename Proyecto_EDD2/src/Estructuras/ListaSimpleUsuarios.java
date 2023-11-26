/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

/**
 *
 * @author luisr
 * @param <T>
 */
public class ListaSimpleUsuarios<T> {

    private NodoSimple<T> pFirst;
    private NodoSimple<T> pLast;
    private int size;
    
    //Constructor
    public ListaSimpleUsuarios() {
        this.pFirst = null;
        this.pLast = null;
        this.size = 0;
    }
    
    //Getters and Setters
    public NodoSimple<T> getpFirst() {
        return pFirst;
    }

    public void setpFirst(NodoSimple<T> pFirst) {
        this.pFirst = pFirst;
    }

    public NodoSimple<T> getpLast() {
        return pLast;
    }

    public void setpLast(NodoSimple<T> pLast) {
        this.pLast = pLast;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean EsVacia() {
        return this.pFirst == null;

    }
    
    /**
         * Método que se encarga de posicionar al inicio de la lista
         * Realizado por: Luis Rivera.
         * Versión: 11/25/2023
         */
    public void addFirst(Usuario usuario) {
        NodoSimple nodo = new NodoSimple(usuario);
        if (EsVacia() == true) {
            this.pFirst = nodo;
            this.pLast = nodo;

        } else {
            nodo.setPnext(this.pFirst);
            this.setpFirst(nodo);

        }
        this.size++;

    }
    
    /**
         * Método que se encarga de ingresar al final de la lista
         * Realizado por: Luis Rivera.
         * Versión: 11/25/2023
         */
    public void addend(Usuario usuario) {

        NodoSimple nodo = new NodoSimple(usuario);

        if (EsVacia() == true) {
            this.pFirst = nodo;
            this.pLast = nodo;

        } else {
            this.pLast.setPnext(nodo);
            this.setpLast(nodo);
        }
        this.size++;
    }
    
    /**
         * Método que se encarga de hacer un String que contega la información de todo los usuarios
         * Realizado por: Luis Rivera.
         * Versión: 11/25/2023
         */
    public String getAllUsers() {
        String todo = "usuario,tipo";
        if (EsVacia()) {
            return todo;
        }
        NodoSimple<T> pAux = this.pFirst;

        while (pAux != null) {
            Usuario data = (Usuario) pAux.getData();
            todo += "\n" + data.getName() + "," + data.getPrioridad() + "";
            pAux = pAux.getPnext();
        }

        System.out.println(todo);
        return todo;

    }
    
    /**
         * Método que se encarga de buscar los documentos
         * Realizado por: Luis Rivera.
         * Versión: 11/25/2023
         */
    public boolean buscarDocumento(String referencia) {
        NodoSimple aux = this.pFirst;
        boolean encontrado = false;
        while (aux != null && encontrado != true) {
            Usuario usuario =(Usuario) aux.getData();
            ListaSimpleDocumentos docs = usuario.getDocs();
            boolean exits = docs.buscar(referencia);
            if (exits) {
                encontrado = true;
                return encontrado;
            } else {
                aux = aux.getPnext();
            }
        }
        return encontrado;

    }
    
    /**
         * Método que se encarga de comprobar que existe un valor dentro de la lista
         * Realizado por: Luis Rivera.
         * Versión: 11/25/2023
         */
    public boolean buscar(String referencia) {
        NodoSimple aux = this.pFirst;
        boolean encontrado = false;
        while (aux != null && encontrado != true) {
            Usuario usuario =(Usuario) aux.getData();
            if (usuario.getName().equals(referencia)) {
                encontrado = true;
            } else {
                aux = aux.getPnext();
            }
        }
        return encontrado;

    }
    
    /**
         * Método que se encarga de eliminar dado un usuario
         * Realizado por: Luis Rivera.
         * Versión: 11/25/2023
         */
    public void EliminarPorReferencia(String referencia) {
        if (buscar(referencia)) {
            Usuario usuario = (Usuario)this.pFirst.getData();
            if (usuario.getName().equals(referencia)) {
                this.pFirst = this.pFirst.getPnext();
                
            }else {
                NodoSimple aux = this.pFirst;
                Usuario nextaux = (Usuario) aux.getPnext().getData();
                while (!nextaux.getName().equals(referencia)) {
                    aux = aux.getPnext();
                    nextaux = (Usuario) aux.getPnext().getData();
                }
                NodoSimple siguiente = aux.getPnext().getPnext();
                aux.setPnext(siguiente);
            }
            size--;
        }     
        
    }
}
