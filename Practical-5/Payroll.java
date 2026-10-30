public class Payroll {
    private static final double HRA_RATE = 0.20;
    private static final double DA_RATE = 0.10;
    private static final double TAX_RATE = 0.05;
    static double netSalary(double basic) {
        double gross = basic + basic * HRA_RATE + basic * DA_RATE;
        return gross - gross * TAX_RATE;
    }
    public static void main(String[] args) {
        double basicSalary = 30000.0;
        System.out.printf("Net salary: Rs. %.2f%n", netSalary(basicSalary));
    }
}
