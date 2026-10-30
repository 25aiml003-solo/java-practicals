import java.util.Scanner;

public class TollBooth {
    private static final double CAR_FEE = 50.0;
    private static final double TRUCK_FEE = 100.0;
    private static final double BUS_FEE = 80.0;

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int cars = 0, trucks = 0, buses = 0;
            double collection = 0;
            System.out.println("Enter vehicle type (car/truck/bus), or done:");
            while (true) {
                String type = input.nextLine().trim().toLowerCase();
                if (type.equals("done")) break;
                switch (type) {
                    case "car" -> { cars++; collection += CAR_FEE; }
                    case "truck" -> { trucks++; collection += TRUCK_FEE; }
                    case "bus" -> { buses++; collection += BUS_FEE; }
                    default -> System.out.println("Unknown vehicle. Try again.");
                }
            }
            System.out.println("Cars: " + cars + ", Trucks: " + trucks + ", Buses: " + buses);
            System.out.printf("Total collection: Rs. %.2f%n", collection);
        }
    }
}
