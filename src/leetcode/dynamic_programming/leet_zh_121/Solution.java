package leetcode.dynamic_programming.leet_zh_121;

public class Solution {
    /*
     * 121. Best Time to Buy and Sell Stock
     * 执行用时 : 431 ms
     * 内存消耗 : 38.4 MB
     * */
//    public int maxProfit(int[] prices) {
//        int max = 0;
//        for (int i = 0; i < prices.length; i++) {
//            for (int j = 0; j < i; j++) {
//                int d = prices[i] - prices[j];
//                if (d > 0 && max < d)
//                    max = d;
//            }
//        }
//        return max;
//    }

    /*
     * 121. Best Time to Buy and Sell Stock
     * * 执行用时 : 3 ms
     * 内存消耗 : 37.9 MB
     * */
    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;
        int minX = 0;
        int[] res = new int[prices.length];
        for (int i = 1; i < prices.length; i++) {
            res[i] = Math.max(res[i - 1], prices[i] - prices[minX]);
            if (prices[i] < prices[minX])
                minX = i;
        }
        return res[prices.length - 1];
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(ss.maxProfit(prices));
    }
}