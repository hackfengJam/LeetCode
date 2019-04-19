package nowcoder.offer.JumpFloorII;

public class Solution {
    /*
     *
     * 动态规划
     *
     * 运行时间：16ms
     * 占用内存：9560k
     * */
    public int JumpFloorII(int target) {
        int[] ans = new int[target + 1];
        ans[0] = 1;
        ans[1] = 1;
        for (int i = 2; i < target + 1; i++) {
            ans[i] = 0;
            for (int j = 0; j < i; j++) {
                ans[i] += ans[j];
            }
        }
        return ans[target];
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        System.out.println(ss.JumpFloorII(3));
    }
}