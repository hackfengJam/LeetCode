package leetcode.algo.backtrack.leet_zh_77;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /*
     * Title: 77. 组合
     * Link : https://leetcode-cn.com/problems/combinations/
     * Label: ["回溯算法"]
     * Level: Medium
     * Desc :
     * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

        示例:

        输入: n = 4, k = 2
        输出:
        [
          [2,4],
          [3,4],
          [2,3],
          [1,2],
          [1,3],
          [1,4],
        ]
     * 执行用时 : 2    ms
     * 内存消耗 : 41.5 MB
     * */
    public void dfs(List<List<Integer>> ret, List<Integer> parent, int n, int loc, int kk) {
        if (kk == 0) {
            ret.add(parent);
            return;
        }
        if (loc > n || n < kk + loc - 1) {
            return;
        }

        // copy line
        List<Integer> line = new ArrayList<>(parent);

        // 取当前 loc
        line.add(loc);
        dfs(ret, line, n, loc + 1, kk - 1);

        // 不取当前 loc
        dfs(ret, parent, n, loc + 1, kk);
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<>();
        dfs(ret, new ArrayList<>(), n, 1, k);
        return ret;
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        int[][] testCase = {
                {4, 2},
        };
        List<List<Integer>> ret;
        for (int i = 0; i < testCase.length; i++) {
            ret = ss.combine(testCase[i][0], testCase[i][1]);
            for (List<Integer> line : ret) {
                for (Integer e : line) {
                    System.out.print(e);
                    System.out.print(" ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}