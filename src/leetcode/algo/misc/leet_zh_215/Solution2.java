package leetcode.algo.misc.leet_zh_215;

public class Solution2 {
    /*
     *
     * 215. 数组中的第K个最大元素
     *
     *
     * */
    public int findKthLargest(int[] nums, int k) {

        return quickSort(nums, 0, nums.length - 1, k);
    }

    private int quickSort(int[] nums, int left, int right, int k) {
        if (left > right) return -1;
        //按照基准值将待排序区间划分为两个子区间
        int div = partition(nums, left, right);
        if (div == k - 1)
            return nums[div];
        else if (div < k - 1)
            return quickSort(nums, div + 1, right, k);
        else
            return quickSort(nums, left, div - 1, k);
//        //子问题排序左子区间
//        quickSort(nums, left, div - 1, k);
//        //子问题排序右子区间
//        quickSort(nums, div + 1, right, k);
//        return -1;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private int partition(int[] num, int begin, int end) {
        int key = num[end];
        int last = end;
        while (begin < end) {
            //1.左边找到小于基准值的元素
            while ((begin < end) && (num[begin] >= key))
                begin++;
            //2.右边找到大于基准值的元素
            while ((begin < end) && (num[end] <= key))
                end--;
            //3.交换两个值
            swap(num, begin, end);
        }
        //两个下标走到一块的时候，把基准值交换过来
        swap(num, begin, last);
        //返回基准值的位置
        return begin;
    }

    public static void main(String[] args) {
        Solution2 ss = new Solution2();
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