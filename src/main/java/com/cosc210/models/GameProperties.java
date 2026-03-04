package com.cosc210.models;

public abstract class GameProperties implements Saveable, Loadable { 
    public double moneyRate;
    public int propertiesPrice, propOwnership,numProperties;
    public String name;
    public abstract void incOwn(int num);
    public abstract void decOwn(int num);
    public abstract void sellAll();

}