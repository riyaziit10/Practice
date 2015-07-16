package Random;

/**
 * Created by riyaz on 30/6/15.
 */
public class BigDecimal {
    public static void main(String[] args) {
        double a = 2.15;
        double b = 1.05;

        System.out.println(a-b);

        java.math.BigDecimal aa = new java.math.BigDecimal("2.15");
        java.math.BigDecimal bb = new java.math.BigDecimal("1.05");


        System.out.println(aa.subtract(bb));
    }
}
