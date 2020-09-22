package leetcode.algo.graph_theory.leet_zh_207;

import java.util.*;

public class Solution2 {

    /*
     * 207. 课程表
     *
     * 执行用时 : 13 ms, 在Course Schedule的Java提交中击败了70.34% 的用户
     * 内存消耗 : 47.3 MB, 在Course Schedule的Java提交中击败了48.56% 的用户
     *
     * DFS
     * */
    private Map<Integer, List<Integer>> sparseGraph;
    private int[] visitStatus;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) return true;

        // 构建 稀疏图
        sparseGraph = new HashMap<>();
        visitStatus = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            sparseGraph.put(i, new ArrayList<>());
            visitStatus[i] = 0;
        }

        for (int i = 0; i < prerequisites.length; i++) {
            sparseGraph.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (visitStatus[i] != 0)
                continue;
            if (!dfs(i))
                return false;
        }

        return true;
    }

    private boolean dfs(int i) {
        visitStatus[i] = 1;
        for (int j = 0; j < sparseGraph.get(i).size(); j++) {
            int v = sparseGraph.get(i).get(j);
            if (visitStatus[v] == 2)
                continue;
            if (visitStatus[v] == 1)
                return false;
            if (!dfs(v))
                return false;
        }
        visitStatus[i] = 2;
        return true;
    }

    public static void main(String[] args) {
        Solution2 ss = new Solution2();
//        int[][] prerequisites = {{1, 0}};
//        int[][] prerequisites = {{1, 0}, {0, 1}};
//        int[][] prerequisites = {{0, 1}, {3, 1}, {1, 3}, {3, 2}};
//        int[][] prerequisites = {{1, 0}, {2, 0}};
//        int[][] prerequisites = {{1, 0}, {2, 0}, {0, 3}};
        int[][] prerequisites = {{0, 1}, {0, 2}, {1, 2}};
//        int[][] prerequisites = {};
        int numCourses = 4;
        System.out.println(ss.canFinish(numCourses, prerequisites));
    }
}