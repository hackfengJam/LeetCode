package leetcode.algo.tree.leet_zh_129;

import leetcode.algo.tree.base.TreeNode;
import leetcode.algo.tree.leet_zh_1167.Codec;

import java.util.ArrayList;
import java.util.List;


public class Solution2 {
    /*
    * 执行用时 : 9 ms
    * 内存消耗 : 34.7 MB
    * */
    // 看返回值为int，就不要考虑溢出的情况了
    private List<String> getAllNumbers(TreeNode node) {
        if (node == null)
            return null;
        if (node.left == null && node.right == null) {
            List<String> res = new ArrayList<>();
            res.add("" + node.val);
            return res;
        }

        List<String> leftRes = getAllNumbers(node.left);
        List<String> rightRes = getAllNumbers(node.right);

        List<String> res = new ArrayList<>();
        if (leftRes != null)
            for (String str : leftRes) {
                res.add(node.val + str);
            }
        if (rightRes != null)
            for (String str : rightRes) {
                res.add(node.val + str);
            }
        return res;
    }

    public int sumNumbers(TreeNode root) {
        List<String> res = getAllNumbers(root);
        int total = 0;
        if (res != null)
            for (String str : res) {
                total += Integer.parseInt(str);
            }

        return total;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        Solution2 ss = new Solution2();
        TreeNode root = codec.deserialize("[5,3,8,0,1,3,null,1,8,4,4,2,3,null,null,null,null,5,4,null,null,7,null,null,6,null,null,null,1,null,6,null,null,null,null,8,null,7]");
        System.out.println(ss.sumNumbers(root));
//        System.out.println(Integer.parseInt("58332768314401"));
        System.out.println(codec.serialize(root));
    }
}