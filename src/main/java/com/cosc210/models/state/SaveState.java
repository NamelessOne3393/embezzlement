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




public class SaveState implements Loadable{
    
    @Override
    public int saveGame(ArrayList<GameProperties> properties,double money,String file){

        try {
            File dir = new File("data");
            dir.mkdir();
            File save = new File("data/"+file+".json");
            save.createNewFile();
            
            
        FileWriter fw = new FileWriter(save);
        JSONObject saveThing = new JSONObject();
        saveThing.put("money",money);
        JSONArray companies = new JSONArray();

        for (GameProperties elem : properties) {
            JSONObject temp = elem.ExportData();
            companies.put(temp);
        }

        saveThing.put("companies",companies);
        fw.write(saveThing.toString());
        fw.close();
        System.out.print("SAVE PASSED");

        }catch(IOException e){System.out.print("SAVE FAILED");}


        return 0;
    }

    @Override
    public int loadGame(ArrayList<GameProperties> thing,String file){
        try {
            File save = new File("data/"+file+".json");

            Scanner scan = new Scanner(save);
            JSONObject rawdata = new JSONObject(scan.next());
            System.out.println(rawdata);
            JSONArray data = rawdata.getJSONArray("companies");
            
            for (int i = 0; i < data.length();i++){
                System.out.println(data.getJSONObject(i).getString("type"));
                thing.add("full".equals(data.getJSONObject(i).getString("type"))?new FullOwnerShip(data.getJSONObject(i)):new ParcOwnerShip(data.getJSONObject(i)));
            }
            
            return rawdata.getInt("money");
            
        } catch (IOException e) {

        thing.add(new ParcOwnerShip(100, "Badcompany", 1));
        thing.add(new FullOwnerShip(10, 0, "BadHouse"));
        }
        return 100000;
    }
}

