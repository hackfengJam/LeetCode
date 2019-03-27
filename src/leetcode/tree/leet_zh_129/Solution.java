package leetcode.tree.leet_zh_129;

import leetcode.tree.base.TreeNode;
import leetcode.tree.leet_zh_1167.Codec;


public class Solution {
    /*
     * 执行用时 : 0 ms
     * 内存消耗 : 37.4 MB
     * */
    // 看返回值为int，就不要考虑溢出的情况了
    public int sumNumbers(TreeNode node, int pre) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null) {
            return pre * 10 + node.val;
        }
        pre = pre * 10 + node.val;
        int leftTotal = sumNumbers(node.left, pre);
        int rightTotal = sumNumbers(node.right, pre);

        return leftTotal + rightTotal;
    }


    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }


    public static void main(String[] args) {
        Codec codec = new Codec();
        Solution ss = new Solution();
        TreeNode root = codec.deserialize("[5,3,8,0,1,3,null,1,8,4,4,2,3,null,null,null,null,5,4,null,null,7,null,null,6,null,null,null,1,null,6,null,null,null,null,8,null,7]");
        System.out.println(ss.sumNumbers(root));
//        System.out.println(Integer.parseInt("58332768314401"));
        System.out.println(codec.serialize(root));
    }
}