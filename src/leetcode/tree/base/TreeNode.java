package leetcode.tree.base;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    private TreeNode floor(TreeNode root, int e) {
        if (root == null)
            return null;

        TreeNode cur = root;
        while (cur != null) {
            if (cur.val == e) {
                if (cur.left == null)
                    return cur;
                cur = cur.left;
            } else if (cur.val < e) {
                if (cur.right == null)
                    return cur;
                cur = cur.right;
            } else {
                cur = cur.right;
            }
        }
        return null;
    }

    private TreeNode ceil(TreeNode root, int e) {
        if (root == null)
            return null;

        TreeNode cur = root;
        if (cur.val == e) {
            if (cur.right == null)
                return cur;
            return ceil(cur.right, e);
        } else if (cur.val > e) {
            if (cur.left == null)
                return cur;
            return ceil(cur.left, e);
        } else {
            return ceil(cur.left, e);
        }
    }

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

    public TreeNode treeToDoubleList(TreeNode node) {
        // 二叉树转双向链表
        TreeNode pLastNodeInList;
        pLastNodeInList = treeToDoubleList(node, null);

        TreeNode head = pLastNodeInList;
        while (head != null && head.left != null)
            head = head.left;
        return head;
    }

}
