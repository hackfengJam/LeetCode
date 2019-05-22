package leetcode.misc.leet_zh_172;

public class Solution {

    /*
     * 172. 阶乘后的零
     *  1 2 3 4 5 6 7 8 9 10
     *
     *
     *  执行用时 : 3 ms, 在Factorial Trailing Zeroes的Java提交中击败了97.45% 的用户
     *  内存消耗 : 33.6 MB, 在Factorial Trailing Zeroes的Java提交中击败了79.72% 的用户

     *  思路：
        n! = x * (10)^k^ = x * (2 ^k^ * 5^k^)
        k即为末尾0的个数
        其中x可能是2的倍数, 所以2的个数一定比5多
        而n!为递减相乘, 只需要统计n中5的个数


        举个复杂点的例子： 10！ = [2 （ 2 * 2 ） 5 （ 2 * 3 ）（ 2 * 2 * 2 ）*（ 2 * 5）]
        在 10！这个阶乘数中可以匹配两对 2 * 5 ，所以10！末尾有 2 个 0。可以发现，一个数字进行拆分后 2 的个数肯定是大于 5 的个数的，
        所以能匹配多少对取决于 5 的个数。（好比现在男女比例悬殊，最多能有多少对异性情侣取决于女生的多少）。
        那么问题又变成了 统计阶乘数里有多少个 5 这个因子。 需要注意的是，像 25，125 这样的不只含有一个 5 的数字的情况需要考虑进去。
        比如 n = 15。那么在 15! 中 有 3 个 5 (来自其中的5, 10, 15)， 所以计算 n/5 就可以 。但是比如 n=25，依旧计算 n/5 ，可以得到 5 个5，
        分别来自其中的5, 10, 15, 20, 25，但是在 25 中其实是包含 2个 5 的，这一点需要注意。
        所以除了计算 n/5 ， 还要计算 n/5/5 , n/5/5/5 , n/5/5/5/5 , ..., n/5/5/5,,,/5直到商为0，然后求和即可。
     * */
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        int n = 10;
        System.out.println(ss.trailingZeroes(n));
    }
}
