package leetcode.algo.misc.leet_zh_470;

public class Solution extends SolBase {


    /*
    *
    *
    *
    *
    * 计算两个rand7()和的个位，两个数用a b表示，即( rand7() + rand7() ) % 10
        枚举如下：
        a	1	2	3	4	5	6	7
    b
    1		2	3	4	5	6	7	8
    2		3	4	5	6	7	8	9
    3		4	5	6	7	8	9	0
    4		5	6	7	8	9	0	1
    5		6	7	8	9	0	1	2
    6		7	8	9	0	1	2	3
    7		8	9	0	1	2	3	4

    去掉右上角的
    6	7	8
    7	8	9
    8	9	0      后

    每个数字的出现次数为4次，0-9的概率相同

    所以程序思路就很明了,当结果扫到右上角的时候进行递归调用，直到输出其他结果
        a=rand7();  b=rand7();
     if(a>4&&b<4)  return rand10();
     else          return (a+b)%10+1;


    平均调用2.3次rand7()
    * */


    public int rand10Tow() {
        /*
        *
        * 两个数用a b表示，即( rand7() + rand7() ) % 10
        枚举如下：
            a	0   1	2	3	4	5	6
        b
        0       0	1	2	3	4	5	6
        1		1   2   3	4	5	6	7
        2		2   3	4	5	6	7	8
        3		3	4	5	6	7	8	9
        4		4	5	6	7	8	9	0
        5		5	6	7	8	9	0	1
        6		6	7	8	9	0	1	2
        除去 右上角
        4	5	6
        5	6	7
        6	7	8
        每个数字的出现次数为4次，0-9的概率相同

            a	0   1	2	3	4	5	6
                            0
                        0	1
        b           0	1	2
        0       0	1	2	3   4	5	6
        1		1   2   3	4   5	6	7
        2		2   3	4	5   6	7	8
        3		3	4	5	6
        4		4	5	6	7
        5		5	6	7	8
        6		6	7	8	9
                7	8	9
                8	9
                9
        * */
        int a = rand7();
        int b = rand7();
        while (a > 3 && b < 3)
            return rand10();

        return (a + b) % 10;
    }

    public int rand10() {
        /*
         *
         * 执行用时 : 7 ms, 在Implement Rand10() Using Rand7()的Java提交中击败了92.50% 的用户
         * 内存消耗 : 36.4 MB, 在Implement Rand10() Using Rand7()的Java提交中击败了100.00% 的用户
         * */
        /*
        *
        * 计算两个rand7()和的个位，两个数用a b表示，即( rand7() + rand7() ) % 10
        枚举如下：
            a	1	2	3	4	5	6	7
        b
        1		2	3	4	5	6	7	8
        2		3	4	5	6	7	8	9
        3		4	5	6	7	8	9	0
        4		5	6	7	8	9	0	1
        5		6	7	8	9	0	1	2
        6		7	8	9	0	1	2	3
        7		8	9	0	1	2	3	4

        去掉右上角的
        6	7	8
        7	8	9
        8	9	0      后

        每个数字的出现次数为4次，0-9的概率相同

        * */
        int a, b;
        do {
            a = rand7();
            b = rand7();
        } while (a > 4 && b < 4);

        return (a + b) % 10 + 1;
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        System.out.println(ss.rand10());
        System.out.println(ss.rand10());
        System.out.println(ss.rand10());
        System.out.println(ss.rand10());
        System.out.println(ss.rand10());
        System.out.println(ss.rand10());
        System.out.println(ss.rand10());
        System.out.println(ss.rand10());
        System.out.println(ss.rand10());
    }
}
