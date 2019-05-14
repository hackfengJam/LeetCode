package weekly_contest.th_136.leet_zh_5056;

import java.util.*;

public class Solution {
    /*
     * 5056. 不邻接植花
     *
     *
     * 51 / 51 个通过测试用例
     * 执行用时：36 ms
     * */
    private int[] visited;
    private Map<Integer, List<Integer>> sparseGraph;
    private final int[] colors = {1, 2, 3, 4};

    public int[] gardenNoAdj(int N, int[][] paths) {
        sparseGraph = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            sparseGraph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < paths.length; i++) {
            int[] location = paths[i];
            int x = location[0];
            int y = location[1];
            sparseGraph.get(x).add(y);
            sparseGraph.get(y).add(x);
        }
        visited = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            visited[i] = -1;
        }

        for (int i = 1; i <= N; i++) {
            if (visited[i] != -1) {
                continue;
            }
            for (int k = 0; k < colors.length; k++) {
                visited[i] = colors[k];
                if (dfs(i)) break;
            }
        }
        int[] ret = new int[N];
        for (int i = 0; i < N; i++) {
            ret[i] = visited[i + 1];
        }
        return ret;
    }

    private boolean dfs(int i) {
        List<Integer> line = sparseGraph.get(i);
        for (int j = 0; j < line.size(); j++) {
            int v = line.get(j);
            if (visited[v] == visited[i]) return false;
            if (visited[v] != -1) continue;
            for (int k = 0; k < colors.length; k++) {
                if (colors[k] == visited[i]) continue;
                visited[v] = colors[k];
                if (dfs(v)) break;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
//        int[][] paths = {{1, 2}, {2, 3}, {3, 1}};
//        int N = 3;
//        int[][] paths = {{1, 2}, {3, 4}};
        int[][] paths = {{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 3}, {2, 4}};
        int N = 4;
        int[] ret = ss.gardenNoAdj(N, paths);
        for (int i = 0; i < ret.length; i++) {
            System.out.print(ret[i] + " ");
        }
    }
}
