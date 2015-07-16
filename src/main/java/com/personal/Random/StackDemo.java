package Random;

import java.util.Stack;

/**
 * Created by riyaz on 20/6/15.
 */
public class StackDemo {
    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(null);
        stack.push(null);
        stack.push(null);

        System.out.println(stack.size());
        System.out.println(stack.pop());


    }
}
