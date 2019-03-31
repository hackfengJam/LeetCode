package weekly_contest.th_130.leet_zh_1031;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    /*
     * 1031. 飞地的数量
     * 23 ms
     * */

    private class Pair {
        private int x;
        private int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    private Pair make_pair(int i, int j) {
        return new Pair(i, j);
    }

    public int numEnclaves(int[][] A) {
        if (A.length == 0)
            return 0;

        int h = A.length;
        int w = A[0].length;
        int[][] dirc = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        Queue<Pair> q = new LinkedList<>();
        int[][] visited = new int[h][w];

        int[] xH = {0, h - 1};
        int[] yH = {0, w - 1};

        // 上下边
        for (int i : xH) {
            for (int j = 0; j < w; j++) {
                if (A[i][j] == 1) {
                    ((LinkedList<Pair>) q).push(make_pair(i, j));
                    visited[i][j] = 1;
                }
            }
        }

        // 左右边
        for (int j : yH) {
            for (int i = 0; i < h; i++) {
                if (A[i][j] == 1) {
                    ((LinkedList<Pair>) q).push(make_pair(i, j));
                    visited[i][j] = 1;
                }
            }
        }

        Pair pair;
        while (!q.isEmpty()) {

            pair = ((LinkedList<Pair>) q).pop();
            for (int i = 0; i < dirc.length; i++) {
                int newX = pair.getX() + dirc[i][0];
                int newY = pair.getY() + dirc[i][1];

                if (newX < 0 || newX >= A.length || newY < 0 || newY >= A[0].length) continue;
                if (A[newX][newY] == 0 || visited[newX][newY] == 1) continue;
                ((LinkedList<Pair>) q).push(make_pair(newX, newY));
                visited[newX][newY] = 1;
            }
        }

        int ans = 0;
        for (int i = 0; i < h; i++)
            for (int j = 0; j < w; j++) {
                if (A[i][j] == 1 && visited[i][j] != 1) {
                    ans++;
                }
            }
        return ans;
    }

    public static void main(String[] args) {

        Solution ss = new Solution();
        /*
         * 0000
         * 1010
         * 0110
         * 0000
         * */
        int[][] nums = {{0, 0, 0, 0}, {1, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}};
//        int[][] nums = {{0, 1, 1, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}};
        System.out.println(ss.numEnclaves(nums));

    }
}
