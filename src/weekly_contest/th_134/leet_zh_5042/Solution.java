package weekly_contest.th_134.leet_zh_5042;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    /*
     *
     * 5042. 逃离大迷宫
     *
     * */
//    private int[][] dire = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
    private class Location {
        private int x;
        private int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    private int[][] dire = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};


    private static int N = 1000000;

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        if (blocked.length == 0)
            return true;
        int[][] board = new int[N][N];
        boolean[][] visited = new boolean[N][N];
        for (int i = 0; i < blocked.length; i++) {
            int[] location = blocked[i];
            board[location[0]][location[1]] = 1;
        }
        Queue<Location> queue = new LinkedList<>();
        queue.offer(new Location(source[0], source[1]));
        while (!queue.isEmpty()) {
            Location lo = queue.poll();
            visited[lo.x][lo.y] = true;
            for (int i = 0; i < dire.length; i++) {
                int newX = lo.x + dire[i][0];
                int newY = lo.x + dire[i][1];
                if (newX >= 0 && newX < N && newY >= 0 && newY < N) {
                    if (newX == target[0] && newY == target[1])
                        return true;
                    else {
                        if (!visited[newX][newY]) queue.offer(new Location(newX, newY));
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        int[][] board = {{0, 1}, {1, 0}};
        int[] source = {0, 0};
        int[] target = {0, 2};
        System.out.println(ss.isEscapePossible(board, source, target));
    }
}