package ch.hslu.sw10;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class TemperatureCourse {
    private Collection<Temperature> temperatures;
    private Collection<TemperatureEventListener> listeners;

    public TemperatureCourse() {
        this.temperatures = new ArrayList<>();
        this.listeners = new ArrayList<>();
    }

    public void add(Temperature temperature) {
        float temperatureCelsius = temperature.getCelsius();
        if (temperatureCelsius > this.getMaxCelsius()) {
            this.fireTemperatureEvent(new TemperatureEvent(this, TemperatureEventType.MAX, temperatureCelsius));
        }

        if (temperatureCelsius < this.getMinCelsius()) {
            this.fireTemperatureEvent(new TemperatureEvent(this, TemperatureEventType.MIN, temperatureCelsius));
        }

        this.temperatures.add(temperature);
    }

    public void clear() {
        this.temperatures.clear();
    }

    public long getCount() {
        return this.temperatures.stream().count();
    }

    public float getMaxCelsius() {
        if (this.temperatures.isEmpty()) {
            return Integer.MIN_VALUE;
        }

        return Collections.max(this.temperatures).getCelsius();
    }

    public float getMaxKelvin() {
        return Collections.max(this.temperatures).getKelvin();
    }

    public float getMinCelsius() {
        if (this.temperatures.isEmpty()) {
            return Integer.MAX_VALUE;
        }

        return Collections.min(this.temperatures).getCelsius();
    }

    public float getMinKelvin() {
        return Collections.min(this.temperatures).getKelvin();
    }

    public float getAverageCelsius() {
        return (float)this.temperatures.stream().mapToDouble(x -> x.getCelsius()).average().getAsDouble();
    }

    public float getAverageKelvin() {
        return (float)this.temperatures.stream().mapToDouble(x -> x.getKelvin()).average().getAsDouble();
    }

    public void addTemperatureEventListener(TemperatureEventListener listener) {
        this.listeners.add(listener);
    }

    private void fireTemperatureEvent(TemperatureEvent event) {
        for (TemperatureEventListener listener : this.listeners) {
            listener.handleTemperatureEvent(event);
        }
    }
}
