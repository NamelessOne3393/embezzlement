package src.ui;

import src.main.GameState;
import src.models.MoneyProperties;

public class consoleDisplay {
        //EFFECT: Just prints out the console main menu
    public static void printMainMenu(){
        System.out.println("----------------------------------------");
        System.out.println("    - Press 1 to see your wallet ");
        System.out.println("    - Press 2 to see your propeties ");
        System.out.println("    - Press 3 to go to buy menu ");
        System.out.println("    - Press 4 to go to sell menu ");
        System.out.println("----------------------------------------");
    }
    //EFFECT: Just prints out the console buy menu
    public static void printBuyMenu(){
        System.out.println("----------------------------------------");
        System.out.println("    You can buy the following propeties:");
        System.out.println("        Company Name : Ownership ");
        System.out.println("        " + GameState.getPropertiesList().get(0).name + "      : " + (GameState.getPropertiesList().get(0).propertiesOwnership * 100) + "%");
        System.out.println("----------------------------------------");
    }

    //EFFECT: Just prints out the console buy menu
    public static void sellMenu(){
        System.out.println("----------------------------------------");
        System.out.println("    You can sell the following propeties:");
        System.out.println("        Company Name : Ownership ");
        System.out.println("        " + GameState.getPropertiesList().get(0).name + "      : " + (GameState.getPropertiesList().get(0).propertiesOwnership * 100) + "%");
        System.out.println("----------------------------------------");
    }
    //REQUIRES: 1 <= num <= 4
    //EFFECT: Print out detail of ingame objects
    public static void menuAction(int num){
        switch (num){
            case 1 ->{System.out.println("You have " + GameState.getSchilling() + " Schilling in your wallet");}
            case 2 -> {System.out.println("You have the following properties");
                for(MoneyProperties m: GameState.getPropertiesList()){
                    System.out.println(m.name + "  : " + m.propertiesOwnership * 100 + "%");
                }
            }   
            case 3 -> {printBuyMenu();}
            case 4 -> {sellMenu();}
        }
    }
}
