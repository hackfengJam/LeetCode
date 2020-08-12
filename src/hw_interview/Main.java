package hw_interview;

public class Main {
    /*
     * Title:
     * Link :
     * Label: [""]
     * Diff : Hard
     * Desc :
     *
     * 执行用时 :  ms
     * 内存消耗 :  MB
     * */
    private boolean isPrime(int v) {
        switch (v) {
            case 0:
            case 1:
                return false;
        }

        int i = 2;
        while (i * i <= v) {
            if (v % i == 0) {
                return false;
            }
            i++;
        }
        return true;
    }

    public int fun(int n) {
        int ret = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                ret++;
            }
        }
        return ret;
    }

    /*
    * 计算小于n的素数个数
    * 思路：
        如果一个数 m 是素数，那么所有 m * k 就都不是素数。另外2是最小的素数
    * */
    public int countPrimes(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (arr[i] == 1) {
                count++;
                for (int j = 2; j * i < n; j++) {
                    arr[i * j] = 0;
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        Main ss = new Main();
//        ss.fun(1000000000);
        System.out.println(ss.fun(10000));
        System.out.println(ss.fun(10));
        System.out.println(ss.countPrimes(10000));
        System.out.println(ss.countPrimes(10));
    }
}
