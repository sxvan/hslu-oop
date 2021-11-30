package ch.hslu.sw08;

import java.util.*;

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
        if (this.temperatures.isEmpty()) {
            return 0;
        }

        return Collections.max(this.temperatures).getCelsius();
    }

    public float getMaxKelvin() {
        if (this.temperatures.isEmpty()) {
            return 0;
        }

        return Collections.max(this.temperatures).getKelvin();
    }

    public float getMinCelsius() {
        if (this.temperatures.isEmpty()) {
            return 0;
        }

        return Collections.min(this.temperatures).getCelsius();
    }

    public float getMinKelvin() {
        if (this.temperatures.isEmpty()) {
            return 0;
        }

        return Collections.min(this.temperatures).getKelvin();
    }

    public float getAverageCelsius() {
        if (this.temperatures.isEmpty()) {
            return 0;
        }

        return (float)this.temperatures.stream().mapToDouble(x -> x.getCelsius()).average().getAsDouble();
    }

    public float getAverageKelvin() {
        if (this.temperatures.isEmpty()) {
            return 0;
        }

        return (float)this.temperatures.stream().mapToDouble(x -> x.getKelvin()).average().getAsDouble();
    }
}
