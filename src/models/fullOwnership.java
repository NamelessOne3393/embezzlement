package src.models;

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
    //MODIFIES: this
    //EFFECT: Increase numProperties by 1 and updates moneyRate
    @Override
    public void incOwn(int num){
        numProperties+= num;
        moneyRate = numProperties * propertiesPrice;
    }
    //REQURES: have enought to properties to sell 
    //MODIFIES: this
    //EFFECT: decreases numProperties by 1 and updates moneyRate
    @Override
    public void decOwn(int num){
        if(numProperties <= 0){
            System.out.println("Don't have any " + name + " to sell");
        } else {
            numProperties-= num;
            moneyRate = numProperties * propertiesPrice;
        }
    }
    //REQURES: have properties to sell 
    //MODIFIES: this
    //EFFECT: decreases numProperties to 0 and updates moneyRate
    @Override
    public void sellAll(){
        if(numProperties <= 0){
            System.out.println("Don't have any " + name + " to sell");
        } else {
            numProperties = 0;
            moneyRate = 0;
        }
    }
    //EFFECT: Saves moneyRate, propertiesPrice, numProperties, and name     
    @Override
    public void autoExportData(){

    }
    //EFFECT: Saves moneyRate, propertiesPrice, numProperties, and name automatically    
    @Override
    public void selectExportDate(){
    //EFFECT: Loads moneyRate, propertiesPrice, numProperties, and name      
    }
    @Override    
    public void autoImportData(String in){

    }
    //EFFECT: Loads moneyRate, propertiesPrice, numProperties, and name      
    @Override    
    public void selectImportDate(String in){

    }

}