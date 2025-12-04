CREATE TABLE filmplus.film
(
    id serial NOT NULL,
    name varchar NOT NULL,
    description varchar NOT NULL,
    release_date date NOT NULL,
    duration integer not null,
    genres genre[] not null,
    PRIMARY KEY (id)
);
