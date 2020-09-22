package leetcode.algo.dynamic_programming.leet_zh_122;

public class Solution {
    /*
     * 122. Best Time to Buy and Sell Stock II
     * 执行用时 : 3 ms
     * 内存消耗 : 37.7 MB
     * */
    public int maxProfit(int[] prices) {

        /*
         * 从第 i 天开始，i+1 天 大于 i天 利润，则直接交易*/
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int step = prices[i + 1] - prices[i];
            if (step > 0) {
                profit += step;
            }
        }
        return profit;
    }

    public static void main(String[] args) {
//        int [] nums = {7,1,5,3,6,4};
        int[] nums = {1, 2, 3, 4, 5};
//        int [] nums = {7,6,4,3,1};
//        int [] nums = {};
        System.out.println(new Solution().maxProfit(nums));
    }
}
