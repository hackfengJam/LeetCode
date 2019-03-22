package leetcode.dynamic_programming.zh_70_climbing_stairs;


class Solution {
    /*
     * 执行用时 : 4 ms
     * 内存消耗 : 36.2 MB
     * */
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        int[] res = new int[n];
        res[0] = 1;
        res[1] = 2;
        for (int i = 2; i < n; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[n - 1];
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        int opCountMax = 5;
        for (int i = 0; i <= opCountMax; i++) {
            System.out.println(so.climbStairs(i));
        }
    }
}