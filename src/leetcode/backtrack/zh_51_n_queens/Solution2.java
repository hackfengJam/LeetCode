package leetcode.backtrack.zh_51_n_queens;

import java.util.ArrayList;
import java.util.List;

class Solution2 {
    /*
     * Title: 51. N 皇后
     * Link : https://leetcode-cn.com/problems/n-queens/
     * Label: ["回溯算法"]
     * Level: Hard
     * Desc :
     * 输入：4
        输出：[
         [".Q..",  // 解法 1
          "...Q",
          "Q...",
          "..Q."],

         ["..Q.",  // 解法 2
          "Q...",
          "...Q",
          ".Q.."]
        ]
        解释: 4 皇后问题存在两个不同的解法。

     *
     * 执行用时 :  5 ms
     * 内存消耗 :  40 MB
     * */
    public boolean check(int[] placeRecord, int desN) {
        for (int i = 0; i <= desN - 1; i++) {
            if ((Math.abs(placeRecord[i] - placeRecord[desN]) == desN - i) || placeRecord[i] == placeRecord[desN]) {
                return false;
            }
        }
        return true;
    }

    public List<String> constructPlace(int[] placeRecord) {
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < placeRecord.length; i++) {
            char[] line = new char[placeRecord.length];
            for (int j = 0; j < placeRecord.length; j++) {
                line[j] = '.';
            }
            line[placeRecord[i]] = 'Q';
            ret.add(new String(line));
        }
        return ret;
    }

    public List<List<String>> solveNQueens(int n) {
        int[] placeRecord = new int[n];
        for (int i = 0; i < n; i++) {
            placeRecord[i] = -1;
        }

        int row = 0;
        List<List<String>> res = new ArrayList<>();

        while (row >= 0) {
            while (placeRecord[row] < n - 1) {
                placeRecord[row]++;
                if (check(placeRecord, row)) {
                    if (row == n - 1) {
                        // record
                        res.add(constructPlace(placeRecord));
                        break;
                    }
                    row++;
                }
            }
            placeRecord[row] = -1;
            row--;
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<String>> matrixList = new Solution2().solveNQueens(8);
        for (List<String> matrix : matrixList) {
            for (String line : matrix) {
                System.out.println(line);
            }
            System.out.println();
        }
        System.out.println(matrixList.size());
    }
}