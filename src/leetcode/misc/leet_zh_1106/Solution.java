package leetcode.misc.leet_zh_1106;

class Solution {
    public int singleNumber(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[0] = nums[0] ^ nums[i];
        }

        return nums[0];
    }

    public static void main(String[] args) {

        int[] nums = {4, 1, 2, 1, 2};
        for (int i = 1; i < nums.length; i++) {
            nums[0] = nums[0] ^ nums[i];
        }
        System.out.println(nums[0]);
//        new Solution().singleNumber(nums);
    }
}