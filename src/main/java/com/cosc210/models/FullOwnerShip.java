package com.cosc210.models;

import org.json.JSONObject;

import com.cosc210.models.exception.notEnoughMoneyException;
import com.cosc210.models.exception.notEnoughOwnershipException;

/**
 * This class reprents the buyable object that need to bought as whole
 * It will keep track of Money Rate, Original Price, number of it owned,
 * and it name
 **/
public class FullOwnerShip extends GameProperties {

    // REQURES: propertiesPrice, numProperties > 0
    // MODIFIES: this
    // EFFECT: Makes FullOwnerShip have it attributes
    public FullOwnerShip(int propertiesPrice, int numProperties, String name) {
        this.propertiesPrice = propertiesPrice;
        this.numProperties = numProperties;
        this.name = name;
        moneyRate = numProperties * propertiesPrice;
    }

    // REQURES: propertiesPrice, numProperties > 0
    // MODIFIES: this
    // EFFECT: Makes FullOwnerShip have it attributes
    public FullOwnerShip(JSONObject obj) {

        System.out.println(obj);
        this.propertiesPrice = obj.getInt("propertiesPrice");
        this.numProperties = obj.getInt("numProperties");
        this.name = obj.getString("name");
        moneyRate = numProperties * propertiesPrice;
    }

    // MODIFIES: this
    // EFFECT: Increase numProperties and updates moneyRate and money
    @Override
    public void incOwn(int num) throws notEnoughMoneyException {
        if (getMoney() < num * propertiesPrice) {
            EventLog.getInstance().logEvent(new Event("Failed to bought "+num+" of "+name));
            throw new notEnoughMoneyException();
        } else {
            numProperties += num;
            moneyRate = numProperties * propertiesPrice;
            setMoney(-num * propertiesPrice);
            EventLog.getInstance().logEvent(new Event("Bought "+num+" of "+name));
        }
    }

    // REQURES: have enought to properties to sell
    // MODIFIES: this
    // EFFECT: decreases numProperties by 1 and updates moneyRate and money
    @Override
    public void decOwn(int num) throws notEnoughOwnershipException {
        if (numProperties - num < 0) {
            EventLog.getInstance().logEvent(new Event("Failed to sold "+num+" of "+name));
            throw new notEnoughOwnershipException("Not enough to sell");
        } else {
            setMoney(num * propertiesPrice);
            numProperties -= num;
            moneyRate = numProperties * propertiesPrice;

            EventLog.getInstance().logEvent(new Event("Sold "+num+" of "+name));
        }

    }

    // REQURES: have properties to sell
    // MODIFIES: this
    // EFFECT: decreases numProperties to 0 and updates moneyRate and money
    @Override
    public void sellAll() throws notEnoughOwnershipException {
        decOwn(numProperties);
    }

    // EFFECT: Saves moneyRate, propertiesPrice, numProperties, and name
    @Override
    public JSONObject ExportData() {
        JSONObject out = new JSONObject();

        out.put("name", name);
        out.put("propertiesPrice", propertiesPrice);
        out.put("numProperties", numProperties);
        out.put("type", "full");

        return out;
    }
}