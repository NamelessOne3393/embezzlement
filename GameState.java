
import java.util.ArrayList;
import java.util.Scanner;

public class GameState{
    private static float Schilling;
    private static ArrayList<MoneyProperties> propertiesList, ownerList;
    public static void main(String[] args) {
        GameState.Schilling = 1;
        propertiesList = new ArrayList<>();
        ownerList = new ArrayList<>();
        System.out.println("Hello, you have " + Schilling);
        printMainMenu();
        propertiesList.add(new MoneyProperties(100, "Badcompany"));
        try (Scanner in = new Scanner(System.in)){
            int input = in.nextInt();
            switch (input){
                case 1:
                    System.out.println("You have " + Schilling + " in your wallet");
                    break;
                case 2:
                    System.out.println("You have the following properties");
                    for(MoneyProperties m: propertiesList){
                        System.out.println(m);
                    }
                    break;
                case 3:
                    printBuyMenu();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Didnt put a number from 1 to 4");
            }

        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }
    public static void printMainMenu(){
        System.out.println("----------------------------------------");
        System.out.println("    - Press 1 to see your wallet ");
        System.out.println("    - Press 2 to see your propeties ");
        System.out.println("    - Press 3 to go to buy menu ");
        System.out.println("    - Press 4 to exit ");
        System.out.println("----------------------------------------");
    }
    public static void printBuyMenu(){
        System.out.println("----------------------------------------");
        System.out.println("    You can buy the following propeties:");
        System.out.println("        Company Name : Ownership ");
        System.out.println("        " + propertiesList.get(0) + " : " + propertiesList.get(0).propertiesOwnership*100f);
    }
}