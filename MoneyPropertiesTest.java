import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MoneyPropertiesTest{
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
}