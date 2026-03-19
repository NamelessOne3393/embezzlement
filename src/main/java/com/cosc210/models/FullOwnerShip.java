package com.cosc210.models;

import org.json.JSONObject;

import com.cosc210.models.exception.notEnoughMoneyException;
import com.cosc210.models.exception.notEnoughOwnershipException;
import com.cosc210.models.state.GameState;

/**
 * This class reprents the buyable object that need to bought as whole
 * It will keep track of Money Rate, Original Price, number of it owned, 
 *  and it name
 **/
public class FullOwnerShip extends GameProperties{

    //REQURES: propertiesPrice, numProperties > 0
    //MODIFIES: this
    //EFFECT: Makes MoneyProperties have it attributes 
    public FullOwnerShip(int propertiesPrice, int numProperties, String name){
        this.propertiesPrice = propertiesPrice; 
        this.numProperties = numProperties;
        this.name = name;
        moneyRate = numProperties * propertiesPrice;
    }
    //REQURES: propertiesPrice, numProperties > 0
    //MODIFIES: this
    //EFFECT: Makes MoneyProperties have it attributes 
    public FullOwnerShip(JSONObject obj){
        
        System.out.println(obj);
        this.propertiesPrice = obj.getInt("propertiesPrice"); 
        this.numProperties = obj.getInt("numProperties");
        this.name = obj.getString("name");
        moneyRate = numProperties * propertiesPrice;
    }
    //MODIFIES: this
    //EFFECT: Increase numProperties and updates moneyRate
    @Override
    public void incOwn(int num) throws notEnoughMoneyException{
        if (getMoney() < num *propertiesPrice){
            throw new notEnoughMoneyException();
        }else{
        numProperties+= num;
        moneyRate = numProperties * propertiesPrice;
        setMoney(-num*propertiesPrice);
        }
    }
    //REQURES: have enought to properties to sell 
    //MODIFIES: this
    //EFFECT: decreases numProperties by 1 and updates moneyRate
    @Override
    public void decOwn(int num) throws notEnoughOwnershipException{
        if(numProperties <= 0){
            throw new notEnoughOwnershipException("Not enough to sell");
        } else {
            setMoney(num*propertiesPrice);
            numProperties-= num;
            moneyRate = numProperties * propertiesPrice;
        }

    }
    //REQURES: have properties to sell 
    //MODIFIES: this
    //EFFECT: decreases numProperties to 0 and updates moneyRate
    @Override
    public void sellAll()throws notEnoughOwnershipException{
        if(numProperties <= 0){
            throw new notEnoughOwnershipException("none to sell");
        } else {
            setMoney(numProperties*propertiesPrice);
            numProperties = 0;
            moneyRate = 0;
        }
    }
    //EFFECT: Saves moneyRate, propertiesPrice, numProperties, and name     
    @Override
    public JSONObject ExportData(){
        JSONObject out = new JSONObject();

        out.put("name",name);
        out.put("propertiesPrice",propertiesPrice);
        out.put("numProperties",numProperties);
        out.put("type","full");

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