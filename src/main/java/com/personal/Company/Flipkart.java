package main.java.com.personal.Company;


import java.util.*;

public class Flipkart
{
    private static void printReverseLevelOrder(int arr[]) {
        if(arr == null || arr.length == 0)
            return;
        int length = arr.length;
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i < length; ++i) {
            if(arr[i] == -1) {
                queue.add(i);
                break;
            }
        }
        queue.add(Integer.MAX_VALUE);
        Stack stack = new Stack();
        while(!queue.isEmpty() && queue.size() != 1) {
            int temp = queue.poll();
            stack.push(temp);
            if( temp != Integer.MAX_VALUE) {
                for (int i = length - 1; i >= 0; --i) {
                    if (arr[i] == temp)
                        queue.add(i);
                }
            } else {
                queue.add(temp);
            }
        }
        while(!stack.isEmpty()) {
            int temp = (int) stack.pop();
            if(temp == Integer.MAX_VALUE) {
                System.out.println();
            } else {
                System.out.print(temp + " ");
            }
        }
    }

    public static void main (String[] args) {
        int arr []  = {8,7,0,5,5,8,7,0,-1};
        int arr2[] = {24, 42, 4, 30, 29, 43, 22, 15, 26, 36, 26, 16, 3, 22, 21, 41, 18, 16, 34, 41, 12, 29, 32, 30, 43,
        15, 4, 38, 36, -1, 24, 42, 18, 6, 21, 38, 6, 17, 32, 17, 3, 34, 12, 14, 14};
        printReverseLevelOrder(arr2);

    }
}

