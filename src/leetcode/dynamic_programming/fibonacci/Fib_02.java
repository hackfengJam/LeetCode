package leetcode.dynamic_programming.fibonacci;

public class Fib_02 {
    private int[] memo;
    private int num;

    private int fib(int n) {
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }

    public int fibonacci(int n) {
        num = 0;
        memo = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            memo[i] = -1;
        }
        return fib(n);
    }

    public static void main(String[] args) {
        Fib_02 fb = new Fib_02();
        int ret = fb.fibonacci(4);
        System.out.println(ret);
        System.out.println(fb.num);
    }

}
