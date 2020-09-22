package leetcode.algo.graph_theory.leet_zh_207;

import java.util.*;

public class Solution3 {

    /*
     * 207. 课程表
     *
     * 拓扑排序
     *
     * 执行用时 : 21 ms, 在Course Schedule的Java提交中击败了57.65% 的用户
     * 内存消耗 : 44.5 MB, 在Course Schedule的Java提交中击败了70.29% 的用户

    时间复杂度：O(n + e)，其中n为图中的结点数目，e为图中的边的数目

    空间复杂度：O(n)

     * */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) return true;


        // 稀疏图
        Map<Integer, List<Integer>> sparseGraph = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            sparseGraph.put(i, new ArrayList<>());
        }

        // 构建稀疏图
        for (int i = 0; i < prerequisites.length; i++) {
            sparseGraph.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        // 各顶点入度
        int[] inDegree = new int[numCourses];

        // 初始化各顶点入度
        for (int v : sparseGraph.keySet()) {
            List<Integer> line = sparseGraph.get(v);
            for (int child : line) {
                inDegree[child]++;
            }
        }

        // 入度为0放入队列
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0)
                deque.offer(i);
        }

        int cnt = 0;
        while (!deque.isEmpty()) {
            int curr = deque.poll();
            cnt++;
            for (int child : sparseGraph.get(curr)) {
                inDegree[child]--;
                if (inDegree[child] == 0) {
                    deque.offer(child);
                }
                if (inDegree[child] < 0)
                    return false;
            }
        }

        return cnt == numCourses;
    }

    public static void main(String[] args) {
        Solution3 ss = new Solution3();
//        int[][] prerequisites = {{1, 0}};
//        int[][] prerequisites = {{1, 0}, {0, 1}};
        int[][] prerequisites = {{0, 1}, {3, 1}, {1, 3}, {3, 2}};
//        int[][] prerequisites = {{1, 0}, {2, 0}};
//        int[][] prerequisites = {{1, 0}, {2, 0}, {0, 3}};
//        int[][] prerequisites = {{0, 1}, {0, 2}, {1, 2}};
//        int[][] prerequisites = {};
        int numCourses = 4;
        System.out.println(ss.canFinish(numCourses, prerequisites));
    }
}