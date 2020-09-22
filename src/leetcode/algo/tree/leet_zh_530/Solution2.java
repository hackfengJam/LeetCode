package leetcode.algo.tree.leet_zh_530;

import leetcode.algo.tree.base.TreeNode;
import leetcode.algo.tree.leet_zh_1167.Codec;

public class Solution2 {


    private TreeNode treeToDoubleList(TreeNode cur, TreeNode pLastNodeInList) {
        if (cur == null)
            return pLastNodeInList;

        // 左子树转换
        if (cur.left != null)
            pLastNodeInList = treeToDoubleList(cur.left, pLastNodeInList);

        cur.left = pLastNodeInList;
        if (pLastNodeInList != null)
            pLastNodeInList.right = cur;

        pLastNodeInList = cur;
        // 右子树转换
        if (cur.right != null)
            pLastNodeInList = treeToDoubleList(cur.right, pLastNodeInList);

        return pLastNodeInList;
    }

    private TreeNode treeToDoubleList(TreeNode node) {
        TreeNode pLastNodeInList;
        pLastNodeInList = treeToDoubleList(node, null);

        TreeNode head = pLastNodeInList;
        while (head != null && head.left != null)
            head = head.left;
        return head;
    }

    public int getMinimumDifference(TreeNode root) {
        TreeNode doubleList = treeToDoubleList(root);
        TreeNode cur = doubleList;
        int min = -1;
        while (cur.right != null) {
            int val = cur.right.val - cur.val;
            if (min == -1)
                min = val;
            else
                min = Math.min(min, val);
            cur = cur.right;
        }

        return min;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        Solution2 ss = new Solution2();
        TreeNode root;
       root = codec.deserialize("[1,null,3,2]");
//        root = codec.deserialize("[3,1,null]");
//        root = codec.deserialize("[5,4,7]");
//        root = codec.deserialize("[543,384,652,null,445,null,699]");
//        System.out.println(ss.floor(root, 1).val);
//        System.out.println(ss.ceil(root, 1).val);

//        System.out.println(ss.treeToDoubleList(root));
        System.out.println(ss.getMinimumDifference(root));
    }
}
