package leetcode.algo.union_find.leet_zh_547;

public class SolutionDFS {
    /*
     * 执行用时 : 12 ms
     * 内存消耗 : 57.1 MB
     * 深度搜索
     * */
    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int cnt = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 1) {
                continue;
            }

            visited[i] = 1;
            dfs(i, M, visited);
            cnt += 1;
        }
        return cnt;
    }

    public void dfs(int i, int[][] M, int[] visited) {
        for (int j = 0; j < M[i].length; j++) {
            if (visited[j] == 1) {
                continue;
            }
            if (M[i][j] == 1) {
                visited[j] = 1;
                dfs(j, M, visited);
            }
        }
    }

    public static void main(String[] args) {
        int[][] M = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}};
//        int[][] M = {
//                {1, 1, 0},
//                {1, 1, 1},
//                {0, 1, 1}};
        System.out.println(new SolutionDFS().findCircleNum(M));
    }
}
