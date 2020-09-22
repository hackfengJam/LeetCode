package leetcode.algo.misc.leet_zh_1108;

class Solution {
    // 结果：TLE
    public boolean find(int[][] matrix, int i, int j, int target, boolean[][] visited) {
        if (i < 0 || j < 0)
            return false;
        if (visited[i][j])
            return false;
        visited[i][j] = true;

        if (matrix[i][j] == target)
            return true;
        if (matrix[i][j] < target)
            return false;
        return find(matrix, i - 1, j, target, visited) || find(matrix, i, j - 1, target, visited);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0)
            return false;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        return find(matrix, matrix.length - 1, matrix[0].length - 1, target, visited);
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30},
        };
        System.out.println(ss.searchMatrix(matrix, 5));
        System.out.println(ss.searchMatrix(matrix, 20));
    }
}