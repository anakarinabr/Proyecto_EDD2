/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import Estructuras.ListaSimpleUsuarios;
import Estructuras.NodoSimple;
import Estructuras.Usuario;
import javax.swing.JOptionPane;

/**
 *
 * @author Ana Blanco
 */
public class AgregarUsuarios extends javax.swing.JFrame {

    public static Global global;

    /**
     * Creates new form EliminarUsuario
     */
    public AgregarUsuarios(Global global) {
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
        Back = new javax.swing.JButton();
        User = new javax.swing.JTextField();
        selected = new javax.swing.JComboBox<>();
        Add = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Back.setText("Regresar");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        getContentPane().add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));
        getContentPane().add(User, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 180, 150, 30));

        selected.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alta", "Media", "Baja" }));
        getContentPane().add(selected, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 300, 220, 20));

        Add.setText("Agregar");
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });
        getContentPane().add(Add, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, 130, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Print docs (4).png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        Usuarios_interfaz agregar = new Usuarios_interfaz(this.global);
        this.setVisible(false);
        agregar.setVisible(true);
    }//GEN-LAST:event_BackActionPerformed

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed

        String username = "";
        username += User.getText().trim();
        String prioridad = "Prioridad_";
        prioridad += (String) selected.getSelectedItem();

        if (!username.equalsIgnoreCase("")) {
            boolean exits = false;
            NodoSimple pAux = this.global.getListaUsuarios().getpFirst();
            for (int i = 0; i < this.global.getListaUsuarios().getSize(); i++) {
                Usuario user = (Usuario) pAux.getData();
                if (username.equalsIgnoreCase(user.getName())) {
                    exits = true;
                }
                pAux = pAux.getPnext();
            }
            if (!exits) {

                if (!username.contains(" ")) {
                    Usuario nuevo = new Usuario(username, prioridad);

                    this.global.getListaUsuarios().addend(nuevo);
                    int hash = this.global.getHashtable().hash(nuevo.getName());
                    this.global.getHashtable().Insert_Usuario(hash, nuevo);
                    JOptionPane.showMessageDialog(null, "Se ha ingresado correctamente el usuario");
                } else {
                    JOptionPane.showMessageDialog(null, "El username no puede contener espacios en blanco");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ese username no está disponible");
            }
        } else if (username.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Ingresar un username, por favor!");
        }
    }//GEN-LAST:event_AddActionPerformed

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
            java.util.logging.Logger.getLogger(AgregarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarUsuarios(global).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JButton Back;
    private javax.swing.JTextField User;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> selected;
    // End of variables declaration//GEN-END:variables

}