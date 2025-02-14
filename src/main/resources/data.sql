-- Filme
INSERT INTO movies (title, publishing_date, summary, trailer, length, original_language, overall_rating)
VALUES ('Inception', '2010-07-16', 'A mind-bending thriller by Christopher Nolan.', 'https://youtube.com/trailer_inception', 148, 'English', 4.8),
       ('The Matrix', '1999-03-31', 'A hacker discovers a shocking truth about his reality.', 'https://youtube.com/trailer_matrix', 136, 'English', 4.7),
       ('Casino Royale', '2006-11-14', 'James Bond earns his license to kill in this action-packed spy thriller.', 'https://youtube.com/trailer_casino_royale', 144, 'English', 4.5),
       ('Skyfall', '2012-10-26', 'Bond investigates an attack on MI6, leading to personal revelations.', 'https://youtube.com/trailer_skyfall', 143, 'English', 4.7),
       ('The Conjuring', '2013-07-19', 'A family encounters terrifying forces in their new home.', 'https://youtube.com/trailer_the_conjuring', 112, 'English', 4.3),
       ('Get Out', '2017-02-24', 'A young man uncovers horrifying secrets about his girlfriend''s family.', 'https://youtube.com/trailer_get_out', 104, 'English', 4.6),
       ('The Big Lebowski', '1998-03-06', 'A case of mistaken identity sends "The Dude" on a hilarious journey.', 'https://youtube.com/trailer_big_lebowski', 117, 'English', 4.2),
       ('Superbad', '2007-08-17', 'Two high school friends plan an unforgettable party night.', 'https://youtube.com/trailer_superbad', 113, 'English', 4.1),
       ('Toy Story', '1995-11-22', 'A cowboy doll struggles to accept a new space toy in the family.', 'https://youtube.com/trailer_toy_story', 81, 'English', 4.8),
       ('Finding Nemo', '2003-05-30', 'A clownfish sets out on an epic journey to rescue his son.', 'https://youtube.com/trailer_finding_nemo', 100, 'English', 4.7);

-- Schauspieler
INSERT INTO actors (first_name, last_name, birthday, heritage)
VALUES ('Leonardo', 'DiCaprio', '1974-11-11', 'USA'),
       ('Keanu', 'Reeves', '1964-09-02', 'Canada'),
       ('Daniel', 'Craig', '1968-03-02', 'England'),
       ('Vera', 'Farmiga', '1973-08-06', 'USA'),
       ('Jordan', 'Peele', '1979-02-21', 'USA'),
       ('Jeff', 'Bridges', '1949-12-04', 'USA'),
       ('Tom', 'Hanks', '1956-07-09', 'USA'),
       ('Ellen', 'DeGeneres', '1958-01-26', 'USA');

-- Regisseure
INSERT INTO directors (first_name, last_name, birthday, heritage)
VALUES ('Christopher', 'Nolan', '1970-07-30', 'UK'),
       ('Lana', 'Wachowski', '1965-06-21', 'USA'),
       ('Martin', 'Scorsese', '1942-11-17', 'USA'),
       ('Steven', 'Spielberg', '1946-12-18', 'USA'),
       ('Quentin', 'Tarantino', '1963-03-27', 'USA'),
       ('Martin', 'Campbell', '1960-01-01', 'UK'),
       ('Sam', 'Mendes', '1965-08-01', 'UK'),
       ('James', 'Wan', '1977-02-26', 'Australia'),
       ('Joel', 'Coen', '1954-11-29', 'USA'),
       ('Greg', 'Mottola', '1974-06-24', 'USA'),
       ('John', 'Lasseter', '1957-01-12', 'USA'),
       ('Andrew', 'Stanton', '1965-12-03', 'USA');

-- Genres
INSERT INTO genres (genre)
VALUES ('Action'),
       ('Sci-Fi'),
       ('Thriller'),
       ('Drama'),
       ('Comedy'),
       ('Animation');

-- Verknüpfung Filme und Schauspieler
INSERT INTO movie_actor (movie_id, actor_id)
VALUES (1, 1),
       (2, 2),
       (3, 3),
 (4, 3),  (5, 4), (6, 5),  (7, 6),  (9, 7),  (10, 8);

-- Verknüpfung Filme und Regisseure
INSERT INTO director_movie (director_id, movie_id)
VALUES (1, 1),  (2, 2), (6, 3),  (7, 4), (8, 5),  (5, 6),  (9, 7), (10, 8),  (11, 9), (12, 10);
-- Verknüpfung Filme und Genres

INSERT INTO genre_movie (genre_id, movie_id) VALUES
(2, 1), (3, 1),  (1, 2), (2, 2),  (1, 3), (3, 3),  (1, 4), (3, 4),  (3, 5), (4, 5),(3, 6), (4, 6), (5, 7),  (5, 8),  (6, 9), (5, 9),  (6, 10), (4, 10);

INSERT INTO users (username, email, notifications_enabled) VALUES
('john_doe', 'john.doe@example.com', TRUE), ('jane_smith', 'jane.smith@example.com', FALSE);

INSERT INTO reviews (user_id, movie_id, star_rating, comment)
VALUES (1, 1, 5, 'Amazing movie! Mind-blowing visuals and story.'), (2, 2, 4, 'A classic sci-fi movie that everyone should watch.'), (1, 3, 5, 'An iconic Bond film. Action-packed and thrilling.'), (2, 5, 4, 'Spine-chilling and brilliantly directed.'), (1, 9, 5, 'Childhood classic. A must-watch for all ages.');

INSERT INTO watchlists (user_id, is_public)
VALUES (1, TRUE), (2, FALSE);

INSERT INTO watchlist_movie (watchlist_id, movie_id) VALUES (1, 1), (1, 3), (1, 9),  (2, 2), (2, 5);