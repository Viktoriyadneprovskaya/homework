CREATE DATABASE Users;

CREATE TABLE table_users (
                             PersonID SERIAL NOT NULL primary key,
                             firstname varchar(255),
                             lastname varchar(255),
                             birthdate date,
                             creation_date date
);

CREATE TABLE users_accounts (
                                ID_check SERIAL NOT NULL primary key ,
                                person_ID bigint references table_users(PersonID),
                                user_account bigint,
                                creation_date timestamp
);

select * from table_users;
select * from users_accounts;

insert into table_users(firstname, lastname, birthdate, creation_date)
values ('Max', 'Maximov', '1982-10-28', CURRENT_TIMESTAMP);

insert into table_users(firstname, lastname, birthdate, creation_date)
values ('Jogn', 'Smith', '1983-02-15', CURRENT_TIMESTAMP);

insert into table_users(firstname, lastname, birthdate, creation_date)
values ('Helen', 'Dove', '1984-01-31', CURRENT_TIMESTAMP);

insert into table_users(firstname, lastname, birthdate, creation_date)
values ('Pola', 'Cast', '1981-05-02', CURRENT_TIMESTAMP);

insert into table_users(firstname, lastname, birthdate, creation_date)
values ('Sofiya', 'Shine', '1988-03-12', CURRENT_TIMESTAMP);

insert into table_users(firstname, lastname, birthdate, creation_date)
values ('Alex', 'Craft', '1987-08-25', CURRENT_TIMESTAMP);

insert into table_users(firstname, lastname, birthdate, creation_date)
values ('Paul', 'Mix', '1979-10-02', CURRENT_TIMESTAMP);

insert into table_users(firstname, lastname, birthdate, creation_date)
values ('Jane', 'Adams', '1982-04-27', CURRENT_TIMESTAMP);

insert into table_users(firstname, lastname, birthdate, creation_date)
values ('Jessica', 'Klein', '1984-02-06', CURRENT_TIMESTAMP);

insert into table_users(firstname, lastname, birthdate, creation_date)
values ('Vlad', 'Kost', '1989-07-23', CURRENT_TIMESTAMP);

insert into table_users(firstname, lastname, birthdate, creation_date)
values ('Igor', 'Medis', '1980-03-30', CURRENT_TIMESTAMP);


insert into users_accounts(person_ID,user_account,creation_date)
values (1,15000, CURRENT_TIMESTAMP);

insert into users_accounts(person_ID,user_account,creation_date)
values (2,15000, CURRENT_TIMESTAMP);

insert into users_accounts(person_ID,user_account,creation_date)
values (3,15000, CURRENT_TIMESTAMP);

insert into users_accounts(person_ID,user_account,creation_date)
values (4,15000, CURRENT_TIMESTAMP);

insert into users_accounts(person_ID,user_account,creation_date)
values (5,15000, CURRENT_TIMESTAMP);

insert into users_accounts(person_ID,user_account,creation_date)
values (6,15000, CURRENT_TIMESTAMP);

insert into users_accounts(person_ID,user_account,creation_date)
values (7,15000, CURRENT_TIMESTAMP);

insert into users_accounts(person_ID,user_account,creation_date)
values (8,15000, CURRENT_TIMESTAMP);

insert into users_accounts(person_ID,user_account,creation_date)
values (9,15000, CURRENT_TIMESTAMP);

insert into users_accounts(person_ID,user_account,creation_date)
values (10,15000, CURRENT_TIMESTAMP);

select * from table_users;
select * from users_accounts;