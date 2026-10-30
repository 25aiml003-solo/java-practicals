import java.util.List;
public class DiscountEngine {
    private static final double MEMBER_DISCOUNT = 0.10;
    private static final double BULK_DISCOUNT = 0.05;
    static double finalPrice(double price, int quantity, boolean member) {
        double discount = member ? MEMBER_DISCOUNT : 0.0;
        if (quantity >= 5) discount += BULK_DISCOUNT;
        return price * quantity * (1.0 - discount);
    }
    public static void main(String[] args) {
        System.out.printf("Final price: Rs. %.2f%n", finalPrice(200.0, 5, true));
    }
}
