-- Session 1
show variables like 'autocommit';
show variables like 'transaction_isolation';

set autocommit = 0;

-- start transactions;
start transaction;
use sakila;
select * from sakila.film where film_id = 20;
update film set title = 'Harry Potter' where film_id = 20;
rollback;


-- Session 2
show variables like 'autocommit';
show variables like 'transaction_isolation';

set autocommit = 0;
set session transaction isolation level read uncommitted;

-- start transaction
start transaction;
use sakila;
select * from film where film_id = 20;
