package leetcode.weekly_contest_129.leet_zh_1023;

class Solution {
    public String binaryToDecimal(int n) {
        StringBuilder res = new StringBuilder();
        boolean isStart = false;
        int x;

        for (int i = 31; i >= 0; i--) {
            x = n >> i & 1;
            if (x != 0)
                isStart = true;
            if (isStart)
                res.append(n >> i & 1);
        }

        return res.toString();

    }

    public boolean queryString(String S, int N) {
        for (int i = 1; i <= N; i++) {
            if (!S.contains(binaryToDecimal(i)))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
//        System.out.println(ss.binaryToDecimal(2));
//        System.out.println(ss.binaryToDecimal(10));
//        ss.binaryToDecimal(2);
        System.out.println(ss.queryString("0110", 3));
        System.out.println(ss.queryString("0110", 4));
    }
}