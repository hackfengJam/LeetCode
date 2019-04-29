package weekly_contest.th_134.leet_zh_5041;

public class Solution {
    /*
     * 5041. 不相交的线
     *
     * 动态规划，最长子序列
     * ans[i][j] =
     *   ans[i-1][j-1]+1                    (A[i] = B[j])
     *   max(ans[i][j-1], ans[i-1][j])  (A[i] != B[j])
     * */
    public int maxUncrossedLines(int[] A, int[] B) {
        int[][] ans = new int[A.length][B.length];
        ans[0][0] = A[0] == B[0] ? 1 : 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] == B[0])
                ans[i][0] = 1;
            else
                ans[i][0] = ans[i - 1][0];
        }
        for (int j = 1; j < B.length; j++) {
            if (B[j] == A[0])
                ans[0][j] = 1;
            else
                ans[0][j] = ans[0][j - 1];
        }

        for (int i = 1; i < A.length; i++) {
            for (int j = 1; j < B.length; j++) {
                if (A[i] == B[j]) {
                    ans[i][j] = ans[i - 1][j - 1] + 1;
                } else {
                    ans[i][j] = Math.max(ans[i][j - 1], ans[i - 1][j]);
                }
            }
        }

        return ans[A.length - 1][B.length - 1];
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
//        int[] A = {1, 4, 2};
//        int[] B = {1, 2, 4};

//        int[] A = {2, 5, 1, 2, 5};
//        int[] B = {10, 5, 2, 1, 5, 2};
        int[] A = {1, 3, 7, 1, 7, 5};
        int[] B = {1, 9, 2, 5, 1};
        int ans = ss.maxUncrossedLines(A, B);
        System.out.println(ans);

    }
}