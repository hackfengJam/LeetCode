package leetcode.dynamic_programming.zh_70_climbing_stairs;


class Solution2 {

    /*
     * 输入: 42
     * 状态: TLE
     * */
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public static void main(String[] args) {
        Solution2 so = new Solution2();
        System.out.println(so.climbStairs(0));
        System.out.println(so.climbStairs(1));
        System.out.println(so.climbStairs(2));
        System.out.println(so.climbStairs(3));
        System.out.println(so.climbStairs(4));

    }
}