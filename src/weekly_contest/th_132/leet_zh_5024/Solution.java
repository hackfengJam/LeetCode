package weekly_contest.th_132.leet_zh_5024;

public class Solution {

    public boolean divisorGame(int N) {
        boolean[] ans = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            ans[i] = false;
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    if (!ans[i - j]) {
                        ans[i] = true;
                        break;
                    }
                }
            }
        }
        return ans[N];
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        System.out.println(ss.divisorGame(4));
        System.out.println(ss.divisorGame(3));
        System.out.println(ss.divisorGame(2));
    }
}
