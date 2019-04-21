package weekly_contest.th_133.leet_zh_1030;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    private class Location {
        private int x;
        private int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    private int[][] dire = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] matrix = new int[R][C];

        int[][] ans = new int[R * C][2];
        int k = 0;
        Queue<Location> locations = new LinkedList<>();

        locations.offer(new Location(r0, c0));
        while (!locations.isEmpty()) {
            Location location = locations.poll();
            int x = location.x;
            int y = location.y;
            if (matrix[x][y] == 1)
                continue;

            matrix[x][y] = 1;

            int[] loc = new int[2];
            loc[0] = x;
            loc[1] = y;
            ans[k++] = loc;

            for (int i = 0; i < dire.length; i++) {
                int newX = x + dire[i][0];
                int newY = y + dire[i][1];
                if (newX >= 0 && newX < R && newY >= 0 && newY < C) {
                    locations.offer(new Location(newX, newY));
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        Solution ss = new Solution();
        int ans[][];

        ans = ss.allCellsDistOrder(1, 2, 0, 0);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i][0] + " : " + ans[i][1]);
        }

        System.out.println("----------------------------");

        ans = ss.allCellsDistOrder(2, 2, 0, 1);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i][0] + " : " + ans[i][1]);
        }

        System.out.println("----------------------------");

        ans = ss.allCellsDistOrder(2, 3, 1, 2);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i][0] + " : " + ans[i][1]);
        }
    }
}