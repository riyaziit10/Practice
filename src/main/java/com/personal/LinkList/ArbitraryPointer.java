package LinkList;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by riyaz on 28/6/15.
 */
class Node {
    private  int data;
    private Node next;
    private Node arbitrary;

    public Node(int data) {
        this.data = data;
        next = null;
        arbitrary=null;
    }

    public Node() {
    }

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

    public Node getArbitrary() {
        return arbitrary;
    }

    public void setArbitrary(Node arbitrary) {
        this.arbitrary = arbitrary;
    }
}

public class ArbitraryPointer {
    Node linklist;

    public ArbitraryPointer(Node linklist) {
        this.linklist = linklist;
    }

    private Node newNode(int element) {
        Node temp = new Node();
        temp.setData(element);
        temp.setNext(null);
        temp.setArbitrary(null);
        return temp;
    }
    ArbitraryPointer() {
        linklist = newNode(10);
        linklist.setNext(newNode(50));
        linklist.getNext().setNext(newNode(30));
    }
    public static void show(Node linklist) {
        Node temp = linklist;
        while(temp != null) {
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }

    ArbitraryPointer cloneLinkList() {
        Node currLL = this.linklist, cloneLL = null;
        Map<Node, Node> hashMap = new HashMap<Node, Node>();
        while(currLL != null){
            Node cloneNode = new Node(currLL.getData());
            hashMap.put(currLL, cloneNode);
            currLL = currLL.getNext();
        }
        currLL = this.linklist;

        while(currLL != null) {
            cloneLL = hashMap.get(currLL);
            cloneLL.setNext(hashMap.get(currLL.getNext()));
            cloneLL.setArbitrary(hashMap.get(currLL.getArbitrary()));
            currLL = currLL.getNext();
        }

        return new ArbitraryPointer(hashMap.get(this.linklist));
    }
    public static void main(String[] args) {
        ArbitraryPointer ap = new ArbitraryPointer();
        System.out.println("Clone of the link list");
        ArbitraryPointer cloneLL = ap.cloneLinkList();
        show(cloneLL.linklist);
    }
}
