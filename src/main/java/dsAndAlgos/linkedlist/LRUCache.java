package dsAndAlgos.linkedlist;

import java.util.HashMap;
import java.util.Map;

import dsAndAlgos.linkedlist.DoublyLinkedList.DoublyNode;

public class LRUCache {

    Map<Integer, String> cacheMap;
    DoublyLinkedList dll;
    int capacity = 0;

    public LRUCache(int capacity) {
        cacheMap = new HashMap(capacity);
        dll = new DoublyLinkedList();
        this.capacity = capacity;
    }

    public void put(Integer key, String value) {

        if(cacheMap.containsKey(key))
            dll.delete(new DoublyNode(key));
        else if(cacheMap.size() >= capacity) dll.delete(dll.tail);

        cacheMap.put(key, value);
        dll.insertHead(new DoublyNode(key));
    }

    public String get(Integer key) {
        String value = cacheMap.get(key);
        if(value == null) return value;

        dll.delete(new DoublyNode(key));
        dll.insertHead(new DoublyNode(key));

        return value;
    }

    public void printList() {
        dll.printLinkedList();
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(5);

        cache.put(2, "Two");
        cache.put(5, "Five");
        cache.put(1, "One");

        cache.printList();
        cache.put(6, "Six");
        cache.put(18, "Eighteen");
        cache.put(1, "One");
        cache.put(7, "Seven");
        cache.printList();
        cache.get(1);
        cache.printList();

        cache.get(6);
        cache.printList();
        cache.put(13, "Thirteen");
        cache.printList();
    }
}
