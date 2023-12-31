/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import Estructuras.Documento;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;

/**
 *
 * @author Ana Blanco
 */
public class Impresora_interfaz extends javax.swing.JFrame {

    /**
     * Creates new form Impresora_interfaz
     */
    public static Graph arbol = new SingleGraph("Monticulo");

    public static Global global;

    public Impresora_interfaz(Global global) {
        this.global = global;
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        back = new javax.swing.JButton();
        Liberar = new javax.swing.JButton();
        Eliminar = new javax.swing.JButton();
        MostrarEnCola = new javax.swing.JButton();
        Árbol = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        back.setText("Regresar");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 12, -1, -1));

        Liberar.setText("Liberar ");
        Liberar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LiberarActionPerformed(evt);
            }
        });
        getContentPane().add(Liberar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 350, 30));

        Eliminar.setText("Eliminar documento de la impresora");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });
        getContentPane().add(Eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 350, 30));

        MostrarEnCola.setText("Ver documentos en forma de cola");
        MostrarEnCola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostrarEnColaActionPerformed(evt);
            }
        });
        getContentPane().add(MostrarEnCola, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 350, 30));

        Árbol.setText("Ver documentos en forma de arbol");
        Árbol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ÁrbolActionPerformed(evt);
            }
        });
        getContentPane().add(Árbol, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 350, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/4.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        
        /**
         * Método que abre la interfaz principal
         * Realizado por: Ana Blanco.
         * Versión: 11/25/2023
         */
        
        this.setVisible(false);
        start_interfaz v2 = new start_interfaz(this.global);
        v2.setVisible(true);
    }//GEN-LAST:event_backActionPerformed

    private void LiberarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LiberarActionPerformed
        
        /**
         * Método que elimina el elemento minimo del monticulo, simulando el avance de la impresora
         * Realizado por: Ana Blanco.
         * Versión: 11/25/2023
         */
        
        if (!this.global.getMonticulobinario().esVacio()) {
            try {
                Documento doc = (Documento)this.global.getMonticulobinario().eliminarMinimo();
                JOptionPane.showMessageDialog(null, "Se ha impreso el documento: "+ doc.getTitulo());
            } catch (Exception ex) {
                Logger.getLogger(Impresora_interfaz.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "La impresora esta vacía");
        }
    }//GEN-LAST:event_LiberarActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        /**
         * Método que abre la interfaz de EliminarDocumentos_cola
         * Realizado por: Ana Blanco.
         * Versión: 11/25/2023
         */
        EliminarDocumento_cola doc = new EliminarDocumento_cola(this.global);
        this.setVisible(false);
        doc.setVisible(true);
    }//GEN-LAST:event_EliminarActionPerformed

    private void MostrarEnColaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostrarEnColaActionPerformed
        
        /**
         * Método que abre la interfaz de mostrar el monticulo en forma de cola
         * Realizado por: Ana Blanco.
         * Versión: 11/25/2023
         */
        
        MostrarEnCola mostrar;
        try {
            mostrar = new MostrarEnCola(this.global);
            this.setVisible(false);
        mostrar.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(Impresora_interfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_MostrarEnColaActionPerformed

    private void ÁrbolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ÁrbolActionPerformed
        this.global.getMonticulobinario().MostrarComoArbol();
    }//GEN-LAST:event_ÁrbolActionPerformed

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
            java.util.logging.Logger.getLogger(Impresora_interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Impresora_interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Impresora_interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Impresora_interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Impresora_interfaz(global).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Eliminar;
    private javax.swing.JButton Liberar;
    private javax.swing.JButton MostrarEnCola;
    private javax.swing.JButton back;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton Árbol;
    // End of variables declaration//GEN-END:variables
}
