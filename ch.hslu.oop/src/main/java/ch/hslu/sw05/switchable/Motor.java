package ch.hslu.sw05.switchable;

public class Motor implements Switchable {
    private int rpm;

    public Motor() {
        this.rpm = 0;
    }

    @Override
    public void switchOn() {
        if (this.isSwitchedOff()) {
            this.rpm = 1000;
        }
    }

    @Override
    public void switchOff() {
        if (this.isSwitchedOn()) {
            this.rpm = 0;
        }
    }

    @Override
    public boolean isSwitchedOn() {
        return this.rpm > 0;
    }

    @Override
    public boolean isSwitchedOff() {
        return this.rpm <= 0;
    }
}