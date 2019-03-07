 CREATE TABLE movie (
    id bigserial PRIMARY KEY,
    title text not null,
    type text not null,
    year integer,
    UNIQUE (title,year),
    check(year > 1878)
 );

 CREATE TABLE customer (
    id bigserial PRIMARY KEY,
    name text not null
 );