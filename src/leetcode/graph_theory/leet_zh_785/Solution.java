package leetcode.graph_theory.leet_zh_785;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    /*
     *
     * 785. 判断二分图
     * 执行用时 : 55 ms, 在Is Graph Bipartite?的Java提交中击败了5.41% 的用户
     * 内存消耗 : 48.3 MB, 在Is Graph Bipartite?的Java提交中击败了46.81% 的用户

     * 78 / 78 个通过测试用例
     * 执行用时：55 ms
     * */
    private Map<Integer, List<Integer>> sparseGraph;
    private int[] visited;
    private final int[] COLORS = {1, 2};

    public boolean isBipartite(int[][] graph) {
        sparseGraph = new HashMap<>();

        for (int i = 0; i < graph.length; i++) {
            int[] line = graph[i];
            for (int j = 0; j < line.length; j++) {
                int x = i;
                int y = line[j];
                if (!sparseGraph.containsKey(x)) {
                    sparseGraph.put(x, new ArrayList<>());
                }
                if (!sparseGraph.containsKey(y)) {
                    sparseGraph.put(y, new ArrayList<>());
                }
                sparseGraph.get(x).add(y);
                sparseGraph.get(y).add(x);
            }
        }

        int N = graph.length;
        visited = new int[N];
        for (int i = 0; i < N; i++) {
            visited[i] = -1;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i] != -1) {
                continue;
            }
            for (int k = 0; k < COLORS.length; k++) {
                visited[i] = COLORS[k];
                if (dfs(i)) break;
            }
        }

        for (int i = 0; i < graph.length; i++) {
            int[] line = graph[i];
            for (int j = 0; j < line.length; j++) {
                int x = i;
                int y = line[j];
                if (visited[x] == visited[y])
                    return false;
            }
        }
        return true;
    }

    private boolean dfs(int i) {
        List<Integer> line = sparseGraph.get(i);
        if (line == null) return true;
        for (int j = 0; j < line.size(); j++) {
            int v = line.get(j);
            if (visited[v] == visited[i]) return false;
            if (visited[v] != -1) continue;
            for (int k = 0; k < COLORS.length; k++) {
                if (COLORS[k] == visited[i]) continue;
                visited[v] = COLORS[k];
                if (dfs(v)) break;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
//        int[][] graph = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
//        int[][] graph = {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
        int[][] graph = {{4}, {}, {4}, {4}, {0, 2, 3}};
        System.out.println(ss.isBipartite(graph));
    }
}
