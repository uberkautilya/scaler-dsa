create database school;
use school;
create table batches(
	batch_id int primary key,
	batch_name varchar(50) not null
);
insert into	batches(batch_id, batch_name)
values
	(1, 'Batch A'),
	(2, 'Batch B'),
	(3, 'Batch C');
	
create table students(
	student_id int auto_increment primary key,
	first_name varchar(50) not null,
	last_name varchar(50) not null,
	batch_id int,
	foreign key(batch_id) references batches(batch_id) on delete cascade on update cascade
);
-- Alternatively
alter table students add foreign key batch_id references batches(batch_id);


insert
	into
	students(first_name,
	last_name,
	batch_id)
values
	('Student101', 'Last101', 1),
	('Student102', 'Last102', 1),
	('Student103', 'Last103', 2),
	('Student104', 'Last104', 3),
	('Student105', 'Last105', 1),
	('Student106', 'Last106', 2);

delete
from
	batches
where
	batch_id = 1;
	
select * from students s ;
select * from batches b ;