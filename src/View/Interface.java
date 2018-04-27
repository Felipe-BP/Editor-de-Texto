/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author Felipe Bueno de Paula
 * Date: 2018/04/26
 */
public class Interface extends JFrame{
    //dimension para o frame
    private static final Dimension DIMENSION = new Dimension(1100, 700);
    
    public Interface(){
        this.initComponents();
    }
    
    private void initComponents(){
        //definição do frame
        this.setMinimumSize(DIMENSION);
        this.setUndecorated(true);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
        //instanciando objeto TxtArea
        TxtArea area = new TxtArea(this);
        
        //instanciando objeto Painel
        Painel tp = new Painel(this, area);
        
        //instanciando objeto Coluna
        Coluna col = new Coluna(this);
        
        
        
        //adicionando os componentes ao frame principal
        this.add(tp, BorderLayout.NORTH);
        this.add(col, BorderLayout.WEST);
        this.add(area, BorderLayout.CENTER);
        
        //empacotando 
        this.pack();
        
        //deixando o frame principal visivel
        this.setVisible(true);        
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new Interface();
            }
        });
    }

}