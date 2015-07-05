package Array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by riyaz on 3/7/15.
 */
public class BinaryTreeToLinkListLevelWise {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }
    static void preOrder(Node root) {
        if(root == null)
            return;
        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }
    static void levelOrderTraversal(Node root) {
        if(root == null)
            return;
        LinkedList<Node>  queue = new LinkedList<Node>();

        queue.add(root);
        queue.add(null);
        Node temp = null;
        while(!queue.isEmpty()) {
            temp = queue.poll();
            if(temp != null) {
                System.out.print(temp.data + "\t");
                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
            }
            else {
                System.out.println();
                if(queue.isEmpty())
                    break;
                queue.add(temp);
            }
        }
    }
    static void linkListConversion(Node root){
        if(root == null) {
            System.out.println("Tree is Empty");
            return;
        }
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(root);
        Node marker = new Node(-1);
        queue.add(marker);
        Node temp = null;
        Node prev = null;
        Node head = null;
        List<Node> arrayList = new ArrayList<Node>();
        while(!queue.isEmpty()) {
            temp = queue.poll();
            if(temp != marker) {
//                System.out.print(temp.data + " ");
                if(temp.left != null)
                    queue.add(temp.left);
                if(temp.right != null)
                    queue.add(temp.right);
                if(head == null)
                    head = temp;
                temp.left = prev;
                temp.right = queue.getFirst() == marker ? null: queue.getFirst();
            } else {
//                System.out.println();
                arrayList.add(head);
                head = null;
                if(queue.isEmpty())
                    break;
                queue.add(marker);
            }
            prev = temp == marker ? null : temp;
        }
        for(Node n : arrayList) {
            while(n != null) {
                System.out.print(n.data + " ");
                n = n.right;
            }
            System.out.println();
        }
    }

    static void zingZagTraversal(Node root) {
        if(root == null) {
            System.out.println("Tree is Empty");
            return;
        }
        Stack<Node> s1 = new Stack<Node>();
        Stack<Node> s2 = new Stack<Node>();
        s1.push(root);
        boolean isEvenLevel = true;
        while(!s1.isEmpty()) {
            Node temp = s1.pop();
            System.out.print(temp.data + " ");
            if (isEvenLevel) {
                if (temp.left != null)
                    s2.push(temp.left);
                if (temp.right != null)
                    s2.push(temp.right);
            } else {
                if (temp.right != null)
                    s2.push(temp.right);
                if (temp.left != null)
                    s2.push(temp.left);
            }
            if(s1.isEmpty()){
                System.out.println();
                Stack<Node> t = s1;
                s1 = s2;
                s2 = t;
                isEvenLevel = !isEvenLevel;
            }
        }
        System.out.println("END");

    }
    public static void main(String[] args) {
        Node a = new Node(10);
        Node b = new Node(20);
        Node c = new Node(30);
        Node d = new Node(40);
        Node e = new Node(50);
        Node f = new Node(60);
        Node g = new Node(70);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right= e;
        c.left = f;
        c.right = g;
//        preOrder(a);
        System.out.println("========Level Order Traversal========");
        levelOrderTraversal(a);
//        System.out.println("=======LinkLst conversion");
//        linkListConversion(a);
        System.out.println("=============zigzag traversal=========");
        zingZagTraversal(a);

    }
}
