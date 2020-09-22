package leetcode.algo.dynamic_programming.knapsack01;

public class Knapsack01_02 {
    /*
     * 0-1 背包问题
     *
     * 有一个背包，它的容量为C（capacity）。
     * 现在有 n 种不同的物品，编号为 0...n-1，其中每一件物品的重量为 w(i), 价值为 v(i)。
     * 问可以向这个背包中盛放哪些物品，使得在不超过背包容量的基础上，物品的总价值最大。
     *
     * 暴力解法：每一件物品都可以放进背包，也可以不放进背包。O((2^n)*n)
     *
     *
     * 解法：
     * F(i, c) = F(i-1, c)
     *         = v(i) + F(i-1, c - w(i))
     *
     * F(i, c) = max(F(i-1, c), v(i) + F(i-1, c - w(i)))
     *
     * 将原问题拆解成若干子问题，同时保存子问题的答案，使得每个子问题只求解一次，最终获得原问题的答案。
     * */


    public int knapsack01(int[] w, int[] v, int C) {
        int[][] memo;

        // init
        int n = w.length;
        memo = new int[n][C + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < C + 1; j++) {
                memo[i][j] = -1;
            }
        }

        for (int i = 0; i <= C; i++) {
            memo[0][i] = i >= v[0] ? v[0] : 0;
        }

        // 自底向上
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= C; j++) {
                memo[i][j] = memo[i - 1][j];

                if (j >= w[i]) {
                    memo[i][j] = Math.max(memo[i][j], v[i] + memo[i - 1][j - w[i]]);
                }
            }
        }

        return memo[n - 1][C];
    }

    public static void main(String[] args) {

        int[] w = {1, 2, 3};
        int[] v = {6, 10, 12};
        int C = 5;

        int ret = new Knapsack01_02().knapsack01(w, v, C);
        System.out.println(ret);

    }
}
