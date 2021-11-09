package ch.hslu.sw08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class TemperatureCourse {
    private Collection<Temperature> temperatures;

    public TemperatureCourse() {
        this.temperatures = new ArrayList<>();
    }

    public void add(Temperature temperature) {
        this.temperatures.add(temperature);
    }

    public void clear() {
        this.temperatures.clear();
    }

    public long getCount() {
        return this.temperatures.stream().count();
    }

    public float getMaxCelsius() {
        return Collections.max(this.temperatures).getCelsius();
    }

    public float getMaxKelvin() {
        return Collections.max(this.temperatures).getKelvin();
    }

    public float getMinCelsius() {
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
}
