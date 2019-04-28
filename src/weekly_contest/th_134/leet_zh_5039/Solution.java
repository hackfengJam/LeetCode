package weekly_contest.th_134.leet_zh_5039;

public class Solution {
    /*
     *
     * 5039. 移动石子直到连续
     *
     * */
    public int[] numMovesStones(int a, int b, int c) {
        int[] ans = new int[2];

        int left = b - a - 1;
        int right = c - b - 1;
        if (left < 0)
            left = 0;
        if (right < 0)
            right = 0;

        ans[0] = left + right;
        ans[1] = left + right;


        return ans;
    }
}