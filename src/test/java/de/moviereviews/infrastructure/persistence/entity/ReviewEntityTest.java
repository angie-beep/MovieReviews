package de.moviereviews.infrastructure.persistence.entity;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ReviewEntityTest {

    @Test
    void testReviewEntity() {
        // Arrange & Act
        ReviewEntity review = new ReviewEntity();
        review.setId(1L);
        review.setStarRating(5);
        review.setComment("Amazing movie!");
        review.setCreatedAt(LocalDateTime.of(2024, 2, 1, 12, 0));
        review.setUpdatedAt(LocalDateTime.of(2024, 2, 2, 14, 0));

        // Assert
        assertEquals(1L, review.getId());
        assertEquals(5, review.getStarRating());
        assertEquals("Amazing movie!", review.getComment());
        assertEquals(LocalDateTime.of(2024, 2, 1, 12, 0), review.getCreatedAt());
        assertEquals(LocalDateTime.of(2024, 2, 2, 14, 0), review.getUpdatedAt());
    }
}
