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

import com.cosc210.models.exception.notEnoughExistException;
import com.cosc210.models.exception.notEnoughMoneyException;
import com.cosc210.models.state.GameState;

public class BuyJFrame extends JFrame implements ActionListener{
    JButton buyCustomBtn;
    JComboBox<String> propertySelect;
    JTextArea output;
    JTextField amountField;
    public BuyJFrame() {
        setTitle("Emezzlement(Buy menu)");
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

        buyCustomBtn = new JButton("Buy");
        buyCustomBtn.addActionListener(this);
        add(buyCustomBtn, BorderLayout.SOUTH);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        int idx = propertySelect.getSelectedIndex();
        try {
            int amount = Integer.parseInt(amountField.getText());
            GameState.getPropertiesList().get(idx).incOwn(amount);
            output.append("You have bought " + amount + " \n");
        } catch (NumberFormatException er) {
            output.append("Invalid number\n");
        } catch(notEnoughMoneyException er){
            output.append("Not enough money\n");
        } catch(notEnoughExistException er){
            output.append("Too many shares\n");
        }
    }
    
}
