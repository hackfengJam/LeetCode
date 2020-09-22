package leetcode.algo.misc.leet_zh_729;

import java.util.ArrayList;
import java.util.List;

public class MyCalendar {
    /*
     * 729. My Calendar I
     * 执行用时 : 175 ms
     * 内存消耗 : 50.2 MB
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

    public MyCalendar() {
        myList = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        int index = -1;
        if (myList.size() == 0) index = 0;

        for (int i = 0; i < myList.size(); i++) {
            Pair pairPre = myList.get(i);


            // 对第一个元素处理
            if (i == 0 && end <= pairPre.start) {
                index = i;
                break;
            }

            // 对最后一个元素处理
            if (i == myList.size() - 1) {
                if (start >= pairPre.end) {
                    index = i + 1; // i+1 一定是小于等于 myList.size() 的
                }
                break;
            }

            // 中间元素处理
            Pair pairPost = myList.get(i + 1);
            if (start >= pairPre.end && end <= pairPost.start) {
                index = i + 1; // i+1 一定是小于等于 myList.size() 的
                break;
            }

        }
        if (index != -1) {
            myList.add(index, new Pair(start, end));
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
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

        System.out.println(myCalendar.book(20, 29));
        System.out.println(myCalendar.book(13, 22));
        System.out.println(myCalendar.book(44, 50));
        System.out.println(myCalendar.book(1, 7));
        System.out.println(myCalendar.book(2, 10));
        System.out.println(myCalendar.book(14, 20));
        System.out.println(myCalendar.book(19, 25));
        System.out.println(myCalendar.book(36, 42));
        System.out.println(myCalendar.book(45, 50));
        System.out.println(myCalendar.book(47, 50));
        System.out.println(myCalendar.book(39, 45));
        System.out.println(myCalendar.book(44, 50));
        System.out.println(myCalendar.book(16, 25));


    }
}
