package leetcode.algo.trie.leet_zh_421;

public class Solution {

    /*
     * 421. Maximum XOR of Two Numbers in an Array
     * 执行用时 : 46 ms
     * 内存消耗 : 56.8 MB
     * */
    private class TreeNode {
        boolean isNum;
        TreeNode[] next;

        public TreeNode(boolean isNum) {
            this.isNum = isNum;
            next = new TreeNode[2];
        }

        public TreeNode() {
            this(false);
        }

    }

    private TreeNode root;

    private void add(int num) {
        TreeNode cur = root;
        for (int i = 31; i >= 0; i--) {
            int bit = num >> i & 1;
            if (cur.next[bit] == null) {
                cur.next[bit] = new TreeNode();
            }
            cur = cur.next[bit];
        }
        cur.isNum = true;
    }

    private int getXOR(int num) {
        int ret = 0;
        int stepRet = 0;
        TreeNode cur = root;
        for (int i = 31; i >= 0; i--) {
            int bit = num >> i & 1;
            if (cur.next[bit ^ 1] != null) { // 尽量找 bit^1
                stepRet = (stepRet << 1) | 1;
                cur = cur.next[bit ^ 1];
            } else if (cur.next[bit] != null) { // 找不到 bit^1，则直接左移
                stepRet = stepRet << 1;
                cur = cur.next[bit];
            } else {
                return ret;
            }
            if (cur.isNum)
                ret = Math.max(stepRet, ret);
        }
        return ret;
    }


    public int findMaximumXOR(int[] nums) {
        int max = 0;
        if (nums.length == 0 || nums.length == 1)
            return max;

        root = new TreeNode();
        add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(getXOR(nums[i]), max);
            add(nums[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        /*
         * 1111
         * 1011
         * */
        Solution ss = new Solution();
        int[] nums = {3, 10, 5, 25, 2, 8};
        System.out.println(ss.findMaximumXOR(nums));
//        System.out.println(5 ^ 25);
//        System.out.println(5 & 25);
//        System.out.println(5 | 25);
//        System.out.println(1 ^ 2);
//        System.out.println(1 & 2);
    }
}
