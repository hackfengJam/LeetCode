package leetcode.algo.misc.leet_zh_1108;

class Solution2 {
    // 结果：TLE
    public boolean find(int[][] matrix, int i, int j, int target) {
        if (i < 0 || j < 0)
            return false;

        if (matrix[i][j] == target)
            return true;
        if (matrix[i][j] < target)
            return false;

        return find(matrix, i - 1, j, target) || find(matrix, i, j - 1, target);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0)
            return false;
        return find(matrix, matrix.length - 1, matrix[0].length - 1, target);
    }

    public static void main(String[] args) {
        Solution2 ss = new Solution2();
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