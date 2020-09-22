package leetcode.algo.design.leet_zh_146;


import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private Map<Integer, Element> map = new HashMap<>();

    private class Element implements Comparable {
        public int key;
        public int val;
        public Integer cnt;

        public Element(int key, int val) {
            this.key = key;
            this.val = val;
            this.cnt = 0;
        }

        @Override
        public int compareTo(Object o) {
            return cnt.compareTo(((Element) o).cnt);
        }
    }

    private class IndexMinHeap {
        // 最小索引堆
        private int[] data;
        private int capacity;
        int[] indexes;
        private int count;

        public int size() {
            return count;
        }

        public boolean isEmpty() {
            return count == 0;
        }

        public IndexMinHeap() {
            this(10);
        }

        public IndexMinHeap(int capacity) {
            data = new int[capacity + 1];
            indexes = new int[capacity + 1];
            count = 0;
            this.capacity = capacity;
        }

        private boolean more(int i, int j) {
            Element eI = map.get(data[i]);
            Element eJ = map.get(data[j]);

            return eI.compareTo(eJ) > 0;
        }


        private void exch(int i, int j) {
            int tmp = data[i];
            data[i] = data[j];
            data[j] = tmp;
        }

        private void exchIndex(int i, int j) {
            int tmp = indexes[i];
            indexes[i] = indexes[j];
            indexes[j] = tmp;
        }

        public void swim(int k) {
            // 上浮
            while (k > 1 && more(indexes[k / 2], indexes[k])) {
                exchIndex(k / 2, k);
                k /= 2;
            }
        }

        public void sink(int k) {
            // 下沉
            while (k * 2 <= count) {
                int j = k * 2;
                if (j < count && more(indexes[j], indexes[j + 1])) j++;
                if (!more(indexes[k], indexes[j])) break;
                exchIndex(k, j);
                k = j;
            }
        }

        // 传入的i 对用户而言，是从0索引的
        public void insert(int i, Element key) {
//            assert (count + 1 <= capacity);
            if (count + 1 <= capacity) {
                // LRU 置换
                delMin();
            }
            assert (i + 1 >= 1 && i + 1 <= capacity);

            i += 1;
            data[i] = key.key;
            map.put(key.key, key);

            indexes[count + 1] = i;
            count++;
            swim(count);
        }

        public Element delMin() {
            assert (count > 0);

            Element key = map.get(data[indexes[1]]);
            exchIndex(1, count);
            count--;
            sink(1);
            return key;
        }

        public void change(int i, Element newKey) {
            map.put(i, newKey);

            for (int j = 1; j <= count; j++) {
                if (data[indexes[j]] == i) {
                    swim(j); // 上移
                    sink(j); // 下沉
                    return;
                }
            }
        }

        public int delMinIndex() {
            assert (count > 0);

            int ret = indexes[1] - 1;
            exchIndex(1, count);
            count--;
            sink(1);
            return ret;
        }

        public Element getKey(int i) {
            Element key = map.get(i);
            if (key == null)
                return new Element(i, -1);
            return key;
        }

    }

    public LRUCache(int capacity) {


    }

    public int get(int key) {

        return 0;
    }

    public void put(int key, int value) {

    }

    public void test(int a) {
        assert (a != 1);
        System.out.println(a);
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(1);
        lruCache.test(2);
        lruCache.test(1);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */