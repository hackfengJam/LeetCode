package weekly_contest.th_129.leet_zh_1020;

class Solution {
    private boolean canThreePartsEqualSum(int[] A, int i, int N) {
        int[] res = new int[2];
        res[0] = 0;
        res[1] = 0;
        boolean flag = false;
        for (int k = i + 1; k < A.length; k++) {
            if (!flag) {
                res[0] += A[k];
                if (res[0] == N) {
                    flag = true;
                }
            } else {
                res[1] += A[k];
            }
        }
        return (N == res[0] && N == res[1]);
    }

    public boolean canThreePartsEqualSum(int[] A) {
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            res += A[i];
            if (canThreePartsEqualSum(A, i, res))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
//        int[] nums = {0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1};
//        int[] nums = {0,2,1,-6,6,7,9,-1,2,0,1};
        int[] nums = {3, 3, 6, 5, -2, 2, 5, 1, -9, 4};

        Solution ss = new Solution();

        System.out.println(ss.canThreePartsEqualSum(nums));
    }
}