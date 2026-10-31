# Write your MySQL query statement below
SELECT name as Customers From Customers left join Orders on Customers.id = Orders.customerId Where Orders.customerId is null