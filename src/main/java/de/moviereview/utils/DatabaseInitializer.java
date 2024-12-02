package de.moviereview.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.io.File;

public class DatabaseInitializer {

    private static final String DB_URL = "jdbc:sqlite:movie_reviews.db";

    public static void main(String[] args) {
        initializeDatabase();
    }

    public static void initializeDatabase() {
        File dbFile = new File("movie_reviews.db");
        if (!dbFile.exists()) {
            try (Connection conn = DriverManager.getConnection(DB_URL)) {
                if (conn != null) {
                    createTables(conn);
                    insertSampleData(conn);
                    System.out.println("Database and sample data initialized.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Database already exists.");
        }
    }

    private static void createTables(Connection conn) throws Exception {
        String createMoviesTable = """
            DROP TABLE IF EXISTS `MovieReviews`.`movies` ;
            CREATE TABLE IF NOT EXISTS `MovieReviews`.`movies` (
              `id` INT PRIMARY KEY AUTO_INCREMENT,
              `title` VARCHAR(255) NOT NULL,
              `summary` TEXT NULL DEFAULT NULL,
              `trailer` VARCHAR(255) NULL DEFAULT NULL,
              `overall_rating` DOUBLE NULL DEFAULT NULL,
              `publishing_date` DATE NULL DEFAULT NULL,
              `genre` VARCHAR(45) NULL DEFAULT NULL,
              `length` INT NULL DEFAULT NULL,
              `original_language` VARCHAR(45) NULL DEFAULT NULL
            );
            """;

        String createUsersTable = """
            DROP TABLE IF EXISTS `MovieReviews`.`users` ;       
            CREATE TABLE IF NOT EXISTS `MovieReviews`.`users` (
              `id` INT PRIMARY KEY AUTO_INCREMENT,
              `username` VARCHAR(45) NOT NULL,
              `email` VARCHAR(155) NOT NULL,
              `notifications_enabled` BOOLEAN NOT NULL DEFAULT FALSE,
              `watchlist_id` INT NOT NULL,
              `password` VARCHAR(45) NOT NULL,
              FOREIGN KEY (`watchlist_id`) REFERENCES `MovieReviews`.`watchlists` (`id`))
            );
            """;

        String createReviewsTable = """
            DROP TABLE IF EXISTS `MovieReviews`.`reviews` ;
            CREATE TABLE IF NOT EXISTS `MovieReviews`.`reviews` (
              `id` INT PRIMARY KEY AUTO_INCREMENT,
              `star_rating` INT NOT NULL,
              `comment` TEXT NULL DEFAULT NULL,
              `created_at` DATETIME NULL DEFAULT NULL,
              `updated_at` DATETIME NULL DEFAULT NULL,
              `user_id` INT NOT NULL,
              `movie_id` INT NOT NULL,
              FOREIGN KEY (`movie_id`) REFERENCES `MovieReviews`.`movies` (`id`),
              FOREIGN KEY (`user_id`) REFERENCES `MovieReviews`.`users` (`id`)
            );
            """;

        String createActorsTable = """
            DROP TABLE IF EXISTS `MovieReviews`.`actors` ;            
            CREATE TABLE IF NOT EXISTS `MovieReviews`.`actors` (
              `id` INT PRIMARY KEY AUTO_INCREMENT,
              `lastname` VARCHAR(45) NOT NULL,
              `firstname` VARCHAR(45) NULL DEFAULT NULL,
              `birthday` DATE NULL DEFAULT NULL,
              `heritage` VARCHAR(45) NULL DEFAULT NULL
            );
            """;

        String createDirectorsTable = """
            DROP TABLE IF EXISTS `MovieReviews`.`directors` ;            
            CREATE TABLE IF NOT EXISTS `MovieReviews`.`directors` (
              `id` INT PRIMARY KEY AUTO_INCREMENT,
              `lastname` VARCHAR(45) NOT NULL,
              `firstname` VARCHAR(45) NULL DEFAULT NULL,
              `birthday` DATE NULL DEFAULT NULL,
              `heritage` VARCHAR(45) NULL DEFAULT NULL
            );
            """;

        String createWatchlistsTable = """           
           DROP TABLE IF EXISTS `MovieReviews`.`watchlists` ;
           CREATE TABLE IF NOT EXISTS `MovieReviews`.`watchlists` (
             `id` INT PRIMARY KEY AUTO_INCREMENT,
             `is_public` BOOLEAN NOT NULL DEFAULT FALSE,
             `user_id` INT NOT NULL,
             FOREIGN KEY (`user_id`) REFERENCES `MovieReviews`.`users` (`id`)
            );
            """;

        String createActorMovieTable = """
            DROP TABLE IF EXISTS `MovieReviews`.`actor_movie` ;
            CREATE TABLE IF NOT EXISTS `MovieReviews`.`actor_movie` (
              `id` INT PRIMARY KEY AUTO_INCREMENT,
              `actor_id` INT NOT NULL,
              `movie_id` INT NOT NULL,
              FOREIGN KEY (`actor_id`) REFERENCES `MovieReviews`.`actors` (`id`),
              FOREIGN KEY (`movie_id`) REFERENCES `MovieReviews`.`movies` (`id`)
            );
            """;

        String createDirectorMovieTable = """
            DROP TABLE IF EXISTS `MovieReviews`.`director_movie` ;
            CREATE TABLE IF NOT EXISTS `MovieReviews`.`director_movie` (
              `id` INT PRIMARY KEY AUTO_INCREMENT,
              `director_id` INT NOT NULL,
              `movie_id` INT NOT NULL,
              FOREIGN KEY (`director_id`) REFERENCES `MovieReviews`.`directors` (`id`),
              FOREIGN KEY (`movie_id`) REFERENCES `MovieReviews`.`movies` (`id`)
            );
            """;

        String createGenresTable = """
            DROP TABLE IF EXISTS `MovieReviews`.`genres` ;            
            CREATE TABLE IF NOT EXISTS `MovieReviews`.`genres` (
              `id` INT PRIMARY KEY AUTO_INCREMENT,
              `genre` VARCHAR(45) NOT NULL,
            );
            """;

        String createGenreMovieTable = """
            DROP TABLE IF EXISTS `MovieReviews`.`genre_movie` ;
            CREATE TABLE IF NOT EXISTS `MovieReviews`.`genre_movie` (
              `id` INT PRIMARY KEY AUTO_INCREMENT,
              `genre_id` INT NOT NULL,
              `movie_id` INT NOT NULL,
              FOREIGN KEY (`genre_id`) REFERENCES `MovieReviews`.`genres` (`id`),
              FOREIGN KEY (`movie_id`) REFERENCES `MovieReviews`.`movies` (`id`)
            );
            """;

        String createWatchlistMovieTable = """           
            DROP TABLE IF EXISTS `MovieReviews`.`watchlist_movie` ;
            CREATE TABLE IF NOT EXISTS `MovieReviews`.`watchlist_movie` (
              `id` INT PRIMARY KEY AUTO_INCREMENT,
              `watchlist_id` INT NULL DEFAULT NULL,
              `movie_id` INT NOT NULL,
              FOREIGN KEY (`movie_id`) REFERENCES `MovieReviews`.`movies` (`id`),
              FOREIGN KEY (`watchlist_id`) REFERENCES `MovieReviews`.`watchlists` (`id`)
            );
            """;

        try (Statement stmt = conn.createStatement()) {
            stmt.execute(createActorsTable);
            stmt.execute(createDirectorsTable);
            stmt.execute(createMoviesTable);
            stmt.execute(createUsersTable);
            stmt.execute(createReviewsTable);
            stmt.execute(createGenresTable);
            stmt.execute(createWatchlistsTable);
            stmt.execute(createActorMovieTable);
            stmt.execute(createDirectorMovieTable);
            stmt.execute(createWatchlistMovieTable);
            stmt.execute(createGenreMovieTable);
        }
    }

    private static void insertSampleData(Connection conn) throws Exception {
        String insertMovies = "INSERT INTO Movies (title, director, release_year, genre) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(insertMovies)) {
            pstmt.setString(1, "The Shawshank Redemption");
            pstmt.setString(2, "Frank Darabont");
            pstmt.setInt(3, 1994);
            pstmt.setString(4, "Drama");
            pstmt.executeUpdate();

            pstmt.setString(1, "The Godfather");
            pstmt.setString(2, "Francis Ford Coppola");
            pstmt.setInt(3, 1972);
            pstmt.setString(4, "Crime");
            pstmt.executeUpdate();

            pstmt.setString(1, "Inception");
            pstmt.setString(2, "Christopher Nolan");
            pstmt.setInt(3, 2010);
            pstmt.setString(4, "Sci-Fi");
            pstmt.executeUpdate();
        }

        String insertUsers = "INSERT INTO Users (username, email) VALUES (?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(insertUsers)) {
            pstmt.setString(1, "john_doe");
            pstmt.setString(2, "john@example.com");
            pstmt.executeUpdate();

            pstmt.setString(1, "jane_smith");
            pstmt.setString(2, "jane@example.com");
            pstmt.executeUpdate();
        }

        String insertReviews = "INSERT INTO Reviews (movie_id, user_id, rating, comment) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(insertReviews)) {
            pstmt.setInt(1, 1); // movie_id for "The Shawshank Redemption"
            pstmt.setInt(2, 1); // user_id for "john_doe"
            pstmt.setInt(3, 10);
            pstmt.setString(4, "Amazing movie with stellar performances!");
            pstmt.executeUpdate();

            pstmt.setInt(1, 2); // movie_id for "The Godfather"
            pstmt.setInt(2, 2); // user_id for "jane_smith"
            pstmt.setInt(3, 9);
            pstmt.setString(4, "Classic mob movie, a must-watch.");
            pstmt.executeUpdate();

            pstmt.setInt(1, 3); // movie_id for "Inception"
            pstmt.setInt(2, 1); // user_id for "john_doe"
            pstmt.setInt(3, 8);
            pstmt.setString(4, "Mind-bending and visually stunning.");
            pstmt.executeUpdate();
        }
    }
}
