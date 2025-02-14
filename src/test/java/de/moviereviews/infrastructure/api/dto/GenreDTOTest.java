package de.moviereviews.infrastructure.api.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenreDTOTest {

    @Test
    void testGenreDTOSettersAndGetters() {
        // Arrange
        GenreDTO genreDTO = new GenreDTO();

        // Act
        genreDTO.setId(1L);
        genreDTO.setName("Science Fiction");

        // Assert
        assertEquals(1L, genreDTO.getId());
        assertEquals("Science Fiction", genreDTO.getName());
    }

    @Test
    void testGenreDTODefaultConstructor() {
        // Arrange & Act
        GenreDTO genreDTO = new GenreDTO();

        // Assert
        assertNotNull(genreDTO);
        assertNull(genreDTO.getId());
        assertNull(genreDTO.getName());
    }
}
