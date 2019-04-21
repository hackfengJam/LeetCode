package weekly_contest.th_133.leet_zh_1031;

class Solution {

    // 暂不使用
    private int[] findMax(int[] AA, int start, int end, int d) {

        int[] ans = new int[AA.length];
        ans[start] = AA[start];
        for (int i = start + 1; i < end; i++) {
            if (i - start >= d) {
                ans[i] = ans[i - 1] + AA[i] - AA[i - d];
            } else {
                ans[i] += ans[i - 1] + AA[i];
            }
        }

        int[] max = new int[2];
        for (int i = 0; i < AA.length; i++)
            if (ans[i] > max[1]) {
                max[0] = i;
                max[1] = ans[i];
            }
        return max;
    }

    private boolean isOk(int[] A, int L, int M, int i, int j) {
        return i + L <= A.length && j + M <= A.length && (j >= i + L || i >= j + M);
    }

    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int[] pre = new int[A.length + 1];
        pre[0] = 0;

        // pre[i + 1] = A[0] + A[1] +...+ A[i];
        for (int i = 0; i < A.length; i++) {
            pre[i + 1] = pre[i] + A[i];
        }
        int ret = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (isOk(A, L, M, i, j)) {
                    ret = Math.max(ret, pre[i + L] - pre[i] + pre[j + M] - pre[j]);
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {

        Solution ss = new Solution();

//        int[] nums = {0, 6, 5, 2, 2, 5, 1, 9, 4};
//        System.out.println(ss.maxSumTwoNoOverlap(nums, 1, 2));

//        int[] nums = {3,8,1,3,2,1,8,9,0};
//        System.out.println(ss.maxSumTwoNoOverlap(nums, 3, 2));


//        int[] nums = {8, 20, 6, 2, 20, 17, 6, 3, 20, 8, 12};
//        System.out.println(ss.maxSumTwoNoOverlap(nums, 5, 4));
//
//        int[] nums = {2, 1, 5, 6, 0, 9, 5, 0, 3, 8};
//        System.out.println(ss.maxSumTwoNoOverlap(nums, 4, 3));

        int[] nums = {1, 0, 3};
        System.out.println(ss.maxSumTwoNoOverlap(nums, 1, 2));


    }
}