package leetcode.algo.string.leet_zh_76;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /*
     * Title: 76. 最小覆盖子串
     * Link : https://leetcode-cn.com/problems/minimum-window-substring
     * Label: ["哈希表", "双指针", "字符串", "Sliding Window"]
     * Diff : Hard
     * Desc :
     * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。

        示例：

        输入: S = "ADOBECODEBANC", T = "ABC"
        输出: "BANC"
        说明：

        如果 S 中不存这样的子串，则返回空字符串 ""。
        如果 S 中存在这样的子串，我们保证它是唯一的答案。

        来源：力扣（LeetCode）
        链接：

     * 执行用时 :  18 ms
     * 内存消耗 :  40.2 MB
     * */

    private int left, right = 0;
    private int match = 0;
    private Map<Character, Integer> windows;
    private Map<Character, Integer> needs;

    public String minWindow(String s, String t) {
        windows = new HashMap<>();
        needs = new HashMap<>();
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }
        while (right < s.length()) {
            char c = s.charAt(right);
            if (needs.containsKey(c)) {
                int cnt = windows.getOrDefault(c, 0) + 1;
                windows.put(c, cnt);
                if (cnt == needs.get(c)) {
                    match++;
                }
            }
            // 缩小窗口
            while (match == needs.size()) {
                // minLen
                if (minLen > right - left + 1) {
                    start = left;
                    minLen = right - left + 1;
                }
                char c2 = s.charAt(left);
                if (needs.containsKey(c2)) {
                    windows.put(c2, windows.get(c2) - 1);
                    if (windows.get(c2) < needs.get(c2)) {
                        match--;
                    }
                }
                // 缩小窗口
                left++;
            }
            // 拉伸窗口
            right++;
        }


        return minLen != Integer.MAX_VALUE ? s.substring(start, start + minLen) : "";
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
//        System.out.println(ss.minWindow("ADOBECODEBANC", "ABC"));
//        System.out.println(ss.minWindow("a", "aa"));
        System.out.println(ss.minWindow("aab", "aab"));
    }
}
