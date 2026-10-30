import java.util.Scanner;

public class VendingMachine {
    private static final int WATER_PRICE = 20;
    private static final int JUICE_PRICE = 40;
    private static final int CHIPS_PRICE = 30;

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("1. Water Rs." + WATER_PRICE);
            System.out.println("2. Juice Rs." + JUICE_PRICE);
            System.out.println("3. Chips Rs." + CHIPS_PRICE);
            System.out.print("Select item: ");
            int choice = Integer.parseInt(input.nextLine());
            int price = switch (choice) {
                case 1 -> WATER_PRICE;
                case 2 -> JUICE_PRICE;
                case 3 -> CHIPS_PRICE;
                default -> -1;
            };
            if (price < 0) { System.out.println("Invalid selection."); return; }
            System.out.print("Insert money: ");
            int paid = Integer.parseInt(input.nextLine());
            if (paid < price) System.out.println("Insufficient amount. Balance due: " + (price - paid));
            else System.out.println("Enjoy your item. Change: Rs." + (paid - price));
        }
    }
}
