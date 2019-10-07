package leetcode.math.base;

import leetcode.math.leet_zh_365.Solution;

public class Base {


    // 最大公约数，辗转相处/欧几里得算法
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    /*
     *
     * 扩展欧几里得算法
     * 基本算法：对于不完全为 0 的非负整数 a，b，gcd（a，b）表示 a，b 的最大公约数，必然存在整数对 x，y ，使得 gcd（a，b）=ax+by。
     * 证明：设 a>b。
     * 1. 显然当 b=0, gcd(a, b) = a。此时x=1, y=0;
     * 2. ab != 0 时
     * 设 ax1 + by1 = gcd(a, b)
     *
     * gcd(a, b) = gcd(a, a mod b) // 根据朴素的欧几里得原理
     *
     * ax1 + by1 = gcd(a, b)
     * bx2 + (a mod b)y2 = gcd(b, a mod b)
     *
     * ax1 + by1 = bx2 + (a mod b)y2
     *
     * ax1 + by1
     * = bx2 + (a - (a/b) * b)y2
     * = ay2 + bx2 - (a/b)*by2
     * = ay2 + b(x2 - (a/b)*y2)
     *
     * 根据恒等定理得：x1=y2; y1 = x2 - (a/b)*y2
     * 这样我们就得到了求解x1, y1 的方法；x1, y1 的值基于 x2, y2;
     * 上面的思想是以递归定义的，因为 gcd 不断的递归求解一定会有个时候 b=0，所以递归可以结束。
     *
     * a = x + kb/gcd(a,b)
     * b = y - ka/gcd(a,b)
     *
     * y = b + ka/gcd(a,b) //  5 = -1 + k*3/1
     * x = a - kb/gcd(a,b) //  3 =  2 - k*5/1
     * */
    private int x = 0, y = 0;

    private int exgcd(int a, int b) {
        if (b == 0) {
            x = 1;
            y = 0;
            return a;
        }
        int r = exgcd(b, a % b);
        int t = x;
        x = y;
        y = t - a / b * y;
        return r;
    }

    private int linear_exgcd(int a, int b, int c) {
        int r = exgcd(a, b);
        if (c % r != 0) {
            // no solution
            throw new IllegalArgumentException("no solution");
        }

        int k = c / r;
        x = x * k;
        y = y * k;

        return r;
    }


    private int mod_linear_exgcd(int a, int b, int n) {
        int d = exgcd(a, n);
        if (b % d != 0) {
            // no solution
            throw new IllegalArgumentException("no solution");
        }

        int x0 = x * (b / d) % n;
        // 特解
        // 通解：
        // [(x0+i*(n//d))%n for i in range(d)]
        x = x0;
        return d;
    }


    public static void main(String[] args) {
        Base base = new Base();
//        System.out.println(base.exgcd(5, 3));
//        System.out.println(base.x + ":" + base.y);
//        System.out.println(base.linear_exgcd(5, 3, 4));
//        System.out.println(base.x + ":" + base.y);
//        System.out.println(base.mod_linear_exgcd(5, 3, 4));
//        System.out.println(base.x + ":" + base.y);
        System.out.println(base.mod_linear_exgcd(5, 3, 4));
        System.out.println(base.x + ":" + base.y);
    }

}
