package leetcode.algo.dynamic_programming.knapsack01;

public class Knapsack01_01 {
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
     * */
    private int[][] memo;

    private int bestValue(int[] w, int[] v, int index, int c) {
        if (index < 0 || c <= 0)
            return 0;
        if (memo[index][c] != -1)
            return memo[index][c];

        int res = bestValue(w, v, index - 1, c);

        if (v[index] >= c) {
            res = Math.max(res, v[index] + bestValue(w, v, index - 1, c - w[index]));
        }
        memo[index][c] = res;

        return memo[index][c];
    }

    private int knapsack01(int[] w, int[] v, int C) {

        int n = w.length;
        memo = new int[n][C + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < C + 1; j++) {
                memo[i][j] = -1;
            }
        }

        return bestValue(w, v, n - 1, C);
    }

    public static void main(String[] args) {

        int[] w = {1, 2, 3};
        int[] v = {6, 10, 12};
        int C = 5;

        int ret = new Knapsack01_01().knapsack01(w, v, C);
        System.out.println(ret);

    }
}
