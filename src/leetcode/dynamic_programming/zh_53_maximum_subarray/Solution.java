package leetcode.dynamic_programming.zh_53_maximum_subarray;

class Solution {
    /*
    * 执行用时 : 13 ms
    * 内存消耗 : 39.2 MB*/
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int res = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            // 0~i i~j j~n
            if (sum > 0)
                sum = sum + nums[i];
            else
                sum = nums[i];
            res = Math.max(res, sum);

        }
        return res;
    }

    public static void main(String[] args) {
//        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums = {1, 2};
//        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        Solution so = new Solution();
        System.out.println(so.maxSubArray(nums));
    }
}