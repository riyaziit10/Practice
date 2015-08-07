package main.java.com.personal.Random;

import java.util.ArrayList;

/**
 * Created by riyaz on 4/8/15.
 */
public class BinaryTreeWrongPairs {
    static void findWrongPair(Node root, int min, int max, ArrayList<ArrayList<Integer>> result) {
        if(root == null)
            return;
        if(root.value < min || root.value  > max) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(root.value);
            boolean b = root.value < min ? list.add(min) : list.add(max);
            result.add(list);
            findWrongPair(root.left, min, max, result);
            findWrongPair(root.right, min, max, result);
        }
        findWrongPair(root.left, min, root.value, result);
        findWrongPair(root.right, root.value, max, result);

    }
    public static void main(String[] args) {
        Node a = new Node(5);
        Node b = new Node(10);
        Node c = new Node(14);
        Node d = new Node(6);
        Node e = new Node(3);
        a.left = b;
        a.right = c;
        b.left = d;
        c.right = e;
        findWrongPairsIn(a, null);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        findWrongPair(a,Integer.MIN_VALUE, Integer.MAX_VALUE, result);

        for(ArrayList<Integer> res : result) {
            System.out.println("Riyaz\t" + res);
        }
    }

    public static void findWrongPairsIn(Node root, Range range) {
        if (range == null) {
            range = new Range(Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        if (root == null) {
            return;
        }
        if (root.isNotIn(range)) {
            root.printTheWrongPairForThis(range);
            findWrongPairsIn(root.left, range);
            findWrongPairsIn(root.right, range);
        }
        findWrongPairsIn(root.left, root.newLeft(range));
        findWrongPairsIn(root.right, root.newRight(range));
    }
}


class Node {
    Node left;
    Node right;
    int value;

    public Node(int value) {
        this.value = value;
    }

    public boolean isNotIn(Range range) {
        if (value >= range.min && value <= range.max) {
            return false;
        }
        return true;
    }

    public Range newLeft(Range range) {
        int min = isNotIn(range) ? Integer.MIN_VALUE : range.min;
        return new Range(min, value);
    }

    public Range newRight(Range range) {
        int max = isNotIn(range) ? Integer.MAX_VALUE : range.max;
        return new Range(value, max);
    }

    public void printTheWrongPairForThis(Range range) {
        if (range.min > value) {
            System.out.println(range.min + "," + value);
        }
        if (range.max < value) {
            System.out.println(range.max + "," + value);
        }
    }
}


class Range {
    int min;
    int max;

    public Range(int min, int max) {
        this.min = min;
        this.max = max;
    }
}


