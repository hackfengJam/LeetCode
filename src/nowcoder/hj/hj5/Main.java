package nowcoder.hj.hj5;

import java.util.Scanner;

public class Main {
    private int[] map = new int[]{10, 11, 12, 13, 14, 15}; // A B C D E F

    private int dp(String s) {
        if (!s.startsWith("0x")) {
            return 0;
        }
        s = s.substring(2);
        int b = 0;
        char c;
        int res = 0, base = 16;
        for (int i = s.length() - 1; i >= 0; i--) {
            c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                b = c - '0';
            } else if (c >= 'A' && c <= 'F') {
                b = map[c - 'A'];
            } else {
                return 0;
            }
            res = res + b * (int) Math.pow(base, (s.length() - 1 - i));
        }
        return res;
    }

    public static void main(String[] args) {
        Main ss = new Main();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String cc = sc.nextLine();
            System.out.println(ss.dp(cc));
        }
    }
}
