/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.Border;
/**
 *
 * @author Felipe Bueno de Paula
 * Date: 2018/04/14
 */
public class Interface implements ActionListener{
    
    private static final Dimension DIMENSION = new Dimension(1000, 700);
    private static final Border BORDA = BorderFactory.createLineBorder(Color.black);
    
    Interface(){
       //defininção do frame principal
        JFrame frame = new JFrame();
        frame.setSize(DIMENSION);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
        //Crição da barra de Menu
        JMenuBar barraMenu = new JMenuBar();
        
        //Criação do Menu com seus itens
        JMenu arquivo = new JMenu("Arquivo");
        JMenuItem novo = new JMenuItem("Novo");
        JMenuItem abrir = new JMenuItem("Abrir");
        JMenuItem fechar = new JMenuItem("Sair");
        arquivo.add(novo);
        arquivo.add(abrir);
        arquivo.addSeparator();
        arquivo.add(fechar);
        
        //Criação de outro Menu com seus itens
        JMenu option = new JMenu("Opções");
        JMenuItem info = new JMenuItem("Informações sobre o software");
        option.add(info);
        
        //Adicionando os menus na Barra de Menu
        barraMenu.add(arquivo);
        barraMenu.add(option);
        
        //Adicionando os ouvintes
        fechar.addActionListener(this);
        
        //Adicionando a barra de menu no frame
        frame.setJMenuBar(barraMenu);
        
        frame.setVisible(true);        
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new Interface();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        if(str.equals("Sair"))
            System.exit(0);
    }
    
}
