package leetcode.algo.misc.leet_zh_136;

public class Solution {
    /*
     *
     * 执行用时 : 2 ms, 在Single Number的Java提交中击败了50.29% 的用户
     * 内存消耗 : 39.4 MB, 在Single Number的Java提交中击败了94.14% 的用户

     * */
    public int singleNumber(int[] nums) {
        int ret = 0;
        for (int num : nums) {
            ret ^= num;
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        int[] nums = {2, 2, 1};

        System.out.println(ss.singleNumber(nums));

    }
}
