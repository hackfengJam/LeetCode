package leetcode.dynamic_programming.leet_zh_309;

public class Solution {
    /*
     * Title: 309. 最佳买卖股票时机含冷冻期
     * Link : https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
     * Label: ["动态规划"]
     * Level: Medium
     * Desc :
     * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
       设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:

        你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
        卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
        示例:

        输入: [1,2,3,0,2]
        输出: 3
        解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]

     * dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
     * dp[i][k][1] = Math.max(dp[i-1][k-1][0] - prices[i], dp[i-1][k][1])
     *
     * dp[0][k][0] = 0
     * dp[0][k][1] = -prices[0]
     * dp[i][0][0] = 0
     * dp[i][0][1] = -inf
     *
     *
     * dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i])
     * dp[i][1] = Math.max(dp[i-2][0] - prices[i], dp[i-1][1])
     * dp[0][0] = 0
     * dp[0][1] = -prices[0]
     *
     *
     * 执行用时 :  1 ms
     * 内存消耗 :  37.8 MB
     * */
    public int maxProfit(int[] prices) {
        if (prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[1][0] = Math.max(0, prices[1] - prices[0]);
        dp[1][1] = Math.max(-prices[0], -prices[1]);
        for (int i = 2; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 2][0] - prices[i], dp[i - 1][1]);
        }
        return dp[prices.length - 1][0];
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        int[] prices = new int[]{1, 2, 3, 0, 2};
        System.out.println(ss.maxProfit(prices));
    }
}
