package leetcode.weekly_contest_129.leet_zh_1021;

class Solution2 {
    public int maxScoreSightseeingPair(int[] A) {
        int max = 0;
        int sum[] = new int[A.length];
        sum[0] = A[0] + 0;
        for (int i = 1; i < A.length; i++) {
            int num = A[i] + i;
            sum[i] = Math.max(num, sum[i - 1]);

        }

        for (int i = 1; i < A.length; i++) {
            max = Math.max(A[i] - i + sum[i - 1], max);
        }
        return max;
    }
    // res[i][j] = A[i] + A[j] + i - j;
    // max(res[i][j])

    public static void main(String[] args) {
        int[] nums = {8, 1, 5, 2, 6};
//        int N = 1000000;
//        int[] nums = new int[N];
//        Random random = new Random();
//        for (int i = 0; i < N; i++) {
//            nums[i] = random.nextInt(1000) + 1;
//        }
        Solution2 ss = new Solution2();
        System.out.println(ss.maxScoreSightseeingPair(nums));
    }
}
