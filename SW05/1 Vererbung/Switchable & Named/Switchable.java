public interface Switchable extends Named {
    void switchOn();

    void switchOff();

    boolean isSwitchedOn();

    boolean isSwitchedOff();
}