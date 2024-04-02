use sakila;

-- Error: distinct columns should contain release_year if used for ordering. Without distinct it is valid
select distinct title from film f order by release_year ;

-- BETWEEN clause example
select * from film f where release_year between 2006 and 2016;
-- Till the tile 'D' is fetched. Not beyond it, say 'Da'
select * from film where title between 'A' and 'D';

-- IS NULL should be used. Not status = NULL, as NULL is not equal to anything
select 1 = 3;
select null = null; -- will return null: Cannot evaluate
select null is null; -- result is 1;

use school;
select * from students s where batch_id is not null;
select * from students s where batch_id <> 3 or batch_id is null;

-- LIMIT Clause
use sakila;
select * from film order by film_id limit 3;
select * from film limit 100, 10;
select * from film limit 10 offset 100;
-- limit after an order by
select * from film order by film_id desc limit 10;


-- UPDATE - usually with primary key - any unique (preferably) numeric column is also fine
-- safe update prevents update without a unique column
update film set title = 'BUBBLE_GROSSE_NEW' where film_id = 102;
update film set description = 'no description'; -- safe update mode should warn 

-- DELETE
delete from film; -- safe delete should warn on this statement
delete from film where film_id = 102;


-- TRUNCATE: Removes the complete table and recreates it
-- Roll back of data isn't possible after this, unlike with delete command
use school;
truncate students_copy;
select * from students s ;
-- populate data into students_copy
insert into students_copy (first_name, last_name)
select first_name, last_name from students ;
select * from students_copy sc ;


-- DROP: Can remove the complete table or the database itself - schema is not preserved
drop table students_copy ;
select * from students_copy sc ;
-- To drop database, below command may be used
-- drop database school;


















































