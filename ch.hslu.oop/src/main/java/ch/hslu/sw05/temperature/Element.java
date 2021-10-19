package ch.hslu.sw05.temperature;

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
    
    public String getStateOfAggregation(float temperatureCelsius) {
        if  (temperatureCelsius < this.temperatureCelsiusLiquid) {
            return "fixed";
        }
        
        if (temperatureCelsius < this.temperatureCelsiusGaseous) {
            return "liquid";
        }
        
        return "gaseous";
    }
}