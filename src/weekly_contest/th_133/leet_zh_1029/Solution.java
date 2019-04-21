package weekly_contest.th_133.leet_zh_1029;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int twoCitySchedCost(int[][] costs) {

        // 存储每个人去A和去B的差价
        List<Integer> diff = new ArrayList<>();

        // 假设全部去A，所求得总和
        int ans = 0;
        for (int i = 0; i < costs.length; i++) {
            diff.add(costs[i][1] - costs[i][0]);
            ans += costs[i][0];
        }

        // 找到差价最少的
        Collections.sort(diff);

        // 求和
        int mid = diff.size() / 2;
        for (int i = 0; i < mid; i++)
            ans += diff.get(i);
        return ans;
    }

    public static void main(String[] args) {
        int[][] costs = {{10, 20}, {30, 200}, {400, 50}, {30, 20}};

        Solution ss = new Solution();

        System.out.println(ss.twoCitySchedCost(costs));
    }
}