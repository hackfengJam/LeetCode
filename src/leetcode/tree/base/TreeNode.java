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

}
