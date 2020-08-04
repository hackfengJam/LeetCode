package nowcoder.hj.mianshi_3;

import java.util.Random;
import java.util.Scanner;

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
    public int testInput(int[] input, int k) {
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i]);
            System.out.print(" ");
        }
        System.out.println();
        System.out.println(k);
        return 0;
    }


    public long fun(int[] input, int x) {
        if (input.length == 0) {
            return 0;
        }
        if (100 * input.length < x) {
            return 0;
        }
        int left = 0, right = 0;
        long res = 0;
        int tmp = 0;
        while (right < input.length) {
            tmp += input[right];
            while (tmp >= x && left <= right) {
                res += (input.length - right);
                tmp -= input[left];
                left++;
            }

            right++;
        }
        return res;
    }

    public int fun1(int[] input, int x) {
        if (input.length == 0) {
            return 0;
        }
        int res = 0;
        int tmp;
        int i, j;
        for (i = 0; i < input.length; i++) {
            tmp = 0;
            for (j = i; j < input.length; j++) {
                tmp += input[j];
                if (tmp >= x) {
                    res++;
                }
            }
        }
        return res;
    }

    public void inputRun() {
        Scanner sc = new Scanner(System.in);
        int cnt = 0, x = 0;
        if (sc.hasNextInt()) {
            cnt = sc.nextInt();
        }
        if (sc.hasNextInt()) {
            x = sc.nextInt();
        }
        int input[] = new int[cnt];
        int i = 0;
        while (i < cnt && sc.hasNextInt()) {
            int cc = sc.nextInt();
            input[i++] = cc;
        }
//        testInput(input, x);
        System.out.println(fun(input, x));
    }

    public static void main(String[] args) {
        Main ss = new Main();
//        ss.inputRun();
//        System.out.println(ss.fun(new int[]{3, 4, 7}, 7));
//        System.out.println(ss.fun(new int[]{3, 4, 7, 1}, 7));
//        System.out.println(ss.fun(new int[]{3, 4, 7, 7}, 7));
//        System.out.println(ss.fun(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 100000000));
//        System.out.println(ss.fun(new int[]{100000000}, 100000000));
//        System.out.println(ss.fun1(new int[]{3, 4, 7}, 7));
//        System.out.println(ss.fun1(new int[]{7, 7, 7, 7, 7, 7, 7}, 8));
//        System.out.println(ss.fun(new int[]{7, 7, 7, 7, 7, 7, 7}, 8));
//        System.out.println(ss.fun1(new int[]{1, 1, 1, 1, 1, 1, 11, 1, 1, 1, 1, 1, 11, 1, 1, 1, 1, 1, 11, 1, 1, 1, 1, 1, 1}, 5));
//        System.out.println(ss.fun(new int[]{1, 1, 1, 1, 1, 1, 11, 1, 1, 1, 1, 1, 11, 1, 1, 1, 1, 1, 11, 1, 1, 1, 1, 1, 1}, 5));
//        System.out.println(ss.fun(new int[]{7, 6, 5, 4, 3, 2, 1, 1, 1, 1, 1, 1, 1}, 5));
        Random random = new Random();
        int[] input = new int[100000];
        for (int i = 0; i < input.length; i++) {
            input[i] = random.nextInt(100);
//            System.out.print(input[i]);
//            System.out.print(" ");
            System.out.println(input[i]);
        }
        System.out.println();
        int x = random.nextInt(10000000);
        System.out.println(x);
        System.out.println(ss.fun1(input, x));
        System.out.println(ss.fun(input, x));
    }
}
