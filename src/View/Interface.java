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
    private static final Dimension DIMENSION = new Dimension(1100, 700);
    //dimension para o panel
    private static final Dimension DIMENSIONP = new Dimension(50, 50);
    //dimension para a coluna
    private static final Dimension DIMENSIONC = new Dimension(250, 100);
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
        barraMenu.setBorder(BORDA);
        barraMenu.setBackground(new Color(29, 27, 27));
        
        //Criação do Menu com seus itens
        JMenu arquivo = new JMenu("Arquivo");
        arquivo.setFont(new Font("Arial", Font.PLAIN, 15));
        arquivo.setForeground(Color.white);
        JMenuItem novo = new JMenuItem("Novo");
        JMenuItem abrir = new JMenuItem("Abrir");
        JMenuItem fechar = new JMenuItem("Sair");
        arquivo.add(novo);
        arquivo.add(abrir);
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
        
        //criação do panel para conter icones e menu
        JPanel panel = new JPanel();
        panel.setPreferredSize(DIMENSIONP);
        panel.setLayout(new GridLayout(2, 0));
        
        //paineis com icones e suas ações, juntamente com o painel da barra de menu
        JPanel subpanel1 = new JPanel();
        subpanel1.setLayout(new FlowLayout(FlowLayout.LEFT));
        subpanel1.setBackground(new Color(95, 89, 89));
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
        sublabel1.setIcon(new ImageIcon(setImage("icons\\icons8-círculo-preenchido-filled-13.png")));
        JLabel sublabel2 = new JLabel();
        sublabel2.setIcon(new ImageIcon(setImage("icons\\icons8-círculo-preenchido-filled-13 (2).png")));
        JLabel sublabel3 = new JLabel();
        sublabel3.setIcon(new ImageIcon(setImage("icons\\icons8-círculo-preenchido-filled-13_1.png")));
        subpanel1.add(sublabel1);
        subpanel1.add(sublabel2);
        subpanel1.add(sublabel3);
        sublabel1.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
            @Override
            public void mouseEntered(MouseEvent e){
                sairImg(true, sublabel1);
            }
            @Override
            public void mouseExited(MouseEvent e){
                sairImg(false, sublabel1);
            }

        });
        sublabel2.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.setExtendedState(frame.getExtendedState() == frame.MAXIMIZED_BOTH ? frame.NORMAL : frame.MAXIMIZED_BOTH);
            }
            @Override
            public void mouseEntered(MouseEvent e){
                aumentarImg(true, sublabel2);
            }
            @Override
            public void mouseExited(MouseEvent e){
                aumentarImg(false, sublabel2);
            }
        });
        sublabel3.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.setExtendedState(frame.ICONIFIED);
            }
            @Override
            public void mouseEntered(MouseEvent e){
                minimizarImg(true, sublabel3);
            }
            @Override
            public void mouseExited(MouseEvent e){
                minimizarImg(false, sublabel3);
            }
        });
        JPanel subpanel2 = new JPanel();
        subpanel2.setLayout(new GridLayout(1, 0));
        subpanel2.add(barraMenu);
        
        //adicionando os subpaineis ao painel
        panel.add(subpanel1);
        panel.add(subpanel2);
        
        //coluna para Arvore de Arquivos
        JPanel coluna = new JPanel();
        coluna.setLayout(new BorderLayout());
        coluna.setPreferredSize(DIMENSIONC);
        coluna.setBackground(new Color(90, 89, 89));
        
        //criação do TextArea 
        JTextArea txtArea = new JTextArea();
        txtArea.setBorder(BORDA);
        txtArea.setBackground(new Color(29, 27, 27));
        txtArea.setFont(new Font("font_face", Font.PLAIN, 20));
        txtArea.setForeground(Color.white);
        txtArea.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    
                }
            }
        });
        JScrollPane scroll = new JScrollPane(txtArea);
        
        //adicionando os componentes ao frame principal
        frame.add(panel, BorderLayout.NORTH);
        frame.add(coluna, BorderLayout.WEST);
        frame.add(scroll);
        
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
    
    public void sairImg(boolean valor, JLabel sublabel1){
        if(valor){
            sublabel1.setIcon(new ImageIcon(setImage("icons\\icons8-círculo-preenchido-filled-13 (1).png")));
        }else
            sublabel1.setIcon(new ImageIcon(setImage("icons\\icons8-círculo-preenchido-filled-13.png")));
    }
    
    public void aumentarImg(boolean valor, JLabel sublabel2){
        if(valor){
            sublabel2.setIcon(new ImageIcon(setImage("icons\\icons8-círculo-preenchido-filled-13 (3).png")));
        }else
            sublabel2.setIcon(new ImageIcon(setImage("icons\\icons8-círculo-preenchido-filled-13 (2).png")));
    }
    
    public void minimizarImg(boolean valor, JLabel sublabel3){
        if(valor){
            sublabel3.setIcon(new ImageIcon(setImage("icons\\icons8-círculo-preenchido-filled-13 (5).png")));
        }else
            sublabel3.setIcon(new ImageIcon(setImage("icons\\icons8-círculo-preenchido-filled-13_1.png")));
    }
}