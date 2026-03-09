package com.cosc210.ui;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FrameMaker extends JFrame{
    final int X_SIZE = 1000, Y_SIZE = 700;
    public FrameMaker(){
        this.setTitle("Embezzlement");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(X_SIZE,Y_SIZE);

        //ICON
        ImageIcon gameIcon = new ImageIcon();//Need to add image and then folder path(Relative)
        this.setIconImage(gameIcon.getImage());
        
        //BACKGROUND COLOR or IMAGE
        this.getContentPane().setBackground(new Color(173, 216, 230));
        
    }
    public void createMainFrame(){
        JLabel wallet = new JLabel("Walllet");
        this.add(wallet);
        this.setVisible(true);
    }
    public void createBuyFrame(){
    }
    public void createSellFrame(){
    }
}
