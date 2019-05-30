package leetcode.misc.leet_zh_229;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /*
     *
     * 229. 求众数 II
     *
     * 执行用时 : 5 ms, 在Majority Element II的Java提交中击败了71.15% 的用户
     * 内存消耗 : 44.9 MB, 在Majority Element II的Java提交中击败了26.60% 的用户
     *
     * 摩尔根投票法 变形

     * */
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> rev = new ArrayList<>();
        int ln = nums.length;
        if (ln == 0) return rev;

        // 至多有两个解，具体证明自行查询资料
        int a = -1, aSize = 0;
        int b = -1, bSize = 0;

        // 找到可能的解
        for (int num : nums) {
            if (aSize != 0 && a == num) {
                aSize++;
            } else if (bSize != 0 && b == num) {
                bSize++;
            } else if (aSize == 0) {
                a = num;
                aSize++;
            } else if (bSize == 0) {
                b = num;
                bSize++;
            } else {
                aSize--;
                bSize--;
            }
        }
        int retA = 0;
        int retB = 0;

        // 再次统计
        for (int num : nums) {
            if (num == a && aSize != 0)
                retA++;
            if (num == b && bSize != 0)
                retB++;
        }

        if (retA > ln / 3)
            rev.add(a);

        if (retB > ln / 3)
            rev.add(b);

        return rev;
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
//        int[] nums = {3, 2, 3};
//        int[] nums = {0, -1, 2, -1};
//        int[] nums = {-1, 1, 1, 1, 2, 1};
        int[] nums = {1, 1, 1, 3, 3, 2, 2, 2};
        List<Integer> ret = ss.majorityElement(nums);
        for (Integer item : ret) {
            System.out.println(item);
        }
    }
}