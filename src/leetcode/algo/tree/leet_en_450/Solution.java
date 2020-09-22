package leetcode.algo.tree.leet_en_450;

import leetcode.algo.tree.base.TreeNode;
import leetcode.algo.tree.leet_zh_1167.Codec;

class Solution {
    /*
     * 450. 删除二叉搜索树中的节点
     * 执行用时 : 7 ms
     * 内存消耗 : 48.1 MB*/
    private TreeNode minmum(TreeNode node) {
        if (node == null || node.left == null)
            return node;

        return minmum(node.left);
    }

    private TreeNode removeMin(TreeNode node) {
        if (node == null)
            return null;
        if (node.left == null)
            return node.right;

        node.left = removeMin(node.left);
        return node;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        if (root.val > key) {
            // 待删除节点在左子树中
            root.left = deleteNode(root.left, key);
            return root;
        } else if (root.val < key) {
            // 待删除节点在右子树中
            root.right = deleteNode(root.right, key);
            return root;
        } else {
            if (root.left == null) {
                // 当前待删除节点左子树为空，则直接返回以右子树做为新的根
                TreeNode res = root.right;

                // 回收
                root.right = null;
                return res;
            }
            if (root.right == null) {
                // 当前待删除节点右子树为空，则直接返回以左子树为做新的根
                TreeNode res = root.left;

                // 回收
                root.left = null;
                return res;
            }

            // 先拿到右子树中最小的节点，待作为新的根结点
            TreeNode rightMin = minmum(root.right);
            // 上一步拿到右子树中最小的节点后，删除该节点，并将新返回的字数替换当前root右子树。
            root.right = removeMin(root.right);

            // 右子树中最小节点变成新的根结点
            rightMin.left = root.left;
            rightMin.right = root.right;

            // 回收
            root.left = root.right = null;

            return rightMin;
        }
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        Solution ss = new Solution();
//        TreeNode root = codec.deserialize("[5,4,6,2,null,null,7]");
        TreeNode root = codec.deserialize("[5,3,6,2,4,null,7]");
        System.out.println(ss.minmum(root).val);

        root = ss.deleteNode(root, 3);
        System.out.println(root.val);
        root = ss.deleteNode(root, 2);
        System.out.println(ss.minmum(root).val);
        root = ss.deleteNode(root, 4);
        System.out.println(ss.minmum(root).val);

//        System.out.println(ss.removeMin(root).val);
    }
}