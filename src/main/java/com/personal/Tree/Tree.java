package main.java.com.personal.Tree;

import java.util.Arrays;

/**
 * Created by riyaz on 6/9/15.
 */
class TreeNode {
    private char c;

    private TreeNode [] children;

    public TreeNode(char c) {
        this.c = c;
        children = new TreeNode[26];
    }

    public void addChild(TreeNode node , int index) {
        children[index] = node;
    }


    public void printChild(String indent) {
        System.out.println(indent + "---> " + this.c);
        for(TreeNode node : children) {
            if(node != null) {
                node.printChild(indent + "    |");
//                System.out.println("--->"  + node.c  );
            }
        }
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "c=" + c +
                ", children=" + Arrays.toString(children) +
                '}';
    }
}
public class Tree {
    private TreeNode root;

    public Tree(TreeNode root) {
        this.root = root;
    }

    public  Tree[]  createForest(String []string) {

        Tree [] forest = new Tree[26];
        TreeNode [] tree = new TreeNode[26];
        for(String str : string) {
            String [] splitString = str.split(" ");
            int start = splitString[0].charAt(0) - 'a';
            int end = splitString[1].charAt(0) - 'a';
            if(tree[start] == null) {
                tree[start] = new TreeNode((char)(start + 'a'));
                forest[start] = new Tree(tree[start]);
            }

            if(tree[end] == null) {
                tree[end] = new TreeNode((char)(end + 'a'));
            } else {
                forest[end] = null;
            }
            tree[start].addChild(tree[end], end);
        }
        return forest;
    }

    public static void printForest(String [] str) {

        Tree t = new Tree(new TreeNode('\0'));
        for (Tree t1 : t.createForest(str)) {
            if (t1 != null)
            {
                t1.root.printChild("");
                System.out.println("");
            }
        }

    }

    public static void main(String[] args) {
            String [] links1 = {"a b", "b c", "b d", "a e"};
            System.out.println("‐‐‐‐‐‐‐‐‐‐‐‐ Forest 1 ‐‐‐‐‐‐‐‐‐‐‐‐‐");
            printForest(links1);
    }

}
