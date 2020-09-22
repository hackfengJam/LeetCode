package leetcode.algo.misc.leet_zh_15;


public class Solution {
    /*
        给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
        注意：答案中不可以包含重复的三元组。

        示例：

        给定数组 nums = [-1, 0, 1, 2, -1, -4]，
        满足要求的三元组集合为：
        [
          [-1, 0, 1],
          [-1, -1, 2]
        ]

     * */
    public double myPow(double x, int n) {
        int cn = n;
        double res = 1.0;
        while (cn != 0) {
            if (cn % 2 != 0)
                res *= x;
            x = x * x;
            cn = cn / 2;
        }
        // cn = 2**n-1 + 2**n-2 + 2**x
        return n > 0 ? res : 1.0 / res;
    }

    private void Sort(int[] nums) {
        quickSort3Ways(nums, 0, nums.length-1);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void quickSort3Ways(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }

//        int p = (l+r) / 2;
        int p = (int)(Math.random()*(r-l+1)) + l;

        swap(nums, l, p);

        int v = nums[l];

        int lt = l;
        int gt = r+1;
        int i = lt+1;

        while (i < gt) {
            if (nums[i] < v) {
                swap(nums, i, lt+1);
                i++;
                lt++;
            } else if (nums[i] > v) {
                swap(nums, i, gt-1);
                gt--;
            } else {
                i++;
            }
        }

        swap(nums, l, lt);

        quickSort3Ways(nums, l, lt-1);
        quickSort3Ways(nums, gt, r);
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        ss.Sort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}