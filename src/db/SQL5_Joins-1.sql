-- inner join: Without the on clause it would have been called a cross join
use school;
select * from batches b ;
select * from students s ;

select
	concat(s.first_name, ' ', s.last_name) as student_name,
	b.batch_name
from
	students s join batches b
on s.batch_id = b.batch_id ;


-- self-join with the same table
select s.name, buddy.name
from students as s join students as buddy
on s.buddy_id = buddy.id;

select * from students s join batches b on s.batch_id = b.batch_id ;
select * from batches b join students s on s.batch_id = b.batch_id ;


-- joining multiple tables: Case for joining more than 2 tables
-- For every student, get the corresponding instructor name and the batch name
select *
from 
students s join instructors i on s.instructor_id = i.id
join batches b on s.b_id = b.id;

-- Q1. For every film, get the name of actors who performed in it
use sakila;
select f.title, concat(a.first_name, ' ', a.last_name ) as actor_name
from 
film f join film_actor fa on fa.film_id = f.film_id 
join actor a on fa.actor_id = a.actor_id ;

-- Customers who rented a film of category 'Horror' - customer first name, last name, email and the film
select 
	concat(c.first_name, ' ', c.last_name) as customer_name, 
	c.email as customer_email, 
	f.title as film_title,
	c2.name as film_category
from customer c join rental r on c.customer_id = r.customer_id 
join inventory i on i.inventory_id = r.inventory_id 
join film f on f.film_id = i.film_id 
join film_category fc on f.film_id = fc.film_id 
join category c2 on c2.category_id = fc.category_id 
where c2.name = 'horror';






















