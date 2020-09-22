package leetcode.algo.graph_theory.leet_zh_207;

import java.util.*;

public class Solution {

    /*
     * 207. 课程表
     * 执行用时 : 606 ms, 在Course Schedule的Java提交中击败了5.07% 的用户
     * 内存消耗 : 107.2 MB, 在Course Schedule的Java提交中击败了5.11% 的用户
    DFS
     * */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) return true;

        int start = Integer.MAX_VALUE;

        // 构建 稀疏图
        Map<Integer, Set<Integer>> sparseGraph = new HashMap<>();

        for (int i = 0; i < prerequisites.length; i++) {
            // edge start
            int eStart = prerequisites[i][0];
            // edge end
            int eEnd = prerequisites[i][1];

            if (!sparseGraph.containsKey(eStart))
                sparseGraph.put(eStart, new HashSet<>());
            if (!sparseGraph.containsKey(eEnd))
                sparseGraph.put(eEnd, new HashSet<>());

            // update start
            if (eStart < start) start = eStart;

            sparseGraph.get(eStart).add(eEnd);
        }

        for (Integer vStart : sparseGraph.keySet()) {
            // 标记
            Map<Integer, Boolean> visited = new HashMap<>();
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(vStart);
            visited.put(vStart, true);

            while (!queue.isEmpty()) {
                int eStart = queue.poll();
                Set<Integer> vSet = sparseGraph.get(eStart);
                if (vSet == null || vSet.size() == 0) {
                    continue;
                }
                for (Integer v : vSet) {
                    if (visited.getOrDefault(v, false)) {
                        if (v.equals(vStart))
                            return false;
                        continue;
                    }
                    queue.offer(v);
                    visited.put(v, true);
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
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