/*
 * Title: 627. 交换工资
 * Link : https://leetcode-cn.com/problems/swap-salary/
 * Label: [""]
 * Level: Easy
 * Desc : 
 *
 * 执行用时 :  ms
 * 内存消耗 :  MB
 * */
# 1
UPDATE salary SET sex= CASE sex WHEN 'm' THEN 'f' ELSE 'm' END;
# 2
UPDATE salary SET sex= IF(sex='m', 'f', 'm');
# 3
UPDATE salary SET sex = char(ascii('m') + ascii('f') - ascii(sex));