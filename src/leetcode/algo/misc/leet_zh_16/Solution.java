package leetcode.algo.misc.leet_zh_16;

import java.util.Arrays;

public class Solution {
    /*
     * Title: 16. 最接近的三数之和
     * Link : https://leetcode-cn.com/problems/3sum-closest/
     * Label: ["数组", "双指针"]
     * Level: Medium
     * Desc :
     * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
        示例：

        输入：nums = [-1,2,1,-4], target = 1
        输出：2
        解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
         

        提示：

        3 <= nums.length <= 10^3
        -10^3 <= nums[i] <= 10^3
        -10^4 <= target <= 10^4
     *
     * 执行用时 :  6 ms
     * 内存消耗 :  39.4 MB
     * */
    public int minAbs(int a, int b) {
        return Math.abs(a) > Math.abs(b) ? b : a;
    }

    public int threeSumClosest(int[] nums, int target) {
        switch (nums.length) {
            case 0:
                return 0;
            case 1:
                return nums[0];
            case 2:
                return nums[0] + nums[1];
            case 3:
                return nums[0] + nums[1] + nums[2];
        }

        // sort
        Arrays.sort(nums);

        int l, r;
        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int curT = target - nums[i]; // target - num[i]

            l = i + 1;
            r = nums.length - 1;
            while (l < r) {
                int v = nums[l] + nums[r];
                if (v == curT) {
                    return target;
                } else if (v > curT) {
                    ret = minAbs(v + nums[i] - target, ret);
                    r--;
                } else {
                    ret = minAbs(v + nums[i] - target, ret);
                    l++;
                }
            }
        }
        return ret + target;
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        int[] nums = new int[]{-1, 2, 1, -4};
        System.out.println(ss.threeSumClosest(nums, 1));
//        System.out.println(ss.threeSumClosest());
    }
}
