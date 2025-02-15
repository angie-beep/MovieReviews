package de.moviereviews.infrastructure.api.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieDTOTest {

    @Test
    void testMovieDTOSettersAndGetters() {
        // Arrange
        MovieDTO movieDTO = new MovieDTO();

        // Act
        movieDTO.setId(1L);
        movieDTO.setTitle("Inception");
        movieDTO.setPublishingDate("2010-07-16");
        movieDTO.setSummary("A mind-bending thriller about dreams within dreams.");
        movieDTO.setTrailer("https://example.com/trailer");
        movieDTO.setOverallRating(8.8f);
        movieDTO.setLength(148);
        movieDTO.setOriginalLanguage("English");

        // Assert
        assertEquals(1L, movieDTO.getId());
        assertEquals("Inception", movieDTO.getTitle());
        assertEquals("2010-07-16", movieDTO.getPublishingDate());
        assertEquals("A mind-bending thriller about dreams within dreams.", movieDTO.getSummary());
        assertEquals("https://example.com/trailer", movieDTO.getTrailer());
        assertEquals(8.8f, movieDTO.getOverallRating());
        assertEquals(148, movieDTO.getLength());
        assertEquals("English", movieDTO.getOriginalLanguage());
    }

    @Test
    void testMovieDTODefaultConstructor() {
        // Arrange & Act
        MovieDTO movieDTO = new MovieDTO();

        // Assert
        assertNotNull(movieDTO);
        assertNull(movieDTO.getId());
        assertNull(movieDTO.getTitle());
        assertNull(movieDTO.getPublishingDate());
        assertNull(movieDTO.getSummary());
        assertNull(movieDTO.getTrailer());
        assertNull(movieDTO.getOverallRating());
        assertNull(movieDTO.getLength());
        assertNull(movieDTO.getOriginalLanguage());
    }
}
