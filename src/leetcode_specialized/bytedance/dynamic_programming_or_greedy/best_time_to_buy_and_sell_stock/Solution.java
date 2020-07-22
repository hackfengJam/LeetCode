package leetcode_specialized.bytedance.dynamic_programming_or_greedy.best_time_to_buy_and_sell_stock;


public class Solution {
    /*
     * Title: 买卖股票的最佳时机
     * Link : https://leetcode-cn.com/explore/interview/card/bytedance/246/dynamic-programming-or-greedy/1042/
     * Label: 数组、动态规划
     *
     * 执行用时 : 2 ms
     * 内存消耗 : 39.9 MB
     * */
    public int maxProfit(int[] prices) {
        int res = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (min > prices[i]) {
                min = prices[i];
            }
            res = Math.max(res, prices[i] - min);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        System.out.println(ss.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(ss.maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println(ss.maxProfit(new int[]{1, 2}));
    }
}
