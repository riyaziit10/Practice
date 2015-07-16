package MadeEasy;

/**
 * Created by riyaz on 20/6/15.
 */

class DLLNode {
    int data;
    DLLNode next;
    DLLNode prev;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public DLLNode getNext() {
        return next;
    }

    public void setNext(DLLNode next) {
        this.next = next;
    }

    public DLLNode getPrev() {
        return prev;
    }

    public void setPrev(DLLNode prev) {
        this.prev = prev;
    }
}

class DoublyLinkList {
    DLLNode dll;

    DLLNode newNode(int data){
        DLLNode node = new DLLNode();
        node.setData(data);
        node.setNext(null);
        node.setPrev(null);
        return node;
    }

    void addInAsc(int data) {
        if(dll == null) {
            dll = newNode(data);
            return;
        }
        if(data < dll.getData()) {
            DLLNode newNode = newNode(data);
            newNode.setNext(dll);
            dll.setPrev(newNode);
            dll = newNode;
        } else {
            DLLNode iterator = dll;
            while(iterator.getNext() != null && data > iterator.getData()) {
                iterator = iterator.getNext();
            }
            if(iterator.getNext() ==  null && data > iterator.getData()) {
                DLLNode newNode = newNode(data);
                iterator.setNext(newNode);
                newNode.setPrev(iterator);
                return;
            }
            DLLNode node = newNode(data);
            iterator.getPrev().setNext(node);
            node.setPrev(iterator.getPrev());
            node.setNext(iterator);
            iterator.setPrev(node);
            return;
        }
    }
    void show() {
        DLLNode iterator = dll;
        while(iterator != null ) {
            System.out.println(iterator.getData());
            iterator = iterator.getNext();
        }
    }
}
public class DoublyLinkListDemo {
    public static void main(String[] args) {
        DoublyLinkList ll = new DoublyLinkList();
        ll.addInAsc(5);
        ll.addInAsc(1);
        ll.addInAsc(20);
        ll.addInAsc(18);
        ll.show();
    }
}
