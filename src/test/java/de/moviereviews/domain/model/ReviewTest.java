package de.moviereviews.domain.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class ReviewTest {

    @Test
    public void testReviewCreationAndGettersSetters() {
        // Erstelle Dummy-Objekte für User und Movie
        User user = new User("john_doe", "john@example.com", true);
        Movie movie = new Movie("Inception", "A mind-bending thriller", "trailerUrl", LocalDate.of(2010, 7, 16), 148, "EN");

        // Erstelle eine Review mit dem Konstruktor
        Review review = new Review(user, movie, 5, "Excellent movie!");
        review.setId(1L);

        // Überprüfe die Werte
        assertEquals(1L, review.getId());
        assertEquals(user, review.getUser());
        assertEquals(movie, review.getMovie());
        assertEquals(5, review.getStarRating());
        assertEquals("Excellent movie!", review.getComment());
        assertNotNull(review.getCreatedAt());
        assertNull(review.getUpdatedAt());

        // Teste den Setter für updatedAt
        LocalDateTime now = LocalDateTime.now();
        review.setUpdatedAt(now);
        assertEquals(now, review.getUpdatedAt());
    }
}
