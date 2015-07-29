package main.java.com.personal.LinkList;

/**
 * Created by riyaz on 26/7/15.
 */
public class PostOrderSuccessor {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

    }

    static class Linker {
        Node linker;
    }
    static void postOrderTraversal(Node root) {
        if(root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.data + " ");
        }
    }
    static void postOrderSuccessor(Node root, Linker head , Linker p) {
        if(root == null)
            return;
        postOrderSuccessor(root.left, head, p);
        postOrderSuccessor(root.right, head, p);
        if(head.linker == null)
            head.linker = root;
        else {
            p.linker.right = root;
            root.left = p.linker;
        }
        p.linker = root;
    }
    static void show (Linker head) {
        Node iter = head.linker;
        System.out.println();
        while(iter != null) {
            System.out.print(iter.data + " ");
            iter = iter.right;
        }
    }
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);
        Node h = new Node(8);
        Node i = new Node(9);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right= e;
        c.left = f;
        c.right = g;
        g.left = h;
        g.right = i;
        postOrderTraversal(a);
        Linker  head = new Linker();
        Linker p = new Linker();
        postOrderSuccessor(a, head, p);
        p.linker.right = null;
        show(head);


    }
}
