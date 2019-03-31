package weekly_contest.th_130.leet_zh_1031;

public class Solution2 {
    /*
     * 1031. 飞地的数量
     * */

    private int[][] dirc = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private int total = 0;
    private int cnt = 0;
    private int[][] visited;
    private int[][] vi;

    private boolean inArea(int[][] A, int i, int j) {
        if (A.length == 0)
            return false;
        if (i < 0 || i >= A.length || j < 0 || j >= A[0].length)
            return false;
        return true;
    }

    private int cntTotal(int[][] A) {
        if (A.length == 0)
            return 0;

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                total += A[i][j];
                visited[i][j] = 0;
                vi[i][j] = 0;
            }
        }
        return total;
    }

    private void init(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                visited[i][j] = 0;
            }
        }
    }

    private void dfs(int[][] A, int i, int j) {
        if (!inArea(A, i, j) || A[i][j] != 1)
            return;
        if (visited[i][j] == 1) {
            return;
        }
        if (vi[i][j] != 1) {
            cnt++;
            vi[i][j] = 1;
        }
        visited[i][j] = 1;

        for (int m = 0; m < dirc.length; m++) {
            int newX = i + dirc[m][0];
            int newY = j + dirc[m][1];
            if (inArea(A, i, j))
                dfs(A, newX, newY);
        }
        return;
    }

    public int numEnclaves(int[][] A) {
        if (A.length == 0)
            return 0;

        int h = A.length;
        int w = A[0].length;

        visited = new int[h][w];
        vi = new int[h][w];
        cntTotal(A);

        int[] xH = {0, h - 1};
        int[] yH = {0, w - 1};

        // 上下边
        for (int i : xH) {
            for (int j = 0; j < w; j++) {
                dfs(A, i, j);
            }
            if (cnt == total)
                return 0;
            init(A);
        }

        // 左右边
        for (int j : yH) {
            for (int i = 0; i < h; i++) {
                dfs(A, i, j);
            }
            if (cnt == total)
                return 0;
            init(A);
        }

        return total - cnt;
    }

    public static void main(String[] args) {

        Solution2 ss = new Solution2();
//        int[][] nums = {{0, 0, 0, 0}, {1, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}};
        int[][] nums = {{0, 1, 1, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}};
        System.out.println(ss.numEnclaves(nums));

    }
}
