package leetcode.greedy.leet_zh_455;

import java.util.Arrays;

public class Solution {
    /*
     *
     * 455. Assign Cookies
     * 执行用时 : 20 ms
     * 内存消耗 : 50.8 MB
     * */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int cnt = 0;
        int j = g.length - 1;
        for (int i = s.length - 1; i >= 0; i--) {
            while (j >= 0) {
                // 找到能分配给最大开心值cookie 的child
                if (g[j] <= s[i]) {
                    cnt++;
                    j--;
                    break;
                } else {
                    j--;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
//        int[] g = {1, 2, 3};
//        int[] s = {1, 1};
//        int[] g = {1, 2};
//        int[] s = {1, 2, 3};
//        int[] g = {1, 2, 3};
//        int[] s = {3};
        int[] g = {1, 2, 3};
        int[] s = {1, 1};
        Solution ss = new Solution();
        System.out.println(ss.findContentChildren(g, s));
    }

}