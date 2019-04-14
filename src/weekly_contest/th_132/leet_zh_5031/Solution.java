package weekly_contest.th_132.leet_zh_5031;

import leetcode.tree.base.TreeNode;
import leetcode.tree.leet_zh_1167.Codec;


public class Solution {
    private String depS(int dp) {
        StringBuilder ans = new StringBuilder();
        while (dp-- != 0) {
            ans.append('-');
        }
        return ans.toString();
    }

    private int getIndex(String childS, String deps) {
        int index = 0;
        for (int i = 0; i < childS.length(); i++) {
            String sb = childS.substring(i);
            index = sb.indexOf(deps);
            if (index != -1) {
                if (childS.charAt(index + i + deps.length()) != '-') {
                    if (index + i - 1 > 0)
                        if (childS.charAt(index + i - 1) == '-')
                            continue;
                    index += i;
                    break;
                }
            }
        }
        return index;
    }

    private TreeNode fun(String S, int dp) {
        if (S.length() == 0)
            return null;
        int end = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) <= '9' && S.charAt(i) >= '0') {
                end++;
            } else break;
        }

        TreeNode root = null;
        if (end != 0) {
            int cur = Integer.valueOf(S.substring(0, end));
            root = new TreeNode(cur);
            if (S.length() == end)
                return root;


            String childS = S.substring(end);
            int index;

            String deps = depS(dp + 1);
            index = getIndex(childS, deps);
            String leftChildS;
            String rightChildS = "";
            if (index != -1) {
                leftChildS = childS.substring(index + deps.length());
                index = getIndex(leftChildS, deps);
                if (index != -1) {
                    rightChildS = leftChildS.substring(index + deps.length());
                    leftChildS = leftChildS.substring(0, index);
                }
                root.left = fun(leftChildS, dp + 1);
                root.right = fun(rightChildS, dp + 1);
            } else {
                return null;
            }
        }
        return root;
    }

    public TreeNode recoverFromPreorder(String S) {
        if (S.length() == 0)
            return null;

        return fun(S, 0);
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        Codec codec = new Codec();
        String str = "1-2--3--4-5--6--7";
//        str = "1-2--3---4-5--6---7";
        str = "1-401--349---90--88";
//        Pattern p = Pattern.compile("\\d*");
//        Matcher m = p.matcher(str);
//        System.out.println(m.find());
//        System.out.println(m.start());
//        System.out.println(m.end());
//        str = "-2--3--4-5--6--7";
//        Pattern p = Pattern.compile("\\d*" + "-" + "\\d");
//        Matcher m = p.matcher(str);
//        System.out.println(m.find());
//        System.out.println(m.start());
//        System.out.println(m.end());
//        System.out.println(m.group());
//
        System.out.println(codec.serialize(ss.recoverFromPreorder(str)));

    }
}
