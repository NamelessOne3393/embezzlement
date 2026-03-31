package com.cosc210.models.state;

import java.util.ArrayList;

import com.cosc210.models.Event;
import com.cosc210.models.EventLog;
import com.cosc210.models.GameProperties;
import com.cosc210.ui.MainJFrame;

public class GameState{
    private static double Schilling;
    private static ArrayList<GameProperties> propertiesList;
    private static SaveState s = new SaveState();
    private static String fileName = "";
    public static void main(String[] args) {
        // Scanner in = new Scanner(System.in);
        // init(in);
        // while(true){
        //     String input = in.nextLine();
        //     if (consoleDisplay.menuAction(inputHandler.handleInput(input))) break;
        //     consoleDisplay.printMainMenu();
        // }
        // in.close();
        initilize();
        new MainJFrame();
    }
/* 
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
                if (input2 == "y")s.loadGame(propertiesList, fileName);
                    fileName = input;
            }
        }
        Schilling = s.loadGame(propertiesList,fileName);
        consoleDisplay.printMainMenu();
        System.out.println("Hello, you have " + Schilling);
    }
*/
    public void init(){
        Schilling = 0; propertiesList = new ArrayList<>(); fileName = "";
    }
    public static void initilize(){
        Schilling = 0; propertiesList = new ArrayList<>(); fileName = "";
    }

    public static ArrayList<GameProperties> getPropertiesList() {
        return propertiesList;
    }
    public static void setPropertiesList(ArrayList<GameProperties> newPropertiesList){
        propertiesList = newPropertiesList;
    }
    public static double getSchilling() {
        return Schilling;
    }
    public static void setSchilling(double schilling){
        Schilling = schilling;
    }

    public static void moneyChange(double money){
        double i = Schilling;
        Schilling += money;
        EventLog.getInstance().logEvent(new Event("Money set to "+Schilling+" from "+i));

    }
    //i am aware only one of these is needed, but i like readability

    
}