package leetcode.algo.hash_mapping.leet_zh_1;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    /*
     * 1. 两数之和
     *
     * hash 表
     * 执行用时 : 8 ms
     * 内存消耗 : 38.6 MB
     * */
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        if (nums.length <= 1)
            return ans;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], i);

        Integer tg;
        for (int i = 0; i < nums.length - 1; i++) {
            if ((tg = map.get(target - nums[i])) != null && tg != i) {
                ans[0] = i;
                ans[1] = tg;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[] nums = {2, 7, 11, 15};
        int[] nums = {3, 2, 4};
        Solution2 ss = new Solution2();
        int[] ans = ss.twoSum(nums, 6);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
}