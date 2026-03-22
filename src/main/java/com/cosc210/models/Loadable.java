package com.cosc210.models;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public interface Loadable {
    public int saveGame(ArrayList<GameProperties> properties,double money,String file);
    public int loadGame(ArrayList<GameProperties> thing,String file);
    public void writeToDisk(JSONObject saveThing,String file) throws IOException;
    public JSONArray arrayToJSON(ArrayList<GameProperties> thing);
    public JSONObject getData(String file);
    public void jsonToArray(ArrayList<GameProperties> thing,JSONArray data);
    public int newGame(ArrayList<GameProperties> thing);



}

