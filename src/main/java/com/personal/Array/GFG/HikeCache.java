package main.java.com.personal.Array.GFG;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


interface Cache<K, V> {
    void put(K key, V value);

    V get(K key);
}

class Node<K, V> {
    K key;
    V value;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache<K, V> implements Cache<K, V> {
    LinkedList<Node> linkedList = new LinkedList<>();
    int capacity;
    Map<K, Node> hashMap = new HashMap<>();

    LRUCache(int size) {
        capacity = size;
    }

    public V get(K key) {
        Node valueNode = null;
        if (hashMap.containsKey(key)) {
            valueNode = hashMap.get(key);
            adjustLinklist(valueNode);
        }
        return valueNode == null ? null : (V) valueNode.value;
    }
    public synchronized void removeLinklist(Node node) {
        linkedList.remove(node);
    }
    public synchronized void addAtfrontLinkList(Node node) {
        linkedList.remove(node);
    }
    public synchronized Node removeFromLast() {
        return linkedList.removeLast();
    }
    public void adjustLinklist(Node node) {
        synchronized (linkedList) {
            removeLinklist(node);
            addAtfrontLinkList(node);
        }
    }


    public synchronized void insertInAbsentKeyHashMap(K key, V value) {
        if(hashMap.containsKey(key)) {
            insertInPresentKeyHashMap(key, value);
            return;
        }
        if(hashMap.size() == capacity) {
            Node lruNode = removeFromLast();
            hashMap.put((K)lruNode.key, null);
        }
        Node newNode = new Node(key,value);
        hashMap.put(key, newNode);
        addAtfrontLinkList(newNode);
    }
    public synchronized void insertInPresentKeyHashMap(K key, V value) {
        Node node = hashMap.get(key);
        if (node != null) {
            node.value = value;
            adjustLinklist(node);
        } else {
            insertInAbsentKeyHashMap(key, value);
        }
    }
    public void put(K key, V value) {
            if (hashMap.containsKey(key)) {
                insertInPresentKeyHashMap(key, value);
            } else {
                insertInAbsentKeyHashMap(key, value);
            }
    }
}

public class HikeCache {

    public static void main(String[] args) {
        System.out.println("Cache Testing 1 with Integer arguments");
        Cache<Integer, Integer> cache = new LRUCache(10);
        cache.put(1, 10);
        cache.put(2, 20);
        cache.put(3, 30);
        System.out.println(cache.get(3));
        System.out.println(cache.get(2));
        System.out.println(cache.get(10));

        System.out.println("Cache Testing 2 with String arguments");
        Cache<String, String> cache1 = new LRUCache<>(10);
        cache1.put("Riyaz", "Ali");
        System.out.println(cache1.get("Riyaz"));
        System.out.println(cache1.get("snapdeal"));


        System.out.println("Cache Testing 3 with different arguements");
        Cache<String, Integer> cache3 = new LRUCache<>(10);
        cache3.put("Delhi", 1);
        cache3.put("Lucknow", 2);
        System.out.println(cache3.get("Lucknow"));
        System.out.println(cache3.get("Chennai"));
    }
}
