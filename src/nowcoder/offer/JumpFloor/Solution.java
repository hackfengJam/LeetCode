package nowcoder.offer.JumpFloor;

public class Solution {
    /*
     *
     * 动态规划
     *
     * 运行时间：14ms
     * 占用内存：9388k
     * */
    public int JumpFloor(int target) {
        int[] ans = new int[target + 1];
        ans[0] = 1;
        ans[1] = 1;
        for (int i = 2; i < target + 1; i++) {
            ans[i] = ans[i - 1] + ans[i - 2];
        }
        return ans[target];
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        System.out.println(ss.JumpFloor(2));
    }
}