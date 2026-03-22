package com.cosc210.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.cosc210.models.state.GameState;
import com.cosc210.models.state.SaveState;


public class MainJFrame extends JFrame implements ActionListener {
    JFileChooser load;
    JButton walletBtn, propertiesBtn, buyBtn, sellBtn,saveBtn, loadBtn, exitBtn;
    JTextArea output;
    SaveState saveSystem;
    public MainJFrame(){
        setTitle("Emezzlement(Main menu)");
        setSize(800, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        output = new JTextArea();
        output.setEditable(false);
        add(new JScrollPane(output), BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 7));
        walletBtn = new JButton("Wallet");
        propertiesBtn = new JButton("Properties");
        buyBtn = new JButton("Buy Menu");
        sellBtn = new JButton("Sell Menu");
        saveBtn = new JButton("Save");
        loadBtn = new JButton("Load");
        exitBtn = new JButton("Exit");

        panel.add(walletBtn);
        panel.add(propertiesBtn);
        panel.add(buyBtn);
        panel.add(sellBtn);
        panel.add(saveBtn);
        panel.add(loadBtn);
        panel.add(exitBtn);
        
        add(panel, BorderLayout.SOUTH);
        
        walletBtn.addActionListener(this);
        propertiesBtn.addActionListener(this); 
        buyBtn.addActionListener(this);
        sellBtn.addActionListener(this); 
        saveBtn.addActionListener(this);
        loadBtn.addActionListener(this);
        exitBtn.addActionListener(this);

        setVisible(true);
        saveSystem = new SaveState();
    }
    
    public void actionPerformed(ActionEvent e) {
        
        Object sourse = e.getSource();
        if(sourse == walletBtn){
            output.append("You have " + GameState.getSchilling()+ " Schillings \n");
        }else if( sourse == propertiesBtn){
            if(GameState.getPropertiesList() == null){
                output.append("Need to load/new save file\n");
            } else{
                output.append("Properties\n");
                output.append("1       " + GameState.getPropertiesList().get(0).name + "      : " 
                + (GameState.getPropertiesList().get(0).propOwnership) + "%\n");
                output.append("2        " + GameState.getPropertiesList().get(1).name + "      : " 
                + (GameState.getPropertiesList().get(1).numProperties) + "\n");
            }
        } else if(sourse == buyBtn){
            if(GameState.getPropertiesList() == null){
                output.append("Need to load/new save file\n");
            } else {
                new BuyJFrame(); //will pop out to the buy menu frame
            }
        } else if(sourse == sellBtn){
            if(GameState.getPropertiesList() == null){
                output.append("Need to load/new save file\n");
            } else {
                new SellJFrame(); //will pop out to the sell menu frame 
            }
        }else if (sourse == saveBtn){
            String saveFile = JOptionPane.showInputDialog(this, "Enter save file name: ");
            if(saveFile != null && !saveFile.isEmpty()){
                saveSystem.saveGame(GameState.getPropertiesList(), GameState.getSchilling(), 
                saveFile);
            }
            output.append("Game is saved as " + saveFile + ".json\n");
        }else if (sourse == loadBtn){
            load = new JFileChooser();
            load.setCurrentDirectory(new File("data"));
            load.setFileFilter(new FileNameExtensionFilter("JSON files","json"));

            int result = load.showOpenDialog(this);
            
            if(result == JFileChooser.APPROVE_OPTION){
                File selectedFile = load.getSelectedFile();
                String loadFile = selectedFile.getName().replace(".json", "");
                if(GameState.getPropertiesList() == null){
                    GameState.setPropertiesList(new ArrayList<>());
                }else{
                    GameState.getPropertiesList().clear();
                }
                int money = saveSystem.loadGame(GameState.getPropertiesList(), loadFile);
                GameState.setSchilling(money);

                output.append("Loaded file: " + loadFile +"\n");
                output.append("Money: " + money + "\n" );
            }
        }else if(sourse == exitBtn){
            
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
