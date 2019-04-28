package weekly_contest.th_134.leet_zh_5040;

public class Solution {
    /*
     *
     * 5040. 边框着色
     * TODO 待优化
     * */

    private int[][] dire = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};


    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        int R = grid.length;
        int C = grid[0].length;
        int[][] locationQueue = new int[R * C][2];
        int[][] visited = new int[R][C]; // 0-未被访问 1-入队 2-访问过且修改过 3-访问过且未修改

        int index = 0;
        int queueLen = 0;

        int desColor = grid[r0][c0];
        if (color == desColor)
            return grid;

        int[] location = new int[2];
        location[0] = r0;
        location[1] = c0;
        visited[r0][c0] = 1;

        // 入队
        locationQueue[index + queueLen] = location;
        queueLen++;

        while (queueLen != 0) {

            // 出队
            location = locationQueue[index++];
            queueLen--;

            int x = location[0];
            int y = location[1];

            boolean isEdge = false;
            for (int i = 0; i < dire.length; i++) {
                int newX = x + dire[i][0];
                int newY = y + dire[i][1];
                if (newX >= 0 && newX < R && newY >= 0 && newY < C) {
                    if (visited[newX][newY] == 0) {

                        if (grid[newX][newY] == desColor) {
                            visited[newX][newY] = 1;

                            location = new int[2];
                            location[0] = newX;
                            location[1] = newY;

                            // 入队
                            locationQueue[index + queueLen] = location;
                            queueLen++;

                        } else {
                            visited[newX][newY] = 3;

                            isEdge = true;
                        }
                    } else if (visited[newX][newY] == 3) {
                        isEdge = true;
                    }
//                    else if (visited[newX][newY] == 2 && grid[newX][newY] == desColor) {
//                        isEdge = false;
//                    }

                } else {
                    isEdge = true;
                }
                if (isEdge) {
                    grid[x][y] = color;
                    visited[x][y] = 2;
                }

            }
        }


        return grid;
    }

    public static void main(String[] args) {
        Solution ss = new Solution();

//        int[][] grid = {{1, 1}, {1, 2}};
//        grid = ss.colorBorder(grid, 0, 0, 3);
//
//        int[][] grid = {{1, 2, 2}, {2, 3, 2}};
//        grid = ss.colorBorder(grid, 0, 1, 3);
//        int[][] grid = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
//        int[][] grid = {{1, 2, 1, 2, 1, 2}, {2, 2, 2, 2, 1, 2}, {1, 2, 2, 2, 1, 2}};
        int[][] grid = {{2, 1, 3, 2, 1, 1, 3}, {1, 2, 3, 1, 2, 1, 2}, {1, 2, 1, 2, 2, 2, 2}, {2, 1, 2, 2, 2, 2, 2}, {2, 3, 3, 3, 2, 1, 2}};

        grid = ss.colorBorder(grid, 4, 4, 3);


        for (int i = 0; i < grid.length; i++) {
            int[] line = grid[i];
            for (int j = 0; j < line.length; j++) {
                System.out.print(" " + grid[i][j]);
            }
            System.out.println();
        }
    }
}