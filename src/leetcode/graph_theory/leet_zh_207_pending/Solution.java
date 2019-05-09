package leetcode.graph_theory.leet_zh_207_pending;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // 稀疏图
        Map<Integer, List<Integer>> sparseGraph = new HashMap<>();

        return false;
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        int[][] prerequisites = {{1, 0}};
        int numCourses = 2;
        System.out.println(ss.canFinish(numCourses, prerequisites));
    }
}