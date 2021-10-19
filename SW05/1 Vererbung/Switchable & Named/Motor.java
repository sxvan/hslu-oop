public class Motor extends CountingSwitchable {
    private int rpm;
    private String name;

    public Motor() {
        this.rpm = 0;
    }

    public void switchOn() {
        if (this.isSwitchedOff()) {
            super.switchOn();
            this.rpm = 1000;
        }
    }

    public void switchOff() {
        if (this.isSwitchedOn()) {
            super.switchOff();
            this.rpm = 0;
        }
    }

    public boolean isSwitchedOn() {
        return this.rpm > 0;
    }

    public boolean isSwitchedOff() {
        return this.rpm <= 0;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
}