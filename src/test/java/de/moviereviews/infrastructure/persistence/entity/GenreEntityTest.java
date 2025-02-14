package de.moviereviews.infrastructure.persistence.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GenreEntityTest {

    @Test
    void testGenreEntity() {
        // Arrange & Act
        GenreEntity genre = new GenreEntity();
        genre.setId(1L);
        genre.setGenre("Sci-Fi");

        // Assert
        assertEquals(1L, genre.getId());
        assertEquals("Sci-Fi", genre.getGenre());
    }
}
