package leetcode.specialized.bytedance.string.longest_common_prefix;

public class Solution {
    /*
     * Title: 最长公共前缀
     * Link : https://leetcode-cn.com/explore/interview/card/bytedance/242/string/1014/
     * Label: 字符串
     *
     * 执行用时 : 1 ms
     * 内存消耗 : 37.8 MB
     * */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        int minLen = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < minLen) {
                minLen = strs[i].length();
            }
        }
        StringBuilder res = new StringBuilder();
        char a = 0;
        for (int i = 0; i < minLen; i++) {
            a = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (a != strs[j].charAt(i)) {
                    a = 0;
                    break;
                }
            }
            if (a == 0) {
                break;
            }
            res.append(a);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        System.out.println(ss.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(ss.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        System.out.println(ss.longestCommonPrefix(new String[]{"", "b"}));
    }
}
