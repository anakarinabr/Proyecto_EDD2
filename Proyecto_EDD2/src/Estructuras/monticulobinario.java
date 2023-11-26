/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author luisr
 * @param <T>
 */
public class MonticuloBinario<T> {

//    AQUI COMIENZA EL ARRAY
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
        /**
         * Método que se encarga de posicionar los documentos Realizado por:
         * Luis Rivera. Versión: 11/25/2023
         */
        Documento nuevaClave = v[i];
        while ((i > 0) && (v[padre(i)].getTime() >= nuevaClave.getTime())) {
            v[i] = v[padre(i)]; // baja el padre al hueco
            i = padre(i); // sube un nivel en el árbol
        }

        v[i] = nuevaClave; // sitúa la clave en su posición
    }

    private boolean monticuloLleno() {
        return (numElem == v.length);
    }

    private void ampliar() {

        /**
         * Método que se encarga de ampliar el array si es necesario Realizado
         * por: Luis Rivera. Versión: 11/25/2023
         */
        Documento[] anteriorV = v;
        v = new Documento[numElem + TAMINI];
        for (int j = 0; j > numElem; j++) {
            v[j] = anteriorV[j];
        }
    }

    public void insertar(Documento clave) {
        /**
         * Método que se ingresar los valores en el monticulo y posicionarlo
         * Realizado por: Luis Rivera. Versión: 11/25/2023
         */

        if (monticuloLleno()) {
            ampliar();
        }
        v[numElem] = clave;
        flotar(numElem);

        numElem++;
    }

    public Documento buscarMinimo() throws Exception {

        /**
         * Método que se encarga de retornar el valor minimo Realizado por: Luis
         * Rivera. Versión: 11/25/2023
         */
        if (esVacio()) {
            throw new Exception("Acceso a montículo vacío");
        }
        return v[0];
    }

    public void criba(int raiz) {

        /**
         * Método que se encarga reacomodar el monticulo para que cumpla con sus
         * condiciones Realizado por: Luis Rivera. Versión: 11/25/2023
         */
        if (numElem > 3) {
            boolean esMonticulo;
            int hijo;
            esMonticulo = false;
            while ((raiz < (numElem / 2) - 1) && !esMonticulo) {

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
                if (v[hijo] != null) {
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

        } else {
            if (v[1] != null) {
                if (v[1].getTime() < v[0].getTime()) {
                    Documento t = v[0];
                    v[0] = v[1];
                    v[1] = t;
                    /* continua por la rama de claves mínimas */
                }
            }
        }
    }

    public Documento eliminarMinimo() throws Exception {

        /**
         * Método que se encarga de eliminar el mínimo elemento del monticulo
         * Realizado por: Luis Rivera. Versión: 11/25/2023
         */
        if (esVacio()) {
            throw new Exception("Acceso a montículo vacío");
        }
        Documento menor;
        menor = v[0];
        v[0] = v[numElem - 1];
        v[numElem - 1] = null;
        criba(0);
        this.numElem--;
        return menor;
    }

    public boolean esVacio() {
        return numElem == 0;
    }

    public void print() {
        String cola = "";

        for (int i = 0; i < v.length; i++) {
            if (v[i] != null) {
                String time = Integer.toString(v[i].getTime());
                cola += time + " - ";
            }
        }

        System.out.println(cola);
    }

    public int getNumElem() {
        return numElem;
    }

    public void setNumElem(int numElem) {
        this.numElem = numElem;
    }

    public Documento[] getV() {
        return v;
    }

    public void setV(Documento[] v) {
        this.v = v;
    }

    public void MostrarComoArbol() {
        
        /**
         * Método que se encarga de abrir la pestaña del visualizador
         * Realizado por: Ana Blanco.
         * Versión: 11/25/2023
         */
        SwingUtilities.invokeLater(() -> {
            mxGraph graph = new mxGraph() {
                // Desactivar la interacción del ratón
                public boolean isCellMovable(Object cell) {
                    return true;
                }

                public boolean isCellConnectable(Object cell) {
                    return false;
                }

            };
            Object parent = graph.getDefaultParent();

            graph.getModel().beginUpdate();
            try {
                dibujarMonticulo(graph, parent, 270, 100, 30, 30);
            } finally {
                graph.getModel().endUpdate();
            }

            mxGraphComponent graphComponent = new mxGraphComponent(graph) {
                // Desactivar la interacción del ratón
                public boolean isForceMarqueeEvent(MouseEvent e) {
                    return false;
                }
            };
            JFrame frame = new JFrame("MinHeap");
            frame.getContentPane().add(graphComponent);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            // Ajustes para el tamaño de la ventana
            frame.setSize(900, 900);
            frame.setLocationRelativeTo(null);  // Centrar en la pantalla

            frame.setVisible(true);
        }
        );
    }

    private void dibujarMonticulo(mxGraph graph, Object parent, int x, int y, int ancho, int alto) {
        
        /**
         * Método que se encarga de dibujar el monticulo en la consola.
         * Realizado por: Ana Blanco.
         * Versión: 11/25/2023
         */
        graph.setCellsSelectable(true);
        graph.setConnectableEdges(false);
        int nivel = 1;
        int nivelAnterior = 0;
        int yOffset = alto * 2;

        Object[] vertices = new Object[numElem];

        int anchoVentana = 900;
        int anchoMonticulo = numElem * (ancho * 2);

        int ajusteX = (anchoVentana - anchoMonticulo) / 2;

        for (int i = 0; i < numElem; i++) {
            int actualX;
            int actualY;

            if (i == 0) {
                actualX = x + ajusteX;
                actualY = y;
            } else {
                if (nivel != nivelAnterior) {
                    nivelAnterior = nivel;
                }
                int padreIndice = padre(i);
                int ejeXPadre = (int) graph.getCellGeometry(vertices[padreIndice]).getCenterX();

                if (hijoIzq(padreIndice) == i) {
                    // El nodo actual es el hijo izquierdo del padre
                    actualX = ejeXPadre - ancho * 2 - ajusteX;
                } else {
                    // El nodo actual es el hijo derecho del padre
                    int anchoPadre = (int) graph.getCellGeometry(vertices[padreIndice]).getWidth();
                    ajusteX /= 2;
                    actualX = ejeXPadre - anchoPadre + ancho * 2 + ajusteX;
                }
                actualY = y + nivel * yOffset;

            }

            vertices[i] = graph.insertVertex(parent, null, v[i].getTitulo(), actualX, actualY, ancho, alto);

            if (i != 0) {
                int padreIndice = padre(i);
                graph.insertEdge(parent, null, "", vertices[padreIndice], vertices[i], "startArrow=none");
            }

            if (i == Math.pow(2, nivel) - 2) {
                nivel++;
            }
        }
    }
}
