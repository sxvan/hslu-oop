public class Circle extends Shape {
    private static final float PI = 3.14f;
    private int diameter;

    public Circle(int x, int y, int diameter) {
        super(x, y);
        this.diameter = diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public int getDiameter() {
        return this.diameter;
    }

    public int getPerimeter() {
        return (int)(this.diameter * this.PI);
    }

    public int getArea() {
        final float radius = this.diameter / 2;
        return (int)(radius * radius * this.PI);
    }
}