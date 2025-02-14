package de.moviereviews.infrastructure.api.dto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MoviePageDTOTest {

    @Test
    void testMoviePageDTOSettersAndGetters() {
        // Arrange
        MoviePageDTO moviePageDTO = new MoviePageDTO();

        MovieDTO movie1 = new MovieDTO();
        movie1.setId(1L);
        movie1.setTitle("Inception");

        MovieDTO movie2 = new MovieDTO();
        movie2.setId(2L);
        movie2.setTitle("Interstellar");

        List<MovieDTO> movies = Arrays.asList(movie1, movie2);

        // Act
        moviePageDTO.setContent(movies);
        moviePageDTO.setTotalElements(2L);
        moviePageDTO.setTotalPages(1);
        moviePageDTO.setCurrentPage(0);
        moviePageDTO.setPageSize(10);

        // Assert
        assertEquals(2, moviePageDTO.getTotalElements());
        assertEquals(1, moviePageDTO.getTotalPages());
        assertEquals(0, moviePageDTO.getCurrentPage());
        assertEquals(10, moviePageDTO.getPageSize());
        assertNotNull(moviePageDTO.getContent());
        assertEquals(2, moviePageDTO.getContent().size());
        assertEquals("Inception", moviePageDTO.getContent().get(0).getTitle());
        assertEquals("Interstellar", moviePageDTO.getContent().get(1).getTitle());
    }

    @Test
    void testMoviePageDTODefaultConstructor() {
        // Arrange & Act
        MoviePageDTO moviePageDTO = new MoviePageDTO();

        // Assert
        assertNotNull(moviePageDTO);
        assertNull(moviePageDTO.getContent());
        assertEquals(0, moviePageDTO.getTotalElements());
        assertEquals(0, moviePageDTO.getTotalPages());
        assertEquals(0, moviePageDTO.getCurrentPage());
        assertEquals(0, moviePageDTO.getPageSize());
    }
}
