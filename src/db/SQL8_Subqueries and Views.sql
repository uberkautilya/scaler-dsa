-- Active: 1712129391218@@localhost@3306@sakila
-- Find all the students having psp > (psp of s_id = 2). There are no variables in sql. Hence subqueries
-- Step 1: Find psp of student with s_id = 2 -> x
-- Step 2: Find all students with psp > x
select *
from school.students
where psp > (
    select psp
    from school.students
    where s_id = 2
);

-- Find data of all students having psp > (min psp of b_id 2). b_id: batch_id
-- T.C. = O(N^2) -> For every row, the inner query is executed. However, optimized by MySQL
select *
from school.students
where psp > (
    select min(psp)
    from school.students
    where b_id = 2
);

-- Q1
use school;
select * from students where psp > (select psp from students where student_id = 2);

-- Q. Find all years where average rental_rate > (Global average rental rate)
use sakila;
-- Step 1: Get global average rental rate
select AVG(rental_rate) from film;
-- Step 2: Get all years where average rental_rate > above
select AVG(rental_rate), release_year
from film
group by release_year
having AVG(rental_rate) > (
    select AVG(rental_rate) from film
);

-- Get names of all students whose names are in (names of TA)
select distinct
    name
from student
where is_student = 1
    and name IN (
        select distinct name
        from User
        where is_TA = 1
    );



-- Find data of all the students where psp > (min(psp) among avg(psp) of every batch)

-- Step 1: select avg(psp) from Students group by b_id;
select avg(psp) from students group by batch_id;
-- Step 2: Find min(psp) in (1 above)
select min(psp) from (
    select avg(psp) from students group by batch_id
);
-- Every derived table must have its own alias
SELECT min(psp) FROM (
    select AVG(psp) as psp 
    -- Without this, the outer query can't find the psp from the inner query as the column name is 'avg(psp)'
    from students
    group by batch_id as avg_psp
)
-- Step 3: Find data of students with psp > 2 above. Use aliasing in subquery in FROM clause
select * from students where psp > (
    SELECT min(psp) FROM (
        SELECT AVG(psp) AS psp
        FROM students
        GROUP BY batch_id AS avg_psp
    ) as min_psp
);




-- Find data of all students where psp >= (min(psp) of students in every batch)
-- Step 1: min(psp) of students in every batch - returns a list of minimum values
SELECT min(psp) FROM students GROUP BY batch_id;
-- Step 2: Find all students psp >= ALL(x)
SELECT * 
FROM students
where psp >= ALL(
    SELECT min(psp)
    FROM students 
    GROUP BY batch_id
    -- Not inside FROM clause -> No need to use alias
)


-- Only stores the query: Data is fetched every time, similar to procedures
-- Materialized view: Stores the data - can cause outdated results - NOT available in MySQL
CREATE OR UPDATE VIEW film_cast AS
select f.title, concat(a.first_name, ' ', a.last_name) as cast
from film f
join film_actor fa
using(film_id)
join actor a
using(actor_id);

-- Query a view
select * 
from film_cast
where title = 'Agent Hitman';

-- DROP view
drop view film_cast























