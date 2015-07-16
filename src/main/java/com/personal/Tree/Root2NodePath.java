package main.java.com.personal.Tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by riyaz on 13/7/15.
 */
public class Root2NodePath {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    static void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }

    static List<Node> root2NodePath(Node root, int k) {
        if (root == null)
            return null;
        if (root.data == k) {
            List<Node> path = new ArrayList<Node>();
            path.add(root);
            return path;
        }

        if (k < root.data) {
            List<Node> leftPath = root2NodePath(root.left,k);
            if (leftPath != null) {
                leftPath.add(0,root);
                return leftPath;
            }
        }

        if (k > root.data) {
            List<Node> rigthPath = root2NodePath(root.right,k);
            if (rigthPath !=null) {
                rigthPath.add(0,root);
                return rigthPath;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Node a = new Node(20);
        Node b = new Node(16);
        Node c = new Node(24);
        Node d = new Node(14);
        Node e = new Node(18);
        Node f = new Node(22);
        Node g = new Node(26);
        Node h = new Node(28);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        g.right = h;
        System.out.println("==========inorder traversal=======");
//        inorder(a);
        List<Node> result = root2NodePath(a,50);
        if (result == null) {
            System.out.println("Root To Node Path is not possible");
        } else {
            Iterator iterator = result.listIterator();
            while (iterator.hasNext()){
                System.out.println(((Node)iterator.next()).data);
            }
        }
    }
}
