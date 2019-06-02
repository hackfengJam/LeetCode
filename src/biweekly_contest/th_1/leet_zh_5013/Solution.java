package biweekly_contest.th_1.leet_zh_5013;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    /*
     * 5013. 字符串的索引对
     * */
    public int[][] indexPairs(String text, String[] words) {
        List<List<Integer>> tmp = new ArrayList<>();

        for (String w : words) {
            int i = text.indexOf(w);
            while (i != -1) {
                List<Integer> line = new ArrayList<>();
                line.add(i);
                line.add(i + w.length() - 1);
                tmp.add(line);
                i = text.indexOf(w, i + 1);
            }
        }
        int[][] rev = new int[tmp.size()][2];
        for (int i = 0; i < tmp.size(); i++) {
            List<Integer> line = tmp.get(i);
            rev[i] = new int[]{line.get(0), line.get(1)};
        }
        Arrays.sort(rev, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int one = o1[0] - o2[0];
                if (one != 0)
                    return one;
                else
                    return o1[1] - o2[1];
            }
        });
        return rev;
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        String text = "thestoryofleetcodeandme";
        String[] words = {"story", "fleet", "leetcode"};
//        String text = "ababa";
//        String[] words = {"aba", "ab"};
        int[][] rev = ss.indexPairs(text, words);
        for (int i = 0; i < rev.length; i++) {
            System.out.println(rev[i][0] + " " + rev[i][1]);
        }
    }
}