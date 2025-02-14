package de.moviereviews.infrastructure.api.graphql.resolver.query;

import de.moviereviews.infrastructure.api.dto.MovieDTO;
import de.moviereviews.infrastructure.api.dto.MoviePageDTO;
import de.moviereviews.domain.service.MovieService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MovieQueryResolverTest {

    @Mock
    private MovieService movieService;

    @InjectMocks
    private MovieQueryResolver movieQueryResolver;

    @Test
    void testGetAllMovies() {
        // Arrange
        MovieDTO movie = new MovieDTO();
        movie.setTitle("Inception");

        when(movieService.getAllMovieDTOs()).thenReturn(Arrays.asList(movie));

        // Act
        List<MovieDTO> result = movieQueryResolver.getAllMovies();

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Inception", result.get(0).getTitle());
        verify(movieService, times(1)).getAllMovieDTOs();
    }
}
