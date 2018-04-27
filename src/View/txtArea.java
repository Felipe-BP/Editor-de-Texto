/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

/**
 *
 * @author Felipe Bueno de Paula
 */
public class TxtArea extends JTextArea{
    
    //definição da borda utilizada
    private static final Border BORDA = BorderFactory.createLineBorder(Color.black);
    
    private final JFrame parent;
    
    public TxtArea(final JFrame parent){
        this.parent = parent;
        this.init();
    }
    
    private void init(){
        this.setBorder(BORDA);
        this.setBackground(new Color(29, 27, 27));
        this.setFont(new Font("font_face", Font.PLAIN, 20));
        this.setForeground(Color.white);
        this.addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    
                }
            }
        });
        JScrollPane scroll = new JScrollPane(this);
    }
}
