package leetcode.dynamic_programming.leet_zh_322;

import java.util.Arrays;

public class Solution {
    /*
     *
     * 322. 零钱兑换
     *
     * 执行用时 : 36 ms, 在Coin Change的Java提交中击败了50.79% 的用户
     * 内存消耗 : 37.1 MB, 在Coin Change的Java提交中击败了80.33% 的用户

     * */
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] ans = new int[amount + 1];
        ans[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                int v = i - coins[j];
                if (v < 0) break;
                if (ans[v] != -1 && min > ans[v]) min = ans[v];
            }
            if (min == Integer.MAX_VALUE)
                ans[i] = -1;
            else
                ans[i] = min + 1;
        }
        return ans[amount];
    }

    public static void main(String[] args) {
        Solution ss = new Solution();

//        int[] coins = {1, 2, 5};
        int[] coins = {2};
        int amount = 11;

        System.out.println(ss.coinChange(coins, amount));
    }
}