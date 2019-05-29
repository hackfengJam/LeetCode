package leetcode.misc.leet_zh_169;

public class Solution {
    /*
     *
     * 169. 求众数
     *
     * 摩尔根投票法
     *
     * 执行用时 : 3 ms, 在Majority Element的Java提交中击败了97.16% 的用户
     * 内存消耗 : 50.2 MB, 在Majority Element的Java提交中击败了28.03% 的用户

     * */

    // 摩尔根投票法
    public int majorityElement(int[] nums) {
        // 题干：你可以假设数组是非空的，并且给定的数组总是存在众数。
        int a = -1, size = 0;

        for (int num : nums) {
            if (size == 0) {
                a = num;
                size++;
            } else if (a == num)
                size++;
            else {
                size--;
            }
        }

        return a;
    }

    public static void main(String[] args) {
        Solution ss = new Solution();

//        int[] nums = {3, 2, 3};
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(ss.majorityElement(nums));
    }
}