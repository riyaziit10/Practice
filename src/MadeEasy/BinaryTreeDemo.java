package MadeEasy;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by riyaz on 20/6/15.
 */
class BinaryNode{
    private int data;
    private BinaryNode left;
    private BinaryNode right;
    private BinaryNode nextSibling;

    public BinaryNode getNextSibling() {
        return nextSibling;
    }

    public void setNextSibling(BinaryNode nextSibling) {
        this.nextSibling = nextSibling;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BinaryNode getLeft() {
        return left;
    }

    public void setLeft(BinaryNode left) {
        this.left = left;
    }

    public BinaryNode getRight() {
        return right;
    }

    public void setRight(BinaryNode right) {
        this.right = right;
    }
}

class BinaryTee{

    private BinaryNode binaryNode;

    public BinaryNode getBinaryNode() {
        return binaryNode;
    }

    public void setBinaryNode(BinaryNode binaryNode) {
        this.binaryNode = binaryNode;
    }

    private  BinaryNode newNode(int data) {
        BinaryNode node = new BinaryNode();
        node.setData(data);
        node.setLeft(null);
        node.setRight(null);
        node.setNextSibling(null);
        return node;
    }

    public BinaryTee() {
        binaryNode = newNode(1);
        binaryNode.setLeft(newNode(2));
        binaryNode.getLeft().setLeft(newNode(4));
        binaryNode.getLeft().getLeft().setRight(newNode(9));
        binaryNode.getLeft().getLeft().getRight().setLeft(newNode(10));
        binaryNode.getLeft().setRight(newNode(5));
        binaryNode.setRight(newNode(3));
        binaryNode.getRight().setLeft(newNode(6));
        binaryNode.getRight().setRight(newNode(7));

    }
    public void preOrderTraversal() {
        preOrder(binaryNode);
    }

    private void preOrder(BinaryNode node) {
        if(node != null) {
            System.out.print(node.getData() + ",");
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }

    }
    public int findMax() {
        return findMax(binaryNode).getData();
    }
    private  BinaryNode findMax(BinaryNode root) {
        if(root == null)
            return root;
        BinaryNode leftMax = findMax(root.getLeft());
        BinaryNode rightMax = findMax(root.getRight());
        if(leftMax == null && rightMax == null)
            return root;
        if(leftMax == null)
            return rightMax;
        if(rightMax == null)
            return leftMax;
        if(leftMax.getData() > rightMax.getData())
            return leftMax;
        else
            return rightMax;
    }

    public void reverseLevelOrder() {
        BinaryNode root = binaryNode;
        if(root == null) {
            System.out.println("Tree is Empty");
            return;
        }

        LinkedList queue = new LinkedList();
        Stack stack = new Stack();
        queue.add(root);
        while(!queue.isEmpty()) {
            BinaryNode temp = (BinaryNode) queue.remove();
            stack.push(temp);
            if(temp.getRight() != null)
                queue.add(temp.getRight());
            if(temp.getLeft() != null)
                queue.add(temp.getLeft());
        }
        while (!stack.isEmpty()){
            BinaryNode temp = (BinaryNode) stack.pop();
            System.out.print(temp.getData() + ",");
        }
    }

    public int height(BinaryNode root) {
        if(root == null)
            return 0;
        return Math.max(height(root.getLeft()), height(root.getRight())) + 1;
    }

    public static Boolean isStructurallyIdentical(BinaryNode root1, BinaryNode root2){
        if(root1 == null && root2==null)
            return true;
        if(root1 == null || root2 == null)
            return false;
        return root1.getData() == root2.getData() &&
               isStructurallyIdentical(root1.getLeft(), root2.getLeft()) &&
                isStructurallyIdentical(root1.getRight(), root2.getRight());
    }

    public void maxSumLevel() {
        LinkedList queue = new LinkedList();
        if(binaryNode == null) {
            System.out.println("Tree is Empty");
            return;
        }
        queue.add(binaryNode);
        queue.add(null);
        int sum = 0, max = 0, maxlevel=0, level =0;
        while(!queue.isEmpty() || queue.size() != 1) {
            BinaryNode temp = (BinaryNode) queue.poll();
            if(temp!= null) {
                sum += temp.getData();
                if(temp.getLeft() != null)
                  queue.add(temp.getLeft());
                if(temp.getRight() != null)
                    queue.add(temp.getRight());
            } else {
                ++level;
                if(sum > max) {
                    max = sum;
                    maxlevel = level;
                }
                sum = 0;
                if(queue.isEmpty())
                    break;
                queue.add(null);
            }
        }
        System.out.println("Maximum sum is = \t" + max + "maximum level is \t" + maxlevel);
    }
    void printArray(int array[], int i) {
        System.out.println("\nRoot to leaf path");
        for(int k =0 ; k <= i; ++k)
            System.out.print(array[k] + ",");
    }
    void rootToLeafPath(BinaryNode root, int i, int array[]) {
        if(root == null)
            return;
        array[i] = root.getData();
        if(root.getLeft() == null && root.getRight() == null) {
            printArray(array,i);
        }

        rootToLeafPath(root.getLeft(), i + 1, array);
        rootToLeafPath(root.getRight(), i + 1, array);

    }

    public boolean isPathExistWithGivenSum(BinaryNode root, int sum) {
        if(root == null || sum < 0)
            return false;



        sum = sum - root.getData();

        if(sum==0 && root.getLeft() == null && root.getRight() == null)
            return true;

        return isPathExistWithGivenSum(root.getLeft(),sum) || isPathExistWithGivenSum(root.getRight(),sum);
    }

    public int toalSum(BinaryNode root) {
        if(root == null)
            return 0;
        return root.getData() + toalSum(root.getLeft()) + toalSum(root.getRight());
    }

    public void mirror() {
        mirrorTree(binaryNode);
        preOrder(binaryNode);
    }

    private void mirrorTree(BinaryNode root){
        if(root == null)
            return;
        BinaryNode temp = root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(temp);
        mirrorTree(root.getLeft());
        mirrorTree(root.getRight());

    }

    public void findAncetor(int element) {
        int [] array= new int[10];
        if(!findAncestor(binaryNode, element,array,0 )) {
            System.out.println("Element is not preset in the Tree");
        }

    }
    private boolean findAncestor(BinaryNode root, int element, int []array, int i){
        if(root == null)
            return false;
        array[i] = root.getData();

        if(array[i] == element){
            printArray(array,i);
            return true;
        }
        return findAncestor(root.getLeft(), element, array, i + 1) ||
                findAncestor(root.getRight(), element, array, i + 1);

    }

    public  void zigzagTraversal(BinaryNode root) {
        if(root == null) {
            System.out.println("Tree is Empty");
            return;
        }
        Stack s1 = new Stack();
        Stack s2 = new Stack();
        boolean flag = true;
        s1.push(root);
        BinaryNode temp = null;
        while(!s1.isEmpty()) {
            temp = (BinaryNode) s1.pop();
            System.out.print(temp.getData() + ",");
            if(flag) {
                if(temp.getLeft() != null)
                    s2.push(temp.getLeft());
                if(temp.getRight() != null)
                    s2.push(temp.getRight());
            } else {
                if(temp.getRight() != null)
                    s2.push(temp.getRight());
                if(temp.getLeft() != null)
                    s2.push(temp.getLeft());
            }

            if(s1.isEmpty()) {
                Stack swap = new Stack();
                swap = s1;
                s1=s2;
                s2=swap;
                flag = !flag;
            }
        }
    }

    public  void nextSibling(BinaryNode root) {
        if(root == null) {
            System.out.println("Tree is Empty");
            return;
        }
        LinkedList queue = new LinkedList();
        queue.add(root);
        queue.add(null);
        BinaryNode temp = null;
        while(true){
            temp = (BinaryNode) queue.poll();
            if(temp != null) {
                BinaryNode sibling = (BinaryNode) queue.peek();
                temp.setNextSibling(sibling);
                if(temp.getLeft() != null)
                    queue.add(temp.getLeft());
                if(temp.getRight() != null)
                    queue.add(temp.getRight());
            }
            if(queue.isEmpty())
                break;
            if(temp == null)
                queue.add(temp);
        }
        show(root);
    }
    private static void show(BinaryNode root){
        if(root!= null ) {
            if(root.getNextSibling() != null)
                System.out.println(root.getNextSibling().getData());
            show(root.getLeft());
            show(root.getRight());
        }
    }

}
public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTee binaryTee = new BinaryTee();
//        BinaryTee binaryNode2 = new BinaryTee();
//        System.out.println("\nPreOrder Traversal of BinaryTree");
//        binaryTee.preOrderTraversal();
//        System.out.println("\nMaximum element is" + binaryTee.findMax());
//        System.out.println("\nReverse Level Order traversal is");
//        binaryTee.reverseLevelOrder();
//        System.out.println("\nHeight of the tree is " + binaryTee.height(binaryTee.getBinaryNode()));
//        System.out.println(BinaryTee.isStructurallyIdentical(binaryTee.getBinaryNode(),binaryNode2.getBinaryNode()));
//        binaryTee.maxSumLevel();
//        int [] array = new int[10];
//        binaryTee.rootToLeafPath(binaryTee.getBinaryNode(), 0, array);
//
//        System.out.println("\n" + binaryTee.isPathExistWithGivenSum(binaryTee.getBinaryNode(),10));
//
//        System.out.println("\nTotal sum of the elements is\t" + binaryTee.toalSum(binaryTee.getBinaryNode()));
//
//        System.out.println("Mirror Tree");
//        binaryTee.mirror();

//        binaryTee.findAncetor(2);
//        binaryTee.zigzagTraversal(binaryTee.getBinaryNode());

        binaryTee.nextSibling(binaryTee.getBinaryNode());

    }
}
