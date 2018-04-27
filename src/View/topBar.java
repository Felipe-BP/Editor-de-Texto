/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Felipe Bueno de Paula
 */
public class TopBar extends JPanel{
    
    //ponto de click inicial
    private Point clickInicial;
    //JFrame pai
    private JFrame parent;
    
    public TopBar(final JFrame parent){
        this.parent = parent;
        this.init(parent);
    }
    
    private void init(JFrame parent){
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setBackground(new Color(95, 89, 89));
        addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                clickInicial = e.getPoint();
                getComponentAt(clickInicial);
            }
        });
        addMouseMotionListener(new MouseMotionAdapter(){
            @Override
            public void mouseDragged(MouseEvent e){
                int x = parent.getLocation().x;
                int y = parent.getLocation().y;
                int xMoved = (x + e.getX()) - (x + clickInicial.x);
                int yMoved = (y + e.getY()) - (y + clickInicial.y);
                int X = x + xMoved;
                int Y = y + yMoved;
                parent.setLocation(X, Y);
            }
        });

        JLabel sublabel1 = new JLabel();
        sublabel1.setIcon(new ImageIcon(setImage("icons\\icons8-círculo-preenchido-filled-13.png")));
        JLabel sublabel2 = new JLabel();
        sublabel2.setIcon(new ImageIcon(setImage("icons\\icons8-círculo-preenchido-filled-13 (2).png")));
        JLabel sublabel3 = new JLabel();
        sublabel3.setIcon(new ImageIcon(setImage("icons\\icons8-círculo-preenchido-filled-13_1.png")));
        add(sublabel1);
        add(sublabel2);
        add(sublabel3);
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
                parent.setExtendedState(parent.getExtendedState() == JFrame.MAXIMIZED_BOTH ? JFrame.NORMAL : JFrame.MAXIMIZED_BOTH);
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
                parent.setExtendedState(JFrame.ICONIFIED);
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
