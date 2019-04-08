package weekly_contest.th_131.leet_zh_5016;

import java.util.*;

public class Solution {
    /*
     * 5016. 删除最外层的括号
     * 简单粗暴方法：一个栈，两个队列
     * */
    private String stackToString(Queue<Character> queue) {
        StringBuilder ans = new StringBuilder();
        Iterator<Character> iterator = queue.iterator();
        while (iterator.hasNext()) {
            Character c = iterator.next();
            ans.append(c);
        }
        return ans.toString();
    }

    public String removeOuterParentheses(String S) {
        Stack<Character> stackIn = new Stack<>();
        Queue<Character> queue = new LinkedList<>();
        Queue<Character> ans = new LinkedList<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == '(') {
                stackIn.push(c);
                ((LinkedList<Character>) queue).addLast(c);
            } else if (c == ')') {
                if (stackIn.size() == 1) { // 只剩 '('， 则此时该括号为最外层括号
                    stackIn.pop();
                    ((LinkedList<Character>) queue).removeFirst();
                    ans.addAll(queue);
                    queue.removeAll(ans);
                } else {
                    stackIn.pop();
                    ((LinkedList<Character>) queue).addLast(c);
                }
            }
        }

        return stackToString(ans);
    }

    public static void main(String[] args) {
        Solution ss = new Solution();

        System.out.println(ss.removeOuterParentheses("(())"));
        System.out.println(ss.removeOuterParentheses("(()())(())"));
        System.out.println(ss.removeOuterParentheses("(()())(())(()(()))"));
    }

}
