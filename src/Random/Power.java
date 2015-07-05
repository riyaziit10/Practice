package Random;

/**
 * Created by riyaz on 21/6/15.
 */

public class Power {
    static int  pow(int x, int y) {
        if( y == 0)
            return 1;
        return x * pow(x, y - 1);
    }
    static int power(int x, int y) {
        int result = 1;
        int power = x;
        while(y != 0) {
            if((y & 1) == 1)
                result = result * power;
            power = power * power;
            y = y >> 1;
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println("O(n) complexity \t" + pow(3,13));
        System.out.println("log(n) complexity \t" + power(3,13));
    }

}
