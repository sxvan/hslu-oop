package ch.hslu.sw08;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureCourseTest {

    @Test
    void add() {
        TemperatureCourse temperatureCourse = new TemperatureCourse();
        Temperature temperature = new Temperature(13.5f);

        temperatureCourse.add(temperature);

        assertEquals(1, temperatureCourse.getCount());
    }

    @Test
    void clear() {
        TemperatureCourse temperatureCourse = new TemperatureCourse();
        Temperature temperature = new Temperature(13.5f);

        temperatureCourse.add(temperature);
        temperatureCourse.clear();

        assertEquals(0, temperatureCourse.getCount());
    }

    @Test
    void getCount() {
        TemperatureCourse temperatureCourse = new TemperatureCourse();
        Temperature temperature = new Temperature(13.5f);

        temperatureCourse.add(temperature);

        assertEquals(1, temperatureCourse.getCount());
    }

    @Test
    void getMaxCelsius() {
        final float maxTemperatureCelsius = 100f;
        TemperatureCourse temperatureCourse = new TemperatureCourse();
        Temperature temperature = new Temperature(13.5f);
        Temperature temperature1 = new Temperature(maxTemperatureCelsius);

        temperatureCourse.add(temperature);
        temperatureCourse.add(temperature1);

        assertEquals(maxTemperatureCelsius, temperatureCourse.getMaxCelsius());
    }

    @Test
    void getMaxKelvin() {
        final float maxTemperatureKelvin = 500f;
        TemperatureCourse temperatureCourse = new TemperatureCourse();
        Temperature temperature = new Temperature(13.5f);
        Temperature temperature1 = new Temperature(maxTemperatureKelvin - 273.15f);

        temperatureCourse.add(temperature);
        temperatureCourse.add(temperature1);

        assertEquals(maxTemperatureKelvin, temperatureCourse.getMaxKelvin());

    }

    @Test
    void getMinCelsius() {
        final float minTemperatureCelsius = 1f;
        TemperatureCourse temperatureCourse = new TemperatureCourse();
        Temperature temperature = new Temperature(13.5f);
        Temperature temperature1 = new Temperature(minTemperatureCelsius);

        temperatureCourse.add(temperature);
        temperatureCourse.add(temperature1);

        assertEquals(minTemperatureCelsius, temperatureCourse.getMinCelsius());
    }

    @Test
    void getMinKelvin() {
        final float minTemperatureKelvin = 1f;
        TemperatureCourse temperatureCourse = new TemperatureCourse();
        Temperature temperature = new Temperature(13.5f);
        Temperature temperature1 = new Temperature(minTemperatureKelvin - 273.15f);

        temperatureCourse.add(temperature);
        temperatureCourse.add(temperature1);

        assertEquals(minTemperatureKelvin, temperatureCourse.getMinKelvin());
    }

    @Test
    void getAverageCelsius() {
        final float temperatureCelsius = 13.5f;
        final float temperatureCelsius1 = 15.5f;
        final float averageTemperatureCelsius = (temperatureCelsius + temperatureCelsius1) / 2;
        Temperature temperature = new Temperature(temperatureCelsius);
        Temperature temperature1 = new Temperature(temperatureCelsius1);
        TemperatureCourse temperatureCourse = new TemperatureCourse();

        temperatureCourse.add(temperature);
        temperatureCourse.add(temperature1);

        assertEquals(averageTemperatureCelsius, temperatureCourse.getAverageCelsius());
    }

    @Test
    void getAverageKelvin() {
        final float temperatureKelvin = 13.5f;
        final float temperatureKelvin1 = 15.5f;
        final float averageTemperatureKelvin = (temperatureKelvin + temperatureKelvin1) / 2;
        Temperature temperature = new Temperature(temperatureKelvin - 273.15f);
        Temperature temperature1 = new Temperature(temperatureKelvin1 - 273.15f);
        TemperatureCourse temperatureCourse = new TemperatureCourse();

        temperatureCourse.add(temperature);
        temperatureCourse.add(temperature1);

        assertEquals(averageTemperatureKelvin, temperatureCourse.getAverageKelvin());
    }

    @Test
    void getAverageKelvin_EmptyTemperatureCourse() {
        TemperatureCourse temperatureCourse = new TemperatureCourse();

        assertEquals(0, temperatureCourse.getAverageKelvin());
    }

    @Test
    void getMaxKelvin_EmptyTemperatureCourse() {
        TemperatureCourse temperatureCourse = new TemperatureCourse();

        assertEquals(0, temperatureCourse.getMaxKelvin());
    }
}