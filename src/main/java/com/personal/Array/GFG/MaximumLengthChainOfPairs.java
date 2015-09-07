package main.java.com.personal.Array.GFG;

import java.util.*;

/**
 * Created by riyaz on 24/8/15.
 */
public class MaximumLengthChainOfPairs {
    private static class Pairs implements Comparable{
        int i;
        int j;

        public Pairs(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public int compareTo(Object o) {
            return this.i - ((Pairs)o).i;
        }
    }
    private static int  createPairs(int [][]pairs) {
        if(pairs == null || pairs.length == 0)
            return - 1;
        int length = pairs.length;
        List<Pairs> list = new ArrayList<Pairs>();
        for(int i = 0; i < length; ++i) {
            list.add(new Pairs(pairs[i][0], pairs[i][1]));
        }
        Collections.sort(list);

        int memo[] = new int[length];
        for(int i = 0; i < length; ++i)
            memo[i] = 1;
        int max = Integer.MIN_VALUE;
        for(int i = 1; i < length; ++i) {
            for(int j = 0; j < i; ++j) {
                if(list.get(j).j < list.get(i).i && memo[i] < memo[j] + 1) {
                    memo[i] = memo[j] + 1;
                    if(memo[i] > max)
                        max = memo[i];
                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int [][] arr = {{5,24,}, {39,60}, {15,28}, {27,40}, {50,90}};

        System.out.println(createPairs(arr));


    }
}
