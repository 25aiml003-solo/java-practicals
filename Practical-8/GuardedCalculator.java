public class GuardedCalculator {
    static double divide(double numerator,double denominator){
        if(denominator==0.0)throw new ArithmeticException("Cannot divide by zero");
        return numerator/denominator;
    }
    public static void main(String[] args){
        try{System.out.println(divide(20.0,4.0));}
        catch(ArithmeticException exception){System.out.println(exception.getMessage());}
    }
}
