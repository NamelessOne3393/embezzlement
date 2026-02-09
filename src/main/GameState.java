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
        Scanner in = new Scanner(System.in);
        while(true){
            String input = in.nextLine();
            System.out.println(input);
            String[] result = input.split("\s");
            System.out.println(result);
            int thing = -1;
            for (String thingamajig : result) {
                System.out.println(thingamajig);
                try{
                    thing = Integer.parseInt(thingamajig);
                    break;
                } catch(NumberFormatException e){}
                
            }


            consoleDisplay.menuAction(thing);

                
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