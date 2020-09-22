package leetcode.algo.misc.leet_zh_729;

import java.util.ArrayList;
import java.util.List;

public class MyCalendar2 {
    /*
     * 729. My Calendar I
     * 执行用时 : 468 ms
     * 内存消耗 : 66.4 MB
     *
     * 添加 Merge 操作，减少 节点的插入
     * */
    private class Pair {
        public int start;
        public int end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private List<Pair> myList;

    public MyCalendar2() {
        myList = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        if (myList.size() == 0) {
            myList.add(new Pair(start, end));
            return true;
        }

        for (int i = 0; i < myList.size(); i++) {
            Pair pairPre = myList.get(i);


            // 对第一个元素处理
            if (i == 0 && end <= pairPre.start) {
                myList.add(i, new Pair(start, end));
                return true;
            }

            // 对最后一个元素处理
            if (i == myList.size() - 1) {
                if (start >= pairPre.end) {
                    myList.add(i + 1, new Pair(start, end)); // i+1 一定是小于等于 myList.size() 的
                    return true;
                }
                break;
            }

            // 中间元素处理
            Pair pairPost = myList.get(i + 1);
            if (start >= pairPre.end && end <= pairPost.start) {

                // 添加 Merge 操作，减少 节点的插入
                boolean isMerge = false;
                if (start == pairPre.end) {
                    pairPre.end = end;
                    isMerge = true;
                }
                if (end == pairPost.start) {
                    pairPost.start = start;
                    isMerge = true;
                }
                if (isMerge && pairPre.end == pairPost.start) {
                    pairPre.end = pairPost.end;
                    myList.remove(i + 1);
                }
                if (!isMerge)
                    myList.add(i + 1, new Pair(start, end));
                return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        MyCalendar2 myCalendar = new MyCalendar2();
//        System.out.println(myCalendar.book(10, 20));
//        System.out.println(myCalendar.book(15, 25));
//        System.out.println(myCalendar.book(20, 30));

//        System.out.println(myCalendar.book(37, 50));
//        System.out.println(myCalendar.book(33, 50));
//        System.out.println(myCalendar.book(4, 17));
//        System.out.println(myCalendar.book(35, 48));
//        System.out.println(myCalendar.book(8, 25));


//        System.out.println(myCalendar.book(47, 50));
//        System.out.println(myCalendar.book(33, 41));
//        System.out.println(myCalendar.book(39, 45));
//        System.out.println(myCalendar.book(33, 42));
//        System.out.println(myCalendar.book(25, 32));
//        System.out.println(myCalendar.book(26, 35));
//        System.out.println(myCalendar.book(19, 25));
//        System.out.println(myCalendar.book(3, 8));
//        System.out.println(myCalendar.book(8, 13));
//        System.out.println(myCalendar.book(18, 27));

//        System.out.println(myCalendar.book(20, 29));
//        System.out.println(myCalendar.book(13, 22));
//        System.out.println(myCalendar.book(44, 50));
//        System.out.println(myCalendar.book(1, 7));
//        System.out.println(myCalendar.book(2, 10));
//        System.out.println(myCalendar.book(14, 20));
//        System.out.println(myCalendar.book(19, 25));
//        System.out.println(myCalendar.book(36, 42));
//        System.out.println(myCalendar.book(45, 50));
//        System.out.println(myCalendar.book(47, 50));
//        System.out.println(myCalendar.book(39, 45));
//        System.out.println(myCalendar.book(44, 50));
//        System.out.println(myCalendar.book(16, 25));

//        List<Integer> list = new ArrayList<>();
//        list.add(1, 1); // (<tt>index &lt; 0 || index &gt;= size()</tt>)
//        System.out.println(list);


    }
}
