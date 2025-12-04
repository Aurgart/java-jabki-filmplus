CREATE TABLE filmplus.review
(
    user_id integer NOT NULL,
    film_id integer NOT NULL,
    review varchar not null,
    PRIMARY KEY (user_id, film_id)
);
