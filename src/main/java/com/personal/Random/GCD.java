package main.java.com.personal.Random;


import java.util.concurrent.*;

/**
 * Created by riyaz on 7/9/15.
 */

public class GCD {

    public static int multiply(int x, int y)
    {
        if(y == 0)
            return 0;

        if(y > 0 )
            return (x + multiply(x, y-1));

        else
            return -multiply(x, -y);
    }

    public static int multiplyV2(int x , int y) {
        if(y == 0)
            return 0;
        if(y < 0)
            return x + multiply(x, y - 1);
        else
            return -x + multiply(x, y + 1);
    }

    private static int GCD(int x, int y) {
        if( y == 0)
            return x;
        return GCD(y, x % y);
    }

    public static void main(String[] args) {
//        System.out.println("V1 \t" + multiply(3, -11));
//        System.out.println("V2 \t"+ multiplyV2(3, -11) );

        System.out.println(GCD(54,24));
    }
}
