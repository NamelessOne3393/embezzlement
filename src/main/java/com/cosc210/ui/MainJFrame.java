package com.cosc210.ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;
import java.awt.*;

public class MainJFrame extends JFrame implements ActionListener {
    private final int X_SIZE = 1000, Y_SIZE = 700;
    private JLabel wallet, properties, buy, sell, exit, save, load;
    private JTextField propertiesField;
    public MainJFrame(){
        super("Embezzlement");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(X_SIZE,Y_SIZE));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(13, 13, 13, 13) );
        setLayout(new FlowLayout());
        JButton propertiesBtn = new JButton("Properties");
        propertiesBtn.setActionCommand("List");
        propertiesBtn.addActionListener(this);
        properties = new JLabel("List of Properties");
        //ICON
        ImageIcon gameIcon = new ImageIcon();//Need to add image and then folder path(Relative)
        this.setIconImage(gameIcon.getImage());
        
        //BACKGROUND COLOR or IMAGE
        this.getContentPane().setBackground(new Color(173, 216, 230));
    }
}
