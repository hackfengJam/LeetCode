package weekly_contest.th_129.leet_zh_1022;

class Solution {

    public int smallestRepunitDivByK(int K) {
        long n = 0;
        for (int i = 1; i <= Math.pow(10, 5); i++) {
            n = (n * 10 + 1) % K;
            if (n % K == 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        System.out.println(Math.pow(2, 32) - 1);
        System.out.println(Math.pow(2, 64));
        // 2.147483648 10^9
        // 4.294967295 10^9
        // 1111111111
        Solution sol = new Solution();
        long x = 1111111111111111111L;
        System.out.println();
        System.out.println(sol.smallestRepunitDivByK(1));
        System.out.println(sol.smallestRepunitDivByK(2));
        System.out.println(sol.smallestRepunitDivByK(3));
        System.out.println(sol.smallestRepunitDivByK(17));
        System.out.println(sol.smallestRepunitDivByK(5));
        System.out.println(sol.smallestRepunitDivByK(147));
        System.out.println(Math.pow(10, 5));
    }
}