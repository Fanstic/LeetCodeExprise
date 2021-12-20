package com.tusk.cache;

import javax.security.auth.kerberos.KerberosKey;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentNavigableMap;

/**
 * @author tusk
 * @desc
 * LRU(Least Recently Used),缓存实现，当缓存满时，移除最久没有使用过的元素
 * @date 2021/12/18 10:02
 */
public class LRUCache {
    Map<String, Integer> container = new LinkedHashMap<>();

    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public Integer get(String key) {
        if (!container.containsKey(key)) {
            return -1;
        }

        makeRecently(key);
        return container.get(key);
    }

    /**
     * 新增元素，缓存已满，删除队头元素
     * 插入队列尾
     *
     * @param key
     * @param value
     */
    public void put(String key, Integer value) {
        if (container.size() >= capacity) {
            String oldKey = container.keySet().iterator().next();

            container.remove(oldKey);
        }

        if (container.containsKey(key)) {
            container.put(key, value);
            makeRecently(key);
            return;
        }

        container.put(key, value);
    }

    /**
     * 最近操作的元素删除后重新插入队尾
     * @param key
     */
    private void makeRecently(String key) {
        int val = container.get(key);
        container.remove(key);
        container.put(key, val);
    }


}
