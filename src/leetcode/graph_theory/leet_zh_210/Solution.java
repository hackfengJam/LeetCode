package leetcode.graph_theory.leet_zh_210;

import java.util.*;

public class Solution {

    /*
     * 210. 课程表 II
     *
     * 拓扑排序
     *
     * 执行用时 : 21 ms, 在Course Schedule II的Java提交中击败了51.89% 的用户
     * 内存消耗 : 45.9 MB, 在Course Schedule II的Java提交中击败了75.90% 的用户

    时间复杂度：O(n + e)，其中n为图中的结点数目，e为图中的边的数目

    空间复杂度：O(n)

     * */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (prerequisites == null) return new int[]{};

        int[] ret = new int[numCourses];
        int cnt = 0;

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

        while (!deque.isEmpty()) {
            int curr = deque.poll();
            ret[numCourses - (++cnt)] = curr;
            for (int child : sparseGraph.get(curr)) {
                inDegree[child]--;
                if (inDegree[child] == 0) {
                    deque.offer(child);
                }
                if (inDegree[child] < 0)
                    return new int[]{};
            }
        }

        return cnt == numCourses ? ret : new int[]{};
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        int[][] prerequisites = {};
//        int[][] prerequisites = {{1, 0}, {0, 1}};
//        int[][] prerequisites = {{0, 1}, {3, 1}, {1, 3}, {3, 2}};
//        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
//        int[][] prerequisites = {{1, 0}, {2, 0}};
//        int[][] prerequisites = {{1, 0}, {2, 0}, {0, 3}};
//        int[][] prerequisites = {{0, 1}, {0, 2}, {1, 2}};
//        int[][] prerequisites = {};
        int numCourses = 2;
//        int numCourses = 4;
        int[] ret = ss.findOrder(numCourses, prerequisites);
        for (int v : ret) {
            System.out.print(v + " ");
        }
    }
}