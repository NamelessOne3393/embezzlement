package com.cosc210.models;

import org.json.JSONObject;

import com.cosc210.models.exception.notEnoughMoneyException;
import com.cosc210.models.state.GameState;

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
    public void incOwn(int num) throws notEnoughMoneyException{
        if(propOwnership + num > 100){
            System.out.println("Only " + ( num + propOwnership-100) + " shares out of " + num + " exist. Buying "+(num + propOwnership-100)+" shares");
            incOwn( num + propOwnership-100);
        } else{
            if (num*propertiesPrice>getMoney()){throw new notEnoughMoneyException();}
            propOwnership += num;
            moneyRate = propOwnership * propertiesPrice * 0.01;
            setMoney(-num*propertiesPrice);
            
        }
    }
    //REQUIRE: have enough ownership to sell
    //MODIFIES: this
    //EFFECT: decreases propertiesOwnership by num% and updates moneyRate
    @Override
    public void decOwn(int num){
        if(propOwnership - num < 0){
            System.out.println("Only " + (100-propOwnership) + " shares out of " + num + " exist. Selling "+(100- propOwnership)+" shares");
            decOwn(100- propOwnership);
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

        setMoney(propOwnership*propertiesPrice);
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
    

    public Double getMoney(){

        return (TESTONLY==Integer.MIN_VALUE)?GameState.getSchilling():TESTONLY;
    }
    public void setMoney(int money){

        if (TESTONLY==Integer.MIN_VALUE){
            GameState.moneyChange(money);
        }else{
            TESTONLY+=money;
        }
    } 
    

}