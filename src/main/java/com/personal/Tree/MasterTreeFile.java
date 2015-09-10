package main.java.com.personal.Tree;

import java.util.*;

/**
 * Created by riyaz on 1/9/15.
 */
public class MasterTreeFile {
    private static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return this.data == ((Node) obj).data;
        }
    }

    private static void inorderTraversal(Node root) {
        if (root == null)
            return;
        inorderTraversal(root.left);
        System.out.print(root.data + "\t");
        inorderTraversal(root.right);
    }

    private static void getMinimum(Node root, Integer[] minimum) {
        if (root == null)
            return;

        if (root.data < minimum[0])
            minimum[0] = root.data;
        getMinimum(root.left, minimum);
        getMinimum(root.right, minimum);

    }

    private static void getMinimumInBST(Node root, Integer[] minimum) {
        if (root == null)
            return;
        getMinimumInBST(root.left, minimum);
        if (root.left == null)
            minimum[0] = root.data;
    }

    private static void levelOrderTraversal(Node root) {
        System.out.println("Level Order Traversal of Tree");
        if (root == null)
            return;
        Queue<Node> queue = new LinkedList<Node>();

        Node marker = new Node(-1);
        queue.add(root);
        queue.add(marker);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if (temp.data == marker.data) {
                System.out.println();
                if (queue.isEmpty())
                    break;
                queue.add(temp);
            } else {
                System.out.print(temp.data + "\t");
                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
            }
        }
    }

    private static int countLeafNodes(Node root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        return countLeafNodes(root.left) + countLeafNodes(root.right);
    }

    private static boolean isBST(Node root, int min, int max) {
        if (root == null)
            return true;
        if (root.data > min && root.data < max && isBST(root.left, min, root.data) && isBST(root.right, root.data, max))
            return true;
        return false;
    }

    private static void spiralOrderTraversal(Node root) {
        System.out.println("Spiral order traversal");
        if (root == null)
            return;
        Stack<Node> stack1 = new Stack<Node>();
        Stack<Node> stack2 = new Stack<Node>();
        boolean levelOrderflag = true;
        stack1.push(root);
        while (!stack1.isEmpty()) {
            Node temp = stack1.pop();
            System.out.print(temp.data + "\t");
            if (levelOrderflag) {
                if (temp.right != null)
                    stack2.push(temp.right);
                if (temp.left != null)
                    stack2.push(temp.left);
            } else {
                if (temp.left != null)
                    stack2.push(temp.left);
                if (temp.right != null)
                    stack2.push(temp.right);
            }
            if (stack1.isEmpty()) {
                Stack s = stack1;
                stack1 = stack2;
                stack2 = s;
                levelOrderflag = !levelOrderflag;
                System.out.println();
            }
        }
    }

    private static void childSumProperty(Node root) {
        if (root == null)
            return;
        childSumProperty(root.left);
        childSumProperty(root.right);
        if (root.left == null && root.right == null)
            return;
        int childSum = (root.left != null ? root.left.data : 0) + (root.right != null ? root.right.data : 0);
        if (root.data < childSum) {
            root.data = childSum;
            return;
        } else if (root.data > childSum) {
            if (root.left.data < root.right.data) {
                root.left.data = root.data - root.right.data;
                childSumProperty(root.left);
            } else {
                root.right.data = root.data - root.left.data;
                childSumProperty(root.right);
            }
        }
    }

    private static boolean isSumTree(Node root) {
        if (root == null)
            return true;
        if (!isSumTree(root.left) || !isSumTree(root.right))
            return false;
        if (root.left == null && root.right == null)
            return true;
        else {
            int leftValue = root.left != null ? root.left.data : 0;
            int rightValue = root.right != null ? root.right.data : 0;
            int childSum = leftValue + rightValue;
            if (childSum == root.data) {
                root.data += childSum;
                return true;
            } else {
                return false;
            }
        }
    }

    private static void printBSTGivenRange(Node root, int k1, int k2) {
        if (root == null)
            return;
        if (k1 < root.data)
            printBSTGivenRange(root.left, k1, k2);
        if (root.data >= k1 && root.data <= k2)
            System.out.print(root.data + "\t");
        if (k2 > root.data)
            printBSTGivenRange(root.right, k1, k2);
    }

    private static boolean printAncestors(Node root, int k) {
        if (root == null)
            return false;
        if (root.data == k)
            return true;
        if (printAncestors(root.left, k) || printAncestors(root.right, k)) {
            System.out.print(root.data + "\t");
            return true;
        }
        return false;
    }

    private static int getKthSmallestElement(Node root, int[] count, int k) {
        if (root == null)
            return -1;
        int result = getKthSmallestElement(root.left, count, k);
        if (count[0] != k) {
            ++count[0];
            if (count[0] == k)
                return root.data;
            return getKthSmallestElement(root.right, count, k);
        }else
            return result;
    }
    private  static boolean globalflag = false;
    private  static Integer result = null;
    private static void getInorderSuccessor(Node root, int k) {
        if(root == null)
            return;
        if(result == null)
            getInorderSuccessor(root.left, k);
        if(!globalflag) {
            if(root.data == k) {
                globalflag = true;
            }
            getInorderSuccessor(root.right, k);
        } else if(globalflag && result == null) {
            result = root.data;
            return;
        }
    }

    private static boolean isRootToLeafPath(Node root, int sum , int currentSum) {
        if(root == null) {
            return sum == 0;
        }
        currentSum += root.data;
        if(root.left == null && root.right == null) {
            return currentSum == sum;
        }
        if(isRootToLeafPath(root.left, sum, currentSum) || isRootToLeafPath(root.right, sum, currentSum))
            return true;
        return false;
    }

    private static Node getDoubleTree(Node root) {
        if(root == null)
            return null;
        Node doubleTree = new Node(root.data);
        doubleTree.left = new Node(root.data);
        doubleTree.left.left = getDoubleTree(root.left);
        doubleTree.right = getDoubleTree(root.right);
        return doubleTree;
    }

    private static boolean hasOnlyOneChild(int arr[]) {
        if (arr == null || arr.length <= 1)
            return true;
        int length = arr.length;
        for (int i = 0; i < length; ++i) {
            if (!((i + 1 >= length || arr[i] > arr[i + 1] && (i + 2 >= length || arr[i] > arr[i + 2])))){
                if (!((i + 1 >= length || arr[i] < arr[i + 1] && (i + 2 >= length || arr[i] < arr[i + 2]))))
                    return false;
            }
        }
            return true;
        }

    public static Node constructTree(int [] pre, char [] preLN, Integer[] index) {
        if(index[0] >= pre.length)
            return null;

        Node root = new Node(pre[index[0]]);
        if(preLN[index[0]++] == 'N') {
            root.left = constructTree(pre, preLN, index);
            root.right = constructTree(pre, preLN , index);
        }
        return root;
    }
    public static void preOrderTraversal(Node root) {
        if(root == null)
            return;
        System.out.println(root.data);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
    private  static void verticalSumUtil(Node root, Map<Integer, Integer> hashMap, int index) {
        if(root == null)
            return;
        int sum = hashMap.get(index) == null ? 0 : hashMap.get(index);
        hashMap.put(index, sum + root.data);
        verticalSumUtil(root.left, hashMap, index - 1);
        verticalSumUtil(root.right, hashMap, index + 1);
    }
    public static void verticalSum(Node  root) {
        if(root == null)
            return;
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

        verticalSumUtil(root, hashMap, 0);
        if(hashMap != null) {
            System.out.println(hashMap.entrySet());
        }

    }

    private static int largestBSTSubtree(Node root, int min, int max, int [] curr_count, int []max_count, boolean []isBST) {
        if(root == null)
            return 0;
        boolean [] flag = {true};
        int minimum = Integer.MIN_VALUE;
        int maximum = Integer.MAX_VALUE;
        int h1 = largestBSTSubtree(root.left, minimum, root.data, curr_count, max_count, flag);
        int h2 = largestBSTSubtree(root.right, root.data, maximum, curr_count, max_count, flag);
        if(root.data > min && root.data < max && flag[0] == true){
            curr_count[0] = h1 + h2 + 1;
            if(curr_count[0] > max_count[0])
                max_count[0] = curr_count[0];
            return curr_count[0];
        } else {
            isBST[0] = false;
            curr_count[0] = 0;
            return 0;
        }

    }

    private static void boundryLevelTraversal(Node root) {
        if(root==null)
            return;
        printLeftView(root);
        printLeafNode(root);
        printRightView(root);
    }

    private static void printLeftView(Node root) {
        if(root == null)
            return;
        if(root.left!= null)
            System.out.print(root.data + " \t");
        printLeftView(root.left);


    }

    private static void printLeafNode(Node root) {
        if(root == null)
            return;
        if(root.left == null && root.right == null)
            System.out.print(root.data + " \t");
        printLeafNode(root.left);
        printLeafNode(root.right);
    }

    private static void printRightView(Node root) {
        if(root == null || root.right == null)
            return;
        printRightView(root.right);
//        if (root.right != null)
            System.out.print(root.data + "\t");
    }


    private static boolean isSameArray(int [] arr1, int [] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        if(Arrays.equals(arr1, arr2))
            return true;
        return false;
    }

    private static  Node createBSTfromPreorder(int [] arr, int i, int min ,int max) {
        if( i >= arr.length)
            return null;
        int length = arr.length;
        int k = i;
        for(; k < length; ++k) {
            if(min < arr[k] && arr[k] < max)
                break;
        }
        if(k == length)
            return null;
        Node root = new Node(arr[k]);
        root.left = createBSTfromPreorder(arr, k + 1, min, arr[k]);
        root.right = createBSTfromPreorder(arr, k + 1, arr[k], max);
        return root;
    }

//    public static int resultFloor = -1;
//    private static void getFloor(Node root, int k) {
//        if(root == null)
//            return;
//       getFloor(root.left, k);
//
//        if( root.data <= k )
//            resultFloor = root.data;
//
//        getFloor(root.right, k);
//
//    }

    private static int getFloor(Node root, int k) {
        if (root == null)
            return -1;

        if(k == root.data)
            return root.data;
        if(k < root.data)
            return getFloor(root.left,k);

        int floor = getFloor(root.right, k);

        return floor <= k ? floor >= root.data ? floor : root.data : floor;
//        return floor <= k ? root.data : floor;
    }


    private static int getCeil(Node root, int k) {
        if(root == null)
            return -1;
        if( k == root.data)
            return root.data;
        if(root.data < k)
            return getCeil(root.right, k);
        int ceil = getCeil(root.left, k);
        return (ceil >= k ? ceil : root.data);
    }

    public static Node pruneTree(Node root, int k) {
        if(root == null )
            return null;
        if( k < 0)
            return root;
        root.left = pruneTree(root.left, k - root.data);
        root.right = pruneTree(root.right, k - root.data);

        if(root.left == null && root.right == null && k - root.data > 0)
            return null;

        return root;
    }


    public static Node deleteOutsideGivenRange(Node root, int min , int max) {
        if(root == null)
            return null;

        root.left = deleteOutsideGivenRange(root.left, min, max);
        root.right = deleteOutsideGivenRange(root.right, min, max);

        if(root.data < min || root.data > max) {
            if(root.left == null && root.right == null)
                return  null;
            else
                return root.left != null ? root.left : root.right;
        }
        return root;
    }

    public static void digonalSum(Node root, int level, Map<Integer, Integer> sum) {
        if(root == null)
            return;
        if(!sum.containsKey(level)) {
            sum.put(level, root.data);
        } else {
            sum.put(level, sum.get(level) + root.data);
        }

        digonalSum(root.left, level + 1, sum);
        digonalSum(root.right, level, sum);
    }


    private static int getMaximumPathSumBetweenLEaves(Node root, int res[]) {
        if(root == null)
            return 0;
        if(root.left == null  && root.right == null)
            return root.data;
        int leftSum = 0 ;
        int rightSum = 0 ;
        leftSum = getMaximumPathSumBetweenLEaves(root.left, res);
        rightSum = getMaximumPathSumBetweenLEaves(root.right, res);

        int current_sum = leftSum + rightSum + root.data;
        if(current_sum > res[0])
            res[0] = current_sum;

        if(root.left == null || root.right == null) {
            return root.left == null ? rightSum + root.data : leftSum + root.data;
        } else {
            return Math.max(leftSum, rightSum) + root.data;
        }
    }

    private static Node removeHalfNodes(Node root) {
        if (root == null)
            return null;
        if(root.left == null && root.right == null)
            return root;
        root.left = removeHalfNodes(root.left);
        root.right = removeHalfNodes(root.right);
        if(root.left == null || root.right == null)
            return root.left == null ? root.right : root.left;
        return root;
    }
    private static class TopViewNode {
        Node node;
        int level;

        public TopViewNode(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }


    public static void printTopView(Node root, int level, Map<Integer, Integer> result) {
        if(root==null)
            return;
        Queue<TopViewNode> queue = new LinkedList<TopViewNode>();
        queue.add(new TopViewNode(root, 0));
        while(!queue.isEmpty()) {
            TopViewNode temp = queue.poll();
            if(!result.containsKey(temp.level)) {
                result.put(temp.level, temp.node.data);
            }

            if(temp.node.left != null) {
                queue.add(new TopViewNode(temp.node.left, temp.level - 1));
            }
            if(temp.node.right != null) {
                queue.add(new TopViewNode(temp.node.right, temp.level + 1));
            }
        }
    }
    public static void main(String[] args) {
//        Node a = new Node(26);    //        20
//        Node b = new Node(10);     //    8        22
//        Node c = new Node(3);    //4     12
//        a.left = b;
//        a.right = c;
//        Node d = new Node(4);     //    10      14
//        Node e = new Node(6);    //
//        b.left = d;
//        b.right = e;
////        Node f = new Node(1);    //
//        Node g = new Node(3);    //
//        c.right = g;
//        c.left = f;
//        inorderTraversal(a);
//        Integer [] min = new Integer[1];
//        min[0] = Integer.MAX_VALUE;
//        getMinimum(a, min);
//        System.out.println();
//        System.out.println("Minimum value in the tree is \t" + min[0]);
//        getMinimumInBST(a, min);
//        System.out.println("Minimum in BST \t" + min[0]);
//        levelOrderTraversal(a);
//        System.out.println("is Sum \t" + isSumTree(a));
//        childSumProperty(a);
//        System.out.println("Afer Child Sum property");
//        levelOrderTraversal(a);

//        System.out.println("Number of leaf Nodes\t" + countLeafNodes(a));
//
//
//        Node aa = new Node(20);
//        Node bb = new Node(8);
//        Node cc = new Node(22);
//        aa.left = bb;
//        aa.right = cc;
//        Node dd = new Node(4);
//        Node ee = new Node(12);
//        bb.left = dd;
//        bb.right = ee;
//        Node ff = new Node(10);
//        Node gg = new Node(14);
//        ee.left = ff;
//        ee.right = gg;
//        inorderTraversal(aa);
//        int[] count = new int[1];
//        System.out.println(getKthSmallestElement(aa, count, 8));
//        getInorderSuccessor(aa, 15);
//        System.out.println(result);
//        System.out.println("Elements in given range");
//        printBSTGivenRange(aa, 10, 22);
//        printAncestors(aa, 12);
//        System.out.println("is Sum BST" + isSumTree(aa));
//
//        System.out.println("isBST\t" + isBST(aa, Integer.MIN_VALUE, Integer.MAX_VALUE));
//        spiralOrderTraversal(a);
//        System.out.println(isRootToLeafPath(aa, 43, 0));
//        System.out.println("Double tree");
////        inorderTraversal(getDoubleTree(aa));
//        int pre[] = {8, 3, 5, 7, 6};
//        System.out.println(hasOnlyOneChild(pre));
//        int arr1 [ ] = {8,4,2,7,3};
//        System.out.println(hasOnlyOneChild(arr1));
//        int arr2[] = {20,10,21,11};
//        System.out.println(hasOnlyOneChild(arr2));

//        int pre[] = {10, 30, 20, 5, 15};
//        char preLN[] = {'N', 'N', 'L', 'L', 'L'};
//        levelOrderTraversal(constructTree(pre, preLN,0));
//        inorderTraversal(constructTree(pre, preLN, 0));
//        Integer [] index = new Integer[1];
//        index[0] = 0;
//        preOrderTraversal(constructTree(pre, preLN, index));


//        inorderTraversal(aa);

//        verticalSum(aa);

//        Node a1 = new Node(5);
//        Node a2 = new Node(2);
//        Node a3 = new Node(4);
//        Node a4 = new Node(1);
//        Node a5 = new Node(3);
//        a1.left = a2;
//        a1.right = a3;
//        a2.left = a4;
//        a2.right = a5;
//        boolean [] flag = {false};
//        int [] curre_count = {0};
//        int []max_count = {0};
//        largestBSTSubtree(a1, Integer.MIN_VALUE, Integer.MAX_VALUE, curre_count, max_count, flag);
//        System.out.println("largest BST subtree in a1 \t" + max_count[0]);
//
//        Node a11 = new Node(50);
//        Node a12 = new Node(30);
//        Node a13 = new Node(60);
//        Node a14 = new Node(5);
//        Node a15 = new Node(20);
//        Node a16 = new Node(45);
//        Node a17 = new Node(70);
//        Node a18 = new Node(65);
//        Node a19 = new Node(80);
//        a11.left = a12;
//        a11.right= a13;
//        a12.left = a14;
//        a12 .right = a15;
//        a13.left = a16;
//        a13.right = a17;
//        a17.left = a18;
//        a17.right = a19;
//        inorderTraversal(a11);
//        largestBSTSubtree(a11, Integer.MIN_VALUE, Integer.MAX_VALUE, curre_count, max_count, flag);
//        System.out.println("largest BST subtree a11 \t" + max_count[0]);

        Node a21 = new Node(20);
        Node a22 = new Node(8);
        Node a23 = new Node(22);
        Node a24 = new Node(4);
        Node a25 = new Node(12);
        Node a26 = new Node(25);
        Node a27 = new Node(10);
        Node a28 = new Node(14);

        a21.left = a22;
        a21.right = a23;
        a22.left = a24;
        a22.right = a25;

        a25.left = a27;
        a25.right = a28;
        a23.right = a26;

//        inorderTraversal(a21);
//
//        boundryLevelTraversal(a21);

//        int arr1 [] = {2,4,1,3};
//        int arr2[] = {2,4,3,1};
//        System.out.println(isSameArray(arr1,arr2));
//        int arr3[] = {8, 3, 6, 1, 4, 7, 10, 14, 13,10};
//        int arr4[] = {8, 10, 14, 3, 6, 4, 1, 7, 13};
//        System.out.println(isSameArray(arr3,arr4));

//        int arr1[] = {10, 5, 1, 7, 40, 50};

//        inorderTraversal(createBSTfromPreorder(arr1, 0, Integer.MIN_VALUE, Integer.MAX_VALUE));

        Node a31 = new Node(8);
        a31.left = new Node(4);
        a31.right = new Node(12);

        a31.left.left = new Node(2);
        a31.left.right = new Node(6);


        a31.right.left = new Node(10);
        a31.right.right = new Node(14);

//        inorderTraversal(a31);

//        System.out.println();
//        for(int i = 0; i < 20; ++i) {
////        int i = 3;
//
//                System.out.println( i + "\t floor\t" +  getFloor(a31,i));
////                System.out.println( i + "\t Ceil\t" +  getCeil(a31,i));
//        }

        Node b1 = new Node (1);
        Node b2 = new Node (2);
        Node b3 = new Node (3);
        b1 .left = b2;
        b1.right = b3;
        Node b4 = new Node (4);
        Node b5 = new Node (5);
        b2.left = b4;
        b2.right = b5;
        Node b6 = new Node (6);
        Node b7 = new Node (7);
        b3.left = b6;
        b3.right = b7;
        Node b8 = new Node (8);
        Node b9 = new Node (9);
        b4.left = b8;
        b4.right = b9;
        Node b10 = new Node (10);
        Node b11 = new Node (11);
        Node b12 = new Node (12);
        b5.left = b12;
        Node b13 = new Node (13);
        b7.left = b10;
        b10.right = b11;
        b9.left = b13;
        Node b14 = new Node (14);
        b9.right = b14;
        Node b15 = new Node (15);
        b14.left = b15;
////        inorderTraversal(pruneTree(b1, 45));
//
//        inorderTraversal(deleteOutsideGivenRange(b1, 4, 15));


        Node c1 = new Node (1);
        Node c2 = new Node (2);
        Node c3 = new Node (3);
        c1.left = c2;
        c1.right = c3;
        Node c4 = new Node (9);
        Node c5 = new Node (6);
        c2.left = c4;
        c2.right = c5;
        Node c6 = new Node (4);
        Node c7 = new Node (5);
        c3.left = c6;
        c3.right = c7;
        Node c8 = new Node (10);
        c4.right = c8;
        Node c9 = new Node (11);
        c5.left = c9;
        Node c10 = new Node (12);
        Node c11 = new Node (7);
        c6.left = c10;
        c6.right = c11;
//        inorderTraversal(c1);
//
//        Map<Integer, Integer> sum = new HashMap<Integer, Integer>();
//        digonalSum(c1, 0, sum);
//        System.out.println(sum.values());


        Node root = new Node(-15);
        root.left = new Node(5);
        root.right = new Node(6);
        root.left.left = new Node(-8);
        root.left.right = new Node(1);
        root.left.left.left = new Node(2);
        root.left.left.right = new Node(6);
        root.right.left = new Node(3);
        root.right.right = new Node(9);
        root.right.right.right= new Node(0);
        root.right.right.right.left= new Node(4);
        root.right.right.right.right= new Node(-1);
        root.right.right.right.right.left= new Node(10);
//        int result[] = new int[1];
//        getMaximumPathSumBetweenLEaves(root, result);
//        System.out.println("Max pathSum of the given binary tree is " + result[0]);

        Node root1 = new Node(2);
        root1.left = new Node(7);
        root1.right = new Node(5);
        root1.left.right = new Node(6);
        root1.left.right.left=new Node(1);
        root1.left.right.right=new Node(11);
        root1.right.right=new Node(9);
        root1.right.right.left=new Node(4);

//        inorderTraversal(root1);
//
//        System.out.println("\nafter removal of half nodes");
//        inorderTraversal(removeHalfNodes(root1));

        Node  root3 = new Node(1);
        root3.left = new Node(2);
        root3.right = new Node(3);
        root3.left.right = new Node(4);
        root3.left.right.right = new Node(5);
        root3.left.right.right.right = new Node(6);
        inorderTraversal(root3);

        Map<Integer, Integer> result = new HashMap<Integer, Integer>();
        printTopView(root3, 0, result);
        System.out.println(result.values());






    }
}
