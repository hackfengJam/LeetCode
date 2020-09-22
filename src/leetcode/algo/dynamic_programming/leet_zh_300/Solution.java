package leetcode.algo.dynamic_programming.leet_zh_300;

public class Solution {
    /*
     * 执行用时 : 49 ms
     * 内存消耗 : 35.1 MB
     * O(n^2)
     * */
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0)
            return 0;
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && res[j] + 1 > res[i]) {
                    res[i] = res[j] + 1;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < res.length; i++) {
            if (max <= res[i]) {
                max = res[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(ss.lengthOfLIS(nums));
    }
}