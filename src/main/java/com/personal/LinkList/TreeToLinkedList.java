package main.java.com.personal.LinkList;

/**
 * Created by riyaz on 14/7/15.
 */
public class TreeToLinkedList {

    static class Iter {
        Node temp;
    }

    static  class Node {
        int data;
        Node left;
        Node right;

        public Node() {
            this.data = Integer.MIN_VALUE;
        }
        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
    static void inorder(Node root) {
        if(root == null)
            return;
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }
//    static Node head = null;
//    static Node p = null;
    static void getDoublyLinkList(Node root, Iter head, Iter p) {
        if(root == null){
            return;
        }
        getDoublyLinkList(root.left, head, p);
        if(head.temp == null)
            head.temp = root;
        else{
            p.temp.right = root;
            root.left = p.temp;
        }
        p.temp = root;
        getDoublyLinkList(root.right, head, p);
    }
    static void show(Node head) {
        if(head == null) {
            System.out.println("Link List is Empty");
            return;
        }
        Node iterator = head;
        while(iterator != null) {
            System.out.println(iterator.data);
            iterator = iterator.right;
        }
    }
    public static void main(String[] args) {
        Node a = new Node(20);
        Node b = new Node(16);
        Node c = new Node(24);
        Node d = new Node(14);
        Node e = new Node(18);
        Node f = new Node(22);
        Node g = new Node(26);
        Node h = new Node(21);
        Node i = new Node(28);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        f.left=h;
        g.right = i;
//        System.out.println("==========inorder traversal=======");
//        inorder(a);
        Iter head = new Iter();
        Iter p = new Iter();
        getDoublyLinkList(a,head,p);
        if(head.temp == null){
            System.out.println("Link list is not possible");
        } else {
            show(head.temp);
        }
    }
}
