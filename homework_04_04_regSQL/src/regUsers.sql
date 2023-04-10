--//ToDo 1.Get a list of all the usernames in the list of Users.
--//ToDo 2.Filter the list of User objects to only include users whose last name starts with "S".
--//ToDo 3.Get a list of all the User objects in the list that have an email address ending in ".com"
--//ToDo 4.Get a list of all the User objects in the list that are available
--//ToDo 5.Filter the list of User objects to only include users whose phoneNumber value is not null or empty
--//ToDo 6.Sort users by last name, and firstname
--//Todo 7.Find the User objects in the list that have a firstName field that matches a given regular expression pattern
--//Todo 8.Find the User object in the list with the earliest date field
--//ToDo 9.Find the User objects in the list that have a date field in the same year as a given date, and then count their amount

CREATE schema regApp_requests;

CREATE TABLE regApp_requests.users(
    ID SERIAL NOT NULL primary key,
    username varchar(255),
    password varchar(255),
    lastName varchar(255),
    firstName varchar(255),
    birthdate date,
    email varchar(255),
    address varchar (255),
    isAvailable boolean
);

CREATE TABLE regApp_requests.phoneNumbers(
    ID_phoneNumber SERIAL NOT NULL primary key,
    ID_user int references users(ID),
    phoneNumber varchar(13)
);

insert into regApp_requests.users(username, password, lastName, firstName,birthdate, email, address, isAvailable)
    values('Usr2','Avr@123Avr','Smit','Ikar','1988-01-01','ad@gmail.com','Ukraine, Dnipro, Green Str',true),
         ('Usr1','Avr@123Avr','Maximoff','Ivan','1986-06-06','pec@ua.com','Ukraine, Kyiv, Blue Str', true),
         ('Usr4','Avr@123Avr','Maximoff','Max','1986-06-06','pisem@bing.net','USA, Washington, Pink Str',false),
         ('usr7','Abr@123Abr','Neo','Adam','2001-05-19','setMeMail@mail.com','USA, New York, Yellow Str',true),
         ('Usr6','Abk@123Ank','John','Turbo','2001-01-01','Turbo@i.ua','Ukraine, Kyiv, Orange Str',false),
         ('usr23','Adb@123Abk','Black','Shon','2005-01-01','PR@i.ua','France, Paris, Black Str',false),
         ('Usr12','Avr@123Acx','Black','Alex','1958-12-12','dombiliBombas@gaza.net','Ukraine, Dnipro, White Str',false),
         ('Usr13','Avr@123Apx','Like','Juli','1942-12-12','dombiliBombas8@gaza.net','Ukraine, Odessa, Brown Str',false);


insert into regApp_requests.phoneNumbers(ID_user, phoneNumber)
    values(1, '+380676161616'),
         (2, '+380500505555'),
         (5, '+380975640000'),
         (7, '+380635632222'),
         (8, '+380502223333');


--#1
select username from regApp_requests.users;

--#2
select *
from regApp_requests.users
where lastName LIKE 'S%';

--#3
select *
from regApp_requests.users
where email LIKE '%com';

--#4
select *
from regApp_requests.users
where isAvailable=true;

--#5
select username,
       firstname,
       lastname,
       birthdate,
       p.phonenumber as phoneNumber
from regapp_requests.users u
left join regapp_requests.phonenumbers p on u.id = p.id_user
where p.phonenumber is not null;


--#6
select *
from regApp_requests.users
ORDER BY lastName,firstName;


--#7
select *
from regApp_requests.users
where firstname ~ '[a-zA-Z]{5,}';

--#8
-- My class Users in RegApp doesn't have CREATION DATA field
-- That's why I did this task in 2 ways: 1) sorted by username 2) show the oldest user
select *
from regApp_requests.users
order by username
limit 1;

select *
from regapp_requests.users
where birthdate = (select MIN(birthdate) from regApp_requests.users);

--#9
select COUNT(birthdate) as user_amount
from regApp_requests.users
where date_part('YEAR',birthdate)='1986';





