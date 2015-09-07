package main.java.com.personal.Array.GFG;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by riyaz on 25/8/15.
 */
public class MergeKSortedArrays {
    private static class MinHeapNode implements Comparable{
        int element;
        int index;
        int array;
        public MinHeapNode(int element, int index, int arr) {
            this.element = element;
            this.index = index;
            this.array = arr;
        }


        @Override
        public int compareTo(Object o) {
            return this.element - ((MinHeapNode)o).element;
        }
    }
    private static int [] getMergedSortedArray(int [][] mat) {
        if(mat == null || mat.length == 0)
            return null;
        int M = mat.length;
        int size = 0;
        PriorityQueue<MinHeapNode> pq = new PriorityQueue<MinHeapNode>(M);
        for(int i = 0; i < M; ++i) {
                size += mat[i].length;
            pq.add(new MinHeapNode(mat[i][0],  0, i));

        }
        int result [] = new int[size];
        int k = 0;
        for(int i = 0; i < size; ++i) {
            MinHeapNode  temp = pq.poll();
            result[k++] = temp.element;
            ++temp.index;
            if(temp.index < mat[temp.array].length) {
                pq.add(new MinHeapNode(mat[temp.array][temp.index], temp.index, temp.array));
            } else {
                pq.add(new MinHeapNode(Integer.MAX_VALUE,Integer.MAX_VALUE, temp.array));
            }
        }

        System.out.println(Arrays.toString(result));
        return result;
    }
    public static void main(String[] args) {
        int arr[][] = { {1, 3, 5, 7},
            {2, 4, 6, 8},
            {0, 9, 10, 11}} ;
        getMergedSortedArray(arr);
    }
}
