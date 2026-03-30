package com.cosc210.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.cosc210.models.exception.notEnoughOwnershipException;
import com.cosc210.models.state.GameState;

// This frame is the sell menu that pop up and handles selling 
public class SellJFrame extends JFrame implements ActionListener {
    JButton sellCustomBtn;
    JComboBox<String> propertySelect;
    JTextArea output;
    JTextField amountField;
    public SellJFrame(){
        setTitle("Emezzlement(Sell menu)");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLayout(new BorderLayout());
        
        JPanel topPanel = new JPanel(new GridLayout(2, 2));
        topPanel.add(new JLabel("Select Propertity"));
        String[] propNames = {GameState.getPropertiesList().get(0).name, 
            GameState.getPropertiesList().get(1).name};
        propertySelect = new JComboBox<>(propNames);

        topPanel.add(propertySelect);
        topPanel.add(new JLabel("Ammount:"));
        amountField = new JTextField();
        topPanel.add(amountField);

        add(topPanel, BorderLayout.NORTH);
        output = new JTextArea();
        output.setEditable(false);
        add(new JScrollPane(output), BorderLayout.CENTER);

        sellCustomBtn = new JButton("Sell");
        sellCustomBtn.addActionListener(this);
        add(sellCustomBtn, BorderLayout.SOUTH);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        int idx = propertySelect.getSelectedIndex();
        try {
            int amount = Integer.parseInt(amountField.getText());
            GameState.getPropertiesList().get(idx).decOwn(amount);
            output.append("You have sold " + amount + " \n");
        } catch (NumberFormatException er) {
            output.append("Invalid number\n");
        } catch(notEnoughOwnershipException er){
            output.append("Not enough ownership\n");
        } 
    }
}
