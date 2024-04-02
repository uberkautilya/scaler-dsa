-- Get distinct combinations of release_year, rating
-- distinct: Displays unique non-null values of a column
use sakila;
select distinct release_year, rating from film;

select * from school.students s ;

-- create a table - select database first
use school;
create table students_copy (
	id int auto_increment primary key,
	first_name varchar(50),
	last_name varchar(50)
);

-- insert data into a table from another one 
insert
	into
	students_copy (first_name, last_name)
select
	first_name,
	last_name
from
	students;
	

-- Where clause
select
	title,
	rating
from
	film
where
	rating = 'PG-13';
	
-- Logical operator: OR, AND
select
	title,
	rating
from
	film f
where
	rating = 'pg-13'
	or rating = 'r';
	
-- NOT: Any of NOT, <> or !=
select
	title,
	rating,
	release_year
from
	film f
where
	rating = 'pg-13'
-- and release_year <> 2006
-- and release_year != 2006
and Not(release_year = 2006) 
;

-- IN
use school;
select
	*
from
	students
where
	batch_id in(5, 7, 1, 2, 3);


use sakila;
select
	rating,
	f.*
from
	film f
where
	rating in ('pg-13', 'r', 'g');

-- ORDER BY: By default data is ordered in the ascending order of the primary key column
-- tie breaker is the primary key in case of same order of rows - pk in ascending
select
	film_id,
	title,
	length,
	rental_duration
from
	film
order by
	length,
	rental_duration;


select
	film_id,
	title,
	length,
	rental_duration
from
	film f
order by
	`length` desc,
	rental_duration;
-- If desc isn't specified on any order-by column, that column ordering is ascending