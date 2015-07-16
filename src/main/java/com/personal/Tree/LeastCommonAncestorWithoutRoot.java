package main.java.com.personal.Tree;

import java.util.HashSet;

/**
 * Created by riyaz on 15/7/15.
 */
class NodeWithParent
{
    public NodeWithParent parent;
    public int value;
    public NodeWithParent left;
    public NodeWithParent right;

    public NodeWithParent(int value)
    {
        this.value=value;
    }

}
public class LeastCommonAncestorWithoutRoot {
    static void inorder(NodeWithParent root) {
        if(root != null) {
            inorder(root.left);
            System.out.println(root.value);
            inorder(root.right);
        }
    }

    static void LCAwithoutRoot(NodeWithParent k1, NodeWithParent k2) {
        if(k1 == null || k2 == null) {
            System.out.println("NOT POSSIBLE");
            return;
        }
        HashSet<NodeWithParent> set = new HashSet<NodeWithParent>();
        while(k1!= null) {
                set.add(k1);
            k1 = k1.parent;
        }

        while(k2!= null) {
            if(set.contains(k2)) {
                System.out.println("LCA is \t" + k2.value);
                return;
            }
            k2 = k2.parent;
        }
        System.out.println("LCA is not possible");
    }
    public static void main(String[] args) {
        NodeWithParent a=new NodeWithParent(5);
        NodeWithParent b=new NodeWithParent(6);
        NodeWithParent c=new NodeWithParent(7);
        NodeWithParent d=new NodeWithParent(8);
        NodeWithParent e=new NodeWithParent(9);
        a.left=b;
        b.parent=a;
        b.left=c;
        c.parent=b;
        b.right=d;
        d.parent=b;
        d.right=e;
        e.parent=d;

        System.out.println("==============inorder traversal==================");
//        inorder(a);
        LCAwithoutRoot(c,a);
    }
}
