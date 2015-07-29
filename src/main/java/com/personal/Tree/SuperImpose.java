package main.java.com.personal.Tree;

/**
 * Created by riyaz on 26/7/15.
 */
public class SuperImpose {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }
    static void inorderTraversal(Node root) {
        if(root != null) {
            inorderTraversal(root.left);
            System.out.print(root.data + " ");
            inorderTraversal(root.right);
        }
    }

    static Node superImpose(Node root1, Node root2) {
        if(root1 == null)
            return root2;
        if(root2 == null)
            return root1;
        root1.left = superImpose(root1.left, root2.left);
        root1.right =  superImpose(root1.right, root2.right);
        return root1;

    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        a.left = b;
        a.right = c;
        b.left = d;
        c.left = e;
        c.right = f;
        System.out.println("Inorder Traversal A");
        inorderTraversal(a);
        Node u = new Node(40);
        Node v = new Node(7);
        Node w = new Node(2);
        Node x = new Node(8);
        Node y = new Node(1);
        Node z = new Node(5);
        u.left = v;
        u.right = w;
        w.left = x;
        w.right = y;
        y.right = z;
        System.out.println("\nInorder Traversal u");
        inorderTraversal(u);
        superImpose(a, u);
        System.out.println("\n super impose tree is");
        inorderTraversal(a);
    }
}
