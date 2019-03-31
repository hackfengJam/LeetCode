package weekly_contest.th_130.leet_zh_1029;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /*
     * 1029. 可被 5 整除的二进制前缀
     * */
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res = new ArrayList<>();
        int a = 0;
        for (int i = 0; i < A.length; i++) {
            a = a << 1 | A[i];
            a = a % 5;
            res.add(a == 0);
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(1 << 1);
//        System.out.println(1 << 1 | 1);
//        System.out.println((1 << 3) % 5);
//        System.out.println(((1 << 3) % 5) % 5);
//        System.out.println(1 << 3);

        Solution ss = new Solution();
        int[] nums = {0, 1, 1};
        int[] nums2 = {1, 1, 1};
        int[] nums3 = {0, 1, 1, 1, 1, 1};
        int[] nums4 = {1, 1, 1, 0, 1};
        System.out.println(ss.prefixesDivBy5(nums));
        System.out.println(ss.prefixesDivBy5(nums2));
        System.out.println(ss.prefixesDivBy5(nums3));
        System.out.println(ss.prefixesDivBy5(nums4));
    }
}
