/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import Estructuras.Documento;
import Estructuras.ListaSimpleDocumentos;
import Estructuras.ListaSimpleUsuarios;
import Estructuras.NodoSimple;
import Estructuras.Usuario;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Ana Blanco
 */
public class EliminarDocumento_cola extends javax.swing.JFrame {

    public static Global global;

    /**
     * Creates new form EliminarDocumento_cola
     */
    public EliminarDocumento_cola(Global global) {
        this.global = global;
        initComponents();
        this.setLocationRelativeTo(null);
        NodoSimple aux = global.getListaUsuarios().getpFirst();
        for (int i = 0; i < global.getListaUsuarios().getSize(); i++) {

            boolean tiene = false;
            Usuario usuario = (Usuario) aux.getData();
            ListaSimpleDocumentos docs = (ListaSimpleDocumentos) usuario.getDocs();
            NodoSimple aux1 = docs.getpFirst();
            for (int j = 0; j < docs.getSize(); j++) {
                Documento doc = (Documento) aux1.getData();
                if (doc.isEncola()) {
                    tiene = true;
                    break;
                }
                aux1 = aux1.getPnext();
            }

            if (!usuario.getDocs().EsVacia()) {
                if (tiene) {
                    ComboBoxUsuarios.addItem(usuario.getName().toString());
                }
            }
            aux = aux.getPnext();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Back = new javax.swing.JButton();
        ComboBoxUsuarios = new javax.swing.JComboBox<>();
        Eliminar = new javax.swing.JButton();
        ComboBoxDocumentos = new javax.swing.JComboBox<>();
        Selection = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Back.setText("Regresar");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        getContentPane().add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 18, -1, -1));

        getContentPane().add(ComboBoxUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 200, -1));

        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });
        getContentPane().add(Eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 350, -1, -1));

        getContentPane().add(ComboBoxDocumentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, 200, -1));

        Selection.setText("Seleccionar");
        Selection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectionActionPerformed(evt);
            }
        });
        getContentPane().add(Selection, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 350, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/11.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed

        /**
         * Método que abre la interfaz principal Realizado por: Ana Blanco.
         * Versión: 11/25/2023
         */
        Impresora_interfaz impresora = new Impresora_interfaz(this.global);
        this.setVisible(false);
        impresora.setVisible(true);
    }//GEN-LAST:event_BackActionPerformed

    private void SelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectionActionPerformed

        /**
         * Método que llena el ComboBox de documentos de forma clasificada
         * Realizado por: Ana Blanco. Versión: 11/25/2023
         */
        ComboBoxDocumentos.removeAllItems();
        String usuario = ComboBoxUsuarios.getSelectedItem().toString();
        if (usuario == null) {
            JOptionPane.showMessageDialog(null, "No hay usuarios con documentos creados");
        } else {
            int indice = this.global.getHashtable().hash(usuario);

            ListaSimpleUsuarios lista = this.global.getHashtable().getTable()[indice];
            NodoSimple aux = lista.getpFirst();
            Usuario auxusuario = (Usuario) aux.getData();

            for (int i = 0; i < lista.getSize(); i++) {
                if (auxusuario.getName().equalsIgnoreCase(usuario)) {
                    NodoSimple doc = auxusuario.getDocs().getpFirst();
                    for (int j = 0; j < auxusuario.getDocs().getSize(); j++) {
                        Documento documento = (Documento) doc.getData();
                        if (documento.isEncola()) {
                            ComboBoxDocumentos.addItem(documento.getTitulo());
                        }
                        doc = doc.getPnext();
                    }
                    break;
                } else {
                    aux = aux.getPnext();
                    auxusuario = (Usuario) aux.getData();
                }
            }
        }


    }//GEN-LAST:event_SelectionActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed

        /**
         * Método que elimina un documento por referencia del monticulo, sin
         * haber sido impreso Realizado por: Ana Blanco. Versión: 11/25/2023
         */
        try {
            String usuario = ComboBoxUsuarios.getSelectedItem().toString();
            int indice = this.global.getHashtable().hash(usuario);

            ListaSimpleUsuarios lista = this.global.getHashtable().getTable()[indice];
            NodoSimple aux = lista.getpFirst();
            int contador = 0;

            for (int i = 0; i < lista.getSize(); i++){
                Usuario auxusuario = (Usuario) aux.getData();
                ListaSimpleDocumentos docs = auxusuario.getDocs();
                NodoSimple doc = docs.getpFirst();
                int contador2 = 0;
                while (contador != docs.getSize()) {
                    Documento doc1 = (Documento) doc.getData();
                    if (doc1.getTitulo().equals(ComboBoxDocumentos.getSelectedItem())) {
                        try {
                            doc1.setTime(0);
                            this.global.getMonticulobinario().criba(0);
                            Documento doc3 = this.global.getMonticulobinario().eliminarMinimo();
                            doc3.setEncola(false);
                            JOptionPane.showMessageDialog(null, "Se ha sacado el documento " + doc3.getTitulo() + " de la cola de impresión");
                            break;
                        } catch (Exception ex) {
                            Logger.getLogger(EliminarDocumento_cola.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                    doc = doc.getPnext();
                    contador2++;
                }
                aux = aux.getPnext();

            }

            ComboBoxDocumentos.removeAllItems();
            ComboBoxUsuarios.removeAllItems();

            NodoSimple aux5 = global.getListaUsuarios().getpFirst();
            for (int i = 0; i < global.getListaUsuarios().getSize(); i++) {

                boolean tiene = false;
                Usuario usuario3 = (Usuario) aux5.getData();
                ListaSimpleDocumentos docs = (ListaSimpleDocumentos) usuario3.getDocs();
                NodoSimple aux1 = docs.getpFirst();
                for (int j = 0; j < docs.getSize(); j++) {
                    Documento doc = (Documento) aux1.getData();
                    if (doc.isEncola()) {
                        tiene = true;
                        break;
                    }
                    aux1 = aux1.getPnext();
                }

                if (!usuario3.getDocs().EsVacia()) {
                    if (tiene) {
                        ComboBoxUsuarios.addItem(usuario3.getName().toString());
                    }
                }
                aux5 = aux5.getPnext();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ups. Algo salió mal");

        }
    }//GEN-LAST:event_EliminarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EliminarDocumento_cola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EliminarDocumento_cola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EliminarDocumento_cola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EliminarDocumento_cola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EliminarDocumento_cola(global).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JComboBox<String> ComboBoxDocumentos;
    private javax.swing.JComboBox<String> ComboBoxUsuarios;
    private javax.swing.JButton Eliminar;
    private javax.swing.JButton Selection;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
