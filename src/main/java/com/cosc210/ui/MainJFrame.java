package com.cosc210.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.cosc210.models.state.GameState;


public class MainJFrame extends JFrame implements ActionListener {
    
    JButton walletBtn, propertiesBtn, buyBtn, sellBtn, exitBtn;
    JTextArea output;
    public MainJFrame(){
        setTitle("Emezzlement(Main menu)");
        setSize(800, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        output = new JTextArea();
        output.setEditable(false);
        add(new JScrollPane(output), BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 5));
        walletBtn = new JButton("See Wallet");
        propertiesBtn = new JButton("See properties");
        buyBtn = new JButton("Buy Menu");
        sellBtn = new JButton("Sell Menu");
        exitBtn = new JButton("Exit");

        panel.add(walletBtn);
        panel.add(propertiesBtn);
        panel.add(buyBtn);
        panel.add(sellBtn);
        panel.add(exitBtn);
        
        add(panel, BorderLayout.SOUTH);
        
        walletBtn.addActionListener(this);
        propertiesBtn.addActionListener(this); 
        buyBtn.addActionListener(this);
        sellBtn.addActionListener(this); 
        exitBtn.addActionListener(this);

        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        
        Object sourse = e.getSource();
        if(sourse == walletBtn){
            output.append("You have " + GameState.getSchilling()+ " Schillings \n");
        }else if( sourse == propertiesBtn){
            output.append("Properties\n");
            output.append("1       " + GameState.getPropertiesList().get(0).name + "      : " 
            + (GameState.getPropertiesList().get(0).propOwnership) + "%\n");
            output.append("2        " + GameState.getPropertiesList().get(1).name + "      : " 
            + (GameState.getPropertiesList().get(1).numProperties) + "\n");
        } else if(sourse == buyBtn){
            new BuyJFrame(); //will pop out to the buy menu frame
        } else if(sourse == sellBtn){
            // new SellJFrame(); will pop out to the sell menu frame 
        } else if(sourse == exitBtn){
            System.exit(0);
        }
    }

    // the main menu has the current balance, rate of income, and a horizontally scrolling menu of all things money is being invested into.
    // File has all the things related to saving and loading
    // public void thing(){
    //     JFrame frame = new JFrame("My First JFrame");
    //     JLabel label = new JLabel("AAAAAAAAAAAAAAAA");
    //     JButton button = new JButton("HI");
    //     JMenuBar bar = new JMenuBar();
    //     JMenu fileMenu = new JMenu("File");
    //     JMenuItem quitItem = new JMenuItem("Quit Without Saving");
    //     quitItem.setActionCommand("Q");
    //     JMenuItem quitSaveItem = new JMenuItem("Quit and Save");
    //     quitSaveItem.setActionCommand("SQ");
    //     JMenuItem saveItem = new JMenuItem("Save");
    //     saveItem.setActionCommand("S");
    //     JMenuItem loadItem = new JMenuItem("Load");
    //     loadItem.setActionCommand("L");
    //     fileMenu.add(quitItem);
    //     fileMenu.add(quitSaveItem);
    //     fileMenu.add(saveItem);
    //     fileMenu.add(loadItem);
    //     bar.add(fileMenu);
    //     frame.setJMenuBar(bar);
    //     quitItem.addActionListener(this);
    //     loadItem.addActionListener(this);
    //     saveItem.addActionListener(this);
    //     quitSaveItem.addActionListener(this);
    //     button.setBounds(200,200,200,100);
    //     frame.add(label);
    //     frame.setSize(800,600); 
    //     frame.add(button);
    //     frame.setLayout(null);
    //     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //     frame.setVisible(true);



    // }


    
}
