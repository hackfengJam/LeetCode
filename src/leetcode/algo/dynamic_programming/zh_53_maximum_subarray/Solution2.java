package leetcode.algo.dynamic_programming.zh_53_maximum_subarray;

class Solution2 {
    /*
     * 执行用时 : 16 ms
     * 内存消耗 : 51.2 MB*/
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] res = new int[nums.length];
        res[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 0~i i~j j~n
            res[i] = Math.max(nums[i] + res[i - 1], nums[i]);
        }
        int max = res[0];
        for (int j = 1; j < res.length; j++) {
            if (res[j] > max) {
                max = res[j];
            }
        }
        return max;
    }

    public void printArr(int[][] nums) {

        int[] line;
        for (int i = 0; i < nums.length; i++) {
            line = nums[i];
            for (int j = 0; j < line.length; j++) {
                System.out.print(String.format("%2d ", line[j]));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        Solution2 so = new Solution2();
        System.out.println(so.maxSubArray(nums));
    }
}