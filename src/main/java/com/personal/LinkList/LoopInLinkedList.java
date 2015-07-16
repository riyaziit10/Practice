package LinkList;

/**
 * Created by riyaz on 5/7/15.
 */
public class LoopInLinkedList {
    static class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
   static void show(Node head){
        if(head == null){
            System.out.println("Link List is Empty");
            return;
        }
        Node iterator = head;
        while(iterator != null){
            System.out.print(iterator.data + " ");
            iterator = iterator.next;
        }
    }

    static boolean isLoopExist(Node head){
        if(head == null){
            return false;
        }
        Node slow = head;
        Node fast = head;
        boolean isLooped=false;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                isLooped = true;
                break;
            }
        }
        if(isLooped == false)
            return false;
        slow = head;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;

        }
        System.out.println(slow.data);
        return true;
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
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        g.next = h;
        h.next = i;
        i.next = d;
//        show(a);
        System.out.println(isLoopExist(a));
    }
}
