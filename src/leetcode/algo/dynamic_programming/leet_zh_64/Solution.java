package leetcode.algo.dynamic_programming.leet_zh_64;

public class Solution {
    /*
     * Title: 64. 最小路径和
     * Link : https://leetcode-cn.com/problems/minimum-path-sum
     * Label: ["数组", "动态规划"]
     * Diff : Medium
     * Desc :
     * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

        说明：每次只能向下或者向右移动一步。

        示例:

        输入:
        [
          [1,3,1],
          [1,5,1],
          [4,2,1]
        ]
        输出: 7
        解释: 因为路径 1→3→1→1→1 的总和最小。

     * 执行用时 : 3 ms
     * 内存消耗 : 42.7 MB
     * */

    public int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int[][] dp = new int[grid.length][grid[0].length];

        // init
        dp[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < grid[0].length; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        // dp
        for (int i = 1; i < grid.length; i++) {
            int[] m = grid[0];
            for (int j = 1; j < m.length; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
//        System.out.println(ss.minPathSum(new int[][]{
//                {1, 3, 1},
//                {1, 5, 1},
//                {4, 2, 1}
//        }));
        System.out.println(ss.minPathSum(new int[][]{
                {}
        }));
    }
}
