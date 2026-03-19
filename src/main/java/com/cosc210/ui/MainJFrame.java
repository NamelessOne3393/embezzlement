package com.cosc210.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class MainJFrame extends JFrame implements ActionListener {




    // the main menu has the current balance, rate of income, and a horizontally scrolling menu of all things money is being invested into.
    // File has all the things related to saving and loading
    public void thing(){
        JFrame frame = new JFrame("My First JFrame");
        JLabel label = new JLabel("AAAAAAAAAAAAAAAA");
        JButton button = new JButton("HI");
        JMenuBar bar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem quitItem = new JMenuItem("Quit Without Saving");
        quitItem.setActionCommand("Q");
        JMenuItem quitSaveItem = new JMenuItem("Quit and Save");
        quitSaveItem.setActionCommand("SQ");
        JMenuItem saveItem = new JMenuItem("Save");
        saveItem.setActionCommand("S");
        JMenuItem loadItem = new JMenuItem("Load");
        loadItem.setActionCommand("L");
        fileMenu.add(quitItem);
        fileMenu.add(quitSaveItem);
        fileMenu.add(saveItem);
        fileMenu.add(loadItem);
        bar.add(fileMenu);
        frame.setJMenuBar(bar);
        quitItem.addActionListener(this);
        loadItem.addActionListener(this);
        saveItem.addActionListener(this);
        quitSaveItem.addActionListener(this);
        button.setBounds(200,200,200,100);
        frame.add(label);
        frame.setSize(800,600); 
        frame.add(button);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);



    }


    public void actionPerformed(ActionEvent e) {
        
        System.out.println(e);
    }

    

    
}
