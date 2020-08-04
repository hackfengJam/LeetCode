package nowcoder.hj.mianshi_2;

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

    private int[] types = new int[101];

    public int fun(int[] input, int k) {
        if (input.length == 0 || k == 0) {
            return 0;
        }
        int repeated = 0, type = 0;
        for (int i = 0; i < input.length; i++) {
            int cc = input[i];
            if (types[cc] == 0) {
                type++;
                types[cc]++;
            } else {
                repeated++;
            }
        }
        if (repeated >= k) {
            return type;
        } else {
            return type - (repeated - k);
        }
    }

    public void inputRun() {
        Scanner sc = new Scanner(System.in);
        int cnt = 0;
        if (sc.hasNextInt()) {
            cnt = sc.nextInt();
        }
        int input[] = new int[cnt];
        int i = 0;
        while (sc.hasNextInt() && i < cnt) {
            int cc = sc.nextInt();
            input[i++] = cc;
        }
        int k = 0;
        if (sc.hasNextInt()) {
            k = sc.nextInt();
        }
        System.out.println(fun(input, k));
    }

    public void inputRun2() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0, x;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                x = sc.nextInt();
                ans += x;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        Main ss = new Main();
        ss.inputRun();
//        System.out.println(ss.fun(new int[]{5, 1, 1, 2, 2}, 2));
    }
}
