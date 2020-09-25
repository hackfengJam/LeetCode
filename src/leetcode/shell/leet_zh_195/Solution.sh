# shellcheck disable=SC2188
<<!
 * Title: 195. 第十行
 * Link : https://leetcode-cn.com/problems/tenth-line/
 * Label: [""]
 * Level: Easy
 * Desc :
 *
  给定一个文本文件 file.txt，请只打印这个文件中的第十行。
  示例:

  假设 file.txt 有如下内容：

  Line 1
  Line 2
  Line 3
  Line 4
  Line 5
  Line 6
  Line 7
  Line 8
  Line 9
  Line 10
  你的脚本应当显示第十行：

  Line 10

  说明:
  1. 如果文件少于十行，你应当输出什么？
  2. 至少有三种不同的解法，请尝试尽可能多的方法来解题。

  官方解题思路

  打印第十行
  sed -n '10p' file.txt

  打印一到十行
  sed -n '1,10p' file.txt

  查找指定字符
  grep -n 'KeyWord' file.txt

  打印指定字符上下5行
  grep -C 5 'KeyWord' file.txt

  打印指定字符上下N行
  grep -A 100 -B 100 'KeyWord' file.txt
  -A after 后面
  -B before 前面

  查找指定字符出现次数
  grep -o 'KeyWord' file.txt | wc -l

 * 执行用时 :  ms
 * 内存消耗 :  MB
!
# 方法一 sed: https://www.runoob.com/linux/linux-comm-sed.html
sed -n '10p' file.txt

# 方法二 awk: https://www.runoob.com/linux/linux-comm-awk.html
awk 'NR==10' file.txt

# 方法三
# head -10 file.txt | tail -1 # 小于10行有问题
tail -n +10 file.txt | head -1
