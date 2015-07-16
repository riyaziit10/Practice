package MadeEasy;

import java.util.Stack;

/**
 * Created by riyaz on 20/6/15.
 */
class BinaryTreeNode {
    private int data;
    private BinaryTreeNode left;
    private BinaryTreeNode right;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }
}

class BSTree {
    private BinaryTreeNode binaryTree;

    public BinaryTreeNode getBinaryTree() {
        return binaryTree;
    }

    public void setBinaryTree(BinaryTreeNode binaryTree) {
        this.binaryTree = binaryTree;
    }

    private BinaryTreeNode newNode(int data) {
        BinaryTreeNode newNode = new BinaryTreeNode();
        newNode.setData(data);
        newNode.setLeft(null);
        newNode.setRight(null);
        return newNode;
    }

    public void addNode(int data) {

        if (this.getBinaryTree() == null) {
            this.setBinaryTree(newNode(data));
            return;
        }
        BinaryTreeNode iterator = this.getBinaryTree();
        while (true) {
            if (data < iterator.getData() && iterator.getLeft() != null)
                iterator = iterator.getLeft();
            else if (data > iterator.getData() && iterator.getRight() != null)
                iterator = iterator.getRight();
            else
                break;
        }
        if (iterator.getLeft() == null && data < iterator.getData()) {
            iterator.setLeft(newNode(data));
            return;
        }
        else
            iterator.setRight(newNode(data));

    }

    public void inorderTraversal() {
        inorder(this.binaryTree);
    }

    private void inorder(BinaryTreeNode node) {
        if (node != null) {
            inorder(node.getLeft());
            System.out.print(node.getData() + ",");
            inorder(node.getRight());
        }
    }

    public void preOrederTraversal() {
        preOrder(this.binaryTree);
    }

    private void preOrder(BinaryTreeNode node) {
        if(node != null) {
            System.out.print(node.getData() + ",");
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    public void postOrderTraversal() {
        postOrder(this.binaryTree);
    }

    private void postOrder(BinaryTreeNode node) {
        if(node != null) {
            postOrder(node.getLeft());
            postOrder(node.getRight());
            System.out.print(node.getData() + ",");
        }

    }
    public void iterativeInorder() {
        Stack stack = new Stack();
        BinaryTreeNode temp = binaryTree, p = null;

        stack.push(temp);
        while(!stack.isEmpty()) {
            temp = (BinaryTreeNode) stack.pop();
            while(temp.getLeft() != null && p == null) {
                stack.push(temp);
                temp = temp.getLeft();
            }
            p = temp;
            System.out.print(temp.getData() + ",");
            if(temp.getRight() != null) {
                p = null;
                stack.push(temp.getRight());
            }
        }
    }

    public void iterativePreOrder() {
        Stack stack = new Stack();
        BinaryTreeNode iter = this.binaryTree;
        stack.push(iter);
        while(!stack.isEmpty()) {
            iter = (BinaryTreeNode) stack.pop();
            System.out.print(iter.getData() + ",");
            if(iter.getRight() != null)
                stack.push(iter.getRight());
            if(iter.getLeft()  != null)
                stack.push(iter.getLeft());
        }
    }

    public boolean findNode(BinaryTreeNode root, int element) {
        if(root == null)
            return false;
        if(root.getData() == element)
            return true;

        return findNode(root.getLeft(), element) || findNode(root.getRight(), element);

    }

    public BinaryTreeNode findMin(BinaryTreeNode root){
        if(root == null)
            return null;
        if(findMin(root.getLeft()) == null)
            return root;
        else
            return findMin(root.getLeft());
    }

    public BinaryTreeNode findMax(BinaryTreeNode root) {
        if(root == null)
            return root;
        if(findMax(root.getRight()) == null)
            return root;
        else
            return findMax(root.getRight());
    }

    public void deleteNode() {

    }

    public BinaryTreeNode deleteNode(BinaryTreeNode root,int data) {
        if(root == null)
            return null;
        if(data == root.getData()) {
            if(root.getLeft() == null && root.getRight() == null)
                return null;
            if(root.getLeft() == null)
                return root.getRight();
            if(root.getRight() == null)
                return root.getLeft();
            BinaryTreeNode predecessor = findMax(root.getLeft());
            root.setLeft(deleteNode(root.getLeft(),predecessor.getData()));
            root.setData(predecessor.getData());
            return root;
        }
        if(data < root.getData()) {
            BinaryTreeNode deletedNode = root.getLeft();
            root.setLeft(deleteNode(root.getLeft(), data));
            deletedNode = null;
        }
        if(data > root.getData()) {
            BinaryTreeNode nodeTobeDeleted= root.getRight();
            root.setRight(deleteNode(root.getRight(), data));
            nodeTobeDeleted = null;
        }
        return root;
    }

    public BinaryTreeNode  LCA(BinaryTreeNode root, int k1, int k2) {
        if(root == null)
            return root;
        if(k1 <= root.getData() && k2 >= root.getData() ||k2 <= root.getData() && k1 >= root.getData())
            return root;
        if(k1 <= root.getData())
            return LCA(root.getLeft(),k1,k2);
        else
            return LCA(root.getRight(), k1, k2);
    }
    public static void changeBST(BinaryTreeNode root) {
        root.getRight().setData(-10);
    }
    public boolean isBST(BinaryTreeNode root, int k1, int k2) {
        if(root == null)
            return true;
        return k1 <= root.getData() && root.getData() <= k2 && isBST(root.getLeft(), k1, root.getData()) && isBST(root.getRight(), root.getData(), k2);
    }
    static int prev = Integer.MIN_VALUE;
    public  boolean isBSTv2(BinaryTreeNode root){
        if(root == null)
            return true;
        if(isBSTv2(root.getLeft()) && prev < root.getData()) {
            prev = root.getData();
            return isBSTv2(root.getRight());
        }
        return false;
    }

}

public class BSTDemo {
    public static void main(String[] args) {
        BSTree binaryTree = new BSTree();
        binaryTree.addNode(7);     //                                     7
        binaryTree.addNode(6);    //                                    /   \
        binaryTree.addNode(8);    //                                   6     8
        binaryTree.addNode(2);    //                                  /       \
        binaryTree.addNode(10);    //                                2       10
        binaryTree.addNode(9);   //                                 / \      / \
        binaryTree.addNode(1);    //                               1   3    9  12
        binaryTree.addNode(3);    //
        binaryTree.addNode(12);    //
        System.out.println("Recursive Inorder Traversal");
        binaryTree.inorderTraversal();
//        System.out.println("\nIterative Inorder Traversal");
//        binaryTree.iterativeInorder();
//        System.out.println("\nRecursive PreOrder Traversal");
//        binaryTree.preOrederTraversal();
//        System.out.println("\nIterativve PreOrder Traversal");
//        binaryTree.iterativePreOrder();
//        System.out.println("\nRecursive PostOrder Traversal");
//        binaryTree.postOrderTraversal();
//        System.out.println("\n" + binaryTree.findNode(binaryTree.getBinaryTree(), 4));
//        System.out.println("\n Minimum element in the tree is \t" + binaryTree.findMin(binaryTree.getBinaryTree()).getData());
//        System.out.println(("\n Maximum element is the tree is \t" + binaryTree.findMax(binaryTree.getBinaryTree()).getData()));
//        binaryTree.deleteNode(binaryTree.getBinaryTree(),7);
//        System.out.println("\n  After deletionn biinaary tree is");
//        binaryTree.inorderTraversal();
//        System.out.println("\nLCA of Binary tree is " + binaryTree.LCA(binaryTree.getBinaryTree(),3,8).getData());
        int k1 = Integer.MIN_VALUE, k2 = Integer.MAX_VALUE;
        //BSTree.changeBST(binaryTree.getBinaryTree());
        System.out.println("\nisBST \t" + binaryTree.isBST(binaryTree.getBinaryTree(), k1, k2));
        System.out.println("isBST prev version \t" + binaryTree.isBSTv2(binaryTree.getBinaryTree()));


    }

}
