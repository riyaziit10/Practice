package LinkList;

/**
 * Created by riyaz on 5/7/15.
 */
public class KthNodeFromTheEnd {
    static class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
    static void show(Node head){
        if(head == null){
            System.out.println("Link list is empty");
            return;
        }
        Node iterator = head;
        while(iterator != null) {
            System.out.print(iterator.data + " ");
            iterator = iterator.next;
        }
            System.out.println();

    }
    static void KthNodeFromEnd(Node head, int k) {
        if(head == null){
            System.out.println("LinkList is Empty");
            return;
        }
        Node forward = head;
        int i = 0;
        while( i < k && forward != null){
            forward = forward.next;
            ++i;
        }
        if(i < k && forward == null) {
            System.out.println("There are no enough node");
            return;
        }
        Node KthNode = head;
        while(forward != null){
            forward = forward.next;
            KthNode = KthNode.next;
        }
        if(KthNode != null)
            System.out.println(KthNode.data);
    }
    public static void main(String[] args) {
        Node a = new Node(10);
        Node b = new Node(20);
        Node c = new Node(30);
        Node d = new Node(40);
        Node e = new Node(50);
        Node f = new Node(60);
        Node g = new Node(70);
        Node h = new Node(80);
        Node i = new Node(90);
        Node j = new Node(100);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        g.next = h;
        h.next = i;
        i.next = j;
        show(a);
        for(int m  = 0; m < 15; ++m)
            KthNodeFromEnd(a,m);

    }
}
