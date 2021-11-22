package ch.hslu.sw09;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureTest {
    @Test
    public void constructor_withCelsius() {
        float celsius = 13.5f;
        Temperature temperature;

        temperature = Temperature.createFromCelsius(celsius);

        assertEquals(celsius, temperature.getCelsius());
    }

    @Test
    public void constructor_withTemperature() {
        Temperature baseTemperature = Temperature.createFromKelvin(13.5f);
        Temperature temperature;

        temperature = Temperature.createFromTemperature(baseTemperature);

        assertEquals(baseTemperature.getCelsius(), temperature.getCelsius());
    }

    @Test
    public void getKelvin(){
        float celsius = 13.5f;
        float kelvin;
        Temperature temperature = Temperature.createFromCelsius(celsius);

        kelvin = temperature.getKelvin();

        assertEquals(celsius - 273.15f, kelvin);
    }

    @Test
    public void getCelsius(){
        float baseCelsius = 13.5f;
        Temperature temperature = Temperature.createFromCelsius(baseCelsius) ;
        float celsius;

        celsius = temperature.getCelsius();

        assertEquals(baseCelsius, celsius);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Temperature.class).suppress(Warning.NONFINAL_FIELDS).verify();
    }

    @Test
    public void getHashCode_isEqual(){
        var temperature = Temperature.createFromCelsius(13.5f);
        var temperature1 = Temperature.createFromCelsius(13.5f);

        int hashCode = temperature.hashCode();
        int hashCode1 = temperature1.hashCode();

        assertEquals(hashCode, hashCode1);
    }

    @Test
    public void getHashCode_isNotEqual(){
        var temperature = Temperature.createFromCelsius(13.5f);
        var temperature1 = Temperature.createFromCelsius(14.5f);

        int hashCode = temperature.hashCode();
        int hashCode1 = temperature1.hashCode();

        assertNotEquals(hashCode, hashCode1);
    }

    @Test
    public void compare_isSmaller() {
        var temperature = Temperature.createFromCelsius(13.5f);
        var temperature1 = Temperature.createFromCelsius(14.5f);

        int result = temperature.compareTo(temperature1);

        assertEquals(-1, result);
    }


    @Test
    public void compare_isGreater() {
        var temperature = Temperature.createFromCelsius(14.5f);
        var temperature1 = Temperature.createFromCelsius(13.5f);

        int result = temperature.compareTo(temperature1);

        assertEquals(1, result);
    }

    @Test
    public void compare_isEqual() {
        var temperature = Temperature.createFromCelsius(13.5f);
        var temperature1 = Temperature.createFromCelsius(13.5f);

        int result = temperature.compareTo(temperature1);

        assertEquals(0, result);
    }

    @Test
    public void convertKelvinToCelsius() {
        float kelvin = 13.5f;

        float celsius = Temperature.convertKelvinToCelsius(kelvin);

        assertEquals(kelvin + 273.15f, celsius);
    }

    @Test
    public void convertCelsiusToKelvin() {
        float celsius = 13.5f;

        float kelvin = Temperature.convertCelsiusToKelvin(celsius);

        assertEquals(celsius - 273.15f, kelvin);
    }

    @Test
    public void illegalKelvin_throwsIllegalArgumentException() {
        float kelvin = -1f;

        final Exception e = assertThrows(IllegalArgumentException.class,
                () -> Temperature.createFromKelvin(kelvin));

        assertEquals("Temperature cannot be less than 0 kelvin.", e.getMessage());
    }

    @Test
    public void illegalCelsius_throwsIllegalArgumentException() {
        float celsius = -300f;

        final Exception e = assertThrows(IllegalArgumentException.class,
                () -> Temperature.createFromCelsius(celsius));

        assertEquals("Temperature cannot be less than -273.15 celsius.", e.getMessage());
    }
}