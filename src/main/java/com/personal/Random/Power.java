package Random;

/**
 * Created by riyaz on 21/6/15.
 */

public class Power {
    static float power(float x , int y) {
        if(y == 0)
            return 1;
//        System.out.println("1");
        float p = power(x, y /2);
        if((y & 1) == 0)
            return p * p;
        else {
            if(y > 0)
                return x * p * p;
            else return (p * p) / x;
        }
    }
    public static void main(String[] args) {
//        System.out.println("O(n) complexity \t" + pow(3,13));
        System.out.println("log(n) complexity \t" + power(3,-4));
    }

}
