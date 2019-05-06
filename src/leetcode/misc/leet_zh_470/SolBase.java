package leetcode.misc.leet_zh_470;

import java.util.Random;

public class SolBase {
    private Random random;

    public int rand7() {
        return random.nextInt(7) + 1;
    }

    public SolBase() {
        random = new Random();
    }
}
