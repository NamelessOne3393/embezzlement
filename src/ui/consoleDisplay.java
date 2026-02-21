package src.ui;

import java.util.Scanner;
import src.main.GameState;
import src.models.MoneyProperties;

public class consoleDisplay {
    static Scanner in = new Scanner(System.in);
        //EFFECT: Just prints out the console main menu
    public static void printMainMenu(){
        System.out.println("----------------------------------------");
        System.out.println("    - Press 1 to see your wallet ");
        System.out.println("    - Press 2 to see your propeties ");
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
        System.out.println("        " + GameState.getPropertiesList().get(0).name + "      : " + (GameState.getPropertiesList().get(0).propertiesOwnership) + "%");
        System.out.println("----------------------------------------");
        System.out.println(" Type amount ownership wanting to buy(For 10%: type 10) ");
    }

    //EFFECT: Just prints out the console buy menu
    public static void printSellMenu(){
        System.out.println("----------------------------------------");
        System.out.println("    You can sell the following propeties:");
        System.out.println("        Company Name : Ownership ");
        System.out.println("        " + GameState.getPropertiesList().get(0).name + "      : " + (GameState.getPropertiesList().get(0).propertiesOwnership) + "%");
        System.out.println("----------------------------------------");
        System.out.println(" Type amount ownership wanting to sell(For 10%: type 10) ");
    }
    //REQUIRES: 1 <= num <= 4
    //EFFECT: Print out detail of ingame objects
    public static void menuAction(int num){
        switch (num){
            case 1 ->{System.out.println("You have " + GameState.getSchilling() + " Schilling in your wallet");}
            case 2 -> {System.out.println("You have the following properties");
                for(MoneyProperties m: GameState.getPropertiesList()){
                    System.out.println(m.name + "  : " + m.propertiesOwnership+ "%");
                }
            }   
            case 3 -> {printBuyMenu();
                buyMenuAction(inputHandler.handleInput(in.nextLine()));
            }
            case 4 -> {printSellMenu();
                sellMenuAction(inputHandler.handleInput(in.nextLine()));
            }
        }
    }

    public static void buyMenuAction(int num){
        if(GameState.getSchilling() < num * 0.01 * GameState.getPropertiesList().get(0).propertiesPrice){
            System.out.println("Not enough money to buy " + num + "%");
        } else {
            GameState.setSchilling(GameState.getSchilling() - num);
            GameState.getPropertiesList().get(0).increaseOwnership(num);
        }
    }

    public static void sellMenuAction(int num){
        if(GameState.getPropertiesList().get(0).propertiesOwnership < num){
            System.out.println("Not enough ownership to sell");
        } else {
            GameState.setSchilling(GameState.getSchilling() + num * 0.01 * GameState.getPropertiesList().get(0).propertiesPrice );
            GameState.getPropertiesList().get(0).decreaseOwnership(num);
        }
    }
}
