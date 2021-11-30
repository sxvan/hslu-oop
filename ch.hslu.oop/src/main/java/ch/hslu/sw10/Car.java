package ch.hslu.sw10;

import ch.hslu.sw10.Switchable;
import ch.hslu.sw10.Headlight;
import ch.hslu.sw10.Named;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Car implements Named, Switchable, PropertyChangeListener {
    private boolean isRunning;
    private String name;
    private Switchable[] switchableComponents;
    private Motor motor;

    public Car(final String name) {
        this();
        this.name = name;
    }

    public Car() {
        this.isRunning = false;
        this.motor = new Motor();
        this.motor.addPropertyChangeEventListener(this);
        this.switchableComponents = new Switchable[] {
                this.motor,
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
            this.switchOn();
            this.isRunning = true;
            for (Switchable component: this.switchableComponents) {
                component.switchOn();
            }
        }
    }

    @Override
    public void switchOff() {
        if (this.isSwitchedOn()) {
            this.switchOff();
            this.isRunning = false;
            for (Switchable component: this.switchableComponents) {
                component.switchOff();
            }
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {

    }
}
