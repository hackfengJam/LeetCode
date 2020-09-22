package leetcode.algo.dynamic_programming.leet_zh_395;


public class Solution {

    /*
     * 395. 至少有K个重复字符的最长子串
     *
     * 执行用时 : 106 ms, 在Longest Substring with At Least K Repeating Characters的Java提交中击败了31.88% 的用户
     * 内存消耗 : 36.5 MB, 在Longest Substring with At Least K Repeating Characters的Java提交中击败了52.36% 的用户

    核心思想：如果某个字符 x 在整个字符串中出现的次数 <k，那么 x 不可能出现在最终要求的子串中。
    因此，可以将原字符串截断为：x 左侧字符子串 + x + x 右侧字符子串；因此，问题就被拆分为对左子串、右子串求解这两个子问题。
     * */
    public int longestSubstring(String s, int k) {
        return dfs(s, k, 0, s.length() - 1);
    }

    private int dfs(String s, int k, int start, int end) {
        int[] count = new int[26];
        for (int i = start; i <= end; i++) {
            char c = s.charAt(i);
            count[c - 'a']++;
        }
        for (int i = start; i <= end; i++) {
            char c = s.charAt(i);
            if (count[c - 'a'] < k) {
                // [start...i-1]  [i+1...end]
                return Math.max(dfs(s, k, i + 1, end), dfs(s, k, start, i - 1));
            }
        }
        return end - start + 1;
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        String str = "aaabb";
        str = "ababbc";
        System.out.println(ss.longestSubstring(str, 2));
    }
}