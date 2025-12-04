CREATE TABLE filmplus.friends
(
    user_id integer NOT NULL,
    friend_id integer NOT NULL,
    PRIMARY KEY (user_id, friend_id)
);
