CREATE TABLE filmplus.user
(
    id serial NOT NULL,
    login varchar NOT NULL,
    name varchar NOT NULL,
    email varchar NOT NULL,
    birthday date NOT NULL,
    PRIMARY KEY (id)
);
