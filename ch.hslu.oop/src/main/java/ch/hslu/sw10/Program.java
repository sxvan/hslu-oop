package ch.hslu.sw10;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Program {
    private static Logger logger = LogManager.getLogger(Program.class);

    public static void main(String[] args) {
        TemperatureCourse temperatureCourse = new TemperatureCourse();
        temperatureCourse.addTemperatureEventListener(e -> handleTemperatureEvent(e));
        String input;
        Scanner scanner = new Scanner(System.in);
        do {
            input = scanner.next();
            try {
                float value = Float.parseFloat(input);
                temperatureCourse.add(Temperature.createFromCelsius(value));
            } catch (IllegalArgumentException e) {
                logger.error(e, e);
            }
        } while (!input.equals("exit"));

        System.out.println("Temperature count: " + temperatureCourse.getCount());
        System.out.println("Average temperature celsius: " + temperatureCourse.getAverageCelsius());
        System.out.println("Min temperature celsius: " + temperatureCourse.getMinCelsius());
        System.out.println("Max temperature celsius: " + temperatureCourse.getMaxCelsius());
    }

    public static void handleTemperatureEvent(TemperatureEvent event) {
        if (event.getTemperatureEventType() == TemperatureEventType.MAX) {
            System.out.println("New max temperature celsius: " + event.getTemperatureCelsius());
        } else {
            System.out.println("New min temperature celsius: " + event.getTemperatureCelsius());
        }
    }
}
