package main.java.com.personal.Tree;

/**
 * Created by riyaz on 4/8/15.
 */
public class DistributedSystemSum {
    private static volatile boolean startFlag = false;

    private static class Node {
        int value;
        Node left;
        Node right;
        Node parent;
        int sum = 0;
        int receiveCount = 0;

        public Node(int value) {
            this.value = value;
            NodeRunner nodeRunner = new NodeRunner(this, value);
            new Thread(nodeRunner).start();
        }

        public synchronized void send(Integer data) {
            sum += data;
            ++receiveCount;
        }

        public synchronized int getReceiveCount() {
            return receiveCount;
        }
    }

    public static class NodeRunner implements Runnable {
        Node node;
        int id;

        public NodeRunner(Node node, int id) {
            this.node = node;
            this.id = id;
        }

        @Override
        public void run() {
            while (!DistributedSystemSum.startFlag) {
//                System.out.println("Waitign for notify");
            }
            int childCount = 0;
            if(node.left != null)
                ++childCount;
            if(node.right != null)
                ++childCount;
            while(node.getReceiveCount() != childCount){
//                System.out.println("Waiting for child count");            //waiting for child node to finish their process;
            }

            int sum = node.sum +  node.value;
            node.sum = 0;
            if(node.parent != null) {
                node.parent.send(sum);
                while(node.getReceiveCount() != childCount + 1){
//                    System.out.println("waiting for sum");
                }
            } else {
                node.sum = sum;
            }
            if(node.left != null)
                node.left.send(node.sum);
            if(node.right != null)
                node.right.send(node.sum);
            System.out.println("Thread \t" + id + "sum \t" + node.sum);
        }
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);
        Node h = new Node(8);
        a.left = b;
        b.parent = a;
        a.right = c;
        c.parent = a;
        b.left = d;
        d.parent = b;
        c.left = e;
        e.parent = c;
        c.right = f;
        f.parent = c;
        f.left = g;
        g.parent = f;
        f.right = h;
        h.parent = f;
        startFlag = true;
    }
}
