package leetcode.dynamic_programming.leet_zh_343;

public class Solution {
    /*
     * 343. 整数拆分
     * 执行用时 : 2 ms
     * 内存消耗 : 32.4 MB
     * */
    public int integerBreak(int n) {
        int[] ans = new int[n + 1];
        ans[1] = 1;
        ans[2] = 1;
        for (int i = 3; i <= n; i++) {
            ans[i] = 0;
            // 求解 ans[i]
            for (int j = 1; j < i; j++) {
                // i + (i - j)
                ans[i] = Math.max(Math.max(ans[i], j * ans[i - j]), j * (i - j));
            }
        }
        return ans[n];
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        System.out.println(ss.integerBreak(2));
        System.out.println(ss.integerBreak(10));
    }
}