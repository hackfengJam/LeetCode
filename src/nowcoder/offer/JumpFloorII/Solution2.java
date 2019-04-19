package nowcoder.offer.JumpFloorII;

public class Solution2 {
    /*
     *
     * 数学思路
     *
        链接：https://www.nowcoder.com/questionTerminal/22243d016f6b47f2a6928b4313c85387
        来源：牛客网

        因为n级台阶，第一步有n种跳法：跳1级、跳2级、到跳n级
        跳1级，剩下n-1级，则剩下跳法是f(n-1)
        跳2级，剩下n-2级，则剩下跳法是f(n-2)
        所以 f(n)=f(n-1)+f(n-2)+...+f(1)
        因为 f(n-1)=f(n-2)+f(n-3)+...+f(1)
        所以 f(n)=2*f(n-1)

     * 运行时间：13ms
     * 占用内存：9264k
     * */
    public int JumpFloorII(int target) {
        int a = 1;
        return a << (target - 1);
    }

    public static void main(String[] args) {
        Solution2 ss = new Solution2();
        System.out.println(ss.JumpFloorII(1));
    }
}