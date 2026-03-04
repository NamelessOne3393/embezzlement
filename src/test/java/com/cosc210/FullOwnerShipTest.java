package com.cosc210;

import com.cosc210.models.FullOwnerShip;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class FullOwnerShipTest {
    private FullOwnerShip ob ;
    @Before
    public void setup(){
        ob = new FullOwnerShip(500, 10,"Company1");
    }
    @Test
    public void incOwnOneTest(){
        ob.incOwn(1);
        assertEquals(11,ob.numProperties, 0.0001 );
        assertEquals(5500, ob.moneyRate, 0.0001);
    }
    @Test
    public void incOwnXTest(){
        ob.incOwn(10);
        assertEquals(20, ob.numProperties,0.0001);
        assertEquals(10000, ob.moneyRate, 0.0001);
    }
    @Test
    public void decOwnOnetest(){
        ob.decOwn(1);
        assertEquals(9, ob.numProperties, 0.0001);
        assertEquals(4500, ob.moneyRate,0.0001);
    }
    @Test
    public void decOwnXtest(){
        ob.decOwn(5);
        assertEquals(5, ob.numProperties, 0.0001);
        assertEquals(2500, ob.moneyRate,0.0001);
    }
    @Test
    public void decOwnAlltest(){
        ob.decOwn(10);
        assertEquals(0, ob.numProperties, 0.0001);
        assertEquals(0, ob.moneyRate,0.0001);
    }
}