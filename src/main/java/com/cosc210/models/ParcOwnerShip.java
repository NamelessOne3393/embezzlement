package com.cosc210.models;

import org.json.JSONObject;

/**
 * This class reprents buyable object that need to be need
 * to be bought in increments 
 * */
public class ParcOwnerShip extends GameProperties{  
    //REQURES: propertiesPrice > 0
    //MODIFIES: this
    //EFFECT: Makes ParcOwnerProperties have it attributes 
    public ParcOwnerShip(int propertiesPrice, String name, int propOwnership){
        //Constructor for it attributes 
        this.name = name;
        this.propOwnership = propOwnership;
        this.propertiesPrice = propertiesPrice;
        moneyRate = propOwnership * propertiesPrice;
    }
    public ParcOwnerShip(JSONObject obj){
        

        this.propertiesPrice = obj.getInt("propertiesPrice"); 
        this.propOwnership = obj.getInt("propOwnership");
        this.name = obj.getString("name");
        moneyRate = propOwnership * propertiesPrice;
    }
    //MODIFIES: this
    //EFFECT: Increase propertiesOwnership by num% and updates moneyRate
    @Override
    public void incOwn(int num){
        if(propOwnership + num > 100){
            propOwnership = 100;
            moneyRate = propertiesPrice;
            System.out.println("You have bought " + (propOwnership - 100) + " out of " + num + " shares");
            return;
        }
        propOwnership += num;
        moneyRate = propOwnership * propertiesPrice * 0.01;
    }
    //REQUIRE: have enough ownership to sell
    //MODIFIES: this
    //EFFECT: decreases propertiesOwnership by num% and updates moneyRate
    @Override
    public void decOwn(int num){
        if(propOwnership - num < 0){
            propOwnership = 0;
            moneyRate = 0;
            System.out.println("You have sold " + (propOwnership) + " out of " + num + " shares");
            return;
        }
        propOwnership -= num;
        moneyRate = propOwnership * propertiesPrice/100;
    }
    //MODIFIES: this
    //EFFECT: Buys all of propertiesOwnership and updates moneyRate
    public void buyAll(){
        if(propOwnership == 100){
            System.out.println("Already have full ownership");
            return;
        }
        propOwnership = 100;
        moneyRate = propertiesPrice;
    }
    //MODIFIES: this
    //EFFECT: decreases propertiesOwnership to 0 and no moneyRate
    @Override
    public void sellAll(){
        if(propOwnership == 0){
            System.out.println("You don't have any ownership to sell");
            return;
        }
        propOwnership = 0;
        moneyRate = 0;
    }
    //EFFECT: Saves moneyRate, propertiesPrice, propOwnership, and name     
    @Override
    public JSONObject ExportData(){
        JSONObject out = new JSONObject();

        out.put("name",name);
        out.put("propertiesPrice",propertiesPrice);
        out.put("propOwnership",propOwnership);
        out.put("type","parc");

        return out;
    }
    //EFFECT: Saves moneyRate, propertiesPrice, propOwnership, and name automatically    
    

}