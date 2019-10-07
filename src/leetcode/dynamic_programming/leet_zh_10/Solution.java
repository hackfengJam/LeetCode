package leetcode.dynamic_programming.leet_zh_10;

public class Solution {
    /*
     * 10. 正则表达式匹配
     * 执行用时 : 431 ms
     * 内存消耗 : 38.4 MB
     *
     * */
    public boolean isMatch(String s, String p) {

        return false;
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        String[][] testCase = {
                {"aa", "a"},
                {"bb", "b"},
        };
        for (int i = 0; i < testCase.length; i++) {
            System.out.println(ss.isMatch(testCase[i][0], testCase[i][1]));
        }
    }
}