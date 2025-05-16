package LLD.Cache;

import java.util.HashMap;

public class LRU {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.put(1, 10);
        cache.put(2, 20);
        cache.put(3, 30);
        System.out.println(cache.get(1)); // 10
        cache.put(4, 40); // evicts key 2
        System.out.println(cache.get(2)); // -1
        cache.put(5, 50); // evicts key 3
        System.out.println(cache.get(3)); // -1
        System.out.println(cache.get(1)); // 10
        System.out.println(cache.get(4)); // 40
        System.out.println(cache.get(5)); // 50
    }
}
class LRUCache{
    private  final int capacity;
    private final HashMap<Integer,Node> map;
    private final Node head,tail;
    LRUCache(int size){
        this.capacity=size;
        this.map=new HashMap<>();
        this.head=new Node(0,0);
        this.tail=new Node(0,0);
        head.next = tail;
        tail.prev = head;

    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            //update
            Node node = map.get(key);
            node.value = value;
            removeLRU(node);
            insertToTail(node);
        }else{
            if(map.size()==capacity){
                Node lru=head.next;
                removeLRU(lru);
                map.remove(lru.key);
            }
            Node newNode=new Node(key,value);
            map.put(key,newNode);
            insertToTail(newNode);
        }
    }

    private void insertToTail(Node newNode) {
        Node prev=tail.prev;
        prev.next=newNode;
        newNode.prev=prev;
        newNode.next=tail;
        tail.prev=newNode;
    }

    private void removeLRU(Node lru) {
        lru.prev.next=lru.next;
        lru.next.prev=lru.prev;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        removeLRU(node);
        insertToTail(node);
        return node.value;

    }
}

class Node{
    int key , value;
    Node next,prev;
    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}