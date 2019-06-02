package biweekly_contest.th_1.leet_zh_5010;

public class Solution {
    /*
     * 5010. 范围内的数字计数
     * */
    public int digitsCount(int d, int low, int high) {
        int rev = 0;
        int power = 0; // 幂

        while (true) {
            int modL = low % 10;
            low = low / 10;
            int modH = high % 10;
            high = high / 10;
            int cnt = (high - low);
            if (d < modL) {
                cnt--;
            }
            if (d <= modH) {
                cnt++;
            }
            if (cnt <= 0)
                break;
            rev += cnt * Math.pow(10, power);
            if (d > modH) {
                rev += modH * Math.pow(10, power);
            }
            power++;
        }
        return rev;
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        int d = 1, low = 1, high = 13;
//        int d = 3, low = 100, high = 250;
        System.out.println(ss.digitsCount(d, low, high));
    }
}
