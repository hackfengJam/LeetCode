package leetcode.dynamic_programming.leet_zh_838;

public class Solution {
    /*
     * 838. Push Dominoes
     * 执行用时 : 178 ms
     * 内存消耗 : 67.8 MB
     * */
    public String pushDominoes(String dominoes) {
        String curDominoes = dominoes;
        StringBuilder res = new StringBuilder();
        int cnt;
        while (true) {
            cnt = 0;
            for (int i = 0; i < curDominoes.length(); i++) {
                char c = curDominoes.charAt(i);
                if (c == 'L' || c == 'R') {
                    res.append(c);
                    continue;
                }
                // !R.L
                // R.!L
                if (i - 1 >= 0 && curDominoes.charAt(i - 1) == 'R' && (i + 1 >= curDominoes.length() || curDominoes.charAt(i + 1) != 'L')) {
                    res.append('R');
                    cnt++;
                    continue;
                }
                if (i + 1 < curDominoes.length() && curDominoes.charAt(i + 1) == 'L' && (i - 1 < 0 || curDominoes.charAt(i - 1) != 'R')) {
                    res.append('L');
                    cnt++;
                    continue;
                }
                res.append(c);
            }
            if (cnt == 0) {
                break;
            }
            curDominoes = res.toString();
            res = new StringBuilder();
        }

        return res.toString();
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        System.out.println(ss.pushDominoes(".L.R...LR..L.."));
        System.out.println(ss.pushDominoes("RR.L"));
        System.out.println(ss.pushDominoes("R."));
    }
}