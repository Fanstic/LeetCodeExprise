package com.tusk.cache;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * @author tusk
 * @desc LFU(Least Frequently Used), 当缓存满时移除最近使用次数最少的元素，
 * 使用次数最少的可能会有多个，这时候需要移除早旧未使用的那个
 * @date 2021/12/20 10:48
 */
public class LFUCache {
    //维护 Frequence 到 keys的关系
    private Map<Integer, LinkedHashSet<String>> freToKeys = new HashMap<>();

    //维护key到value的映射关系
    private Map<String, Integer> keyToVal = new HashMap<>();

    //维护key到 fre的关系
    private Map<String, Integer> keyToFre = new HashMap<>();
    private int capacity;

    //最小频率
    private int minFreq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        minFreq = 0;
    }

    public static void main(String[] args) {

    }

    public void put(String key, Integer value) {
        keyToVal.put(key, value);
        keyToFre.put(key, keyToFre.getOrDefault(key, 0) + 1);

        int newFreq = keyToFre.get(key);
        if (!freToKeys.containsKey(newFreq)) {
            LinkedHashSet<String> keySet = new LinkedHashSet<>();
            keySet.add(key);

            freToKeys.put(newFreq, keySet);
        } else {
            freToKeys.get(newFreq).add(key);
        }

        if (keyToVal.size() >= capacity) {
            LinkedHashSet<String> set = freToKeys.get(minFreq);

            String targetKey = set.iterator().next();
            keyToVal.remove(targetKey);
            keyToFre.remove(targetKey);
        }
    }

    public Integer get(String key) {
        if (!keyToVal.containsKey(key)) {
            return -1;
        }

        int oldFre = keyToFre.getOrDefault(key, 0);
        int newFre = oldFre + 1;
        keyToFre.put(key, newFre);

        if (freToKeys.containsKey(newFre)) {
            freToKeys.get(newFre).add(key);
        } else {
            LinkedHashSet<String> set = new LinkedHashSet<>();
            set.add(key);
            freToKeys.put(newFre, set);
        }

        if (newFre < minFreq) {
            minFreq = newFre;
        }
        return keyToVal.get(key);
    }


}
