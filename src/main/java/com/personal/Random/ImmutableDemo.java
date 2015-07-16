package Random;

import java.util.Arrays;

/**
 * Created by riyaz on 6/6/15.
 */
public class ImmutableDemo {
    private int [] arr;

   // const int a =10; error use final

    public ImmutableDemo(int[] arr) {
//        this.arr = arr;  //wrong way of immutability
        this.arr = arr.clone();
    }

    @Override
    public String toString() {
//        volatile int a = 10; // can't declare local volatile variables
        return "Immutable{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }

    public static void main(String[] args) {
        int []  array = {1,2};

        ImmutableDemo a = new ImmutableDemo(array);
        System.out.println("Before modification" + a);

        array[1] = 10;

        System.out.println("After modification" + a);
    }
}
