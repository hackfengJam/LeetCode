package leetcode.algo.dynamic_programming.fibonacci;

public class Fib_01 {
    private int[] memo;
    private int num;

    private int fib(int n) {
        num++;
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        if (memo[n] == -1)
            memo[n] = fib(n - 1) + fib(n - 2);

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
        Fib_01 fb = new Fib_01();
        int ret = fb.fibonacci(4);
        System.out.println(ret);
        System.out.println(fb.num);
    }

}
