package leetcode.algo.graph_theory.leet_zh_200;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    /*
     * 200. 岛屿的个数
     * 执行用时 : 17 ms, 在Number of Islands的Java提交中击败了10.93% 的用户
     * 内存消耗 : 43.4 MB, 在Number of Islands的Java提交中击败了33.57% 的用户

     * */

    private class Location {
        private int x;
        private int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    private int[][] dire = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int numIslands(char[][] grid) {
        int h = grid.length;
        if (h == 0)
            return 0;
        int w = grid[0].length;
        if (w == 0)
            return 0;
        boolean[][] visited = new boolean[h][w];
        Queue<Location> queue = new LinkedList<>();
        int res = 0;

        for (int i = 0; i < grid.length; i++) {
            char[] line = grid[i];
            for (int j = 0; j < line.length; j++) {
                if (visited[i][j])
                    continue;
                visited[i][j] = true;
                char c = line[j];
                if (c == '1') {
                    queue.offer(new Location(i, j));
                    while (!queue.isEmpty()) {
                        Location point = queue.poll();
                        for (int k = 0; k < dire.length; k++) {
                            int x = point.x + dire[k][0];
                            int y = point.y + dire[k][1];
                            if (x < 0 || x >= h || y < 0 || y >= w || visited[x][y])
                                continue;
                            if (grid[x][y] == '1') {
                                queue.offer(new Location(x, y));
                            }
                            visited[x][y] = true;
                        }
                    }
                    res++;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
//        char[][] grid = {
//                {'1', '1', '1', '1', '0'},
//                {'1', '1', '0', '1', '0'},
//                {'1', '1', '0', '0', '0'},
//                {'0', '0', '0', '0', '0'}};
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        System.out.println(ss.numIslands(grid));
    }
}