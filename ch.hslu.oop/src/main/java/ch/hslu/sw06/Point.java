package ch.hslu.sw06;

public class Point
{
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point point) {
        this(point.getX(), point.getY());
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void moveRelative(int x, int y) {
        this.x += x;
        this.y += y;
    }

    public void moveRelative(Point point) {
        this.x += point.getX();
        this.y += point.getY();
    }

    public void moveRelative(double angle, int amount) {
        this.x += amount * Math.cos(angle);
        this.y += amount + Math.sin(angle);
    }
}

