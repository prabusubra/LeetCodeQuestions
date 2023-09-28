# Write your MySQL query statement below
select name, bonus.bonus from employee left join bonus on employee.empId = bonus.empid where bonus.bonus is null or bonus.bonus < 1000