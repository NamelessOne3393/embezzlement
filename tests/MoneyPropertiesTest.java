package tests;
import org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;

import src.models.MoneyProperties;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class MoneyPropertiesTest{
    /*
    @Test
    public void MoneyProperties_Attributes_Test(){
        float price = 1000f;String name = "Company1";
        MoneyProperties mp = new MoneyProperties(price, name);
        assertEquals(name,mp.name);
        assertEquals(0.1f,mp.propertiesOwnership, 0.0001);
        assertEquals(price,mp.propertiesPrice, 0.0001);
        assertEquals(100f,mp.moneyRate, 0.0001);
    }
    @Test
    public void increaseOwnership_call_Test(){
        float price = 500f;
        MoneyProperties mp = new MoneyProperties(price, "Company2");
        //Testing First call
        mp.increaseOwnership();
        assertEquals(0.2f,mp.propertiesOwnership,0.0001);
        assertEquals(100f, mp.moneyRate, 0.0001);
        //Testing Second Call
        mp.increaseOwnership();
        assertEquals(0.3f,mp.propertiesOwnership,0.0001);
        assertEquals(150f, mp.moneyRate, 0.0001);
    }
    @Test
    public void sellTest(){
        float price = 500f;
        MoneyProperties mp = new MoneyProperties(price, "Company2");
        //Testing First call
        mp.increaseOwnership();
        assertEquals(0.2f,mp.propertiesOwnership,0.0001);
        assertEquals(100f, mp.moneyRate, 0.0001);
        //Testing Second Call
        mp.decreaseOwnership();
        assertEquals(0.1f,mp.propertiesOwnership,0.0001);
        assertEquals(50f, mp.moneyRate, 0.0001);
    }
    */
    
    /*tests to write
    buy 1, buy X, buy all
    sell 1, sell X, sell all
        buy/sell 1,all call x
        1 is default.
    
    refresh list
        called after buying a new company
    generate company, validate companies
    
    
    */
    private MoneyProperties mp = new MoneyProperties(500f, "Company1");
    @Test
    public void buy1Test(){
        mp.increaseOwnership();
        assertEquals(0.2f, mp.propertiesOwnership,0.0001);
        assertEquals(100f, mp.moneyRate, 0.0001);
    }
    @Test
    public void buyXTest(){
        int x = 8;
        for(int i = 0; i < x; i++){
            mp.increaseOwnership();
        }
        assertEquals(0.1f*9, mp.propertiesOwnership,0.0001);
        assertEquals(450f, mp.moneyRate, 0.0001);
    }
    @Test
    public void buyAllTest(){
        mp.buyAllOwnership();
        assertEquals(1, mp.propertiesOwnership,0.0001);
        assertEquals(500f, mp.moneyRate, 0.0001);
    }
    @Before
    public void init(){
        for(int i = 0; i < 9; i++){mp.increaseOwnership();}
    }
    @Test
    public void sell1Test(){
        mp.decreaseOwnership();
        assertEquals(0.9f,mp.propertiesOwnership,0.0001);
        assertEquals(450f, mp.moneyRate, 0.0001);
    }
    @Test
    public void sellXTest(){
        int x = 8;
        for(int i = 0; i < 8; i++){mp.decreaseOwnership();}
        assertEquals(0.2f,mp.propertiesOwnership,0.0001);
        assertEquals(100f, mp.moneyRate, 0.0001);
    }
    @Test
    public void sellAllTest(){
        mp.sellAllOwnership();
        assertEquals(0f,mp.propertiesOwnership,0.0001);
        assertEquals(0f, mp.moneyRate, 0.0001);
    }
    @Test
    public void companyGenerateTest(){}
    @Test
    public void partialCompanyGenerationTest(){}
    @Test
    public void companyAvoidDuplicantTest(){}
    @Test
    public void refreshCompaniesTest(){}





}