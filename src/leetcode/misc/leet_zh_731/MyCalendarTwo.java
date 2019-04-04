package leetcode.misc.leet_zh_731;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class MyCalendarTwo {
    /*
     * 731. My Calendar II
     * 执行用时 : 611 ms
     * 内存消耗 : 56.4 MB
     *
     * When booking a new event [start, end), count delta[start]++ and delta[end]--.
     * When processing the values of delta in sorted order of their keys,
     * the running sum active is the number of events open at that time.
     * If the sum is 3 or more, that time is (at least) triple booked.
     *
     *
     * */
    private TreeMap<Integer, Integer> calendar;

    public MyCalendarTwo() {
        calendar = new TreeMap<>();
    }

    public boolean book(int start, int end) {

        // 尝试添加至日程中
        calendar.put(start, calendar.getOrDefault(start, 0) + 1);
        calendar.put(end, calendar.getOrDefault(end, 0) - 1);

        // 记录活跃的日程数
        int active = 0;

        for (int d : calendar.values()) {
            // 以时间线统计日程
            active += d;

            // 中途活跃日程>=3时，返回 false
            if (active >= 3) {

                // 恢复现场
                calendar.put(start, calendar.get(start) - 1);
                calendar.put(end, calendar.get(end) + 1);

                // remove this part, it can passes. but this will only costs more spaces.
                if (calendar.get(start) == 0)
                    calendar.remove(start);

                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        MyCalendarTwo myCalendar = new MyCalendarTwo();
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
