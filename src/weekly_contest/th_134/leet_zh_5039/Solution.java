package weekly_contest.th_134.leet_zh_5039;

public class Solution {
    /*
     *
     * 5039. 移动石子直到连续
     *
     * */
    public int[] numMovesStones(int a, int b, int c) {
        int[] ans = new int[2];
        if (a > b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        if (b > c) {
            int tmp = b;
            b = c;
            c = tmp;
        }
        if (a > b) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        int left = b - a - 1;
        int right = c - b - 1;

        ans[0] = 2;
        ans[1] = left + right;
        if (right == 0 && left == 0) ans[0] = 0;
        else if (right <= 1 || left <= 1) ans[0] = 1;


        return ans;
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        int[] ans = ss.numMovesStones(4, 2, 3);
        System.out.println(ans[0] + " " + ans[1]);
    }
}