# Write your MySQL query statement below
select name, bonus.bonus from employee left join bonus on employee.empId = bonus.empid where isnull(bonus.bonus) or bonus.bonus < 1000