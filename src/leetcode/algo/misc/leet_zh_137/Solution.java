package leetcode.algo.misc.leet_zh_137;

public class Solution {
    /*
     * 137. 只出现一次的数字 II
     *
     * 执行用时 : 2 ms, 在Single Number II的Java提交中击败了65.85% 的用户
     * 内存消耗 : 38.3 MB, 在Single Number II的Java提交中击败了49.57% 的用户

     * */
    public int singleNumber(int[] nums) {
        int one = 0, two = 0, three;
        for (int num : nums) {
            // two的相应的位等于1，表示该位出现2次
            two |= (one & num);

            // one的相应的位等于1，表示该位出现1次
            one ^= num;

            // three的相应的位等于1，表示该位出现3次
            three = (one & two);

            // 如果相应的位出现3次，则该位重置为0
            two &= ~three;
            one &= ~three;
        }
        return one;
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        int[] nums = {2, 2, 2, 3};
//        System.out.println(1 | 1);
//        System.out.println(2 | 2 | 2);
        System.out.println(ss.singleNumber(nums));
    }
}
