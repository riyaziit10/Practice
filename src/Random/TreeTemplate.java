package Random;

/**
 * Created by riyaz on 5/7/15.
 */
public class TreeTemplate {
    static  class Node {
        int data;
        Node left;
        Node right;

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
        System.out.println("==========inorder traversal=======");
        inorder(a);
    }
}
