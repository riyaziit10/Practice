package Tree;

/**
 * Created by riyaz on 4/7/15.
 */
public class IsBST {
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
    static  boolean isBST(Node root, int min, int max) {
        if(root == null)
            return true;
        return root.data < max && root.data > min && isBST(root.left, min, root.data) && isBST(root.right, root.data, max);
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
        System.out.println("=============isBST================");
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        System.out.println(isBST(a, min, max));
    }
}
