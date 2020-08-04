package nowcoder.hj.hj22;

import java.util.Scanner;

public class Main {
    /*
     * Title: 汽水瓶
     * Link :
     * Label: [""]
     * Diff : EASY
     * Desc :
     *
     * 执行用时 :  ms
     * 内存消耗 :  MB
     * */
    private int dp(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        int m = n / 3;
        if (m < 1) {
            return m;
        }
        m = m + dp((n % 3) + m);
        return m;
    }

    public static void main(String[] args) {
        Main ss = new Main();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int cc = sc.nextInt();
            if (0 == cc) {
                return;
            }
            System.out.println(ss.dp(cc));
        }
    }
}
