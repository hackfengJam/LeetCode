package weekly_contest.th_136.leet_zh_5057;

public class Solution {

    /*
     *
     * 5057. 分隔数组以得到最大和
     *
     * 51 / 51 个通过测试用例
     * 执行用时：36 ms
     *
     *
    dp表示以i结尾的最大和，那么答案就是dp[n-1]
    计算过程以样例[1,15,7,9,2,5,10] K=3为例：
    先初始化前K个dp为前i+1个元素中的最大值乘以i+1，
    即dp = [1,30,45]，对应过程：
    [1]
    [15,15]
    [15,15,15]
    加入第K+1个值开始，对dp可能有K个影响，样例中分别对应过程如下：
    [1, 15, 15, 15]
    [15, 15, 9, 9]
    [15, 15, 15, 9]
    也就是说，后加入的这个9，可能在长度为L<=K的区间内的第1到K个值。
    然后取一个和最大的依次往下计算。
     * */
    public int maxSumAfterPartitioning(int[] A, int K) {
        int[][] m = new int[505][505];
        int[] F = new int[505];
        int N = A.length;
        for (int i = 1; i <= N; i++) {
            // m[i][j] = max(A[i-1]...A[j-1])
            m[i][i] = A[i - 1];
//            for (int j = i + 1; j <= N; j++) { // 执行用时：36 ms
            int n = Math.min(N, i + K + 1); // 执行用时：37 ms
            for (int j = i + 1; j <= n; j++) {
                m[i][j] = Math.max(m[i][j - 1], A[j - 1]);
            }
        }
        for (int i = 1; i <= N; i++) {

            // i = 4  -> F[4] = max(F[1] + 3 * m[1][4], F[2] + 2 * m[2][4], F[3] + 1 * m[3][4])
            for (int j = Math.max(1, i - K + 1); j <= i; j++) {
                F[i] = Math.max(F[i], F[j - 1] + (i - j + 1) * m[j][i]);
            }
        }
        return F[N];
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        int[] A = {1, 15, 7, 9, 2, 5, 10};
        System.out.println(ss.maxSumAfterPartitioning(A, 4));
    }
}
