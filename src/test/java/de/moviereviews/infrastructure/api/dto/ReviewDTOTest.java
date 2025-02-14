package de.moviereviews.infrastructure.api.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReviewDTOTest {

    @Test
    void testReviewDTOSettersAndGetters() {
        // Arrange
        ReviewDTO reviewDTO = new ReviewDTO();

        // Act
        reviewDTO.setId(1L);
        reviewDTO.setMovieId(10L);
        reviewDTO.setUserId(5L);
        reviewDTO.setRating(4);
        reviewDTO.setComment("Great movie!");
        reviewDTO.setCreatedAt("2024-02-01T12:00:00Z");
        reviewDTO.setUpdatedAt("2024-02-02T14:00:00Z");

        // Assert
        assertEquals(1L, reviewDTO.getId());
        assertEquals(10L, reviewDTO.getMovieId());
        assertEquals(5L, reviewDTO.getUserId());
        assertEquals(4, reviewDTO.getRating());
        assertEquals("Great movie!", reviewDTO.getComment());
        assertEquals("2024-02-01T12:00:00Z", reviewDTO.getCreatedAt());
        assertEquals("2024-02-02T14:00:00Z", reviewDTO.getUpdatedAt());
    }

    @Test
    void testReviewDTODefaultConstructor() {
        // Arrange & Act
        ReviewDTO reviewDTO = new ReviewDTO();

        // Assert
        assertNotNull(reviewDTO);
        assertNull(reviewDTO.getId());
        assertNull(reviewDTO.getMovieId());
        assertNull(reviewDTO.getUserId());
        assertNull(reviewDTO.getRating());
        assertNull(reviewDTO.getComment());
        assertNull(reviewDTO.getCreatedAt());
        assertNull(reviewDTO.getUpdatedAt());
    }
}
