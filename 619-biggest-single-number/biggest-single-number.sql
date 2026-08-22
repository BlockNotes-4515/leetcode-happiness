# Write your MySQL query statement below
SELECT MAX(num) AS NUM
FROM MyNumbers
WHERE num IN(
    SELECT num
    FROM MyNumbers
    GROUP BY num
    HAVING COUNT(num)=1
);