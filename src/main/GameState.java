package src.main;

import java.util.ArrayList;
import java.util.Scanner;
import src.models.MoneyProperties;
import src.ui.consoleDisplay;

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
        
        try (Scanner in = new Scanner(System.in)){
            int input = in.nextInt();
            while(input > 4 || input < 1){ input = in.nextInt();}
            consoleDisplay.menuAction(input);
        } catch (Exception e) {
            e.printStackTrace(); 
        }
        
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