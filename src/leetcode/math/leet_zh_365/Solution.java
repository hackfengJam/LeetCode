package leetcode.math.leet_zh_365;

public class Solution {
    /*
     * gcd(a,b)
     * a % b == 0 ? b: gcd(b, a % b)
     * */

    /*
     * 365. Water and Jug Problem
     * 内存消耗 : 31.6 MB
     * 执行用时 : 0 ms
     * */
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public boolean canMeasureWater(int x, int y, int z) {
        if (z == 0 || x + y == z)
            return true;
        if (x + y < z)
            return false;

        int d = gcd(x, y);
        return z % d == 0;
    }



    public static void main(String[] args) {
        Solution ss = new Solution();
        System.out.println(ss.gcd(12, 9));
        System.out.println(ss.gcd(3, 5));
        System.out.println(ss.gcd(2, 6));
        System.out.println(ss.gcd(0, 1));
        System.out.println(ss.canMeasureWater(0, 0, 0));
        System.out.println(ss.canMeasureWater(1, 0, 1));
        System.out.println(ss.canMeasureWater(3, 5, 4));
        System.out.println(ss.canMeasureWater(2, 6, 5));
        System.out.println(ss.canMeasureWater(1, 1, 12));
    }
}
