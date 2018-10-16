DROP TABLE IF EXISTS users;
create table users
(
	id serial primary key,
	role integer,
	mail varchar(100) not null,
	pass varchar(100),
	first_name varchar(50),
	second_name varchar(50)
);


