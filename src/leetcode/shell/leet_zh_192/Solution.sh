# shellcheck disable=SC2188
<<!
 * Title: 192. 统计词频
 * Link : https://leetcode-cn.com/problems/word-frequency
 * Label: [""]
 * Level: Easy
 * Desc : 
 *
 写一个 bash 脚本以统计一个文本文件 words.txt 中每个单词出现的频率。

  为了简单起见，你可以假设：

  words.txt只包括小写字母和 ' ' 。
  每个单词只由小写字母组成。
  单词间由一个或多个空格字符分隔。
  示例:

  假设 words.txt 内容如下：

  the day is sunny the the
  the sunny is is

  你的脚本应当输出（以词频降序排列）：

  the 4
  is 3
  sunny 2
  day 1

  说明:

  不要担心词频相同的单词的排序问题，每个单词出现的频率都是唯一的。
  你可以使用一行 Unix pipes 实现吗？

  解题思路：
  https://leetcode-cn.com/problems/word-frequency/solution/jiu-shi-zhe-yao-ji-zhi-qie-wan-mei-ha-ha-by-novice/

 * 执行用时 :  ms
 * 内存消耗 :  MB
!
# 方法一
<<!
- xargs 分割字符串 -n 1表示每行输出一个 可以加-d指定分割符
- 要使用uniq统计词频需要被统计文本相同字符前后在一起，所以先排序 uniq -c 表示同时输出出现次数
- sort -nr 其中-n表示把数字当做真正的数字处理(当数字被当做字符串处理，会出现11比2小的情况)
!
# xargs: https://www.runoob.com/linux/linux-comm-xargs.html
cat words.txt | xargs -n 1 | sort | uniq -c | sort -nr | awk '{print $2" "$1}'

# 方法二
<<!
  https://leetcode-cn.com/problems/word-frequency/solution/jiu-shi-zhe-yao-ji-zhi-qie-wan-mei-ha-ha-by-novice/

1、首先cat命令查看words.txt
2、tr -s ' ' '\n'将空格都替换为换行 实现分词
3、sort排序 将分好的词按照顺序排序
4、uniq -c 统计重复次数（此步骤与上一步息息相关，-c原理是字符串相同则加一，如果不进行先排序的话将无法统计数目）
5、sort -r 将数目倒序排列
6、awk '{print $2,$1}' 将词频和词语调换位置打印出来
!
# tr: https://www.runoob.com/linux/linux-comm-tr.html
cat words.txt | tr -s ' ' '\n' | sort | uniq -c | sort -r | awk '{print $2,$1}'

## split: https://www.runoob.com/linux/linux-comm-split.html
#split -4 split.txt test



