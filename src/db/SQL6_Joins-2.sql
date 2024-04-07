-- Compound Joins
-- For every film, name films which were released 2 years before and after 2 years after the current film. 
-- Also its rate should be higher than the current film
select 
f1.name, f1.release_year, f1.rate, 
f2.name, f2.release_year, f2.rate
from films f1 join films f2
on 
(f2.release_year between f1.release_year - 2 and f1.release_year + 2)
and 
(f2.rate > f1.rate);

select f1.title, f1.release_year, f2.title, f2.release_year from film f1 join film f2
on f2.release_year between f1.release_year - 5 and f1.release_year + 5;

-- Right Join
select * from 
students s right join batches b 
on s.b_id = b.b_id;


-- Left Join
use school;
select * from students s left join batches b on s.batch_id = b.batch_id;

-- Right Join
insert into batches(batch_id, batch_name) VALUES (5, 'Batch D');
select * from students s right join batches b on s.batch_id = b.batch_id;


-- Outer Join


-- Cross Join
-- For a student give all the possible batches in which we can add.
-- Strictly speaking the keyword 'cross' isn't required. If there isn't a on clause, the same result is returned
-- For readability it is preferred
select * from students s cross join batches b;

-- Natural Join
select * from students s natural join batches b; -- Helps avoid the 'on' clause. By default all columns with common names and types are compared.
-- same as 
select * from students s join batches b on s.batch_id = b.batch_id;

-- Natural Join with USING clause: So all common columns needn't match as required above
-- Need to enclose using condition in paranthesis - compare only the provided columns
select * from students s join batches b using (batch_id);

-- Implicit Join - same as Cross Join of the form below
-- Cross Join: when join keyword itself is not used
select * from students, batches;

-- Taking union of results from separate queries, as long as the column count is the same in each of them
select name from students 
union
select name from instructors
union
select name from investors;

select first_name as names, student_id as ids from students 
union 
select batch_name, batch_id from batches;
