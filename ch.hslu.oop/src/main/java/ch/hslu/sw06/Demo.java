package ch.hslu.sw06;

public class Demo {
    public int maxInt(int a, int b, int c) {
        if (a > b && a > c) {
            return a;
        } else if (b > c) {
            return b;
        }

        return c;
    }
}
