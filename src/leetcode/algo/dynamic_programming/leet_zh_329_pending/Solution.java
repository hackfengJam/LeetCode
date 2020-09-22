package leetcode.algo.dynamic_programming.leet_zh_329_pending;

public class Solution {
    /*
     *
     * 329. 矩阵中的最长递增路径
     * */


    private int[][] dire = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int[][] ret;
    private int[][] graph;
    private boolean[][] visited;
    private int R;
    private int C;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        ret = new int[matrix.length][matrix[0].length];
        visited = new boolean[matrix.length][matrix[0].length];
        R = matrix.length;
        C = matrix[0].length;
        graph = matrix;

        // init
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                ret[i][j] = 1;
                visited[i][j] = false;
            }
        }

        // resolution
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (visited[i][j])
                    continue;
                visited[i][j] = true;
                int dpRet = dfs(i, j, 1);
                ret[i][j] = Math.max(ret[i][j], dpRet);
            }
        }


        int max = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (max < ret[i][j])
                    max = ret[i][j];
            }
        }

        return max;
    }

    private int dfs(int i, int j, int dp) {
        int dpRet = dp;
        for (int k = 0; k < dire.length; k++) {
            int newX = i + dire[k][0];
            int newY = j + dire[k][1];
            if (newX >= 0 && newX < R && newY >= 0 && newY < C) {
                if (graph[newX][newY] > graph[i][j]) {
                    if (visited[newX][newY]) {
                        dpRet = Math.max(dpRet, ret[newX][newY] + dp);
                        continue;
                    }
                    visited[newX][newY] = true;

                    int d = dfs(newX, newY, dp + 1);
                    dpRet = Math.max(dpRet, d);
                    ret[newX][newY] = Math.max(d - dp, ret[newX][newY]);
                } else {
                    if (visited[newX][newY]) {
                        continue;
                    }
                    visited[newX][newY] = true;
                    ret[newX][newY] = Math.max(dfs(newX, newY, 1), ret[newX][newY]);
                }
            }
        }
        return dpRet;
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
//        int[][] matrix = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        int[][] matrix = {{7, 8, 9}, {9, 7, 6}, {7, 2, 3}};
        System.out.println(ss.longestIncreasingPath(matrix));
    }
}
