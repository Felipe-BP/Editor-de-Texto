/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import javax.swing.*;
import java.awt.*;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.border.Border;
/**
 *
 * @author Felipe Bueno de Paula
 * Date: 2018/04/18
 */
public class Interface{
    //dimension para o frame
    private static final Dimension DIMENSION = new Dimension(1000, 700);
    //dimension para o panel
    private static final Dimension DIMENSIONP = new Dimension(50, 50);
    //borda
    private static final Border BORDA = BorderFactory.createLineBorder(Color.black);
    //ponto de click inicial
    private Point clickInicial;
    
    Interface(){
       //defininção do frame principal
        JFrame frame = new JFrame();
        frame.setMinimumSize(DIMENSION);
        frame.setUndecorated(true);
        frame.setLayout(new BorderLayout());
        
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
        fechar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                sairActionPerformed(e);
            }
        });
        
        JPanel panel = new JPanel();
        panel.setBorder(BORDA);
        panel.setPreferredSize(DIMENSIONP);
        panel.setLayout(new GridLayout(2, 0));
        
        JPanel subpanel1 = new JPanel();
        subpanel1.setBorder(BORDA);
        subpanel1.setLayout(new FlowLayout(FlowLayout.LEFT));
        subpanel1.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                clickInicial = e.getPoint();
                subpanel1.getComponentAt(clickInicial);
            }
        });
        subpanel1.addMouseMotionListener(new MouseMotionAdapter(){
            @Override
            public void mouseDragged(MouseEvent e){
                int x = frame.getLocation().x;
                int y = frame.getLocation().y;
                int xMoved = (x + e.getX()) - (x + clickInicial.x);
                int yMoved = (y + e.getY()) - (y + clickInicial.y);
                int X = x + xMoved;
                int Y = y + yMoved;
                frame.setLocation(X, Y);
            }
        });
        Icon fecharimg = new ImageIcon("C:\\Users\\Rafael\\Pictures\\icons8-cancelar-filled-12.png");
        Icon aumentarimg = new ImageIcon("C:\\Users\\Rafael\\Pictures\\icons8-redimensionar-diagonal-filled-10.png");
        JLabel sublabel1 = new JLabel(fecharimg);
        JLabel sublabel2 = new JLabel(aumentarimg);
        subpanel1.add(sublabel1);
        subpanel1.add(sublabel2);
        sublabel1.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }

        });
        sublabel2.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.setExtendedState(MAXIMIZED_BOTH);
            }
        });
        JPanel subpanel2 = new JPanel();
        subpanel2.setBorder(BORDA);
        subpanel2.setLayout(new GridLayout(1, 0));
        subpanel2.add(barraMenu);
        
        panel.add(subpanel1);
        panel.add(subpanel2);
        
        JTextArea txtArea = new JTextArea();
        txtArea.setBorder(BORDA);
        
        frame.add(panel, BorderLayout.NORTH);
        frame.add(txtArea);
        
        frame.pack();
        
        frame.setVisible(true);        
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new Interface();
            }
        });
    }

    public void sairActionPerformed(ActionEvent e) {
        int i = JOptionPane.showConfirmDialog(null, "Você deseja sair?", "Você deseja sair?", JOptionPane.YES_NO_OPTION);
        if(i==0){
            System.exit(0);
        }
    }
}
