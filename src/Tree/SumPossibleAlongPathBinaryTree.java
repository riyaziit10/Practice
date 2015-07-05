package Tree;

/**
 * Created by riyaz on 2/7/15.
 */

public class SumPossibleAlongPathBinaryTree {
    static  class Node {
        int data;
        Node left;
        Node right;
        public Node() {
        }
        public Node(int data) {
            this.data = data;
        }
    }

    public static void  preOorderTraversal(Node root) {
        if(root == null)
            return;
        System.out.println(root.data);
        preOorderTraversal(root.left);
        preOorderTraversal(root.right);

    }

    public static boolean isSum(Node root, int sum){
        if(sum == 0)
            return true;

        if(root == null || sum < 0) {
            return true;
        }
        return isSum(root.left, sum - root.data) ||
                isSum(root.right,sum - root.data) ||
                isSum(root.left, sum)||
                isSum(root.right,sum);

    }

    public static int sumChildNode(Node root) {
        if(root == null)
            return 0;
        int sum = sumChildNode(root.left) + sumChildNode(root.right);
        int rootData = root.data;
        if(sum != 0)
            root.data = sum;
        return rootData + sum;
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
        c.left = e;
        c.right = f;
        b.right = g;

        preOorderTraversal(a);
        System.out.println(isSum(a,15));
        sumChildNode(a);
        preOorderTraversal(a);

    }
}
