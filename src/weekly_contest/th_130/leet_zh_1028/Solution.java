package weekly_contest.th_130.leet_zh_1028;

public class Solution {
    /*
    * 1028. 负二进制转换
    * */

    public String baseNeg2(int N) {
        if (N == 0)
            return "0";
        StringBuilder res = new StringBuilder();
        int k = 1; // 奇偶
        while (N != 0) {
            if ((N & 1) == 1) {
                N -= k; // 1->11
                res.insert(0, "1");

            } else {
                res.insert(0, "0");
            }
            N /= 2;
            k *= -1;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().baseNeg2(2));
        System.out.println(new Solution().baseNeg2(3));
        System.out.println(new Solution().baseNeg2(4));
        System.out.println(new Solution().baseNeg2(5));
        System.out.println(new Solution().baseNeg2(6));
    }
}
