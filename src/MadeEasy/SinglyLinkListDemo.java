package MadeEasy;

/**
 * Created by riyaz on 20/6/15.
 */

class Node {
    int data;
    Node next;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
class SinglyLinkList {
    Node sll;

    Node newNode (int data) {
        Node temp = new Node();
        temp.setData(data);
        temp.setNext(null);
        return temp;
    }

    void addNode(int data){
        if(sll == null)
            sll = newNode(data);
        else
            this.findNext().setNext(newNode(data));
    }

    Node findNext() {
        Node iterator = this.sll;
        while(iterator.getNext() != null)
            iterator = iterator.getNext();

        return  iterator;
    }
    void show() {
        Node iterator = this.sll;
        while(iterator != null) {
            System.out.println(iterator.getData());
            iterator = iterator.getNext();
        }
    }
}
public class SinglyLinkListDemo {
    public static void main(String[] args) {
        SinglyLinkList ll = new SinglyLinkList();
        ll.addNode(10);
        ll.addNode(20);
        ll.addNode(30);
        System.out.println("Here is the input link list");
        ll.show();
    }
}
