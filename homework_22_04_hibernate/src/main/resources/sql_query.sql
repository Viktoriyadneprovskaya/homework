CREATE  schema  hib;

CREATE TABLE hib.movies
(
    ID        SERIAL NOT NULL primary key,
    language  varchar,
    moviename varchar,
    releaseyear varchar
);