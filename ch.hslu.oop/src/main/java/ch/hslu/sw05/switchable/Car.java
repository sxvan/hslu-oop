package ch.hslu.sw05.switchable;

public class Car extends CountingSwitchable implements Named {
    private boolean isRunning;
    private String name;
    private Switchable[] switchableComponents;

    public Car(final String name) {
        this();
        this.name = name;
    }

    public Car() {
        this.isRunning = false;
        this.switchableComponents = new Switchable[] {
                new Motor(),
                new Headlight("Front Right"),
                new Headlight("Front Left")
        };
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isSwitchedOn() {
        return this.isRunning;
    }

    @Override
    public boolean isSwitchedOff() {
        return !this.isRunning;
    }

    @Override
    public void switchOn() {
        if (this.isSwitchedOff()) {
            super.switchOn();
            this.isRunning = true;
            for (Switchable component: this.switchableComponents) {
                component.switchOn();
            }
        }
    }

    @Override
    public void switchOff() {
        if (this.isSwitchedOn()) {
            super.switchOff();
            this.isRunning = false;
            for (Switchable component: this.switchableComponents) {
                component.switchOff();
            }
        }
    }
}
