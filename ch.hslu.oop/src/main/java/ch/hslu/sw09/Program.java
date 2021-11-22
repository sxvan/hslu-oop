package ch.hslu.sw09;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Program {
    private static Logger logger = LogManager.getLogger(Program.class);

    public static void main(String[] args) {
        String input;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Bitte Temperatur eingeben ('exit' zum Beenden): ");
            input = scanner.next();
            try {
                float value = Float.valueOf(input);
                System.out.println(value);
            } catch (NumberFormatException e) {
                logger.error(e, e);
            }
        } while (!input.equals("exit"));
        System.out.println("Programm beendet.");
    }
}
