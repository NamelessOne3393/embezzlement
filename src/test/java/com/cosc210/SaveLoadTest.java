package com.cosc210;

import java.io.File;
import java.util.ArrayList;

import org.json.JSONArray;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import com.cosc210.models.FullOwnerShip;
import com.cosc210.models.GameProperties;
import com.cosc210.models.ParcOwnerShip;
import com.cosc210.models.state.SaveState;


public class SaveLoadTest {
    private GameProperties ob,oc ;
    private ArrayList<GameProperties> EmptyList = new ArrayList<>(),List = new ArrayList<>();
    private SaveState s = new SaveState();
    @Before
    public void setup(){
        ob = new ParcOwnerShip(500, "Company1", 50);
        oc = new FullOwnerShip(500, 10,"Company2");
        List.add(ob);
        List.add(oc);
    }

    @Test
    public void ArrayJsonPingPong(){
        JSONArray a = s.arrayToJSON(List);
        s.jsonToArray(EmptyList, a);
        JSONArray b = s.arrayToJSON(EmptyList);
        assertTrue(a.toString().equals(b.toString()));
        assertTrue(List.get(0).equals(EmptyList.get(0)));
        assertTrue(List.get(1).equals(EmptyList.get(1)));

    }
    @Test
    public void newGameTest(){
        assertEquals(s.newGame(EmptyList),100000);
        assertTrue(new ParcOwnerShip(100, "Badcompany", 1).equals(EmptyList.get(0)));
        assertTrue(new FullOwnerShip(10, 0, "BadHouse").equals(EmptyList.get(1)));


    }
    @Test
    public void saveloadWorks(){
        s.saveGame(List, 10, "file");
        s.loadGame(EmptyList, "file");
        assertTrue(List.get(0).equals(EmptyList.get(0)));
        assertTrue(List.get(1).equals(EmptyList.get(1)));
        File c = new File("file");
        c.delete();
        
    }
    @Test
    public void loadDontWorks(){
        s.loadGame(EmptyList, "");
        assertTrue(new ParcOwnerShip(100, "Badcompany", 1).equals(EmptyList.get(0)));
        assertTrue(new FullOwnerShip(10, 0, "BadHouse").equals(EmptyList.get(1)));
       }
    /* 
    @Test
    public void (){}

    Invalid load
    valid load
    succesful save

    */
}
