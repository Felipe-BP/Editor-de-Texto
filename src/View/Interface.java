/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
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
    //dimension para a coluna
    private static final Dimension DIMENSIONC = new Dimension(35, 50);
    //borda
    private static final Border BORDA = BorderFactory.createLineBorder(Color.black);
    //ponto de click inicial
    private Point clickInicial;
    //numeros para barra
    private static int i = 2;
    
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
        
        //criação do panel para conter icones e menu
        JPanel panel = new JPanel();
        panel.setBorder(BORDA);
        panel.setPreferredSize(DIMENSIONP);
        panel.setLayout(new GridLayout(2, 0));
        
        //paineis com icones e suas ações, juntamente com o painel da barra de menu
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

        JLabel sublabel1 = new JLabel();
        sublabel1.setIcon(new ImageIcon(setImage("icons\\icons8-cancelar-filled-12.png")));
        JLabel sublabel2 = new JLabel();
        sublabel2.setIcon(new ImageIcon(setImage("icons\\icons8-redimensionar-diagonal-filled-10.png")));
        JLabel sublabel3 = new JLabel();
        sublabel3.setIcon(new ImageIcon(setImage("icons\\icons8-comprimir-filled-10.png")));
        subpanel1.add(sublabel1);
        subpanel1.add(sublabel2);
        subpanel1.add(sublabel3);
        sublabel1.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }

        });
        sublabel2.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.setExtendedState(frame.getExtendedState() == frame.MAXIMIZED_BOTH ? frame.NORMAL : frame.MAXIMIZED_BOTH);
            }
        });
        sublabel3.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.setExtendedState(JFrame.ICONIFIED);
            }
        });
        JPanel subpanel2 = new JPanel();
        subpanel2.setBorder(BORDA);
        subpanel2.setLayout(new GridLayout(1, 0));
        subpanel2.add(barraMenu);
        
        //adicionando os subpaineis ao painel
        panel.add(subpanel1);
        panel.add(subpanel2);
        
        //coluna para numero de linhas
        JPanel coluna = new JPanel();
        coluna.setBorder(BORDA);
        coluna.setLayout(new BorderLayout());
        coluna.setPreferredSize(DIMENSIONC);
        JLabel um = new JLabel("1");
        coluna.add(um, BorderLayout.NORTH);
        JPanel subpanelnum = new JPanel();
        subpanelnum.setLayout(new FlowLayout());
        coluna.add(subpanelnum);
        
        //criação do TextArea 
        JTextArea txtArea = new JTextArea();
        txtArea.setBorder(BORDA);
        txtArea.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    JTextField numeros = new JTextField(i+"\n");
                    numeros.setEditable(false);
                    subpanelnum.add(numeros);
                    i++;
                }
            }
        });
        
        //adicionando os componentes ao frame principal
        frame.add(panel, BorderLayout.NORTH);
        frame.add(coluna, BorderLayout.WEST);
        frame.add(txtArea);
        
        //empacotando 
        frame.pack();
        
        //deixando o frame principal visivel
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
    
    private BufferedImage setImage(String path){
        try{
            return ImageIO.read(getClass().getClassLoader().getResource(path));
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}