package com.cosc210.models.state;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import com.cosc210.models.GameProperties;
import static com.cosc210.models.state.SaveState.loadGame;
import static com.cosc210.models.state.SaveState.saveGame;
import com.cosc210.ui.MainJFrame;
import com.cosc210.ui.consoleDisplay;
import com.cosc210.ui.inputHandler;

public class GameState{
    private static double Schilling;
    private static ArrayList<GameProperties> propertiesList;
    private static SaveState s = new SaveState();
    private static String fileName = "";
    public static void main(String[] args) {
        
        MainJFrame.thing();
        Scanner in = new Scanner(System.in);
        init(in);
        while(true){
            String input = in.nextLine();
            if (consoleDisplay.menuAction(inputHandler.handleInput(input))) break;
            consoleDisplay.printMainMenu();
        }
        in.close();
        s.saveGame(propertiesList, Schilling,fileName);
    }

    public static void init(Scanner in){
        Schilling = 0; propertiesList = new ArrayList<>(); fileName = "";
        while(fileName == ""){

            System.out.println("Enter your save file name");
            String input = in.nextLine();
            if (new File("data/"+input+".json").exists()){
                fileName = input;
            } else{
                System.out.println("Invalid save, make a new file?(y/n)");
                String input2 = in.nextLine();
                if (input2 == "y")loadGame(propertiesList, fileName);
                    fileName = input;
            }
        }
        Schilling = s.loadGame(propertiesList,fileName);
        consoleDisplay.printMainMenu();
        
        System.out.println("Hello, you have " + Schilling);
        while(true){
            String input = in.nextLine();
            if (consoleDisplay.menuAction(inputHandler.handleInput(input))) break;
            consoleDisplay.printMainMenu();
        }
        saveGame(propertiesList, Schilling,fileName);
        MainJFrame mainMenu = new MainJFrame();
    }

    public static ArrayList<GameProperties> getPropertiesList() {
        return propertiesList;
    }

    public static double getSchilling() {
        return Schilling;
    }
    public static void setSchilling(double schilling){
        Schilling = schilling;
    }

    public static void moneyChange(double money){
        Schilling += money;
    }
    //i am aware only one of these is needed, but i like readability

    
}