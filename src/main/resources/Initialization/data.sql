-- Aktualisiertes data.sql

-- Beispiel-Daten für Filme
INSERT INTO movies (title, release_date, overview, trailer, length, original_language, overall_rating) VALUES
                                                                                                           ('Inception', '2010-07-16', 'A mind-bending thriller by Christopher Nolan.', 'https://youtube.com/trailer_inception', 148, 'English', 4.8),
('The Matrix', '1999-03-31', 'A hacker discovers a shocking truth about his reality.', 'https://youtube.com/trailer_matrix', 136, 'English', 4.7),
('Casino Royale', '2006-11-14', 'James Bond earns his license to kill in this action-packed spy thriller.', 'https://youtube.com/trailer_casino_royale', 144, 'English', 4.5),
('Skyfall', '2012-10-26', 'Bond investigates an attack on MI6, leading to personal revelations.', 'https://youtube.com/trailer_skyfall', 143, 'English', 4.7),
('The Conjuring', '2013-07-19', 'A family encounters terrifying forces in their new home.', 'https://youtube.com/trailer_the_conjuring', 112, 'English', 4.3),
('Get Out', '2017-02-24', 'A young man uncovers horrifying secrets about his girlfriend's family.', 'https://youtube.com/trailer_get_out', 104, 'English', 4.6),
('The Big Lebowski', '1998-03-06', 'A case of mistaken identity sends "The Dude" on a hilarious journey.', 'https://youtube.com/trailer_big_lebowski', 117, 'English', 4.2),
('Superbad', '2007-08-17', 'Two high school friends plan an unforgettable party night.', 'https://youtube.com/trailer_superbad', 113, 'English', 4.1),
('Toy Story', '1995-11-22', 'A cowboy doll struggles to accept a new space toy in the family.', 'https://youtube.com/trailer_toy_story', 81, 'English', 4.8),
('Finding Nemo', '2003-05-30', 'A clownfish sets out on an epic journey to rescue his son.', 'https://youtube.com/trailer_finding_nemo', 100, 'English', 4.7);

-- Beispiel-Daten für Schauspieler
INSERT INTO actors (firstname, lastname, birthday, heritage) VALUES
('Leonardo', 'DiCaprio', '1974-11-11', 'USA'),
('Keanu', 'Reeves', '1964-09-02', 'Canada'),
('Daniel', 'Craig', '1968-03-02', 'England'),
('Vera', 'Farmiga', '1973-08-06', 'USA'),
('Jordan', 'Peele', '1979-02-21', 'USA'),
('Jeff', 'Bridges', '1949-12-04', 'USA'),
('Tom', 'Hanks', '1956-07-09', 'USA'),
('Ellen', 'DeGeneres', '1958-01-26', 'USA');

-- Verknüpfung Filme und Schauspieler
INSERT INTO movie_actor (movie_id, actor_id) VALUES
(1, 1), -- Inception, Leonardo DiCaprio
(2, 2), -- The Matrix, Keanu Reeves
(3, 3), -- Casino Royale, Daniel Craig
(4, 3), -- Skyfall, Daniel Craig
(5, 4), -- The Conjuring, Vera Farmiga
(6, 5), -- Get Out, Jordan Peele
(7, 6), -- The Big Lebowski, Jeff Bridges
(9, 7), -- Toy Story, Tom Hanks
(10, 8); -- Finding Nemo, Ellen DeGeneres

-- Beispiel-Daten für Benutzer
INSERT INTO users (username, email, notifications_enabled) VALUES
('john_doe', 'john.doe@example.com', TRUE),
('jane_smith', 'jane.smith@example.com', FALSE);

-- Beispiel-Daten für Bewertungen
INSERT INTO reviews (user_id, movie_id, star_rating, comment) VALUES
(1, 1, 5, 'Amazing movie! Mind-blowing visuals and story.'),
(2, 2, 4, 'A classic sci-fi movie that everyone should watch.'),
(1, 3, 5, 'An iconic Bond film. Action-packed and thrilling.'),
(2, 5, 4, 'Spine-chilling and brilliantly directed.'),
(1, 9, 5, 'Childhood classic. A must-watch for all ages.');

-- Beispiel-Daten für Watchlists
INSERT INTO watchlists (user_id, is_public) VALUES
(1, TRUE),
(2, FALSE);

-- Verknüpfung Watchlists und Filme
INSERT INTO watchlist_movie (watchlist_id, movie_id) VALUES
(1, 1), -- John's Watchlist includes Inception
(1, 3), -- John's Watchlist includes Casino Royale
  (1, 9), -- John's Watchlist includes Toy Story
                                                                                                    (2, 2), -- Jane's Watchlist includes The Matrix
                                                                                                            (2, 5); -- Jane's Watchlist includes The Conjuring
