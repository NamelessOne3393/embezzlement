package com.cosc210;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

import com.cosc210.models.FullOwnerShip;
import com.cosc210.models.GameProperties;
import com.cosc210.models.state.GameState;
import com.cosc210.models.state.SaveState;

public class GameStateTest {


    @Test
    public void bigTestCauseImLazy(){
        GameState a = new GameState();
        SaveState s = new SaveState();
        a.init();

        a.setSchilling(s.newGame(a.getPropertiesList()));
        a.moneyChange(100);
        assertTrue(100100 == a.getSchilling());
        a.setPropertiesList(new ArrayList<GameProperties>());
        a.getPropertiesList().add(new FullOwnerShip(500, 10,"Company2"));
        assertTrue(a.getPropertiesList().get(0).equals(new FullOwnerShip(500, 10,"Company2")));

    }
    
}
