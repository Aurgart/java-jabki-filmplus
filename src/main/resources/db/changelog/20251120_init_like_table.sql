CREATE TABLE filmplus.like
(
    user_id integer NOT NULL,
    film_id integer NOT NULL,
    PRIMARY KEY (user_id, film_id)
);
