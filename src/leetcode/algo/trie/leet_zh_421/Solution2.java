package leetcode.algo.trie.leet_zh_421;

public class Solution2 {

    /*
     * 结果 : TLE
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
            if (cur.next[bit ^ 1] != null) {
                stepRet = (stepRet << 1) | 1;
                cur = cur.next[bit ^ 1];
                if (cur.isNum)
                    ret = Math.max(stepRet, ret);
            } else if (cur.next[bit] != null) {
                stepRet = stepRet << 1;
                cur = cur.next[bit];
                if (cur.isNum)
                    ret = Math.max(stepRet, ret);
            } else {
                return ret;
            }
        }
        return ret;
    }


    public int findMaximumXOR(int[] nums) {
        int max = 0;

        root = new TreeNode();

        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(getXOR(nums[i]), max);
        }

        return max;
    }

    public static void main(String[] args) {
        /*
         * 1111
         * 1011
         * */
        Solution2 ss = new Solution2();
        int[] nums = {3, 10, 5, 25, 2, 8};
        System.out.println(ss.findMaximumXOR(nums));
//        System.out.println(5 ^ 25);
//        System.out.println(5 & 25);
//        System.out.println(5 | 25);
//        System.out.println(1 ^ 2);
//        System.out.println(1 & 2);
    }
}
