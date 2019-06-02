package biweekly_contest.th_1.leet_zh_5008;

public class Solution {
    /*
     * 5008. 不动点
     * */
    public int fixedPoint(int[] A) {
        int rev = -1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == i) {
                rev = i;
                break;
            }
        }
        return rev;
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        int[] nums = {-10, -5, 0, 3, 7};
        System.out.println(ss.fixedPoint(nums));
    }
}