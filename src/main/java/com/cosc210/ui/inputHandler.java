package com.cosc210.ui;

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


    public static int handleInput(String input){

        String[] result = input.split("\\s+");
        int thing = -1;
        for (String thingamajig : result) {
            try{
                thing = Integer.parseInt(thingamajig);
                break;
            } catch(NumberFormatException e){}
        }
        return thing;
    }

    
}
