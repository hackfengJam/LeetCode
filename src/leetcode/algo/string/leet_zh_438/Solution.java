package leetcode.algo.string.leet_zh_438;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    /*
      * Title: 438. 找到字符串中所有字母异位词
      * Link : https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
      * Label: ["哈希表"]
      * 执行用时 :  41 ms
      * 内存消耗 :  41.1 MB
      * Desc :
      *     给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。

            字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。

            说明：

            字母异位词指字母相同，但排列不同的字符串。
            不考虑答案输出的顺序。
            示例 1:

            输入:
            s: "cbaebabacd" p: "abc"

            输出:
            [0, 6]

            解释:
            起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
            起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
             示例 2:

            输入:
            s: "abab" p: "ab"

            输出:
            [0, 1, 2]

            解释:
            起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
            起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
            起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。

            来源：力扣（LeetCode）
            链接：
    * */
    private int left, right = 0;
    private int match = 0;
    private Map<Character, Integer> windows;
    private Map<Character, Integer> needs;

    public List<Integer> findAnagrams(String s, String p) {
        windows = new HashMap<>();
        needs = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
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
                if (right - left + 1 == p.length()) {
                    res.add(left);
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


        return res;
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
//        System.out.println(ss.findAnagrams("cbaebabacd", "abc"));
        System.out.println(ss.findAnagrams("abab", "ab"));
    }
}