package leetcode.graph_theory.leet_zh_200;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    /*
     * 200. 岛屿的个数
     * 并查集
     * 执行用时 : 5 ms, 在Number of Islands的Java提交中击败了67.76% 的用户
     * 内存消耗 : 40.1 MB, 在Number of Islands的Java提交中击败了93.94% 的用户

     * */

    private class UnionFind {
        public int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int a) {
            if (a < 0 && a >= parent.length) {
                throw new IllegalArgumentException("a is out of bound");
            }

            while (a != parent[a]) {
                a = parent[a];
            }
            return a;
        }

        public void conn(int a, int b) {
            int findA = find(a);
            int findB = find(b);
            if (findA == findB)
                return;
            if (findA < findB)
                parent[findB] = findA;
            else
                parent[findA] = findB;
        }
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int h = grid.length;
        int w = grid[0].length;
        UnionFind uf = new UnionFind(h * w);
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (grid[i][j] == '1') {
                    if (i + 1 < h && grid[i + 1][j] == '1') uf.conn(i * w + j, (i + 1) * w + j);
                    if (j + 1 < w && grid[i][j + 1] == '1') uf.conn(i * w + j, i * w + j + 1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < uf.parent.length; i++) {
            if (grid[i / w][i % w] == '1' && i == uf.parent[i])
                res++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution2 ss = new Solution2();
//        char[][] grid = {
//                {'1', '1', '1', '1', '0'},
//                {'1', '1', '0', '1', '0'},
//                {'1', '1', '0', '0', '0'},
//                {'0', '0', '0', '0', '0'}};
//        char[][] grid = {
//                {'1', '1', '0', '0', '0'},
//                {'1', '1', '0', '0', '0'},
//                {'0', '0', '1', '0', '0'},
//                {'0', '0', '0', '1', '1'}};
        char[][] grid = {
                {'1', '0', '1', '1', '1'},
                {'1', '0', '1', '0', '1'},
                {'1', '1', '1', '0', '1'}};
        System.out.println(ss.numIslands(grid));
    }
}