# Write your MySQL query statement below
Select E1.name as Employee 
From Employee as E1 Left Join 
Employee as E2 on E1.managerId = E2.id
Where E1.salary > E2.salary