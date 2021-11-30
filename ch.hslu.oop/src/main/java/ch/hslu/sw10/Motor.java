package ch.hslu.sw10;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Collection;

public class Motor implements Switchable {
    private int rpm;
    private Collection<PropertyChangeListener> listeners = new ArrayList<>();

    public Motor() {
        this.rpm = 0;
    }

    @Override
    public void switchOn() {
        if (this.isSwitchedOff()) {
            final int oldValue = this.rpm;
            this.rpm = 1000;
            this.firePropertyChangeEvent(
                    new PropertyChangeEvent(this, "rpm", oldValue, this.rpm));
        }
    }

    @Override
    public void switchOff() {
        if (this.isSwitchedOn()) {
            final int oldValue = this.rpm;
            this.rpm = 0;
            this.firePropertyChangeEvent(
                    new PropertyChangeEvent(this, "rpm", oldValue, this.rpm));
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

    public void addPropertyChangeEventListener(PropertyChangeListener listener) {
        this.listeners.add(listener);
    }

    public void removePropertyChangeEventListener(PropertyChangeListener listener) {
        this.listeners.remove(listener);
    }

    private void firePropertyChangeEvent(PropertyChangeEvent event) {
        for (PropertyChangeListener listener : this.listeners) {
            listener.propertyChange(event);
        }
    }
}