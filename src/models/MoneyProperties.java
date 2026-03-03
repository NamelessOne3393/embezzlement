// package src.models;

// /**
//  * This class represents the ingame share, company and etc items 
//  * that the player can buy and sell to make money based of its
//  * prize and percent ownership. It will keep track of the items
//  * Money Rate, Orignal Price, Ownership % and name
//  */

// public class MoneyProperties {
//     public double moneyRate;
//     public int propertiesPrice, propertiesOwnership, numProperties;
//     public String name;

//     //REQURES: propertiesPrice > 0
//     //MODIFIES: this
//     //EFFECT: Makes MoneyProperties have it attributes 
//     public MoneyProperties(int propertiesPrice, String name){
//         //Constructor for it attributes 
//         this.name = name;
//         propertiesOwnership = 1;
//         moneyRate = propertiesOwnership * propertiesPrice;
//         this.propertiesPrice = propertiesPrice;
//     }
//     //REQURES: propertiesPrice, numProperties > 0
//     //MODIFIES: this
//     //EFFECT: Makes MoneyProperties have it attributes 
//     public MoneyProperties(int propertiesPrice, int numProperties, String name){
//         this.propertiesPrice = propertiesPrice; 
//         this.numProperties = numProperties;
//         this.name = name;
//         moneyRate = numProperties * propertiesPrice;
//     }
//     //MODIFIES: this
//     //EFFECT: Increase propertiesOwnership by 1% and updates moneyRate
//     @Override
//     public void increaseOwnership(){
//         //Increase ownership % and money rate when Player buys it 
//         if(propertiesOwnership + 1 == 100){
//             System.out.println("Already have full ownership");
//             return;
//         } 
//         propertiesOwnership += 1;
//         moneyRate = propertiesOwnership * propertiesPrice * 0.01;
//     }
//     //MODIFIES: this
//     //EFFECT: Buys all of propertiesOwnership and updates moneyRate
//     @Override
//     public void buyAllOwnership(){
//         if(propertiesOwnership == 100){
//             System.out.println("Already have full ownership");
//             return;
//         }
//         propertiesOwnership = 100;
//         moneyRate = propertiesPrice;
//     }
//     //MODIFIES: this
//     //EFFECT: decreases propertiesOwnership by 10% and updates moneyRate
//     @Override
//     public void decreaseOwnership(){
//         //decreases ownership % and money rate when Player buys it 
//         if(propertiesOwnership == 0){
//             System.out.println("You don't have any ownership to sell");
//             return;
//         }
//         propertiesOwnership -= 1;
//         moneyRate = propertiesOwnership * propertiesPrice * 0.01;
//     }
//     //MODIFIES: this
//     //EFFECT: decreases propertiesOwnership to 0 and no moneyRate
//     @Override
//     public void sellAllOwnership(){
//         if(propertiesOwnership == 0){
//             System.out.println("You don't have any ownership to sell");
//             return;
//         }
//         propertiesOwnership = 0;
//         moneyRate = 0;
//     }
//     //MODIFIES: this
//     //EFFECT: Increase propertiesOwnership by num% and updates moneyRate
//     @Override
//     public void increaseOwnership(int num){
//         if(propertiesOwnership + num > 100){
//             propertiesOwnership = 100;
//             moneyRate = propertiesPrice;
//             System.out.println("You have bought " + (propertiesOwnership - 100) + " out of " + num + " shares");
//             return;
//         }
//         propertiesOwnership += num;
//         moneyRate = propertiesOwnership * propertiesPrice * 0.01;
//     }
//     //REQURES: have enought to ownership to sell 
//     //MODIFIES: this
//     //EFFECT: Decreases propertiesOwnership by 1% and updates moneyRate
//     @Override
//     public void decreaseOwnership(int num){
//         if(propertiesOwnership - num < 0){
//             propertiesOwnership = 0;
//             moneyRate = 0;
//             System.out.println("You have sold " + (propertiesOwnership) + " out of " + num + " shares");
//             return;
//         }
//         propertiesOwnership -= num;
//         moneyRate = propertiesOwnership * propertiesPrice * 0.01;
//     }
//     //MODIFIES: this
//     //EFFECT: Increase numProperties by 1 and updates moneyRate
//     @Override
//     public void buyProperty(){
//         numProperties++;
//         moneyRate = numProperties * propertiesPrice;
//     }
    
//     //REQURES: have enought to properties to sell 
//     //MODIFIES: this
//     //EFFECT: decreases numProperties by 1 and updates moneyRate
//     @Override
//     public void sellProperty(){
//         if(numProperties <= 0){
//             System.out.println("Don't have any " + name + " to sell");
//         } else {
//             numProperties--;
//             moneyRate = numProperties * propertiesPrice;
//         }
//     }
//     //REQURES: have properties to sell 
//     //MODIFIES: this
//     //EFFECT: decreases numProperties to 0 and updates moneyRate
//     @Override
//     public void sellAllProperties(){
//         if(numProperties <= 0){
//             System.out.println("Don't have any " + name + " to sell");
//         } else {
//             numProperties = 0;
//             moneyRate = 0;
//         }
//     }
//     //MODIFIES: this
//     //EFFECT: increase numProperties by X and updates moneyRate
//     @Override
//     public void buyXProperties(int num){
//         numProperties += num;
//         moneyRate = numProperties * propertiesPrice;
//     }
//     //REQURES: have X properties to sell 
//     //MODIFIES: this
//     //EFFECT: decreases numProperties by X and updates moneyRate
//     @Override
//     public void sellXProperties(int num){
//         if(numProperties <= 0){
//             System.out.println("Don't have any " + name + " to sell");
//         } else {
//             numProperties -= num;
//             moneyRate = numProperties * propertiesPrice;
//         }
//     }
//     public String exportData(){
//         String out = Double.toString(moneyRate)+","+Integer.toString(propertiesPrice)+","+Integer.toString(propertiesOwnership)+","+Integer.toString(numProperties)+","+name;
//         return out;
//     }

//     public void importData(String in){
//         String[] sp = in.split(",");
//         moneyRate = Double.parseDouble(sp[0]);
//         propertiesPrice = Integer.parseInt(sp[1]);
//         propertiesOwnership = Integer.parseInt(sp[2]);
//         numProperties = Integer.parseInt(sp[3]);
//         name = sp[4];
//     }
// /* 
// public double moneyRate;
//     public int propertiesPrice, propertiesOwnership, numProperties;
//     public String name;
// */
// }
