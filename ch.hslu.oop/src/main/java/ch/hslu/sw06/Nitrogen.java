package ch.hslu.sw06;

public class Nitrogen extends Element {
    public Nitrogen() {
        super("N", -210, -196);
    }

    @Override
    public String toString() {
        return "GIFTIG: " + super.toString();
    }
}