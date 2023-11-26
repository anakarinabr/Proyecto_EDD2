/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author Ana Blanco
 */
public class Panel extends JPanel{
    
    Panel(){
        this.setPreferredSize(new Dimension(600,400));
    }
    
    public void pain(Graphics g){
        Graphics2D g2D = (Graphics2D)g;
        g2D.drawLine(0, 0, 600, 400);
    }
}
