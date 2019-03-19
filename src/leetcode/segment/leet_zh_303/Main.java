package leetcode.segment.leet_zh_303;

public class Main {
    public static void main(String[] args) {
        int[] nums = {-1, 2, 3, -2, 4, 5, 6};

        NumArray obj = new NumArray(nums);
        int param_1 = obj.sumRange(0, 1);
        System.out.println(param_1);

        nums = new int[0];
        NumArray obj2 = new NumArray(nums);
        int param_2 = obj.sumRange(0, 1);
        System.out.println(param_1);
    }
}
