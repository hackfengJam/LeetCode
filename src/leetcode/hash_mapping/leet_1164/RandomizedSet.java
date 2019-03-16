package leetcode.hash_mapping.leet_1164;

import java.util.*;

class RandomizedSet {

    public Map<Integer, Integer> hashMap;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        hashMap = new HashMap<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (hashMap.get(val) != null) {
            return false;
        }
        hashMap.put(val, val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        return hashMap.remove(val, val);

    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        Random random = new Random();
        Set set = hashMap.keySet();
        int index = random.nextInt(hashMap.keySet().size());
        return (Integer) set.toArray()[index];
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */