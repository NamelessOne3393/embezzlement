package src.ui;
/**
 * This class handles user input
 * It is a static class that only exists once, and is 
 * a resource by other classes
 * 
 * 
 * 
 * Menus will be stored as lists of keywords and formats, which will then be assembled in the display
 * 
*/



public class inputHandler {


    static int pointer = 0;//start on the default menu. this both determines what is rendered as well as what commands do

    public static void handleInput(String input){

        String[] result = input.split("\s");
        int thing = -1;
        for (String thingamajig : result) {
            try{
                thing = Integer.parseInt(thingamajig);
                break;
            } catch(NumberFormatException e){}   
        }
        consoleDisplay.menuAction(thing);

    }


    
}
