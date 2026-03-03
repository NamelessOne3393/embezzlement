package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import src.models.ParcOwnerShip;

public class ParcOwnerShipTest {
    private ParcOwnerShip ob ;
    @Before
    public void setup(){
        ob = new ParcOwnerShip(500, "Company1", 50);
    }
    @Test
    public void incOwnOneTest(){
        ob.incOwn(1);
        assertEquals(51,ob.propOwnership, 0.0001 );
        assertEquals(255, ob.moneyRate, 0.0001);
    }
    @Test
    public void incOwnXTest(){
        ob.incOwn(10);
        assertEquals(60, ob.propOwnership,0.0001);
        assertEquals(300, ob.moneyRate, 0.0001);
    }
    @Test
    public void buyAllTest(){
        ob.buyAll();
        assertEquals(100, ob.propOwnership,0.0001);
        assertEquals(500, ob.moneyRate, 0.0001);
    }
    @Test
    public void decOwnOnetest(){
        ob.decOwn(1);
        assertEquals(49, ob.propOwnership, 0.0001);
        assertEquals(245, ob.moneyRate,0.0001);
    }
    @Test
    public void decOwnXtest(){
        ob.decOwn(5);
        assertEquals(45, ob.propOwnership, 0.0001);
        assertEquals(225, ob.moneyRate,0.0001);
    }
    @Test
    public void decOwnAlltest(){
        ob.sellAll();
        assertEquals(0, ob.propOwnership, 0.0001);
        assertEquals(0, ob.moneyRate,0.0001);
    }
}
