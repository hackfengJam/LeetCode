/*
 * Title: 182. 查找重复的电子邮箱
 * Link : https://leetcode-cn.com/problems/duplicate-emails
 * Label: [""]
 * Level: Easy
 * Desc :
 *
 编写一个 SQL 查询，查找 Person 表中所有重复的电子邮箱。
    示例：
    +----+---------+
    | Id | Email   |
    +----+---------+
    | 1  | a@b.com |
    | 2  | c@d.com |
    | 3  | a@b.com |
    +----+---------+
    根据以上输入，你的查询应返回以下结果：
    +---------+
    | Email   |
    +---------+
    | a@b.com |
    +---------+
    说明：所有电子邮箱都是小写字母。

 * 执行用时 : 261 ms
 * 内存消耗 : 0 B
 * */

# 方法一
select t1.email as Email from (select email, count(email) as e_c from Person group by email) as t1 where t1.e_c > 1;

# 方法二
select Email from Person group by Email having count(Email) > 1;
