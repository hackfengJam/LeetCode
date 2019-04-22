package test;

import java.util.*;

public class Test {

    public void main() {
        // 正数在前，负数在后，相对位置不变
        Integer[] nums = {1, 2, 3, -2, -4, 5, 3, -2, 4, 1, -5, 3};

        Arrays.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                if ((a ^ b) >= 0) {
                    return 0;
                } else if (a < 0) {
                    return 1;
                } else
                    return -1;
            }
        });
        Arrays.stream(nums).forEach(System.out::println);
    }

    public static void main(String[] args) {
        new Test().main();
    }
}
