package Array;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by riyaz on 30/6/15.
 */
public class NextSmallerElement {
    public static void main(String[] args) {
        int [] arr = {3, 4, 5, 2, 7, 5, 7, 3, 8, 2, 5, 7, 9, 1, 3};
        int arrLength =  arr.length;
        if(arr.length ==0)
            return;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        for(int i = arrLength - 1; i >=0 ; --i){
            while(arr[i] < stack.peek())
                stack.pop();
            int element = stack.peek();
            stack.push(arr[i]);
            arr[i] = element;
        }
        System.out.println(Arrays.toString(arr));
    }
}
