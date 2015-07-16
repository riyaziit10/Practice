package Random;

import java.util.BitSet;

/**
 * Created by riyaz on 25/6/15.
 */
public class BitSetDemo {
    public static void main(String[] args) {
        int [] arr = {1,2,3,5};
        int count = 5;
        BitSet bits = new BitSet(count);
        for(int i:arr)
            bits.set(i-1);
        System.out.println(bits);
        int missingcount = count = arr.length;
    }
}
