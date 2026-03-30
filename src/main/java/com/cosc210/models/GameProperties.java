package com.cosc210.models;

import com.cosc210.models.exception.notEnoughExistException;
import com.cosc210.models.exception.notEnoughMoneyException;
import com.cosc210.models.exception.notEnoughOwnershipException;
import com.cosc210.models.state.GameState;

/* 
    This is the abstract class that makes to the basic of the Full and parc ownership class
*/
public abstract class GameProperties implements Exportable { 
    public double moneyRate;
    public int propertiesPrice, propOwnership,numProperties;
    public String name;
    public int TESTONLY=Integer.MIN_VALUE;
    public abstract void incOwn(int num) throws notEnoughMoneyException, notEnoughExistException;
    public abstract void decOwn(int num)throws notEnoughOwnershipException;
    public abstract void sellAll()throws notEnoughOwnershipException;
    public void TESTMODE(){TESTONLY = 100000;}
    public boolean equals(GameProperties thing){
        return this.ExportData().toString().equals(thing.ExportData().toString());
    }
    public Double getMoney(){

        return (this.TESTONLY==Integer.MIN_VALUE)?GameState.getSchilling():this.TESTONLY;
    }
    public void setMoney(int money){

        if (this.TESTONLY==Integer.MIN_VALUE){
            GameState.moneyChange(money);
        }else{
            this.TESTONLY+=money;
        }
    } 

}