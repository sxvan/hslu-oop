package ch.hslu.sw10;

import java.util.EventObject;

public class TemperatureEvent extends EventObject {
    private TemperatureEventType temperatureEventType;

    public TemperatureEvent(Object source, TemperatureEventType temperatureEventType) {
        super(source);
        this.temperatureEventType = temperatureEventType;
    }

    public TemperatureEventType getTemperatureEventType() {
        return this.temperatureEventType;
    }
}
