package ch.hslu.sw10;

import java.util.EventObject;

public class TemperatureEvent extends EventObject {
    private TemperatureEventType temperatureEventType;
    private float temperatureCelsius;

    public TemperatureEvent(Object source, TemperatureEventType temperatureEventType, float temperatureCelsius) {
        super(source);
        this.temperatureEventType = temperatureEventType;
        this.temperatureCelsius = temperatureCelsius;
    }

    public TemperatureEventType getTemperatureEventType() {
        return this.temperatureEventType;
    }

    public float getTemperatureCelsius() {
        return temperatureCelsius;
    }
}
