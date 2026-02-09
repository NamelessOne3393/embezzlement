package src.models;
/**
 * This class represents the ingame share, company and etc items 
 * that the player can buy and sell to make money based of its
 * prize and percent ownership. It will keep track of the items
 * Money Rate, Orignal Price, Ownership % and name
 */

public class MoneyProperties {
    public float moneyRate, propertiesPrice, propertiesOwnership;
    public String name;

    //REQURES: propertiesPrice > 0
    //MODIFIES: this
    //EFFECT: Makes MoneyProperties have it attributes 
    public MoneyProperties(float propertiesPrice, String name){
        //Constructor for it attributes 
        this.name = name;
        propertiesOwnership = 0.1f;
        moneyRate = propertiesOwnership * propertiesPrice;
        this.propertiesPrice = propertiesPrice;
    }
    //MODIFIES: this
    //EFFECT: Increase propertiesOwnership by 10% and updates moneyRate
    public void increaseOwnership(){
        //Increase ownership % and money rate when Player buys it 
        propertiesOwnership += 0.1;
        moneyRate = propertiesOwnership * propertiesPrice;
    }
    //MODIFIES: this
    //EFFECT: Buys all of propertiesOwnership and updates moneyRate
    public void buyAllOwnership(){
        propertiesOwnership = 1;
        moneyRate = propertiesPrice;
    }
    //MODIFIES: this
    //EFFECT: decreases propertiesOwnership by 10% and updates moneyRate
    public void decreaseOwnership(){
        //decreases ownership % and money rate when Player buys it 
        propertiesOwnership -= 0.1;
        moneyRate = propertiesOwnership * propertiesPrice;
    }
    //MODIFIES: this
    //EFFECT: decreases propertiesOwnership to 0 and no moneyRate
    public void sellAllOwnership(){
        propertiesOwnership = 0;
        moneyRate = 0;
    }
}
