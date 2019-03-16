package leetcode.misc.leet_1107;

import java.util.Arrays;

class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int[] res = {0, nums[0]};
        for (int i = 0; i < nums.length; i++) {
            int step = 0;
            for (int j = 0; j < nums.length - i; j++) {
                if (nums[i] != nums[i + j]) {
//                    step = j;
                    break;
                } else {
                    step += 1;
                }
            }
            if (step > res[0]) {
                res[0] = step;
                res[1] = nums[i];
            }
            i = i + step - 1;
        }
        return res[1];
    }

    public int majorityElement_opt(int[] nums) {
        int res = 0, n = nums.length;
        for (int i = 0; i < 32; ++i) {
            int ones = 0, zeros = 0;
            for (int num : nums) {
                if (ones > n / 2 || zeros > n / 2) break;
                if ((num & (1 << i)) != 0) ++ones;
                else ++zeros;
            }
            if (ones > zeros) res |= (1 << i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 4, 4, 4, 4};
//        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        int num = new Solution().majorityElement_opt(nums);
        System.out.println(num);
    }
}