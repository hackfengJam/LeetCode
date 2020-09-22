package leetcode.algo.segment.leet_zh_307;

public class Main {
    public static void main(String[] args) {
        int[] nums = {9, -8};

        NumArray obj = new NumArray(nums);

        obj.update(0, 3);
        System.out.println(obj.sumRange(1, 1));
        System.out.println(obj.sumRange(0, 1));
        obj.update(1, -3);
        System.out.println(obj.sumRange(0, 1));
    }
}
