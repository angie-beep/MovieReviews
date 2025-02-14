package de.moviereviews.infrastructure.mapper;

import de.moviereviews.domain.model.Movie;
import de.moviereviews.infrastructure.api.dto.MovieDTO;
import de.moviereviews.infrastructure.mapper.MovieMapper;
import de.moviereviews.infrastructure.persistence.entity.MovieEntity;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MovieMapperTest {

    @Test
    void testToDomain() {
        // Arrange
        MovieEntity entity = new MovieEntity();
        entity.setId(1L);
        entity.setTitle("Inception");
        entity.setSummary("A dream within a dream.");
        entity.setTrailer("https://example.com/trailer");
        entity.setOverallRating(8.8f);
        entity.setPublishingDate(LocalDate.of(2010, 7, 16));
        entity.setLength(148);
        entity.setOriginalLanguage("English");

        // Act
        Movie movie = MovieMapper.toDomain(entity);

        // Assert
        assertNotNull(movie);
        assertEquals(1L, movie.getId());
        assertEquals("Inception", movie.getTitle());
        assertEquals("A dream within a dream.", movie.getSummary());
        assertEquals("https://example.com/trailer", movie.getTrailer());
        assertEquals(8.8f, movie.getOverallRating());
        assertEquals(LocalDate.of(2010, 7, 16), movie.getPublishingDate());
        assertEquals(148, movie.getLength());
        assertEquals("English", movie.getOriginalLanguage());
    }

    @Test
    void testToDTO() {
        // Arrange
        Movie movie = new Movie();
        movie.setId(1L);
        movie.setTitle("Inception");
        movie.setSummary("A dream within a dream.");
        movie.setTrailer("https://example.com/trailer");
        movie.setOverallRating(8.8f);
        movie.setPublishingDate(LocalDate.of(2010, 7, 16));
        movie.setLength(148);
        movie.setOriginalLanguage("English");

        // Act
        MovieDTO dto = MovieMapper.toDTO(movie);

        // Assert
        assertNotNull(dto);
        assertEquals(1L, dto.getId());
        assertEquals("Inception", dto.getTitle());
        assertEquals("A dream within a dream.", dto.getSummary());
        assertEquals("https://example.com/trailer", dto.getTrailer());
        assertEquals(8.8f, dto.getRating());
        assertEquals(148, dto.getLength());
        assertEquals("English", dto.getOriginalLanguage());
        assertEquals("2010-07-16", dto.getReleaseDate()); // Prüft die korrekte Formatierung des Datums
    }
}
