import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class LibraryFee {
    private static final double FEE_PER_DAY = 2.0;
    static double calculate(LocalDate dueDate, LocalDate returnedDate) {
        long lateDays = Math.max(0, ChronoUnit.DAYS.between(dueDate, returnedDate));
        return lateDays * FEE_PER_DAY;
    }
    public static void main(String[] args) {
        LocalDate due = LocalDate.of(2026, 10, 20);
        LocalDate returned = LocalDate.of(2026, 10, 25);
        System.out.println("Late fee: Rs. " + calculate(due, returned));
    }
}
