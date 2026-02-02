
import java.util.ArrayList;
import java.util.Scanner;

public class GameState{
    private static float Schilling;
    private static ArrayList<MoneyProperties> propertiesList, ownerList;
    public static void main(String[] args) {
        Schilling = 1;
        propertiesList = new ArrayList<>();
        ownerList = new ArrayList<>();
        System.out.println("Hello, you have " + Schilling);
        printMainMenu();
        propertiesList.add(new MoneyProperties(100, "Badcompany"));
        try (Scanner in = new Scanner(System.in)){
            int input = in.nextInt();
            while(input > 4 || input < 1){ input = in.nextInt();}
            menuAction(input);

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
        System.out.println("        " + propertiesList.get(0).name + "      : " + propertiesList.get(0).propertiesOwnership*100f);
        System.out.println("----------------------------------------");
    }
    public static void menuAction(int num){
        switch (num){
            case 1 ->{System.out.println("You have " + Schilling + " in your wallet");}
            case 2 -> {System.out.println("You have the following properties");
                for(MoneyProperties m: propertiesList){
                    System.out.println(m.name + "  : " + m.propertiesOwnership);
                }
            }   
            case 3 -> {printBuyMenu();}
            case 4 -> {}
        }
    }
}