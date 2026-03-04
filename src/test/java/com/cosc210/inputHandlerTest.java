package com.cosc210;

import com.cosc210.ui.inputHandler;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class inputHandlerTest {
    //should not accept an imput with words if asking for a number and vis versa
    @Test
    public void rejectBadFormatedInput(){
        int input = inputHandler.handleInput("hello");
        assertEquals(-1, input);
    }
    //should accept valid number 
    @Test
    public void acceptValidNumber(){
        int input = inputHandler.handleInput("43");
        assertEquals(43, input);
    }
    @Test
    public void acceptFirstNumberIfMultple(){
        int input = inputHandler.handleInput("abc 13 def 88");
        assertEquals(13, input);
    }
    // //should not accept an imput with more or less arguments than requested 
    // public void rejectIncorrectArguments(){}
    // //depending on position, reject or accept certain arguments
    // void changeRejectionCriteraByMenu(){}
    // //changes output format depending on location
    // void navigate(){}
    // //cannot change to illegal position
    // void stayInBounds(){}
    // //can construct data into a big list and return it
    // void constructArbitraryList(){}
    // //can catch if it would return a string with errors.
    // void illegalOutputFallback(){}


    
    
}
