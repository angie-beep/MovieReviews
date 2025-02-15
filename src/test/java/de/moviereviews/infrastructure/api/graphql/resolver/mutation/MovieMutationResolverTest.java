package de.moviereviews.infrastructure.api.graphql.resolver.mutation;

import de.moviereviews.domain.model.Movie;
import de.moviereviews.infrastructure.api.dto.MovieDTO;
import de.moviereviews.domain.service.MovieService;
import de.moviereviews.infrastructure.persistence.entity.ActorEntity;
import de.moviereviews.infrastructure.persistence.entity.DirectorEntity;
import de.moviereviews.infrastructure.persistence.entity.GenreEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MovieMutationResolverTest {

    @Mock
    private MovieService movieService;

    @InjectMocks
    private MovieMutationResolver movieMutationResolver;

    @Test
    void testAddMovie() {
        // Arrange
        Set<GenreEntity> genres = new HashSet<>();
        Set<DirectorEntity> directors = new HashSet<>();
        Set<ActorEntity> actors = new HashSet<>();

        Movie movie = new Movie();
        movie.setTitle("Inception");
        movie.setPublishingDate(LocalDate.of(2010, 7, 16));
        movie.setOriginalLanguage("English");
        movie.setLength(148);
        movie.setOverallRating(8.8f);

        when(movieService.addMovie("Inception", genres, LocalDate.of(2010, 7, 16), directors, actors, "English", 148, 8.8f))
                .thenReturn(movie);

        // Act
        MovieDTO result = movieMutationResolver.addMovie("Inception", genres, LocalDate.of(2010, 7, 16), directors, actors, "English", 148, 8.8f);

        // Assert
        assertNotNull(result);
        assertEquals("Inception", result.getTitle());
        assertEquals("2010-07-16", result.getPublishingDate());
        assertEquals("English", result.getOriginalLanguage());
        assertEquals(148, result.getLength());
        assertEquals(8.8f, result.getOverallRating());

        verify(movieService, times(1)).addMovie("Inception", genres, LocalDate.of(2010, 7, 16), directors, actors, "English", 148, 8.8f);
    }

    @Test
    void testUpdateMovie() {
        // Arrange
        Set<GenreEntity> genres = new HashSet<>();
        Set<DirectorEntity> directors = new HashSet<>();
        Set<ActorEntity> actors = new HashSet<>();

        Movie movie = new Movie();
        movie.setTitle("Interstellar");
        movie.setPublishingDate(LocalDate.of(2014, 11, 7));
        movie.setOriginalLanguage("English");
        movie.setLength(169);
        movie.setOverallRating(8.6f);

        when(movieService.updateMovie(1L, "Interstellar", genres, LocalDate.of(2014, 11, 7), directors, actors, "English", 169, 8.6f))
                .thenReturn(movie);

        // Act
        MovieDTO result = movieMutationResolver.updateMovie(1L, "Interstellar", genres, LocalDate.of(2014, 11, 7), directors, actors, "English", 169, 8.6f);

        // Assert
        assertNotNull(result);
        assertEquals("Interstellar", result.getTitle());
        assertEquals("2014-11-07", result.getPublishingDate());
        assertEquals("English", result.getOriginalLanguage());
        assertEquals(169, result.getLength());
        assertEquals(8.6f, result.getOverallRating());

        verify(movieService, times(1)).updateMovie(1L, "Interstellar", genres, LocalDate.of(2014, 11, 7), directors, actors, "English", 169, 8.6f);
    }

    @Test
    void testDeleteMovie() {
        // Arrange
        when(movieService.deleteMovie(1L)).thenReturn(true);

        // Act
        Boolean result = movieMutationResolver.deleteMovie(1L);

        // Assert
        assertTrue(result);
        verify(movieService, times(1)).deleteMovie(1L);
    }
}
