package leetcode.algo.tree.leet_zh_856;


public class Solution {

    /*
     * 856. Score of Parentheses
     * 执行用时 : 1 ms, 在Score of Parentheses的Java提交中击败了100.00% 的用户
     * 内存消耗 : 33.3 MB, 在Score of Parentheses的Java提交中击败了0.00% 的用户
     * */

    // 记录当前处理到的位置
    private int index = 0;

    private int cntSorce(String s) {
        int total = 0;

        // 如果当前进来已经是')'，说明深度到底，直接返回0
        if (s.charAt(index) == ')') {
            return total;
        }
        int cc = 0; // 当前深度括弧所存储的值
        while (index < s.length()) {
            char c = s.charAt(index);
            if ('(' == c) {
                index++;
                cc += 2 * cntSorce(s);// 如果 cc 不等于零，说明当前应该是 (( 状态
                continue;
            }
            if (')' == c) {
                index++;
                if (cc == 0) // 如果 cc 等于零，说明当前应该是 () 状态，此时直接 +1 即可；
                    cc = 1;
            }

            total += cc;
            cc = 0;
            if (index < s.length() && ')' == s.charAt(index)) // 判断此时已经是 )) 状态，则直接返回当前深度值。
                return total;
        }
        return total;
    }

    public int scoreOfParentheses(String S) {
        // 默认是合法括弧
        index = 0;
        return cntSorce(S);
    }


    public static void main(String[] args) {
        Solution ss = new Solution();
        System.out.println(ss.scoreOfParentheses("()"));
        System.out.println(ss.scoreOfParentheses("(())"));
        System.out.println(ss.scoreOfParentheses("()()"));
        System.out.println(ss.scoreOfParentheses("(()(()))"));
    }
}