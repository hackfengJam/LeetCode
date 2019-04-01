package leetcode.tree.leet_zh_856;


public class Solution2 {

    /*
     * 856. Score of Parentheses
     * 执行用时 : 1 ms, 在Score of Parentheses的Java提交中击败了100.00% 的用户
     * 内存消耗 : 35.8 MB, 在Score of Parentheses的Java提交中击败了0.00% 的用户
     * */

    /*
     *
     * 栈思想，但未使用栈
     * */
    public int scoreOfParentheses(String S) {
        // 默认是合法括弧
        int sum = 0;
        int dpW = 0;

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                if (dpW == 0)
                    dpW = 1;
                else
                    dpW = dpW << 1; // *2, 进入到下层深度
            } else {// S.charAt(i) == ')'
                if (S.charAt(i - 1) == '(') {
                    sum += dpW;
                }
                dpW = dpW >> 1; // /2, 恢复到当前深度
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        Solution2 ss = new Solution2();
        System.out.println(ss.scoreOfParentheses("()"));
        System.out.println(ss.scoreOfParentheses("(())"));
        System.out.println(ss.scoreOfParentheses("()()"));
        System.out.println(ss.scoreOfParentheses("(()(()))"));
    }
}