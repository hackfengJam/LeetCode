package leetcode.dynamic_programming.leet_zh_279;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /*
    * 279. 完全平方数

    四平方定理： 任何一个正整数都可以表示成不超过四个整数的平方之和。 推论：满足四数平方和定理的数n（四个整数的情况），必定满足 n=4^a(8b+7)

     int numSquares(int n) {
        //先根据上面提到的公式来缩小n
        while(n % 4 == 0) {
            n /= 4;
        }
        //如果满足公式 则返回4
        if(n % 8 == 7) {
            return 4;
        }
        //在判断缩小后的数是否可以由一个数的平方或者两个数平方的和组成
        int a = 0;
        while ((a * a) <= n) {
            int b = sqrt((n - a * a));
            if(a * a + b * b == n) {
                //如果可以 在这里返回
                if(a != 0 && b != 0) {
                    return 2;
                } else{
                    return 1;
                }
            }
            a++;
        }
        //如果不行 返回3
        return 3;
    }
    * */
    public int numSquares(int n) {
        int[] ans = new int[n + 1];
        List<Integer> li = new ArrayList<>();
        for (int i = 1; ; i++) {
            if (i * i > n) {
                break;
            }
            ans[i * i] = 1;
            li.add(i * i);
        }
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            if (ans[i] != 0) continue;
            for (Integer item : li) {
                if (item > i) break;
                if (min > ans[i - item])
                    min = ans[i - item];
            }
            ans[i] = min + 1;
        }

        return ans[n];
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        System.out.println(ss.numSquares(13));
    }
}