class Point {
    private final double x;
    private final double y;
    Point(double x, double y) { this.x = x; this.y = y; }
    double distanceFromOrigin() { return Math.sqrt(x * x + y * y); }
    public boolean equals(Object other) {
        if (!(other instanceof Point point)) return false;
        return Double.compare(x, point.x) == 0 && Double.compare(y, point.y) == 0;
    }
    public int hashCode() { return java.util.Objects.hash(x, y); }
    public String toString() { return "(" + x + ", " + y + ")"; }
}
public class PointDemo {
    public static void main(String[] args) {
        Point first = new Point(3, 4);
        Point second = new Point(3, 4);
        System.out.println(first + " distance=" + first.distanceFromOrigin());
        System.out.println("Points equal: " + first.equals(second));
    }
}
