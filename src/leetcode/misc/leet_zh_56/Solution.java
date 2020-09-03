package leetcode.misc.leet_zh_56;

import java.util.*;

public class Solution {
    /*
     * Title: 56. 合并区间
     * Link : https://leetcode-cn.com/problems/merge-intervals/
     * Label: ["数组", "排序"]
     * Level: Medium
     * Desc :
     * 给出一个区间的集合，请合并所有重叠的区间。

    示例 1:

    输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
    输出: [[1,6],[8,10],[15,18]]
    解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
    示例 2:

    输入: intervals = [[1,4],[4,5]]
    输出: [[1,5]]
    解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。

    提示：

    intervals[i][0] <= intervals[i][1]

     *
     * 执行用时 :  7 ms
     * 内存消耗 :  42.4 MB
     * */
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1)
            return intervals;

        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] > o2[0]) {
                return 1;
            } else if (o1[0] < o2[0]) {
                return -1;
            } else {
                return o1[1] - o2[1];
            }
        });

        List<int[]> arr = new ArrayList<>();

        int l = 0;
        while (l < intervals.length) {
            int[] segL = intervals[l];

            for (; l < intervals.length - 1 && segL[1] >= intervals[l + 1][0]; l++) {
                segL[1] = Math.max(intervals[l + 1][1], segL[1]);
            }

            arr.add(segL);
            l++;
        }

        return arr.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        Solution ss = new Solution();

        int[][] nums = new int[][]{{2, 6}, {8, 10}, {1, 3}, {15, 18}};
//        int[][] nums = new int[][]{{1, 4}, {2, 3}};
        int[][] ret = ss.merge(nums);
        for (int i = 0; i < ret.length; i++) {
            for (int j = 0; j < ret[i].length; j++) {
                System.out.print(ret[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

    }
}
