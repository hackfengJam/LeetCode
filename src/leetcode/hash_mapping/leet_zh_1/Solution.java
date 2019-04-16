package leetcode.hash_mapping.leet_zh_1;

public class Solution {
    /*
     * 1. 两数之和
     *
     * 暴力解法
     * 执行用时 : 58 ms
     * 内存消耗 : 38.9 MB
     * */
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        if (nums.length <= 1)
            return ans;

        for (int i = 0; i < nums.length; i++) {
            int tg = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (tg == nums[j]) {
                    ans[0] = i;
                    ans[1] = j;
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        Solution ss = new Solution();
        int[] ans = ss.twoSum(nums, 9);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
}