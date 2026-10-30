class Fraction {
    private final int numerator;
    private final int denominator;
    Fraction(int numerator, int denominator) {
        if (denominator == 0) throw new IllegalArgumentException("Denominator cannot be zero");
        int divisor = gcd(Math.abs(numerator), Math.abs(denominator));
        int sign = denominator < 0 ? -1 : 1;
        this.numerator = sign * numerator / divisor;
        this.denominator = sign * denominator / divisor;
    }
    private static int gcd(int a, int b) { return b == 0 ? Math.max(a, 1) : gcd(b, a % b); }
    Fraction add(Fraction other) {
        return new Fraction(numerator * other.denominator + other.numerator * denominator,
                denominator * other.denominator);
    }
    public String toString() { return numerator + "/" + denominator; }
}
public class FractionDemo {
    public static void main(String[] args) {
        Fraction first = new Fraction(1, 2);
        Fraction second = new Fraction(1, 3);
        System.out.println(first + " + " + second + " = " + first.add(second));
    }
}
