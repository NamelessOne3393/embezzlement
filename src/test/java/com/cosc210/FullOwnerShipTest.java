package com.cosc210;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

import com.cosc210.models.FullOwnerShip;
import com.cosc210.models.exception.notEnoughMoneyException;
import com.cosc210.models.exception.notEnoughOwnershipException;

public class FullOwnerShipTest {
    private FullOwnerShip ob ;
    @Before
    public void setup(){
        ob = new FullOwnerShip(500, 10,"Company1");
        ob.TESTMODE();
        
    }
    @Test
    public void incOwnOneTest(){
        try{
        ob.incOwn(1);
        assertEquals(11,ob.numProperties, 0.0001 );
        assertEquals(5500, ob.moneyRate, 0.0001);
        }catch(notEnoughMoneyException e){}
    }
    @Test
    public void incOwnXTest(){
        try{
        ob.incOwn(10);
        assertEquals(20, ob.numProperties,0.0001);
        assertEquals(10000, ob.moneyRate, 0.0001);
        }catch(notEnoughMoneyException e){}
    }
    @Test
    public void decOwnOnetest(){
        try{
            ob.decOwn(1);
            assertEquals(9, ob.numProperties, 0.0001);
            assertEquals(4500, ob.moneyRate,0.0001);
        }catch(notEnoughOwnershipException e){
            fail("Should not throw an exception");
        }
    }
    @Test
    public void decOwnXtest(){
        try{
            ob.decOwn(5);
            assertEquals(5, ob.numProperties, 0.0001);
            assertEquals(2500, ob.moneyRate,0.0001);
        }catch(notEnoughOwnershipException e){
            fail("Should not throw an exception");
        }
    }
    @Test
    public void decOwnAlltest(){
        try{
            ob.decOwn(10);
            assertEquals(0, ob.numProperties, 0.0001);
            assertEquals(0, ob.moneyRate,0.0001);
        } catch(notEnoughOwnershipException e){
            fail("Should not throw and exception");
        }
    }
    @Test
    public void notEnoughOwnershipTest(){
        try {
            ob.sellAll();
            ob.decOwn(1);
            fail("Should have thrown a notEnoughOwnershipException");
        } catch (notEnoughOwnershipException e) {
            //Expected
        }
    }
}