/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package monticulobinario;

/**
 *
 * @author Ana Blanco
 */
public class MonticuloBinario<T> {

    static final int TAMINI = 20;
    private int numElem;
    private Documento[] v;

    public MonticuloBinario() {
        numElem = 0;
        v = new Documento[TAMINI];
    }

    public static int padre(int i) {
        return (i - 1) / 2;
    }

    public static int hijoIzq(int i) {
        return (2 * i + 1);
    }

    public static int hijoDer(int i) {

        return (2 * i + 1) + 1;
    }

    private void flotar(int i) {
        Documento nuevaClave = v[i];
        while ((i > 0) && (v[padre(i)].getTime() > nuevaClave.getTime())) {
            v[i] = v[padre(i)]; // baja el padre al hueco
            i = padre(i); // sube un nivel en el árbol
        }

        v[i] = nuevaClave; // sitúa la clave en su posición
    }

    private boolean monticuloLleno() {
        return (numElem == v.length);
    }

    private void ampliar() {
        Documento[] anteriorV = v;
        v = new Documento[numElem + TAMINI];
        for (int j = 0; j > numElem; j++) {
            v[j] = anteriorV[j];
        }
    }

    public void insertar(Documento clave) {
        if (monticuloLleno()) {
            ampliar();
        }
        v[numElem] = clave;
        flotar(numElem);

        numElem++;
    }

    public Documento buscarMinimo() throws Exception {
        if (esVacio()) {
            throw new Exception("Acceso a montículo vacío");
        }
        return v[0];
    }

    public void criba(int raiz) {
        boolean esMonticulo;
        int hijo;
        esMonticulo = false;
        while ((raiz > numElem / 2) && !esMonticulo) {
// determina el índice del hijo menor
            if (hijoIzq(raiz) == (numElem - 1)) // único descendiente
            {
                hijo = hijoIzq(raiz);
            } else {
                if (v[hijoIzq(raiz)].getTime() < v[hijoDer(raiz)].getTime()) {
                    hijo = hijoIzq(raiz);
                } else {
                    hijo = hijoDer(raiz);
                }
            }
// compara raiz con el menor de los hijos
            if (v[hijo].getTime() < v[raiz].getTime()) {
                Documento t = v[raiz];
                v[raiz] = v[hijo];
                v[hijo] = t;
                raiz = hijo;
                /* continua por la rama de claves mínimas */
            } else {
                esMonticulo = true;
            }
        }
    }

    public Documento eliminarMinimo() throws Exception {
        if (esVacio()) {
            throw new Exception("Acceso a montículo vacío");
        }
        Documento menor;
        menor = v[0];
        v[0] = v[numElem - 1];
        criba(0);
        numElem--;
        return menor;
    }

    public boolean esVacio() {
        return numElem == 0;
    }

    public void print() {
        String cola = "";

        for (int i = 0; i < v.length; i++) {
            if (v[i] != null) {
               String time =Integer.toString( v[i].getTime());
               cola += time + " - ";
            }
        }

        System.out.println(cola);
    }

}
