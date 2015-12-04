package main.java.com.personal.MuliThreading;

/**
 * Created by riyaz on 17/11/15.
 */
import java.lang.reflect.Array;
import java.util.*;

public class Solution {
   public static void printBackWord(int arr[], Queue Q) {

        if(Q.isEmpty())
            return;
        Queue P = new LinkedList();
        Queue R = new LinkedList();

        while( !Q.isEmpty() ) {
            int node = (int) Q.poll(); P.add(node);
            for(int j=0; j<arr.length; j++)
                if( arr[j]==node )
                    R.add(j);
        }
       P.add(100);
        printBackWord(arr, R);

        while( !P.isEmpty() ) {
            if(P.peek()== 100) {
                System.out.println();
                P.poll();
            }else
            System.out.print(P.poll() + " ");
        }
    }

    public static void reverseLeveleOrder(int arr[]) {
        if(arr == null || arr.length == 0)
            return;
        int length = arr.length ;

        PriorityQueue queue = new PriorityQueue();
        for(int i = 0; i < length; ++i) {
            if(arr[i] == -1) {
                queue.add(i);
                break;
            }
        }

        printBackWord(arr, queue);
    }

    public static void main(String args[] ) throws Exception {
//        Scanner scan = new Scanner(System.in);
//        int n = Integer.parseInt(scan.nextLine());
//        int arr[] = new int[n];
//        String srr [] = scan.nextLine().split(" ");
//
//        for(int i = 0; i < n; ++i) {
//            arr[i] = Integer.parseInt(srr[i]);
//        }
        int a [] = { -1, 0 , 0 , 2 , 1};
        int a1[] = {8,7,0,5,5,8,7,0,-1};
        reverseLeveleOrder(a1);

    }
}
