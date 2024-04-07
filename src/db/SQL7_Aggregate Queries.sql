
use school;

SELECT * from school.students;

-- Aggregate Function: COUNT
SELECT count(batch_id) from school.students;

-- Get count of distinct batch_id
select COUNT(distinct (batch_id)) as distinct_batch_id_count
from school.students;

-- Count of rows in the students table - all column is never null. Hence count the rows
SELECT COUNT(*) as ROW_COUNT FROM school.students;

SELECT 1 as output from students;
-- This would seem to be faster. But due to SQL optimizations both (count (*)) would take the same time.
SELECT count(1) from students; 

select * from school.students;
-- Max, Min, Avg, Sum
SELECT MAX(batch_id), MIN(batch_id), AVG(batch_id), SUM(batch_id), count(batch_id) FROM school.students;

-- Error: avg() takes only one parameter
SELECT AVG(1, 2);

-- We cannot use nested aggregate functions. Aggregate(aggregate())
SELECT AVG(count(batch_id)) from school.students;

-- Need not yield same result: count(*) also includes rows where the psp column is NULL.
SELECT AVG(psp), SUM(psp)/COUNT(*) from school.students;

-- We can get the columns which are common in a group with a group by select query


-- Get avg(psp) of every batch along with their batch_id
SELECT avg(s.psp), b.batch_name
FROM school.students s join batches b on s.batch_id = b.batch_id
GROUP BY b.batch_id; -- grouping by an integer is preferred


-- Films released in each year: No null values in title, count(title) will give same result as count(*)
select count(title), release_year from sakila.film group by release_year;


-- HAVING CLAUSE
-- Get avg(psp) of every batches where the avg(psp) of that batch is > 85
select avg(s.psp), b.batch_id, b.batch_name
from school.students s join batches b on s.batch_id = b.batch_id 
group by batch_id
having avg(s.psp) > 85;

-- Following query won't work as where clause doesn't filter groups
select avg(s.psp), b.batch_id, b.batch_name
from school.students s join batches b on s.batch_id = b.batch_id 
group by batch_id
where AVG(s.psp) > 85; -- where clause cannot filter groups


