package leetcode.algo.dynamic_programming.leet_zh_198;

public class Solution {
    /*
     * 198. 打家劫舍
     * 执行用时 : 1 ms, 在所有 Java 提交中击败了82.21% 的用户
     * 内存消耗 : 33.9 MB, 在所有 Java 提交中击败了90.44% 的用户
     * */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int[] ans = new int[nums.length];

        ans[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int max = Math.max(ans[i - 1], nums[i]);
            for (int j = 0; j < i - 1; j++) {
                int val = ans[j] + nums[i];
                if (max < val)
                    max = val;
            }
            ans[i] = max;
        }
        return ans[nums.length - 1];
    }

    public static void main(String[] args) {
        Solution ss = new Solution();

        int[] nums = {2, 9, 3, 1, 9};
//        int[] nums = {2, 7, 9, 3, 1};
//        int[] nums = {1, 2, 3, 1};
        System.out.println(ss.rob(nums));
    }
}