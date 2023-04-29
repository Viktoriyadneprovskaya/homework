CREATE schema regg_app;


create table regg_app.users
(
    user_id      bigint generated by default as identity
        constraint user_pk primary key,
    username     varchar unique ,
    password     varchar,
    firstname    varchar,
    lastname     varchar,
    birth_date   date,
    email        varchar,
    phone_number varchar,
    address      varchar,
    isAvailable  boolean
)