interface Shape { double area(); }
class Circle implements Shape {
    private static final double PI = Math.PI;
    private final double radius;
    Circle(double radius) { this.radius = radius; }
    public double area() { return PI * radius * radius; }
}
class Rectangle implements Shape {
    private final double width, height;
    Rectangle(double width, double height) { this.width = width; this.height = height; }
    public double area() { return width * height; }
}
public class ShapeArea {
    public static void main(String[] args) {
        Shape[] shapes = {new Circle(5), new Rectangle(4, 6)};
        for (Shape shape : shapes) System.out.println("Area: " + shape.area());
    }
}
