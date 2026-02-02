class MoneyProperties {
    public float moneyRate, propertiesPrice, propertiesOwnership;
    public String name;
    public MoneyProperties(float propertiesPrice, String name){
        this.name = name;
        propertiesOwnership = 0.1f;
        moneyRate = propertiesOwnership * propertiesPrice;
        this.propertiesPrice = propertiesPrice;
    }
    public void increaseOwnership(){
        propertiesOwnership += 0.1;
        moneyRate = propertiesOwnership * propertiesPrice;
    }
}
