
import java.util.Scanner;

public class GameState{
    private static float Schilling;
    public static void main(String[] args) {
        GameState.Schilling = 1;
        System.out.println("Hello, you have " + GameState.Schilling);
        try (Scanner in = new Scanner(System.in)){
            String inputLine = in.nextLine();
            if(inputLine.isEmpty()){GameState.Schilling += 1;}
            System.out.println("You have " + GameState.Schilling);
        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }
}