package src.main;

import java.util.ArrayList;
import java.util.Scanner;
import src.models.MoneyProperties;
import src.ui.consoleDisplay;
import src.ui.inputHandler;

public class GameState{
    private static double Schilling;
    private static ArrayList<MoneyProperties> propertiesList;
    public static void main(String[] args) {
        Schilling = 100; propertiesList = new ArrayList<>();
        System.out.println("Hello, you have " + Schilling);
        consoleDisplay.printMainMenu();
        propertiesList.add(new MoneyProperties(100, "Badcompany"));
        Scanner in = new Scanner(System.in);
        while(true){
            String input = in.nextLine();
            if (consoleDisplay.menuAction(inputHandler.handleInput(input)))break;
            consoleDisplay.printMainMenu();

        }
        SaveState.saveGame(propertiesList,Schilling);
    }

    public static ArrayList<MoneyProperties> getPropertiesList() {
        return propertiesList;
    }

    public static double getSchilling() {
        return Schilling;
    }
    public static void setSchilling(double schilling){
        Schilling = schilling;
    }
}