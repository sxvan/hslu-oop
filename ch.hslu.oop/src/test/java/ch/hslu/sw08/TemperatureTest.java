package ch.hslu.sw08;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureTest {
    @Test
    public void constructor_withCelsius() {
        float celsius = 13.5f;
        Temperature temperature;

        temperature = new Temperature(celsius);

        assertEquals(celsius, temperature.getCelsius());
    }

    @Test
    public void constructor_withTemperature() {
        Temperature baseTemperature = new Temperature(13.5f);
        Temperature temperature;

        temperature = new Temperature(baseTemperature);

        assertEquals(baseTemperature.getCelsius(), temperature.getCelsius());
    }

    @Test
    public void getKelvin(){
        float celsius = 13.5f;
        float kelvin;
        Temperature temperature = new Temperature(celsius);

        kelvin = temperature.getKelvin();

        assertEquals(celsius + 273.15f, kelvin);
    }

    @Test
    public void getCelsius(){
        float baseCelsius = 13.5f;
        Temperature temperature = new Temperature(baseCelsius);
        float celsius;

        celsius = temperature.getCelsius();

        assertEquals(baseCelsius, celsius);
    }

    @Test
    public void setKelvin() {
        float kelvin = 13.5f;
        Temperature temperature = new Temperature(50f);

        temperature.setKelvin(kelvin);

        assertEquals(kelvin, temperature.getKelvin());
    }

    @Test
    public void setCelsius() {
        float celsius = 13.5f;
        Temperature temperature = new Temperature(50f);

        temperature.setCelsius(celsius);

        assertEquals(celsius, temperature.getCelsius());
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Temperature.class).suppress(Warning.NONFINAL_FIELDS).verify();
    }

    @Test
    public void getHashCode_isEqual(){
        var temperature = new Temperature(13.5f);
        var temperature1 = new Temperature(13.5f);

        int hashCode = temperature.hashCode();
        int hashCode1 = temperature1.hashCode();

        assertEquals(hashCode, hashCode1);
    }

    @Test
    public void getHashCode_isNotEqual(){
        var temperature = new Temperature(13.5f);
        var temperature1 = new Temperature(14.5f);

        int hashCode = temperature.hashCode();
        int hashCode1 = temperature1.hashCode();

        assertNotEquals(hashCode, hashCode1);
    }

    @Test
    public void compare_isSmaller() {
        var temperature = new Temperature(13.5f);
        var temperature1 = new Temperature(14.5f);

        int result = temperature.compareTo(temperature1);

        assertEquals(-1, result);
    }


    @Test
    public void compare_isGreater() {
        var temperature = new Temperature(14.5f);
        var temperature1 = new Temperature(13.5f);

        int result = temperature.compareTo(temperature1);

        assertEquals(1, result);
    }

    @Test
    public void compare_isEqual() {
        var temperature = new Temperature(13.5f);
        var temperature1 = new Temperature(13.5f);

        int result = temperature.compareTo(temperature1);

        assertEquals(0, result);
    }

    @Test
    public void convertKelvinToCelsius() {
        float kelvin = 13.5f;

        float celsius = Temperature.convertKelvinToCelsius(kelvin);

        assertEquals(kelvin - 273.15f, celsius);
    }

    @Test
    public void convertCelsiusToKelvin() {
        float celsius = 13.5f;

        float kelvin = Temperature.convertCelsiusToKelvin(celsius);

        assertEquals(celsius + 273.15f, kelvin);
    }
}