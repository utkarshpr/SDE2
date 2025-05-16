package LLD.Cache;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFU {
    public static void main(String[] args) {
        LFUCache lfu = new LFUCache(2);
        lfu.put(1, 1);
        lfu.put(2, 2);
        System.out.println(lfu.get(1)); // returns 1
        lfu.put(3, 3); // evicts key 2
        System.out.println(lfu.get(2)); // returns -1
        System.out.println(lfu.get(3)); // returns 3
    }
}
class LFUCache{
    private final int capacity;
    private  int minfreq;
    private final HashMap<Integer,Node1> map;
    private final HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;

    LFUCache(int capacity){
        this.capacity=capacity;
        this.minfreq=0;
        this.map=new HashMap<>();
        this.freqToKeys=new HashMap<>();
    }

    public void put(int key, int val) {
        if(map.containsKey(key)){
            Node1 node =map.get(key);
            updateFreq(node);
            node.value=val;
        }else{
            if (map.size() >= capacity) {
                evictLFU();
            }
            Node1 node=new Node1(key,val);
            map.put(key,node);
            freqToKeys.computeIfAbsent(1,k-> new LinkedHashSet<>()).add(node.key);
            minfreq=1;
        }
    }

    private void evictLFU() {
        LinkedHashSet<Integer> keys=freqToKeys.get(minfreq);
        int evictKey= keys.getFirst();
        keys.remove(evictKey);
        if(keys.isEmpty())freqToKeys.remove(minfreq);
        map.remove(evictKey);

    }

    private void updateFreq(Node1 node) {
        int freq=node.freq;
        freqToKeys.get(freq).remove(node.key);
        if(freqToKeys.get(freq).isEmpty()){
            freqToKeys.remove(freq);
            if(minfreq==freq)minfreq++;
        }
        node.freq++;
        freqToKeys.computeIfAbsent(node.freq,k-> new LinkedHashSet<>()).add(node.key);
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node1 node = map.get(key);
        updateFreq(node);
        return node.value;
    }
}

class Node1 {
    int key, value, freq;
    Node1(int key, int value) {
        this.key = key;
        this.value = value;
        this.freq = 1;
    }
}