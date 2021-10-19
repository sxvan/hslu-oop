package ch.hslu.sw05.temperature;

import javax.swing.event.CellEditorListener;

public final class Program {
    public static void main(String[] args) {
        Element[] elements = new Element[] {
                new Lead(),
                new Mercury(),
                new Nitrogen()
        };

        String[] elementNames = new String[] {
                "Pb",
                "Hg",
                "N",
                "H"
        };

        Temperature temperature = new Temperature(100);
        for (Element element : elements) {
            System.out.println(temperature.getStateOfAggregation(element.getName()));
        }

        for (String elementName : elementNames) {
            System.out.println(temperature.getStateOfAggregation(elementName));
        }
    }
}
