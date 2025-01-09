-- Aktualisiertes schema.sql

-- Tabelle für Filme
CREATE TABLE movies (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        title VARCHAR(255) NOT NULL,
                        release_date DATE,
                        overview TEXT,
                        trailer TEXT,
                        length INT,
                        original_language VARCHAR(50),
                        overall_rating DOUBLE DEFAULT 0.0
);

-- Tabelle für Schauspieler
CREATE TABLE actors (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        firstname VARCHAR(100),
                        lastname VARCHAR(100),
                        birthday DATE,
                        heritage VARCHAR(100)
);

-- Verknüpfungstabelle zwischen Filmen und Schauspielern
CREATE TABLE movie_actor (
                             movie_id BIGINT,
                             actor_id BIGINT,
                             PRIMARY KEY (movie_id, actor_id),
                             FOREIGN KEY (movie_id) REFERENCES movies(id),
                             FOREIGN KEY (actor_id) REFERENCES actors(id)
);

-- Tabelle für Benutzer
CREATE TABLE users (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(50) NOT NULL UNIQUE,
                       email VARCHAR(255) NOT NULL UNIQUE,
                       notifications_enabled BOOLEAN DEFAULT TRUE
);

-- Tabelle für Bewertungen
CREATE TABLE reviews (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         user_id BIGINT,
                         movie_id BIGINT,
                         star_rating INT CHECK (star_rating BETWEEN 1 AND 5),
                         comment TEXT,
                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                         FOREIGN KEY (user_id) REFERENCES users(id),
                         FOREIGN KEY (movie_id) REFERENCES movies(id)
);

-- Tabelle für Watchlists
CREATE TABLE watchlists (
                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                            user_id BIGINT,
                            is_public BOOLEAN DEFAULT TRUE,
                            FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Verknüpfungstabelle zwischen Watchlists und Filmen
CREATE TABLE watchlist_movie (
                                 watchlist_id BIGINT,
                                 movie_id BIGINT,
                                 PRIMARY KEY (watchlist_id, movie_id),
                                 FOREIGN KEY (watchlist_id) REFERENCES watchlists(id),
                                 FOREIGN KEY (movie_id) REFERENCES movies(id)
);




