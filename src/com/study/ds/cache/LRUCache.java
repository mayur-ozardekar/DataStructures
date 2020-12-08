package com.study.ds.cache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU Cache
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache. It
 * should support the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1. put(key, value) - Set or insert the
 * value if the key is not already present. When the cache reached its capacity,
 * it should invalidate the least recently used item before inserting a new
 * item.
 *
 * The cache is initialized with a positive capacity.
 *
 * Follow up: Could you do both operations in O(1) time complexity?
 *
 */
public class LRUCache {

    Map<Integer, Integer> cache;
    int capacity = 0;

    public LRUCache(int capacity) {
        this.cache = new LinkedHashMap<>(capacity);
        this.capacity = capacity;
    }

    public void put(int key, int val) {

        if (capacity == cache.size()) {
            Map.Entry<Integer, Integer> entry = cache.entrySet().iterator().next();
            int first = entry.getKey();
            cache.remove(first);
        }

        cache.put(key, val);
    }

    public int get(int key) {
        int result = -1;

        if(cache.containsKey(key)){
            result = cache.get(key);
            if (capacity == cache.size()) {
                cache.remove(key);
                cache.put(key, result);
            }
        }

        return result;
    }

    @Override
    public String toString() {
        return "LRUCache{" +
                "cache=" + cache +
                ", count=" + capacity +
                '}';
    }
}

class MainTest {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1, 3);
        lruCache.put(2, 5);
        lruCache.put(4, 8);
        System.out.println(lruCache);
        System.out.println(lruCache.get(2));
        System.out.println(lruCache);
        lruCache.put(6, 10);
        lruCache.put(8, 12);
        System.out.println(lruCache);
    }
}
