package ch.hslu.sw10;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Program implements TemperatureEventListener {
    private static Logger logger = LogManager.getLogger(Program.class);

    public static void main(String[] args) {
        TemperatureCourse temperatureCourse = new TemperatureCourse();
        temperatureCourse.addTemperatureEventListener();
        String input;
        Scanner scanner = new Scanner(System.in);
        do {
            input = scanner.next();
            try {
                float value = Float.parseFloat(input);
                Temperature temperature = Temperature.createFromCelsius(value);
                temperatureCourse.add(temperature);
            } catch (NumberFormatException e) {
                logger.error(e, e);
            } catch (IllegalArgumentException e) {
                logger.error(e, e);
            }
        } while (!input.equals("exit"));

    }

    @Override
    public void handleTemperatureEvent(TemperatureEvent event) {

    }
}
