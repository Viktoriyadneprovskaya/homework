CREATE DATABASE Users;

CREATE TABLE table_users (
PersonID SERIAL NOT NULL primary key,
firstname varchar(255),
lastname varchar(255),
birthdate date,
creation_date timestamp
);

CREATE TABLE users_accounts (
ID_check SERIAL NOT NULL primary key ,
person_ID bigint references table_users(PersonID),
user_account bigint,
creation_date timestamp
);

insert into table_users(firstname, lastname, birthdate, creation_date)
values ('Max', 'Maximov', '1982-10-28', CURRENT_TIMESTAMP),
       ('Jogn', 'Smith', '1983-02-15', CURRENT_TIMESTAMP),
       ('Helen', 'Dove', '1984-01-31', CURRENT_TIMESTAMP),
       ('Pola', 'Cast', '1981-05-02', CURRENT_TIMESTAMP),
       ('Sofiya', 'Shine', '1988-03-12', CURRENT_TIMESTAMP),
       ('Alex', 'Craft', '1987-08-25', CURRENT_TIMESTAMP),
       ('Paul', 'Mix', '1979-10-02', CURRENT_TIMESTAMP),
       ('Jane', 'Adams', '1982-04-27', CURRENT_TIMESTAMP),
       ('Jessica', 'Klein', '1984-02-06', CURRENT_TIMESTAMP),
       ('Vlad', 'Kost', '1989-07-23', CURRENT_TIMESTAMP),
       ('Igor', 'Medis', '1980-03-30', CURRENT_TIMESTAMP);

insert into users_accounts(person_ID,user_account,creation_date)
values (1,15000, CURRENT_TIMESTAMP),
       (2,15000, CURRENT_TIMESTAMP),
       (3,15000, CURRENT_TIMESTAMP),
       (4,15000, CURRENT_TIMESTAMP),
       (5,15000, CURRENT_TIMESTAMP),
       (6,15000, CURRENT_TIMESTAMP),
       (7,15000, CURRENT_TIMESTAMP),
       (8,15000, CURRENT_TIMESTAMP),
       (9,15000, CURRENT_TIMESTAMP),
       (10,15000, CURRENT_TIMESTAMP);
