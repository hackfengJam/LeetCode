package leetcode.tree.leet_zh_530;

import leetcode.tree.base.TreeNode;
import leetcode.tree.leet_zh_1167.Codec;

public class Solution {
    private class DoubleList {
        public int val;
        public DoubleList left;
        public DoubleList right;

        public DoubleList(int x) {
            val = x;
        }
    }


    private DoubleList treeToDoubleList(TreeNode node, DoubleList pLastNodeInList) {
        if (node == null)
            return pLastNodeInList;


    }

    private DoubleList treeToDoubleList(TreeNode node) {
        DoubleList pLastNodeInList;
        pLastNodeInList = treeToDoubleList(node, null);

        DoubleList head = pLastNodeInList;
        while (head != null && head.left != null)
            head = head.left;
        return head;
    }

    public int getMinimumDifference(TreeNode root) {
        DoubleList doubleList = treeToDoubleList(root);

        return 0;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        Solution ss = new Solution();
        TreeNode root;
//       root = codec.deserialize("[1,null,3,2]");
        root = codec.deserialize("[3,1,null]");
//        root = codec.deserialize("[5,4,7]");
//        root = codec.deserialize("[543,384,652,null,445,null,699]");
//        System.out.println(ss.floor(root, 1).val);
//        System.out.println(ss.ceil(root, 1).val);
        System.out.println(ss.getMinimumDifference(root));
    }
}
