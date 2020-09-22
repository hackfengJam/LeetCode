package leetcode.algo.string.leet_zh_3;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /*
     * Title: 3. 无重复字符的最长子串
     * Link : https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
     * Label: ["哈希表", "双指针", "字符串", "Sliding Window"]
     * Diff : Medium
     * Desc :
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

        示例 1:

        输入: "abcabcbb"
        输出: 3
        解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
        示例 2:

        输入: "bbbbb"
        输出: 1
        解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
        示例 3:

        输入: "pwwkew"
        输出: 3
        解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
             请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

     * 执行用时 : 9 ms
     * 内存消耗 : 39.4 MB
     * */

    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        if (s.length() == 0) {
            return maxLength;
        }
        char c;
        int left = 0, right = 0;
        Map<Character, Integer> windows = new HashMap<>();
        while (right < s.length()) {
            c = s.charAt(right);
            if (!windows.containsKey(c)) {
                windows.put(c, right);
                if (maxLength < right - left + 1) {
                    maxLength = right - left + 1;
                }
            } else {
                int index = windows.get(c) + 1;
                for (int i = left; i < index; i++) {
                    char c2 = s.charAt(i);
                    windows.remove(c2);
                }
                left = index;
                windows.put(c, right);
            }
            right++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
//        System.out.println(ss.lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(ss.lengthOfLongestSubstring("bbbbb"));
//        System.out.println(ss.lengthOfLongestSubstring("pwwkew"));
        System.out.println(ss.lengthOfLongestSubstring("tmmzuxt1z"));
    }
}
