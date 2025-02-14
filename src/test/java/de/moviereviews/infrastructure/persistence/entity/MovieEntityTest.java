package de.moviereviews.infrastructure.persistence.entity;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MovieEntityTest {

    @Test
    void testMovieEntity() {
        // Arrange & Act
        MovieEntity movie = new MovieEntity();
        movie.setId(1L);
        movie.setTitle("Inception");
        movie.setSummary("A dream within a dream.");
        movie.setTrailer("https://example.com/trailer");
        movie.setOverallRating(8.8);
        movie.setPublishingDate(LocalDate.of(2010, 7, 16));
        movie.setLength(148);
        movie.setOriginalLanguage("English");

        // Assert
        assertEquals(1L, movie.getId());
        assertEquals("Inception", movie.getTitle());
        assertEquals("A dream within a dream.", movie.getSummary());
        assertEquals("https://example.com/trailer", movie.getTrailer());
        assertEquals(8.8, movie.getOverallRating());
        assertEquals(LocalDate.of(2010, 7, 16), movie.getPublishingDate());
        assertEquals(148, movie.getLength());
        assertEquals("English", movie.getOriginalLanguage());
    }
}
