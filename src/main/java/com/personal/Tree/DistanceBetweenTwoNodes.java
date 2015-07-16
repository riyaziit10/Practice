package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by riyaz on 5/7/15.
 */
public class DistanceBetweenTwoNodes {
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
    static int getNodeDepth(Node root, int data){
        if(root == null)
            return 0;
        if(data == root.data)
            return 1;
        int left = getNodeDepth(root.left, data);
        if(left != 0){
            return 1 + left;
        }
        int right = getNodeDepth(root.right, data);
        if(right != 0)
            return 1 + right;
        return right;

    }
    static Node  LCA(Node root, int k1, int k2) {
        if(root == null)
            return null;
        if( k1 == root.data || k2 == root.data)
            return root;
        Node left = LCA(root.left, k1, k2);
        Node right= LCA(root.right, k1, k2);

        if(left != null && right != null)
            return root;

        return  left != null ? left : right;
    }

    static void getDistance2Nodes(Node root, int a, int b){
        int depthA = getNodeDepth(root,a);
        int depthB = getNodeDepth(root, b);
        if(depthA == 0  ||  depthB == 0) {
            System.out.println("Please provide correct data, one or both nodes are missing");
            return;
        }

        Node lca = LCA(root, a, b);
        if(lca == root) {
            System.out.println("Distance between two nodes is \t" + (depthA + depthB - 3));
            return;
        }
        int lcaDepth = getNodeDepth(root,lca.data);
        System.out.println("Distance between two nodes is \t " + (depthA + depthB - 2 * lcaDepth - 1));


    }

    static boolean findPath(Node root, int k, List<Node> path) {
        if(root == null)
            return false;
        path.add(root);
        if(root.data == k)
            return true;
        if(findPath(root.left,k,path) || findPath(root.right,k,path))
            return true;
        path.remove(root);
        return false;
    }

    static void findDistance(Node root, int k1 , int k2) {
        if(root == null){
            System.out.println("Tree is Empty");
            return;
        }
        List<Node> pathK1 = new ArrayList<Node>();
        List<Node> pathK2 = new ArrayList<Node>();
        findPath(root, k1,pathK1);
        findPath(root, k2, pathK2);
        if(pathK1.size() == 0 || pathK2.size() == 0) {
            System.out.println("One or Both node are missing");
            return;
        }
        int index = 0;
        for(; index < pathK1.size(); ++index){
            if(pathK1.get(index) != pathK2.get(index))
                break;
        }
        System.out.println( pathK1.size() + pathK2.size() - 2 * index - 1);

    }
    public static void main(String[] args) {
        int [] arr = {20, 16, 24, 14, 18, 22, 26};
        Node a = new Node(arr[0]);
        Node b = new Node(arr[1]);
        Node c = new Node(arr[2]);
        Node d = new Node(arr[3]);
        Node e = new Node(arr[4]);
        Node f = new Node(arr[5]);
        Node g = new Node(arr[6]);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        System.out.println("=============inorder traversal================");
//        inorder(a);
//        for(int i = 0; i < arr.length; ++i)
//        System.out.println(arr[i] + " Node depth" + getNodeDepth(a,arr[i]));
//        System.out.println(getNodeDepth(a,24));
        getDistance2Nodes(a, 14, 26);
        findDistance(a, 14,26);
    }
}
