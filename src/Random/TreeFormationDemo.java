package Random;

/**
 * Created by riyaz on 21/6/15.
 */
class Node {
    private char data;
    private Node left;
    private Node right;

    public char getData() {
        return data;
    }

    public void setData(char data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
public class TreeFormationDemo {

    static Node newNode(char data){
    Node node = new Node();
        node.setData(data);
        node.setLeft(null);
        node.setRight(null);
        return node;
    }
    static int search(char [] arr, char c) {
        for(int i=0; i < arr.length; ++i) {
            if(arr[i] == c)
                return i;
        }
        return -1;
    }

    static int pStart = 0;
    public Node tree( char[] inorder, int iStart, int iEnd, char[] preOrder, int pEnd) {
        if(pStart > pEnd)
            return null;
        if(iEnd < iStart)
            return null;
        Node root = newNode(preOrder[pStart]);
        int loc = search(inorder,preOrder[pStart]);
        ++pStart;
        root.setLeft( tree(inorder, iStart, loc - 1, preOrder, pEnd));
        root.setRight(tree(inorder,loc + 1, iEnd, preOrder, pEnd));
        return root;

    }

    static void preOrder(Node root) {
        if(root != null) {
            System.out.print(root.getData() + ",");
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }
    public static void main(String[] args) {
        char [] inorder = {'D', 'B', 'E', 'A', 'F' ,'C','G'};
        char [] preOrder = {'A', 'B', 'D', 'E', 'C', 'F','G'};
        System.out.println("Inorder traversal [D, B, E, A, F, C, G]");
        System.out.println("PreOrder traversal [A, B, D, E, C, F, G] "  );
        preOrder(new TreeFormationDemo().tree(inorder, 0, inorder.length - 1, preOrder, preOrder.length - 1));

    }
}
