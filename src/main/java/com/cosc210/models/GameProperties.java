package com.cosc210.models;

import com.cosc210.models.exception.notEnoughMoneyException;
import com.cosc210.models.exception.notEnoughOwnershipException;

public abstract class GameProperties implements Exportable { 
    public double moneyRate;
    public int propertiesPrice, propOwnership,numProperties;
    public String name;
    public int TESTONLY=Integer.MIN_VALUE;
    public abstract void incOwn(int num) throws notEnoughMoneyException;
    public abstract void decOwn(int num)throws notEnoughOwnershipException;
    public abstract void sellAll()throws notEnoughOwnershipException;
    public void TESTMODE(){TESTONLY = 100000;}

}