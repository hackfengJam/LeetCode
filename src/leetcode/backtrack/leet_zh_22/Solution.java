package leetcode.backtrack.leet_zh_22;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /*
     * 22. 括号生成
     * 执行用时 : 12 ms
     * 内存消耗 : 43.7 MB
     * */
    private List<String> generateP(String str, int leftCount, int restCount) {
        List<String> res = new ArrayList<>();
        if (restCount == 0 && leftCount == 0) {
            res.add(str);
            return res;
        }
        if (restCount > 0) {
            for (String line : generateP("(", leftCount + 1, restCount - 1)) {
                res.add(str + line);
            }
        }
        if (leftCount > 0)
            for (String line : generateP(")", leftCount - 1, restCount)) {
                res.add(str + line);
            }
        return res;
    }

    public List<String> generateParenthesis(int n) {

        return generateP("(", 1, n - 1);
    }

    public static void main(String[] args) {

        Solution ss = new Solution();
        List<String> res = ss.generateParenthesis(3);
        System.out.println(res.size());
        for (String str : res) {
            System.out.println(str);
        }
    }
}