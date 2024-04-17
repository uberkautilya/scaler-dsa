SELECT * FROM information_schema.innodb_trx;
-- Session 1
show variables like 'autocommit';
show variables like 'transaction_isolation';

set autocommit = 0;

-- start transactions;
start transaction;
use sakila;
select * from sakila.film where film_id = 20;
update film set title = 'Mask of Zorro 2' where film_id = 20;
commit;
rollback;

--
update school.students
set psp = 79 where student_id = 4;
commit;

-- ********************************************************

-- Read Committed isolation level

SELECT trx_isolation_level FROM information_schema.innodb_trx;
-- Session 2
show variables like 'autocommit';
show variables like 'transaction_isolation';

set autocommit = 0;
set session transaction isolation level read committed;

-- start transaction
start transaction;
use sakila;
select * from film where film_id = 20;

rollback;


-- Repeatable Read: Can give Phantom Read
set session transaction isolation level repeatable read;

use school;
start transaction;
select * from students where psp < 80;
-- send the mail.
-- After this, say the psp for student with id = 4 is updated with psp = 79 in another session
update students set email_sent = true
where psp < 80;
-- Since the isolation level is repeatable read, the update would not happen for this studen of id = 4
-- if update happens in the same session, behavior does NOT hold
-- In case of an insert/update within same transaction, a new read will be performed
-- Hence, the repeatable read is exempted for this row.
-- Now a new read will include this row if filter condition is satisfied
-- this is called PHANTOM READ - wasn't present earlier in the read, but now it is.
















