package com.cosc210.models;

import com.cosc210.models.exception.notEnoughOwnershipException;

public abstract class GameProperties implements Saveable, Loadable { 
    public double moneyRate;
    public int propertiesPrice, propOwnership,numProperties;
    public String name;
    public abstract void incOwn(int num);
    public abstract void decOwn(int num)throws notEnoughOwnershipException;
    public abstract void sellAll()throws notEnoughOwnershipException;

}