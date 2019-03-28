package leetcode.stack.leet_en_20;

import java.util.Stack;

public class Solution {
    /*
     * 20. Valid Parentheses（合法/有效的括号）
     * 执行用时 : 13 ms
     * 内存消耗 : 35.4 MB
     * */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ']') {
                if (stack.isEmpty() || '[' != stack.pop()) {
                    return false;
                }
            } else if (c == '}') {

                if (stack.isEmpty() || '{' != stack.pop()) {
                    return false;
                }
            } else if (c == ')') {
                if (stack.isEmpty() || '(' != stack.pop()) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        String str = "([)]";
        System.out.println(ss.isValid(str));
    }
}
