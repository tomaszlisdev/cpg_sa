 CREATE TABLE hist_movie (
    id bigserial PRIMARY KEY,
    title text not null,
    type text not null,
    year integer,
    UNIQUE (title,year),
    check(year > 1878)
 );

 CREATE TABLE hist_customer (
    id bigserial PRIMARY KEY,
    name text not null
 );