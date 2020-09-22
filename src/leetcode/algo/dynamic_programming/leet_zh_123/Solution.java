package leetcode.algo.dynamic_programming.leet_zh_123;

public class Solution {
    /*
     * Title: 123. 买卖股票的最佳时机 III
     * Link : https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
     * Label: ["数组", "动态规划"]
     * Level: Hard
     * Desc :
     * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
       设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
       注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

        示例 1:

        输入: [3,3,5,0,0,3,1,4]
        输出: 6
        解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
             随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
        示例 2:

        输入: [1,2,3,4,5]
        输出: 4
        解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。  
             注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。  
             因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
        示例 3:

        输入: [7,6,4,3,1]
        输出: 0
        解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。
    *
    * 0 不持有 1 持有
    * dp:
    * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
    * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
    *
    * base case:
    * dp[-1][k][0] = 0
    * dp[-1][k][1] = -inf
    * dp[i][0][0] = 0
    * dp[i][0][1] = -inf
    *
    *
    * 执行用时 : 172  ms
    * 内存消耗 : 66.4 MB
    * */
    public int maxProfit(int[] prices) {
        int max_k = 2;
        int[][][] dp = new int[prices.length][max_k + 1][2];

        // base case
        for (int i = 0; i < dp.length; i++) {
            dp[i][0][0] = 0;
            dp[i][0][1] = Integer.MIN_VALUE;
        }
        for (int i = 0; i <= max_k; i++) {
            dp[0][i][0] = Math.max(0, Integer.MIN_VALUE + prices[0]);
            dp[0][i][1] = Math.max(Integer.MIN_VALUE, 0 - prices[0]);
        }

        // dp
        for (int i = 1; i < dp.length; i++) {
//            for (int k = max_k; k >= 1; k--) {
            for (int k = 1; k <= max_k; k++) {
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }
        return dp[prices.length - 1][max_k][0];
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        int[] prices = new int[]{1, 2, 3};
        System.out.println(ss.maxProfit(prices));
        prices = new int[]{3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(ss.maxProfit(prices));
        prices = new int[]{1, 2, 3, 4, 5};
        System.out.println(ss.maxProfit(prices));
        prices = new int[]{7, 6, 4, 3, 1};
        System.out.println(ss.maxProfit(prices));
        prices = new int[]{2, 1, 2, 0, 1};
        System.out.println(ss.maxProfit(prices));
    }
}
