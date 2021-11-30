package ch.hslu.sw10;

public class Headlight implements Switchable, Named {
    private boolean isOn;
    private String name;

    public Headlight(final String name) {
        this();
        this.name = name;
    }

    public Headlight() {
        this.isOn = false;
    }

    @Override
    public void switchOn() {
        if (this.isSwitchedOff()) {
            this.isOn = true;
        }
    }

    @Override
    public void switchOff() {
        if (this.isSwitchedOn()) {
            this.isOn = false;
        }
    }

    @Override
    public boolean isSwitchedOn() {
        return this.isOn;
    }

    @Override
    public boolean isSwitchedOff() {
        return !this.isOn;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.getName();
    }
}
