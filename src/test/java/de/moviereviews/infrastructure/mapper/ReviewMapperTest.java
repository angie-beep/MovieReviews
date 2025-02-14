package de.moviereviews.infrastructure.mapper;

import de.moviereviews.domain.model.Review;
import de.moviereviews.infrastructure.mapper.ReviewMapper;
import de.moviereviews.infrastructure.persistence.entity.ReviewEntity;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ReviewMapperTest {

    @Test
    void testToDomain() {
        // Arrange
        ReviewEntity entity = new ReviewEntity();
        entity.setId(1L);
        entity.setStarRating(5);
        entity.setComment("Amazing movie!");
        entity.setCreatedAt(LocalDateTime.of(2024, 2, 1, 12, 0));
        entity.setUpdatedAt(LocalDateTime.of(2024, 2, 2, 14, 0));

        // Act
        Review review = ReviewMapper.toDomain(entity);

        // Assert
        assertNotNull(review);
        assertEquals(1L, review.getId());
        assertEquals(5, review.getStarRating());
        assertEquals("Amazing movie!", review.getComment());
        assertEquals(LocalDateTime.of(2024, 2, 1, 12, 0), review.getCreatedAt());
        assertEquals(LocalDateTime.of(2024, 2, 2, 14, 0), review.getUpdatedAt());
    }
}
