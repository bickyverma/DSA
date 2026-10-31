# Write your MySQL query statement below
SELECT firstName, lastName, city, state FROM PERSON
LEFT JOIN Address
ON Person.personID = Address.personID;