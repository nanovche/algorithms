package leetcode;


import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {

    private final LinkedHashMap<Integer, Integer> cache;
    private final int capacity;

    public LRUCache(int capacity) {
        this.cache = new LinkedHashMap<>(capacity, 0.75f, true);
        this.capacity = capacity;
    }
    public int get(int key) {
        Integer value = cache.get(key);
        if(value == null) {
            return -1;
        }
        return (int)value;
    }

    public void put(int key, int value) {

        cache.put(key, value);
        if(cache.size()  > capacity){
            Iterator<Map.Entry<Integer,Integer>> entryIterator = cache.entrySet().iterator();
            if(entryIterator.hasNext()){
                entryIterator.next();
                entryIterator.remove();
            }
        }
    }
}
