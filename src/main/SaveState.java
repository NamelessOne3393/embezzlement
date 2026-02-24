package src.main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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

        String saveData=Double.toString(money);

        for (MoneyProperties elem : properties) {
            saveData += ",{"+elem.exportData()+"}";
            
        }


        fw.write(saveData);
        fw.close();
        System.out.print("SAVE PASSED");

        }catch(IOException e){System.out.print("SAVE FAILED");}


        return 0;
    }

}
