package Tree;

/**
 * Created by riyaz on 4/7/15.
 */
public class TreeCreationFromPreAndIn {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }
    static void inOrder(Node root) {
        if(root == null)
            return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
    static void preOrder(Node root) {
        if(root == null)
            return;
        System.out.print(root.data + " ");
        inOrder(root.left);
        inOrder(root.right);
    }
    static int search(int [] arr , int e){
        int arrLength = arr.length;
        for(int i = 0; i < arrLength; ++i) {
            if(arr[i] == e)
                return i;
        }
        return  -1;

    }
    static Node treeCreation(Node root, int [] inOrder, int iStart, int iEnd, int [] preOrder, int pEnd, int [] index) {
        if(index[0] > pEnd)
            return null;
        if(iStart > iEnd)
            return  null;
        root = new Node(preOrder[index[0]]);
        int loc = search(inOrder, preOrder[index[0]]);
        ++index[0];
        root.left = treeCreation(root, inOrder, iStart, loc - 1, preOrder, pEnd, index);
        root.right = treeCreation(root, inOrder, loc + 1, iEnd, preOrder, pEnd, index);
        return root;

    }
    public static void main(String[] args) {
        int[] inorder = {4, 2, 5, 1, 3};
        int[] preorder = { 1, 2, 4, 5, 3};
        Node root = null;
        root = treeCreation(root, inorder, 0, inorder.length -1, preorder, preorder.length - 1, new int[]{0});
        inOrder(root);
        System.out.println("\n============preOrder==========");
        preOrder(root);

    }
}
