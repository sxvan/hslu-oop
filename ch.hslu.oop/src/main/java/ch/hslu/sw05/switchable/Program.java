package ch.hslu.sw05.switchable;

public final class Program {
    public static void main(String[] args) {
        Object carObject = new Car("Mercedes Benz");
        Car car = (Car) carObject;
        Switchable switchable = (Switchable) carObject;
        CountingSwitchable countingSwitchable =  (CountingSwitchable) carObject;
        Named named = (Named) carObject;


        if (car != null) {
            System.out.println("--- Car ---");
            car.switchOn();
            car.switchOff();
            System.out.println("Switch count: " + car.getSwitchCount());
            System.out.println("Name: " + car.getName());
        }

        if (switchable != null) {
            System.out.println("--- Switchable ---");
            switchable.switchOn();
            switchable.switchOff();
        }

        if (countingSwitchable != null) {
            System.out.println("--- CountingSwitchable");
            countingSwitchable.switchOn();
            countingSwitchable.switchOff();
            System.out.println("Switch count: " + countingSwitchable.getSwitchCount());
        }

        if (named != null) {
            System.out.println("--- Named ---");
            System.out.println(named.getName());
        }
    }
}
