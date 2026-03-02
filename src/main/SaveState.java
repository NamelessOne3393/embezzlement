package src.main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import src.models.MoneyProperties;




public class SaveState {
    

    static public int saveGame(ArrayList<MoneyProperties> properties,double money){
//public double moneyRate;
  //  public int propertiesPrice, propertiesOwnership, numProperties;
    //public String name;

        try {
            File dir = new File("data");
            dir.mkdir();
            File save = new File("data/save.txt");
            save.createNewFile();
            
            
        FileWriter fw = new FileWriter(save);
        JSONObject saveThing = new JSONObject();
        saveThing.put("money",money);
        JSONArray companies = new JSONArray();

        for (MoneyProperties elem : properties) {
            JSONObject temp = new JSONObject();
            temp.put("name",elem.name);
            temp.put("moneyRate",elem.moneyRate);
            temp.put("numProperties",elem.numProperties);
            temp.put("propertiesOwnership",elem.propertiesOwnership);
            temp.put("propertiesPrice",elem.propertiesPrice);
            companies.put(temp);
             

            
        }

        saveThing.put("companies",companies);
        fw.write(saveThing.toString());
        fw.close();
        System.out.print("SAVE PASSED");

        }catch(IOException e){System.out.print("SAVE FAILED");}


        return 0;
    }
    static public JSONObject loadGame(){


        try {
            
            File save = new File("data/save.txt");

            Scanner scan = new Scanner(save);
            return new JSONObject(scan.next());
            
        } catch (IOException e) {}


        return null;
    }
}
