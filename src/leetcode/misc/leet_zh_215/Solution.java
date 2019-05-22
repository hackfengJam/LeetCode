package leetcode.misc.leet_zh_215;

public class Solution {
    /*
     *
     * 215. 数组中的第K个最大元素
     *
     * 执行用时 : 2 ms, 在Kth Largest Element in an Array的Java提交中击败了99.75% 的用户
     * 内存消耗 : 39.5 MB, 在Kth Largest Element in an Array的Java提交中击败了50.75% 的用户

     第一次交换，算法复杂度为O(N)，接下来的过程和快速排序不同，快速排序是要继续处理两边的数据，
     再合并，合并操作的算法复杂度是O(1)，于是总的算法复杂度是O(N*logN)（可以这么理解，每次交换用了N，一共logN次）。
     但是这里在确定枢纽元的相对位置（在K的左边或者右边）之后不用再对剩下的一半进行处理。
     也就是说第二次插入的算法复杂度不再是O(N)而是O(N/2)，这不还是一样吗？
     其实不一样，因为接下来的过程是1+1/2+1/4+........ < 2，换句话说就是一共是O(2N)的算法复杂度也就是O(N)的算法复杂度。

     * */
    public int findKthLargest(int[] nums, int k) {

        return quickSort(nums, 0, nums.length - 1, k);
    }

    private int quickSort(int[] nums, int l, int r, int k) {
        if (l >= r) {
            if (l == k - 1)
                return nums[l];
            if (r == k - 1)
                return nums[r];
            return -1;
        }

        int mid = partition(nums, l, r);
        if (mid == k - 1)
            return nums[k - 1];
        else if (mid > k - 1) {
            return quickSort(nums, l, mid - 1, k);
        } else {
            return quickSort(nums, mid + 1, r, k);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private int partition(int[] nums, int start, int end) {
        int mid = end + (start - end) / 2;
        int ans = nums[mid];
        swap(nums, mid, start);
        int i = start + 1, j = end;
        while (true) {
            while (i <= end && nums[i] > ans) i++;
            while (start + 1 <= j && nums[j] < ans) j--;
            if (i > j) break;
            swap(nums, i, j);
            i++;
            j--;
        }

        swap(nums, start, j);

        return j;
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
//        int[] nums = {3, 2, 1, 5, 6, 4};
//        int[] nums = {3,2,3,1,2,4,5,5,6};
        int[] nums = {2, 1};
        int k = 1;

        int ret = ss.findKthLargest(nums, k);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        System.out.println(ret);
    }
}