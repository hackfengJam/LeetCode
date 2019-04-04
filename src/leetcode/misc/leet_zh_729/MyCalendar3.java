package leetcode.misc.leet_zh_729;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class MyCalendar3 {
    /*
     * 729. My Calendar I
     * 执行用时 : 190 ms
     * 内存消耗 : 55.6 MB
     *
     * O(N logN)
     * */

    private TreeMap<Integer, Integer> calendar;

    public MyCalendar3() {
        calendar = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer prev = calendar.floorKey(start);
        Integer next = calendar.ceilingKey(start);
        if ((prev == null || calendar.get(prev) <= start) && (next == null || end <= next)) {
            calendar.put(start, end);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        MyCalendar3 myCalendar = new MyCalendar3();
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
