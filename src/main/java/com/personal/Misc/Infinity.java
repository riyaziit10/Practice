package main.java.com.personal.Misc;

/**
 * Created by riyaz on 29/11/15.
 */
public class Infinity {

    private static int getMinimumStep(int curr, int step, int destination) {
        if(Math.abs(curr) > Math.abs(destination))
            return Integer.MAX_VALUE;
        if(curr == destination)
            return step;
        int forward = getMinimumStep(curr + step + 1, step + 1, destination);
        int backward = getMinimumStep(curr - step - 1, step + 1, destination);

        return Math.min(forward, backward);
    }

    public static void main(String[] args) {
        System.out.println(getMinimumStep(0,0, 11));
    }
}
