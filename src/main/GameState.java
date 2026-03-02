package src.main;

import java.util.ArrayList;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import src.models.MoneyProperties;
import src.ui.consoleDisplay;
import src.ui.inputHandler;

public class GameState{
    private static double Schilling;
    private static ArrayList<MoneyProperties> propertiesList;
    public static void main(String[] args) {
        JSONObject load = SaveState.loadGame();
        if (load == null){Schilling = 100; propertiesList = new ArrayList<>();
        propertiesList.add(new MoneyProperties(100, "Badcompany"));}
        else{
            Schilling = load.getDouble("money");
            propertiesList = new ArrayList<>();
            JSONArray b = load.getJSONArray("companies");
            for (int i = 0; i < b.length(); i++){
                JSONObject a = b.getJSONObject(i);
                propertiesList.add(new MoneyProperties(a.getInt("propertiesPrice"), a.getString("name"),a.getInt("propertiesOwnership")));
            }


        }
        System.out.println("Hello, you have " + Schilling);
        consoleDisplay.printMainMenu();
        Scanner in = new Scanner(System.in);
        while(true){
            String input = in.nextLine();
            if (consoleDisplay.menuAction(inputHandler.handleInput(input)))break;
            consoleDisplay.printMainMenu();

        }
        in.close();
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