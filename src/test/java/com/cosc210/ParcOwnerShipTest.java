package com.cosc210;

import org.json.JSONObject;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

import com.cosc210.models.ParcOwnerShip;
import com.cosc210.models.exception.notEnoughExistException;
import com.cosc210.models.exception.notEnoughMoneyException;
import com.cosc210.models.exception.notEnoughOwnershipException;

public class ParcOwnerShipTest {
    private ParcOwnerShip ob,oc ;
    @Before
    public void setup(){
        ob = new ParcOwnerShip(500, "Company1", 50);
        ob.TESTMODE();
        oc = new ParcOwnerShip(500, "Company1", 50);
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
        }catch(notEnoughExistException e){fail();}
    }
    @Test
    public void incOwnXTest(){
        try{
        ob.incOwn(10);
        assertEquals(60, ob.propOwnership,0.0001);
        assertEquals(300, ob.moneyRate, 0.0001);
        ob.incOwn(40);
        }catch(Exception e){fail();}
        try{
        ob.incOwn(10);
        fail();
        }catch(notEnoughExistException e){assertTrue(true);
        }catch(notEnoughMoneyException e){fail();}
    }
    @Test
    public void buyAllTest(){
        try{
        ob.buyAll();
        assertEquals(100, ob.propOwnership,0.0001);
        assertEquals(500, ob.moneyRate, 0.0001);
        }catch(Exception e){
            fail("Should not throw an exception");
        }
        try{
        ob.buyAll();
        fail("cant buy more");
        }catch(notEnoughMoneyException e){
            fail();
        }catch(notEnoughExistException e){
            assertTrue(true);
        }
    }
    @Test
    public void failToDecOwntest(){
        try{
        ob.setMoney(-100000);
        ob.decOwn(1);
        assertEquals(49, ob.propOwnership, 0.0001);
        assertEquals(245, ob.moneyRate,0.0001);
        }catch(notEnoughOwnershipException e){
            fail("Should not throw an exception");
        }
    }
    @Test
    public void decOwnXtest(){
        try{
        ob.decOwn(5);
        assertEquals(45, ob.propOwnership, 0.0001);
        assertEquals(225, ob.moneyRate,0.0001);
        }catch(notEnoughOwnershipException e){
            fail("Should not throw an exception");
        }
        try{
        ob.decOwn(50);
            fail("Should throw an exception");
        }catch(notEnoughOwnershipException e){
            assertTrue(true);
        }
    }
    @Test
    public void decOwnAlltest(){
        try{
        ob.sellAll();
        assertEquals(0, ob.propOwnership, 0.0001);
        assertEquals(0, ob.moneyRate,0.0001);
        }catch(notEnoughOwnershipException e){
            fail("Should not throw an exception");
        }
        try{
        ob.sellAll();
            fail("Should throw an exception");
        }catch(notEnoughOwnershipException e){
            assertTrue(true);
        }
    }
    @Test
    //ping pong
    public void toAndFromJSONTest(){
        JSONObject one = ob.ExportData();
        ParcOwnerShip two = new ParcOwnerShip(one);
        
        JSONObject three = two.ExportData();
        ParcOwnerShip four = new ParcOwnerShip(three);
        assertTrue(four.equals(ob));
    }
}
