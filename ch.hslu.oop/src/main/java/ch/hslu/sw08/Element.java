package ch.hslu.sw08;

public abstract class Element {
    private String name;
    private float temperatureCelsiusLiquid;
    private float temperatureCelsiusGaseous;
    
    protected Element(String name, float temperatureCelsiusLiquid, float temperatureCelsiusGaseous) {
        this.name = name;
        this.temperatureCelsiusLiquid = temperatureCelsiusLiquid;
        this.temperatureCelsiusGaseous = temperatureCelsiusGaseous;
    }
    
    public String getName() {
        return this.name;
    }
    
    public StateOfAggregation getStateOfAggregation(float temperatureCelsius) {
        if  (temperatureCelsius < this.temperatureCelsiusLiquid) {
            return StateOfAggregation.SOLID;
        }
        
        if (temperatureCelsius < this.temperatureCelsiusGaseous) {
            return StateOfAggregation.LIQUID;
        }
        
        return StateOfAggregation.GAS;
    }
}