import java.util.ArrayList;

public class Temperature
{
    private float temperatureCelcius;
    private Element[] elements;


    public Temperature(float temperatureCelsius)
    {
        this();
        this.temperatureCelcius = temperatureCelsius;
    }
    
    public Temperature()
    {
        this.elements = new Element[] {
            new Nitrogen(),
            new Mercury(),
            new Lead()
        };
    }
    

    public float getTemperatureCelcius()
    {
        return this.temperatureCelcius;
        
    }
    
    public void setTemperatureCelcius(float temperatureCelcius)
    {
        this.temperatureCelcius = temperatureCelcius;
        
    }
    
    public  float getTemperatureKelvin()
    {
        return this.temperatureCelcius + (float)273.15;
        
    }
    
    public  float getTemperatureFahrenheit()
    {
        return this.temperatureCelcius * (float)1.8 + 32;
        
    }
    
    public void updateTemperatureCelcius(float temperatureCelcius)
    {
        this.temperatureCelcius += temperatureCelcius;
    }
    
    public void updateTemperatureKelvin(float temperatureKelvin)
    {
        this.temperatureCelcius += temperatureKelvin - (float)273.15;
    }
    
    public String getStateOfAggregation(String elementName) 
    {
       for (int i = 0; i < elements.length; i++) {
           Element element = elements[i];
           if (element.getName() == elementName) {
               return element.getStateOfAggregation(this.getTemperatureCelcius());
           }
       }
        
       return "Element not found";
    }
}