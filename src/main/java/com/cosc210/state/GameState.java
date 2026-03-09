package com.cosc210.state;

import java.util.ArrayList;
import java.util.Scanner;

import com.cosc210.models.FullOwnerShip;
import com.cosc210.models.GameProperties;
import com.cosc210.models.ParcOwnerShip;
import com.cosc210.ui.FrameMaker;
import com.cosc210.ui.consoleDisplay;
import com.cosc210.ui.inputHandler;

public class GameState{
    private static double Schilling;
    private static ArrayList<GameProperties> propertiesList;
    public static void main(String[] args) {
        Schilling = 100; propertiesList = new ArrayList<>();
        System.out.println("Hello, you have " + Schilling);
        consoleDisplay.printMainMenu();
        propertiesList.add(new ParcOwnerShip(100, "Badcompany", 1));
        propertiesList.add(new FullOwnerShip(10, 0, "BadHouse"));
        Scanner in = new Scanner(System.in);
        FrameMaker mainMenu = new FrameMaker();
        mainMenu.createMainFrame();
        while(true){
            String input = in.nextLine();
            if (consoleDisplay.menuAction(inputHandler.handleInput(input))) break;
            consoleDisplay.printMainMenu();

        }
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
}