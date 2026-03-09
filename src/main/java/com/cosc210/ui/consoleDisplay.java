package com.cosc210.ui;

import java.util.Scanner;

import com.cosc210.state.GameState;

public class consoleDisplay {
    static Scanner in = new Scanner(System.in);
    //EFFECT: Just prints out the console main menu
    public static void printMainMenu(){
        System.out.println("----------------------------------------");
        System.out.println("    - Press 1 to see your wallet ");
        System.out.println("    - Press 2 to see propeties ");
        System.out.println("    - Press 3 to go to buy menu ");
        System.out.println("    - Press 4 to go to sell menu ");
        System.out.println("    - Press 5 to exit");
        System.out.println("----------------------------------------");
    }
    //EFFECT: Just prints out the console buy menu
    public static void printBuyMenu(){
        System.out.println("----------------------------------------");
        System.out.println("    You can buy the following propeties:");
        System.out.println("        Company Name : Ownership ");
        System.out.println("1        " + GameState.getPropertiesList().get(0).name + "      : " + (GameState.getPropertiesList().get(0).propOwnership) + "%");
        System.out.println("2        " + GameState.getPropertiesList().get(1).name + "      : " + (GameState.getPropertiesList().get(1).numProperties));
        System.out.println("----------------------------------------");
        System.out.println(" First type 1 or 2 for the properties");
        System.out.println(" Type amount ownership wanting to buy(For 10%: type 10 or 1 of full number of properties) ");
    }

    //EFFECT: Just prints out the console buy menu
    public static void printSellMenu(){
        System.out.println("----------------------------------------");
        System.out.println("    You can sell the following propeties:");
        System.out.println("        Company Name : Ownership ");
        System.out.println("1       " + GameState.getPropertiesList().get(0).name + "      : " + (GameState.getPropertiesList().get(0).propOwnership) + "%");
        System.out.println("2        " + GameState.getPropertiesList().get(1).name + "      : " + (GameState.getPropertiesList().get(1).numProperties));
        System.out.println("----------------------------------------");
        System.out.println(" First type 1 or 2 for the properties");
        System.out.println(" Then Type amount ownership wanting to sell(For 10%: type 10 or 1 of full number of properties) ");
    }
    //REQUIRES: 1 <= num <= 4
    //EFFECT: Print out detail of ingame objects
    public static boolean menuAction(int num){
        boolean run = false; 
        switch (num){
            case 1 ->{System.out.println("You have " + GameState.getSchilling() + " Schilling in your wallet");}
            case 2 -> {System.out.println("There are the following properties");
                    System.out.println("1       " + GameState.getPropertiesList().get(0).name + "      : " + (GameState.getPropertiesList().get(0).propOwnership) + "%");
                    System.out.println("2        " + GameState.getPropertiesList().get(1).name + "      : " + (GameState.getPropertiesList().get(1).numProperties));
            }   
            case 3 -> {printBuyMenu();
                buyMenuAction(inputHandler.handleInput(in.nextLine()));
            }
            case 4 -> {printSellMenu();
                sellMenuAction(inputHandler.handleInput(in.nextLine()));
            }
            case 5 ->{run=true;}
        }
        return run;
    }
    //EFFECT: changes between parOwnership, fullOwnership 
    public static void buyMenuAction(int num){
        switch(num){
            case 1 -> {buyParAction(inputHandler.handleInput(in.nextLine()));}
            case 2 -> {buyWholeAction(inputHandler.handleInput(in.nextLine()));}
        }
    }
    //REQUIRES: num <= number of ownership available
    //EFFECT: Increases the ownership by the amount num
    public static void buyParAction(int num){
        if(GameState.getSchilling() < num * 0.01 * GameState.getPropertiesList().get(0).propertiesPrice){
            System.out.println("Not enough money to buy " + num + "%");
        } else {
            GameState.setSchilling(GameState.getSchilling() - num);
            GameState.getPropertiesList().get(0).incOwn(num);
        }
    }
    //REQUIRES: num <= number of ownership available
    //EFFECT: Increases the num of properties by the amount num
    public static void buyWholeAction(int num){
        if(GameState.getSchilling() < num * GameState.getPropertiesList().get(1).propertiesPrice){
            System.out.println("Not enough money to buy " + num);
        } else {
            GameState.setSchilling(GameState.getSchilling() - num * GameState.getPropertiesList().get(1).propertiesPrice );
            GameState.getPropertiesList().get(1).incOwn(num);
        }
    }
    //EFFECT: changes between parOwnership, fullOwnership 
    public static void sellMenuAction(int num){
        switch(num){
            case 1 -> {sellParAction(inputHandler.handleInput(in.nextLine()));}
            case 2 -> {sellWholeAction(inputHandler.handleInput(in.nextLine()));}
        }
    }
    //REQUIRES: num <= number of ownership owned
    //EFFECT: decreases the ownership by the amount num
    public static void sellParAction(int num){
        if(GameState.getPropertiesList().get(0).propOwnership < num){
            System.out.println("Not enough ownership to sell");
        } else {
            GameState.setSchilling(GameState.getSchilling() + num * GameState.getPropertiesList().get(0).propertiesPrice/100.0 );
            GameState.getPropertiesList().get(0).decOwn(num);
        }
    }
    //EFFECT: decreases the num of properties 
    public static void sellWholeAction(int num){
        if(GameState.getPropertiesList().get(1).propertiesPrice * num > GameState.getSchilling()){
            System.out.println("Not enough money to sell " + num);
        } else {
            GameState.setSchilling(GameState.getSchilling() + num * GameState.getPropertiesList().get(1).propertiesPrice );
            GameState.getPropertiesList().get(1).decOwn(num);
        }
    }
}
