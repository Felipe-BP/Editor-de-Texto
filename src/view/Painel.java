/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.Controle;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

/**
 *
 * @author Felipe Bueno de Paula
 */
public class Painel extends JPanel{
    //definição da borda utilizada
    private static final Border BORDA = BorderFactory.createLineBorder(Color.black);
    //dimension para o panel
    private static final Dimension DIMENSIONP = new Dimension(50, 50);
    //parent
    private final JFrame parent;
    
    public Painel(final JFrame parent, JTextArea txt){
        this.parent = parent;
        this.init(parent, txt);
    }
    
    private void init(JFrame parent, JTextArea txt){
        this.setPreferredSize(DIMENSIONP);
        this.setLayout(new GridLayout(2, 0));
        
        //Crição da barra de Menu
        JMenuBar barraMenu = new JMenuBar();
        barraMenu.setBorder(BORDA);
        barraMenu.setBackground(new Color(29, 27, 27));
        
        //Criação do Menu com seus itens
        JMenu arquivo = new JMenu("Arquivo");
        arquivo.setFont(new Font("Arial", Font.PLAIN, 15));
        arquivo.setForeground(Color.white);
        JMenuItem novo = new JMenuItem("Novo");
        JMenuItem abrir = new JMenuItem("Abrir");
        JMenuItem salvar = new JMenuItem("Salvar");
        JMenuItem fechar = new JMenuItem("Sair");
        arquivo.add(novo);
        arquivo.add(abrir);
        arquivo.add(salvar);
        arquivo.addSeparator();
        arquivo.add(fechar);
        
        //Criação de outro Menu com seus itens
        JMenu option = new JMenu("Opções");
        option.setFont(new Font("Arial", Font.PLAIN, 15));
        option.setForeground(Color.white);
        JMenuItem info = new JMenuItem("Informações sobre o software");
        option.add(info);
        
        //Adicionando os menus na Barra de Menu
        barraMenu.add(arquivo);
        barraMenu.add(option); 
        
        //Adicionando os ouvintes
        fechar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                sairActionPerformed(e);
            }
        });
        
        salvar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Controle c = new Controle();
                try {
                    c.salvarArquivo(txt.getText());
                } catch (IOException ex) {
                    Logger.getLogger(Painel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        JPanel subpanel2 = new JPanel();
        subpanel2.setLayout(new GridLayout(1, 0));
        subpanel2.add(barraMenu);
        
        //adicionando os subpaineis ao painel
        TopBar tp = new TopBar(parent);
        this.add(tp);
        this.add(subpanel2);
    }
    
    public void sairActionPerformed(ActionEvent e) {
        int i = JOptionPane.showConfirmDialog(null, "Você deseja sair?", "Você deseja sair?", JOptionPane.YES_NO_OPTION);
        if(i==0){
            System.exit(0);
        }
    }
    
}
