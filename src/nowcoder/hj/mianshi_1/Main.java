package nowcoder.hj.mianshi_1;

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
    public int fun(int[] input, int ln) {
        if (input.length == 0 || ln == 0) {
            return 0;
        }
        int left = 0, right = 0;
        int window = 0;
        int res = 0;
        while (right < input.length) {
            int rightV = input[right];
            window += rightV;
            if (right - left == ln - 1) {
                res = Math.max(res, window);
                int leftV = input[left];
                window -= leftV;
                left++;
            }
            right++;
        }
        return res;
    }

    public static void main(String[] args) {
        Main ss = new Main();
        Scanner sc = new Scanner(System.in);
        int cnt = 0;
        if (sc.hasNextInt()) {
            cnt = sc.nextInt();
        }
        int input[] = new int[cnt];
        int i = 0;
        while (i < cnt && sc.hasNextInt()) {
            int cc = sc.nextInt();
            input[i++] = cc;
        }
        int ln = 0;
        if (sc.hasNextInt()) {
            ln = sc.nextInt();
        }
        System.out.println(ss.fun(input, ln));
    }
}
