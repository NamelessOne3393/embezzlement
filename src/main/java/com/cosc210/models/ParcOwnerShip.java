package com.cosc210.models;

import org.json.JSONObject;

import com.cosc210.models.exception.notEnoughExistException;
import com.cosc210.models.exception.notEnoughMoneyException;
import com.cosc210.models.exception.notEnoughOwnershipException;

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
    //EFFECT: Increase propertiesOwnership by num% and updates moneyRate and money
    @Override
    public void incOwn(int num) throws notEnoughMoneyException,notEnoughExistException{
        if(propOwnership + num > 100){
            throw new notEnoughExistException("Only " + ( num + propOwnership-100) + " shares out of " + num + " exist.");
        } else{
            if (num*propertiesPrice>this.getMoney()){throw new notEnoughMoneyException();}
            propOwnership += num;
            moneyRate = propOwnership * propertiesPrice * 0.01;
            this.setMoney(-num*propertiesPrice);
            
        }
    }
    //REQUIRE: have enough ownership to sell
    //MODIFIES: this
    //EFFECT: decreases propertiesOwnership by num% and updates moneyRate and money
    @Override
    public void decOwn(int num) throws notEnoughOwnershipException{
        if(propOwnership - num < 0){
            throw new notEnoughOwnershipException("Only " + (100-propOwnership) + " shares out of " + num + " exist.");
        }
        propOwnership -= num;
        moneyRate = propOwnership * propertiesPrice/100;
        setMoney(num*propertiesPrice);
    }
    //MODIFIES: this
    //EFFECT: Buys all of propertiesOwnership and updates moneyRate and money
    public void buyAll()throws notEnoughMoneyException, notEnoughExistException{
        if(propOwnership == 100){
            throw new notEnoughExistException("Already have full ownership");
            
        }
        incOwn(100-propOwnership);
    }
    //MODIFIES: this
    //EFFECT: decreases propertiesOwnership to 0 and no moneyRate
    @Override
    public void sellAll() throws notEnoughOwnershipException{
        if(propOwnership == 0){
            throw new notEnoughOwnershipException("You don't have any ownership to sell");
        }
        decOwn(propOwnership);
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
    

    
    

}