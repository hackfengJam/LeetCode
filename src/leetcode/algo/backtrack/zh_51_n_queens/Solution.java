package leetcode.algo.backtrack.zh_51_n_queens;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int total = 0;

    public boolean funQueens(int[][] result, int[] placeRecord, int row) {
        int ln = placeRecord.length;
        if (row == ln) {
            return true;
        }

        for (int col = 0; col < ln; col++) {
            placeRecord[row] = col;
            if (check(placeRecord, row)) {
                if (funQueens(result, placeRecord, row + 1) && row == ln - 1) {
                    total++;
                    result[total - 1] = new int[ln];
                    for (int i = 0; i < ln; i++) {
                        result[total - 1][i] = placeRecord[i];
                    }
                }
            }
        }

        return false;
    }


    public boolean check(int[] placeRecord, int desN) {
        for (int i = 0; i <= desN - 1; i++) {
            if ((Math.abs(placeRecord[i] - placeRecord[desN]) == desN - i) || placeRecord[i] == placeRecord[desN]) {
                return false;
            }
        }
        return true;
    }

    public boolean placeQueens(List<List<String>> resultList, int[] placeRecord, int row) {
        int ln = placeRecord.length;
        if (row == ln) {
            return true;
        }

        for (int col = 0; col < ln; col++) {
            placeRecord[row] = col;
            if (check(placeRecord, row)) {
                if (placeQueens(resultList, placeRecord, row + 1) && row == ln - 1) {
                    char[] line;
                    List<String> matrix = new ArrayList<String>();
                    for (int i = 0; i < ln; i++) {
                        line = new char[ln];
                        for (int j = 0; j < ln; j++) {
                            if (j != placeRecord[i]) {
                                line[j] = '.';
                            } else {
                                line[j] = 'Q';
                            }
                        }
                        matrix.add(new String(line));
                    }
                    resultList.add(matrix);
                }
            }
        }

        return false;
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> matrixList = new ArrayList<List<String>>();

        placeQueens(matrixList, new int[n], 0);

        return matrixList;
    }

    public void testFunQueens() {
        int n = 8;
        int[][] result = new int[92][n];
        Solution so = new Solution();
        so.funQueens(result, new int[n], 0);
        for (int i = 0; i < 92; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j] + ",");
            }
            System.out.println();
        }
        System.out.println(so.total);
    }

    public static void main(String[] args) {
        List<List<String>> matrixList = new Solution().solveNQueens(8);
        for (List<String> matrix : matrixList) {
            for (String line : matrix) {
                System.out.println(line);
            }
            System.out.println();
        }
        System.out.println(matrixList.size());
    }
}