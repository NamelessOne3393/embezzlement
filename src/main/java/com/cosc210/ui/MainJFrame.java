package com.cosc210.ui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class MainJFrame
// extends JFrame implements ActionListener 
{




    // the main menu has the current balance, rate of income, and a horizontally scrolling menu of all things money is being invested into.
    // File has all the things related to saving and loading
    public static void thing(){
        JFrame frame = new JFrame("My First JFrame");
        JLabel label = new JLabel("AAAAAAAAAAAAAAAA");
        JButton button = new JButton("HI");
        JMenuBar bar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem quitItem = new JMenuItem("Quit Without Saving");
        JMenuItem quitSaveItem = new JMenuItem("Quit and Save");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem loadItem = new JMenuItem("Load");
        fileMenu.add(quitItem);
        fileMenu.add(quitSaveItem);
        fileMenu.add(saveItem);
        fileMenu.add(loadItem);
        bar.add(fileMenu);
        frame.setJMenuBar(bar);
        button.setBounds(200,200,200,100);
        frame.add(label);
        frame.setSize(800,600); 
        frame.add(button);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


    }
    /* private final int X_SIZE = 1000, Y_SIZE = 700;
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
    } */

    
}
