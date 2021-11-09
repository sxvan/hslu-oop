package ch.hslu.sw08;

import java.util.Objects;

public final class Temperature implements Comparable<Temperature>
{
    private static final float KELVIN_OFFSET = 273.15f;
    private float kelvin;

    public Temperature(float celsius)
    {
        this.kelvin = convertCelsiusToKelvin(celsius);
    }

    public Temperature(Temperature temperature) {
        this(temperature.getCelsius());
    }

    public void setKelvin(float kelvin) {
        this.kelvin = kelvin;
    }

    public void setCelsius(float celsius) {
        this.kelvin = convertCelsiusToKelvin(celsius);
    }
    
    public float getKelvin()
    {
        return this.kelvin;
    }

    public float getCelsius()
    {
        return convertKelvinToCelsius(this.kelvin);
    }

    public static final float convertKelvinToCelsius(float kelvin) {
        return kelvin - KELVIN_OFFSET;
    }

    public static final float convertCelsiusToKelvin(float celsius) {
        return celsius + KELVIN_OFFSET;
    }

    @Override
    public int compareTo(Temperature temperature) {
        return Float.compare(this.kelvin, temperature.kelvin);
    }

    @Override
    public String toString() {
        return "Temperature{" +
                "kelvin=" + kelvin +
                '}';
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Temperature)) {
            return false;
        }

        Temperature that = (Temperature) obj;
        return this.compareTo(that) == 0;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(kelvin);
    }
}