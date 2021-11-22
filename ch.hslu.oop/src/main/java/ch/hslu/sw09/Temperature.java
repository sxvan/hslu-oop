package ch.hslu.sw09;

import java.util.Objects;

public final class Temperature implements Comparable<Temperature>
{
    private static final float KELVIN_OFFSET = 273.15f;
    private static final int MIN_KELVIN = 0;
    private static final float MIN_CELSIUS = MIN_KELVIN - KELVIN_OFFSET;
    private final float kelvin;

    public static Temperature createFromCelsius(float celsius) throws IllegalArgumentException {
        return new Temperature(celsius, TemperatureUnit.CELSIUS);
    }

    public static Temperature createFromKelvin(float kelvin) throws IllegalArgumentException {
        return new Temperature(kelvin, TemperatureUnit.KELVIN);
    }

    public static Temperature createFromTemperature(Temperature temperature) throws IllegalArgumentException {
        return new Temperature(temperature);
    }

    private Temperature(float temperature, TemperatureUnit temperatureUnit) throws IllegalArgumentException
    {
        if (temperatureUnit == TemperatureUnit.KELVIN) {
            if (temperature < MIN_KELVIN) {
                throw new IllegalArgumentException(
                        String.format("Temperature cannot be less than %s kelvin.", MIN_KELVIN));
            }
            this.kelvin = temperature;
        } else if (temperatureUnit == TemperatureUnit.CELSIUS) {
            if (temperature < MIN_CELSIUS) {
                throw new IllegalArgumentException(
                        String.format("Temperature cannot be less than %s celsius.", MIN_CELSIUS));
            }
            this.kelvin = convertCelsiusToKelvin(temperature);
        } else {
            throw new IllegalArgumentException("Illegal temperature unit.");
        }
    }

    private Temperature(Temperature temperature) {
        this(temperature.getKelvin(), TemperatureUnit.KELVIN);
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
        return kelvin + KELVIN_OFFSET;
    }

    public static final float convertCelsiusToKelvin(float celsius) {
        return celsius - KELVIN_OFFSET;
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