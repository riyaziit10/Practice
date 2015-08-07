package main.java.com.personal.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by riyaz on 2/8/15.
 */
public class PrintMaximumLevelNodes {
    static  class Node {
        int data;
        Node left;
        Node right;

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }

        public Node(int data) {
            this.data = data;
        }
    }
    static void inorder(Node root) {
        if(root == null)
            return;
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }

    static void oddLevelSumV2 (Node root, int level, Integer [] sum) {
        if(root == null)
            return;
        if((level & 1) == 1)
            sum[0] += root.data;
        oddLevelSumV2(root.left, level + 1, sum);
        oddLevelSumV2(root.right, level + 1, sum);
    }

    static int oddLevelSum(Node root, int level) {
        if(root == null)
            return 0;
        int sum = oddLevelSum(root.left, level + 1) + oddLevelSum(root.right, level + 1);
        if((level & 1) == 1)
            return root.data + sum;
        else
            return sum;
    }
    static void maxLevelNodes(Node root, int k, Map<Integer, ArrayList<Node>> resultMap) {
        if(root == null)
            return;
        ArrayList<Node> list = resultMap.get(k);
        if(list == null) {
            list = new ArrayList<Node>();
            list.add(root);
            resultMap.put(k, list);
        } else
        list.add(root);
        maxLevelNodes(root.left, k + 1, resultMap);
        maxLevelNodes(root.right, k + 1, resultMap);
    }
    public static void main(String[] args) {
        Node a = new Node(20);
        Node b = new Node(16);
        Node c = new Node(24);
        Node d = new Node(14);
        Node e = new Node(18);
        Node f = new Node(22);
        Node g = new Node(26);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        g.right = e;
//        inorder(a);
        Map<Integer, ArrayList<Node>> result =  new HashMap<Integer, ArrayList<Node>>();
//        maxLevelNodes(a, 0, result);
//        System.out.println(result.entrySet());
        Integer[] sum = new Integer[]{0};
        oddLevelSumV2(a, 1,sum);
        System.out.println("sum \t" + sum[0]);
        System.out.println("Odd level sum \t " + oddLevelSum(a,1));
    }
}
