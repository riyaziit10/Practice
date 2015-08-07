package main.java.com.personal.Array;

import java.util.Arrays;

/**
 * Created by riyaz on 4/8/15.
 */
public class DepthFromParrentArray {
    static int findDepthV2(int [] arr, int node, int [] result) {
        if(node == -1)
            return 0;
        if(result[node] != 0)
            return result[node];
        result[node] = 1 + findDepthV2(arr, arr[node], result);
        if(result[node] > result[result.length - 1])
            result[result.length  - 1 ] = result[node];
        return result[node];

    }
    static int findDepthV2(int [] arr) {
        if(arr == null)
            return 0;
        int length = arr.length;
        if(length == 0)
            return 0;
        int [] result = new int[length + 1];
        for(int i = 0; i < length; ++i) {
            findDepthV2(arr, i, result);
        }
        System.out.println(Arrays.toString(result));
        return result[length];
    }
//    private static int findDepth(int[] parentArray) {
//        int[] depthArray = new int[parentArray.length];
//        for (int i = 0; i < parentArray.length; ++i) {
//            findDepthRecursive(depthArray, parentArray, i);
//        }
//        return depthArray[parentArray.length - 1] ;
//    }
//
//
//    private static int findDepthRecursive(int[] depth,
//                                          int[] parentArray, int i) {
//        if (i == -1) {
//            return 0;
//        }
//        if (depth[i] != 0) {
//            return depth[i];
//        }
//        depth[i] = 1 + findDepthRecursive(depth, parentArray,
//                parentArray[i]);
//        if (depth[i] > depth[parentArray.length - 1]) {
//            depth[parentArray.length - 1] = depth[i];
//        }
//        return depth[i];
//    }
    public static void main(String[] args) {
        int[] parentArray = {3, -1, 3, 1, 5, 1, 0, 4, 2, 6};
        System.out.println(findDepthV2(parentArray));
//        System.out.println("Recursive \t" + findDepth(parentArray));
    }
}
