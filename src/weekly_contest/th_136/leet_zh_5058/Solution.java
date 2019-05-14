package weekly_contest.th_136.leet_zh_5058;

public class Solution {

    /*
    *
    *
    *
    搜索后缀数组和最长公共前缀，具体做法比较复杂。
    这里以题目样例"banana"说明一下做法：
    对"banana"求后缀数组结果为：
    "banana$"
    "anana$"
    "nana$"
    "ana$"
    "na$"
    "a$"
    "$"
    其中"$"代表空字符串
    然后对后缀数组进行排序，得到：
    "$"
    "a$"
    "ana$"
    "anana$"
    "banana$"
    "na$"
    "nana$"
    用LCP(i, j)表示排序后数组中第i个字符串和第j个字符串的最长公共前缀，用height(i)表示LCP(i, i-1)。
    那么max(height)就是我们要求得结果，对应样例中的"ana$"和"anana$"的最长公共前缀"ana"。
    其中，对后缀数组排序的时间复杂度为nlogn(倍增法，基数排序，另有线性复杂度的DC3法)，height可以用n的时间复杂度求出，这里需要有很多定理需要证明。

    另外有一种只针对本题的二分搜索+hash判断字符串相等的方法，复杂度也是nlogn，编程复杂度更低。具体过程是二分枚举答案的长度，然后用滑动窗口和hash判断是否有重复字符串，具体过程如下：
    length("banana")-1=5，二分区间为[0,5]
    取(0+5)//2=2开始滑动窗口
    "ba" "an" "na" "an" check
    取(2+5)//2=3开始滑动窗口
    "ban" "ana" "nan" "ana" check
    取(3+5)//2=4开始滑动窗口
    "bana" "anan" "nana" not check
    所以答案为last check："ana"
    为了实现滑动窗口hash的O(n)复杂度，需要自己构造hash函数，把字符串转为26进制整数计算。
    * */

    public String longestDupSubstring(String S) {
        String ret = "";
        return ret;
    }

    public static void main(String[] args) {
    }
}
