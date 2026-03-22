package com.cosc210;

import org.json.JSONObject;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

import com.cosc210.models.FullOwnerShip;
import com.cosc210.models.exception.notEnoughMoneyException;
import com.cosc210.models.exception.notEnoughOwnershipException;

public class FullOwnerShipTest {
    private FullOwnerShip ob, oc;
    @Before
    public void setup(){
        ob = new FullOwnerShip(500, 10,"Company1");
        oc = new FullOwnerShip(500, 10,"Company1");
        ob.TESTMODE();
        oc.TESTMODE();
    }
    @Test
    public void brokeTest(){
        try{
        ob.setMoney(-100000);
        oc.setMoney(-100000);
        ob.incOwn(1);
        fail("exception not thrown");
        }catch(notEnoughMoneyException e){
            assertTrue(ob.equals(oc));

        }
    }
    @Test
    public void incOwnXTest(){
        try{
        ob.incOwn(10);
        assertEquals(20, ob.numProperties,0.0001);
        assertEquals(10000, ob.moneyRate, 0.0001);
        assertTrue(!ob.equals(oc));
        }catch(notEnoughMoneyException e){
            fail("Should not throw an exception");
        }
    }
    @Test
    public void decOwnOnetest(){
        try{
            ob.decOwn(1);
            assertEquals(9, ob.numProperties, 0.0001);
            assertEquals(4500, ob.moneyRate,0.0001);
        assertTrue(!ob.equals(oc));
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
        assertTrue(!ob.equals(oc));
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
            assertTrue(!ob.equals(oc));
        } catch(notEnoughOwnershipException e){
            fail("Should not throw and exception");
        }
    }

    @Test
    public void notEnoughOwnershipTest(){
        try {
            ob.sellAll();
            oc.sellAll();
            ob.decOwn(1);
            fail("Should have thrown a notEnoughOwnershipException");
        } catch (notEnoughOwnershipException e) {
            //Expected
            assertTrue(ob.equals(oc));
            
        }
    }
    @Test
    //ping pong
    public void toAndFromJSONTest(){
        JSONObject one = ob.ExportData();
        FullOwnerShip two = new FullOwnerShip(one);
        
        JSONObject three = two.ExportData();
        FullOwnerShip four = new FullOwnerShip(three);
        assertTrue(four.equals(ob));
    }
}