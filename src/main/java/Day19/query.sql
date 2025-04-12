1. Write a query to find emp name and his manager name from a table Employee(id, name, managerId)

SELECT 
    e.name AS employee_name,
    m.name AS manager_name
FROM 
    Employee e
LEFT JOIN 
    Employee m ON e.managerId = m.id;


2. Write a query to find one emp from each department who is getting highest salary within his dept.


WITH RankedEmp AS (
    SELECT *, 
           ROW_NUMBER() OVER (PARTITION BY dept_id ORDER BY salary DESC) AS rn
    FROM Employee
)
SELECT id, name, dept_id, salary
FROM RankedEmp
WHERE rn = 1;


3. Write a query to delete duplicate rows from a table.

WITH Duplicates AS (
    SELECT *, 
           ROW_NUMBER() OVER (PARTITION BY name, dept_id, salary ORDER BY id) AS rn
    FROM Employee
)
DELETE FROM Duplicates
WHERE rn > 1;
