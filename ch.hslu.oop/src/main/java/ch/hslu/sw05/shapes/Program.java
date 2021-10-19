package ch.hslu.sw05.shapes;

public final class Program {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[] {
                new Circle(1, 1, 100),
                new Rectangle(1, 1, 100, 100),
                new Square(1, 1, 100)
        };

        for (Shape shape : shapes) {
            if (shape instanceof Circle) {
                System.out.println("--- Circle ---");
            }

            if (shape instanceof Rectangle) {
                System.out.println("--- Rectangle ---");
            }

            if (shape instanceof Square) {
                System.out.println("--- Square ---");
            }

            System.out.println("Perimeter: " + shape.getPerimeter());
            System.out.println("Area: " + shape.getPerimeter() + "\n");
        }
    }

}
