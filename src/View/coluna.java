/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Felipe Bueno de Paula
 */
public class Coluna extends JPanel{
    
    //dimension para a Coluna
    private static final Dimension DIMENSIONC = new Dimension(250, 100);
    
    private final JFrame parent;
    
    public Coluna(final JFrame parent){
        this.parent = parent;
        this.init();
    }
    
    private void init(){
        this.setLayout(new BorderLayout());
        this.setPreferredSize(DIMENSIONC);
        this.setBackground(new Color(90, 89, 89)); 
    }
}
