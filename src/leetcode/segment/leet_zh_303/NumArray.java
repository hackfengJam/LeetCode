package leetcode.segment.leet_zh_303;

import javax.management.Query;

/*
303. 区域和检索 - 数组不可变
https://leetcode-cn.com/problems/range-sum-query-immutable/
 */

class NumArray {

    class SegmentTree {

        private int[] data;
        private int[] tree;

        public SegmentTree(int[] nums) {

            data = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                data[i] = nums[i];
            }

            tree = new int[4 * data.length];
            buildSegmentTree(0, 0, data.length - 1);

        }

        public void buildSegmentTree(int treeIndex, int l, int r) {
            if (l == r) {
                tree[treeIndex] = data[l];
                return;
            }
            int mid = l + (r - l) / 2;

            int leftChildIndex = leftChild(treeIndex);
            int rightChildIndex = rightChild(treeIndex);

            buildSegmentTree(leftChildIndex, l, mid);
            buildSegmentTree(rightChildIndex, mid + 1, r);


            tree[treeIndex] = tree[leftChildIndex] + tree[rightChildIndex];

        }

        public int leftChild(int treeIndex) {
            return 2 * treeIndex + 1;
        }

        public int rightChild(int treeIndex) {
            return 2 * treeIndex + 2;
        }

        public int sumRange(int treeIndex, int l, int r, // 前三个字段全是描述该 treeIndex 对应节点信息
                            int queryL, int queryR) {
            if (l == queryL && r == queryR) {
                return tree[treeIndex];
            }
            int mid = l + (r - l) / 2;

            int leftChildIndex = leftChild(treeIndex);
            int rightChildIndex = rightChild(treeIndex);
            if (queryL > mid) {
                return sumRange(rightChildIndex, mid + 1, r, queryL, queryR);
            } else if (queryR <= mid) {
                return sumRange(leftChildIndex, l, mid, queryL, queryR);
            }

            int leftChildResult = sumRange(leftChildIndex, l, mid, queryL, mid);
            int rightChildResult = sumRange(rightChildIndex, mid + 1, r, mid + 1, queryR);

            return leftChildResult + rightChildResult;
        }


        public int sumRange(int i, int j) {
            if (tree == null) {
                throw new IllegalArgumentException("Error");
            }
            return sumRange(0, 0, data.length - 1, i, j);
        }
    }

    private SegmentTree segmentTree = null;

    public NumArray(int[] nums) {
        if (nums.length > 0) {
            segmentTree = new SegmentTree(nums);
        }

    }

    public int sumRange(int i, int j) {

        if (segmentTree != null) {
            return segmentTree.sumRange(i, j);
        }
        return 0;
    }
}


/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */