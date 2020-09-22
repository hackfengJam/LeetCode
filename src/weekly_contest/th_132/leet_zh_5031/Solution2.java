package weekly_contest.th_132.leet_zh_5031;

import leetcode.algo.tree.base.TreeNode;
import leetcode.algo.tree.leet_zh_1167.Codec;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution2 {
    private String depS(int dp) {
        StringBuilder ans = new StringBuilder();
        while (dp-- != 0) {
            ans.append('-');
        }
        return ans.toString();
    }

    private TreeNode fun(String S, int dp) {
        if (S.length() == 0)
            return null;
        Pattern p_root = Pattern.compile("\\d*");
        Matcher m;

        m = p_root.matcher(S);
        TreeNode root = null;
        if (m.find()) {
            int cur = Integer.valueOf(S.substring(m.start(), m.end()));
            root = new TreeNode(cur);
            if (S.length() == (m.end() - m.start()))
                return root;


            String childS = S.substring(m.end());
            int index;

            String deps = depS(dp + 1);
            Pattern p = Pattern.compile("\\d" + deps + "\\d");

            index = childS.indexOf(deps);
            String leftChildS;
            String rightChildS = "";
            if (index == 0 && childS.charAt(index + deps.length()) != '-') {
                leftChildS = childS.substring(deps.length());
//            index = leftChildS.indexOf(deps);
                m = p.matcher(leftChildS);
                if (m.find()) {
                    rightChildS = leftChildS.substring(m.start() + 1 + deps.length());
                    leftChildS = leftChildS.substring(0, m.start() + 1);
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
        Solution2 ss = new Solution2();
        Codec codec = new Codec();
        String str = "1-2--3--4-5--6--7";
        str = "1-2--3---4-5--6---7";
//        str = "1-401--349---90--88";
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
