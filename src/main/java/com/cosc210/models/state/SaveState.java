package com.cosc210.models.state;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import com.cosc210.models.FullOwnerShip;
import com.cosc210.models.GameProperties;
import com.cosc210.models.Loadable;
import com.cosc210.models.ParcOwnerShip;;


/*
    This class is incharge of saving and loading 
*/

public class SaveState implements Loadable{
    
    @Override
    public int saveGame(ArrayList<GameProperties> properties,double money,String file){
        JSONObject saveThing = new JSONObject();
        saveThing.put("money",money);
        saveThing.put("companies",arrayToJSON(properties));
        try {
            writeToDisk(saveThing, file);
            System.out.print("SAVE PASSED");
        }catch(IOException e){System.out.print("SAVE FAILED");}
        return 0;
    }

    @Override
    public void writeToDisk(JSONObject saveThing,String file) throws IOException{
            File save = new File("data/"+file+".json");
            save.createNewFile();
        try (FileWriter fw = new FileWriter(save)) {
            fw.write(saveThing.toString());
        }
    }

    @Override
    public JSONArray arrayToJSON(ArrayList<GameProperties> thing){
        JSONArray companies = new JSONArray();
        for (GameProperties elem : thing) {
            JSONObject temp = elem.ExportData();
            companies.put(temp);
        }
        return companies;

    }



    @Override
    public int loadGame(ArrayList<GameProperties> thing,String file){
        JSONObject rawData = getData(file);
        if (rawData != null){    
            JSONArray data = rawData.getJSONArray("companies");
            jsonToArray(thing, data);
            return rawData.getInt("money");
        }else{
        return newGame(thing);
        }

    }
         

    @Override
    public JSONObject getData(String file){
        JSONObject rawData;
        try {
            File save = new File("data/"+file+".json");

            try (Scanner scan = new Scanner(save)) {
                rawData = new JSONObject(scan.next());
            }
            return rawData;
        } catch (IOException e) {
            return null;
        }

    }

    @Override
    public void jsonToArray(ArrayList<GameProperties> thing,JSONArray data){
        for (int i = 0; i < data.length();i++){
            thing.add("full".equals(data.getJSONObject(i).getString("type"))?new FullOwnerShip(data.getJSONObject(i)):new ParcOwnerShip(data.getJSONObject(i)));
        }
    }
    @Override
    public int newGame(ArrayList<GameProperties> thing){
        
        thing.add(new ParcOwnerShip(100, "Badcompany", 1));
        thing.add(new FullOwnerShip(10, 0, "BadHouse"));

        return 100000;

    }
}

