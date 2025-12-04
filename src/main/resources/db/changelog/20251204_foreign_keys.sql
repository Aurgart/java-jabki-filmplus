ALTER TABLE filmplus.friends
ADD CONSTRAINT fk_friends_user FOREIGN KEY (user_id)
REFERENCES filmplus.user(id)
ON DELETE CASCADE
ON UPDATE NO ACTION;

ALTER TABLE filmplus.friends
ADD CONSTRAINT fk_friends_friend FOREIGN KEY (friend_id)
REFERENCES filmplus.user(id)
ON DELETE CASCADE
ON UPDATE NO ACTION;

ALTER TABLE filmplus.like
ADD CONSTRAINT fk_like_user FOREIGN KEY (user_id)
REFERENCES filmplus.user(id)
ON DELETE CASCADE
ON UPDATE NO ACTION;

ALTER TABLE filmplus.like
ADD CONSTRAINT fk_film_user FOREIGN KEY (film_id)
REFERENCES filmplus.film(id)
ON DELETE CASCADE
ON UPDATE NO ACTION;

ALTER TABLE filmplus.review
ADD CONSTRAINT fk_review_user FOREIGN KEY (user_id)
REFERENCES filmplus.user(id)
ON DELETE CASCADE
ON UPDATE NO ACTION;

ALTER TABLE filmplus.review
ADD CONSTRAINT fk_review_film FOREIGN KEY (film_id)
REFERENCES filmplus.film(id)
ON DELETE CASCADE
ON UPDATE NO ACTION;
