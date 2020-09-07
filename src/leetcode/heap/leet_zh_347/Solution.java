package leetcode.heap.leet_zh_347;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /*
     * Title: 347. 前 K 个高频元素
     * Link : https://leetcode-cn.com/problems/top-k-frequent-elements/
     * Label: ["堆", "哈希表"]
     * Level: Medium
     * Desc :
     *给定一个非空的整数数组，返回其中出现频率前 k 高的元素。

        示例 1:

        输入: nums = [1,1,1,2,2,3], k = 2
        输出: [1,2]
        示例 2:

        输入: nums = [1], k = 1
        输出: [1]
         

        提示：

        你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
        你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
        题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
        你可以按任意顺序返回答案。

     * 执行用时 : 14 ms
     * 内存消耗 : 42.6 MB
     * */

    private Map<Integer, Integer> dict;

    private class Node {
        int k;
        int v;

        public Node() {
        }

        public Node(int k, int v) {
            this.k = k;
            this.v = v;
        }
    }

    private void swap(Node[] arr, int i, int j) {
        Node tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private void heapify(Node[] arr, int n, int i) {
        if (i >= n) {
            return;
        }

        int c1 = 2 * i + 1;
        int c2 = 2 * i + 2;
        int min = i;
        if (c1 < n && arr[c1].v < arr[min].v) {
            min = c1;
        }
        if (c2 < n && arr[c2].v < arr[min].v) {
            min = c2;
        }
        if (min != i) {
            swap(arr, min, i);
            heapify(arr, n, min);
        }
    }

    private void heapSort(Node[] heap, int n) {
        for (int i = n - 1; i >= 0; i--) {
            swap(heap, i, 0);
            heapify(heap, i, 0);
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        dict = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            dict.put(nums[i], dict.getOrDefault(nums[i], 0) + 1);
        }
        Node heap[] = new Node[k];
        for (int i = 0; i < k; i++) {
            heap[i] = new Node(0, 0);
        }
        for (Integer key : dict.keySet()) {
            int value = dict.get(key);
            if (heap[0].v < value) {
                heap[0] = new Node(key, value);
                heapify(heap, k, 0);
            }
        }

        heapSort(heap, heap.length);

        int ret[] = new int[k];
        for (int i = 0; i < heap.length; i++) {
            ret[i] = heap[i].k;
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int[] ret;
        ret = ss.topKFrequent(nums, 2);
        for (int i = 0; i < ret.length; i++) {
            System.out.print(ret[i]);
            System.out.print(" ");
        }
    }
}
