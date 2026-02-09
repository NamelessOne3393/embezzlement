package src.main;

import java.util.ArrayList;
import java.util.Scanner;
import src.models.MoneyProperties;
import src.ui.consoleDisplay;
import src.ui.inputHandler;

public class GameState{
    private static float Schilling;
    private static ArrayList<MoneyProperties> propertiesList, ownerList;
    public static void main(String[] args) {
        Schilling = 1;
        propertiesList = new ArrayList<>();
        ownerList = new ArrayList<>();
        System.out.println("Hello, you have " + Schilling);
        consoleDisplay.printMainMenu();
        propertiesList.add(new MoneyProperties(100, "Badcompany"));
        Scanner in = new Scanner(System.in);
        while(true){
            String input = in.nextLine();
            inputHandler.handleInput(input);
        }
        //in.close();
    }

    public static ArrayList<MoneyProperties> getOwnerList() {
        return ownerList;
    }

    public static ArrayList<MoneyProperties> getPropertiesList() {
        return propertiesList;
    }

    public static float getSchilling() {
        return Schilling;
    }
}