package leetcode.misc.leet_zh_50;


public class Solution {
    /*
     * 50. Pow(x, n)
     * 执行用时 : 19 ms
     * 内存消耗 : 43.7 MB
     * 数学、二分查找
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

    public static void main(String[] args) {
        Solution ss = new Solution();
        System.out.println(ss.myPow(2, 3));
        System.out.println(ss.myPow(2, -2));
        System.out.println(ss.myPow(2, 2147483647));
    }
}