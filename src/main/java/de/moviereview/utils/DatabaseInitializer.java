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
            CREATE TABLE IF NOT EXISTS movies (
                id INTEGER PRIMARY KEY,
                title TEXT NOT NULL,
                summary TEXT,
                trailer INTEGER,
                overall_rating REAL,
                publishing_date DATETIME,
                genre TEXT,
                rank INTEGER,
                length INTEGER,
                original_language TEXT
            );
            """;

        String createUsersTable = """
            CREATE TABLE IF NOT EXISTS users (
                id INTEGER PRIMARY KEY,
                username TEXT UNIQUE NOT NULL,
                email TEXT UNIQUE,
                notifications_enabled,
                watchlist_id INTEGER
            );
            """;

        String createReviewsTable = """
            CREATE TABLE IF NOT EXISTS reviews (
                id INTEGER PRIMARY KEY,
                movie_id INTEGER,
                user_id INTEGER,
                star_rating INTEGER CHECK(rating >= 1 AND rating <= 5),
                comment TEXT,
                created_at DATETIME,
                updated_at DATETIME,
                FOREIGN KEY (movie_id) REFERENCES Movies(id),
                FOREIGN KEY (user_id) REFERENCES Users(id)
            );
            """;

        String createActorsTable = """
            CREATE TABLE IF NOT EXISTS actors (
                id INTEGER PRIMARY KEY,
                
            );
            """;

        try (Statement stmt = conn.createStatement()) {
            stmt.execute(createMoviesTable);
            stmt.execute(createUsersTable);
            stmt.execute(createReviewsTable);
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
