package leetcode.backtrack.zh_52_n_queens;


public class Solution {
    /*
     * 52. N皇后 II
     * 执行用时 : 10 ms
     * 内存消耗 : 32.4 MB
     * */
    public boolean check(int[] placeRecord, int desN) {
        for (int i = 0; i <= desN - 1; i++) {
            if ((Math.abs(placeRecord[i] - placeRecord[desN]) == desN - i) || placeRecord[i] == placeRecord[desN]) {
                return false;
            }
        }
        return true;
    }

    public int totalNQueens(int n) {
        if (n == 1)
            return 1;
        int total = 0;
        int row = 0;
        int[] placeRecord = new int[n + 1];
        for (int i = 0; i < placeRecord.length; i++) {
            placeRecord[i] = -1;
        }
        while (row >= 0) {
            while (placeRecord[row] < n - 1) {
                placeRecord[row]++;
                if (check(placeRecord, row)) {
                    row++;
                    if (row == n) {
                        total++;
                        break;
                    }
                }
            }
            placeRecord[row] = -1;
            row--;
        }
        return total;
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        int n = 14;// 16: 14772512
        Long startTime;
        for (int i = 1; i < n; i++) {
            startTime = System.nanoTime();
            System.out.println(i + ": " + ss.totalNQueens(i) + " -> " + (System.nanoTime() - startTime) / 1000000000.0 + " s");
        }
    }
}