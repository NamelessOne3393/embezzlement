package src.models;

/**
 * This class represents the ingame share, company and etc items 
 * that the player can buy and sell to make money based of its
 * prize and percent ownership. It will keep track of the items
 * Money Rate, Orignal Price, Ownership % and name
 */

public class MoneyProperties implements fullOwnership, fractionOwnership{
    public double moneyRate;
    public int propertiesPrice, propertiesOwnership, numProperties;
    public String name;

    //REQURES: propertiesPrice > 0
    //MODIFIES: this
    //EFFECT: Makes MoneyProperties have it attributes 
    public MoneyProperties(int propertiesPrice, String name){
        //Constructor for it attributes 
        this.name = name;
        propertiesOwnership = 1;
        moneyRate = propertiesOwnership * propertiesPrice;
        this.propertiesPrice = propertiesPrice;
    }
    public MoneyProperties(int propertiesPrice, int numProperties, String name){
        this.propertiesPrice = propertiesPrice;
        this.numProperties = numProperties;
        this.name = name;
        moneyRate = numProperties * propertiesPrice;
    }
    //MODIFIES: this
    //EFFECT: Increase propertiesOwnership by 10% and updates moneyRate
    @Override
    public void increaseOwnership(){
        //Increase ownership % and money rate when Player buys it 
        if(propertiesOwnership + 1 == 100){
            System.out.println("Already have full ownership");
            return;
        } 
        propertiesOwnership += 1;
        moneyRate = propertiesOwnership * propertiesPrice * 0.01;
    }
    //MODIFIES: this
    //EFFECT: Buys all of propertiesOwnership and updates moneyRate
    @Override
    public void buyAllOwnership(){
        if(propertiesOwnership == 100){
            System.out.println("Already have full ownership");
            return;
        }
        propertiesOwnership = 100;
        moneyRate = propertiesPrice;
    }
    //MODIFIES: this
    //EFFECT: decreases propertiesOwnership by 10% and updates moneyRate
    @Override
    public void decreaseOwnership(){
        //decreases ownership % and money rate when Player buys it 
        if(propertiesOwnership == 0){
            System.out.println("You don't have any ownership to sell");
            return;
        }
        propertiesOwnership -= 1;
        moneyRate = propertiesOwnership * propertiesPrice * 0.01;
    }
    //MODIFIES: this
    //EFFECT: decreases propertiesOwnership to 0 and no moneyRate
    @Override
    public void sellAllOwnership(){
        if(propertiesOwnership == 0){
            System.out.println("You don't have any ownership to sell");
            return;
        }
        propertiesOwnership = 0;
        moneyRate = 0;
    }
    @Override
    public void increaseOwnership(int num){
        if(propertiesOwnership + num > 100){
            propertiesOwnership = 100;
            moneyRate = propertiesPrice;
            System.out.println("You have bought " + (propertiesOwnership - 100) + " out of " + num + " shares");
            return;
        }
        propertiesOwnership += num;
        moneyRate = propertiesOwnership * propertiesPrice * 0.01;
    }
    @Override
    public void decreaseOwnership(int num){
        if(propertiesOwnership - num < 0){
            propertiesOwnership = 0;
            moneyRate = 0;
            System.out.println("You have sold " + (propertiesOwnership) + " out of " + num + " shares");
            return;
        }
        propertiesOwnership -= num;
        moneyRate = propertiesOwnership * propertiesPrice * 0.01;
    }
    @Override
    public void fullProperties(){

    }
    @Override
    public void buyProperty(){

    }
    @Override
    public void sellProperty(){

    }
    @Override
    public void sellAllProperties(){

    }
    @Override
    public void buyXProperties(int num){

    }
    @Override
    public void sellXProperties(int num){
        
    }
}
