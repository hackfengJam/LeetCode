package leetcode.specialized.bytedance.longest_substring_without_repeating_characters;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /*
     * 无重复字符的最长子串
     * link: https://leetcode-cn.com/explore/interview/card/bytedance/242/string/1012
     * Label: 滑动窗口、hashMap、双指针
     *
     * 执行用时 : 8 ms
     * 内存消耗 : 40.4 MB

     * */
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        if (s.length() == 0) {
            return maxLength;
        }

        char a;
        int start, index;
        start = 0;
        Map<Character, Integer> tmp = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            a = s.charAt(i);
            if (tmp.containsKey(a)) {
                index = tmp.get(a);
                // >= 非 >
                if (index >= start) {
                    start = tmp.get(a) + 1;
                }
            }
            maxLength = Math.max(maxLength, i - start + 1);
            tmp.put(a, i);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        System.out.println(ss.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(ss.lengthOfLongestSubstring("bbbbb"));
        System.out.println(ss.lengthOfLongestSubstring("pwwkew"));
        System.out.println(ss.lengthOfLongestSubstring("abba"));
    }
}