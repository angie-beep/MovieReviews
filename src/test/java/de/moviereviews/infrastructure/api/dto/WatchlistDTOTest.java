package de.moviereviews.infrastructure.api.dto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WatchlistDTOTest {

    @Test
    void testWatchlistDTOSettersAndGetters() {
        // Arrange
        WatchlistDTO watchlistDTO = new WatchlistDTO();

        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        userDTO.setName("John Doe");
        userDTO.setEmail("john.doe@example.com");

        MovieDTO movie1 = new MovieDTO();
        movie1.setId(10L);
        movie1.setTitle("Inception");

        MovieDTO movie2 = new MovieDTO();
        movie2.setId(20L);
        movie2.setTitle("Interstellar");

        List<MovieDTO> movies = Arrays.asList(movie1, movie2);

        // Act
        watchlistDTO.setId(100L);
        watchlistDTO.setIsPublic(true);
        watchlistDTO.setUser(userDTO);
        watchlistDTO.setMovies(movies);

        // Assert
        assertEquals(100L, watchlistDTO.getId());
        assertTrue(watchlistDTO.getIsPublic());
        assertNotNull(watchlistDTO.getUser());
        assertEquals("John Doe", watchlistDTO.getUser().getName());
        assertEquals(2, watchlistDTO.getMovies().size());
        assertEquals("Inception", watchlistDTO.getMovies().get(0).getTitle());
        assertEquals("Interstellar", watchlistDTO.getMovies().get(1).getTitle());
    }

    @Test
    void testWatchlistDTODefaultConstructor() {
        // Arrange & Act
        WatchlistDTO watchlistDTO = new WatchlistDTO();

        // Assert
        assertNotNull(watchlistDTO);
        assertNull(watchlistDTO.getId());
        assertNull(watchlistDTO.getIsPublic());
        assertNull(watchlistDTO.getUser());
        assertNull(watchlistDTO.getMovies());
    }
}
