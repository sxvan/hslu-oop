package ch.hslu.sw05.shapes;

public class Rectangle extends Shape {
    private int width;
    private int height;

    public Rectangle(int x, int y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    public void changeDimension(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    @Override
    public int getPerimeter() {
        return this.width * 2 + this.height * 2;
    }

    @Override
    public int getArea() {
        return this.width * this.height;
    }
}