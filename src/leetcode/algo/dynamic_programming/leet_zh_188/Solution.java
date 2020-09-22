package leetcode.algo.dynamic_programming.leet_zh_188;

public class Solution {
    /*
     * Title: 188. 买卖股票的最佳时机 IV
     * Link : https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/
     * Label: ["动态规划"]
     * Level: Hard
     * Desc :
     * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
       设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
       注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

        示例 1:

        输入: [2,4,1], k = 2
        输出: 2
        解释: 在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
        示例 2:

        输入: [3,2,6,5,0,3], k = 2
        输出: 7
        解释: 在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
             随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。

     * dp[i][k][0] = max(dp[i-1][k][1] + prices[i], dp[i-1][k][0])
     * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
     *
     * base case:
     * dp[0][k][0] = 0
     * dp[0][k][1] = - prices[0]
     * dp[i][0][0] = 0
     * dp[i][0][1] = -inf
     *
     * 执行用时 : 11 ms
     * 内存消耗 : 41.9 MB
     * */
    public int maxProfit_k_inf(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[][] dp = new int[prices.length][2];

        // base case
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[prices.length - 1][0];
    }

    public int maxProfit(int max_k, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        if (max_k > prices.length / 2) {
            return maxProfit_k_inf(prices);
        }
        int[][][] dp = new int[prices.length][max_k + 1][2];

        // base case
        for (int i = 0; i < prices.length; i++) {
            dp[i][0][0] = 0;
            dp[i][0][1] = Integer.MIN_VALUE;
        }
        for (int i = 1; i <= max_k; i++) {
            dp[0][i][0] = 0;
            dp[0][i][1] = -prices[0];
        }

        for (int i = 1; i < prices.length; i++) {
            for (int k = 1; k <= max_k; k++) {
                dp[i][k][0] = Math.max(dp[i - 1][k][1] + prices[i], dp[i - 1][k][0]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }

        return dp[prices.length - 1][max_k][0];
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        int[] prices = new int[]{1, 2, 3};
        prices = new int[]{2, 4, 1};
        System.out.println(ss.maxProfit(2, prices));
        prices = new int[]{3, 2, 6, 5, 0, 3};
        System.out.println(ss.maxProfit(2, prices));
    }
}
