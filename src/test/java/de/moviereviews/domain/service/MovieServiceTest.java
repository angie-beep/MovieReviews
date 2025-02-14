package de.moviereviews.domain.service;

import de.moviereviews.domain.model.Movie;
import de.moviereviews.infrastructure.api.dto.MoviePageDTO;
import de.moviereviews.infrastructure.mapper.MovieMapper;
import de.moviereviews.infrastructure.persistence.entity.MovieEntity;
import de.moviereviews.infrastructure.persistence.repository.GenreRepository;
import de.moviereviews.infrastructure.persistence.repository.MovieRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MovieServiceTest {

    @Mock
    private MovieRepository movieRepository;

    @Mock
    private GenreRepository genreRepository;

    @InjectMocks
    private MovieService movieService;

    private MovieEntity movieEntity;
    private Movie movie;

    @BeforeEach
    void setUp() {
        movieEntity = new MovieEntity();
        movieEntity.setId(1L);
        movieEntity.setTitle("Inception");
        movieEntity.setPublishingDate(LocalDate.of(2010, 7, 16));
        movieEntity.setOriginalLanguage("English");
        movieEntity.setLength(148);
        movieEntity.setOverallRating(8.8f);
        movieEntity.setGenres(new HashSet<>());

        movie = MovieMapper.toDomain(movieEntity);
    }

    @Test
    void testAddMovie() {
        when(movieRepository.save(any(MovieEntity.class))).thenReturn(movieEntity);

        Movie createdMovie = movieService.addMovie("Inception", new HashSet<>(), LocalDate.of(2010, 7, 16),
                new HashSet<>(), new HashSet<>(), "English", 148, 8.8f);

        assertNotNull(createdMovie);
        assertEquals("Inception", createdMovie.getTitle());
        verify(movieRepository, times(1)).save(any(MovieEntity.class));
    }

    @Test
    void testUpdateMovie_Found() {
        when(movieRepository.findById(1L)).thenReturn(Optional.of(movieEntity));
        when(movieRepository.save(any(MovieEntity.class))).thenReturn(movieEntity);

        Movie updatedMovie = movieService.updateMovie(1L, "Interstellar", new HashSet<>(), LocalDate.of(2014, 11, 7),
                new HashSet<>(), new HashSet<>(), "English", 169, 8.6f);

        assertNotNull(updatedMovie);
        assertEquals("Interstellar", updatedMovie.getTitle());
        verify(movieRepository, times(1)).findById(1L);
        verify(movieRepository, times(1)).save(any(MovieEntity.class));
    }

    @Test
    void testUpdateMovie_NotFound() {
        when(movieRepository.findById(99L)).thenReturn(Optional.empty());

        Movie updatedMovie = movieService.updateMovie(99L, "Interstellar", new HashSet<>(), LocalDate.of(2014, 11, 7),
                new HashSet<>(), new HashSet<>(), "English", 169, 8.6f);

        assertNull(updatedMovie);
        verify(movieRepository, times(1)).findById(99L);
        verify(movieRepository, never()).save(any(MovieEntity.class));
    }

    @Test
    void testDeleteMovie() {
        doNothing().when(movieRepository).deleteById(1L);

        Boolean result = movieService.deleteMovie(1L);

        assertTrue(result);
        verify(movieRepository, times(1)).deleteById(1L);
    }

    @Test
    void testGetAllMovies() {
        when(movieRepository.findAll()).thenReturn(Collections.singletonList(movieEntity));

        List<Movie> movies = movieService.getAllMovies();

        assertNotNull(movies);
        assertEquals(1, movies.size());
        assertEquals("Inception", movies.get(0).getTitle());
        verify(movieRepository, times(1)).findAll();
    }

    @Test
    void testGetMoviesByFilters() {
        Page<MovieEntity> moviePage = new PageImpl<>(Collections.singletonList(movieEntity));
        when(movieRepository.findByGenresContainingIgnoreCaseAndOriginalLanguageContainingIgnoreCase(anyString(), anyString(), any(PageRequest.class)))
                .thenReturn(moviePage);

        MoviePageDTO result = movieService.getMoviesByFilters("Sci-Fi", "Nolan", "English", 0, 10);

        assertNotNull(result);
        assertEquals(1, result.getContent().size());
        assertEquals("Inception", result.getContent().get(0).getTitle());
        verify(movieRepository, times(1)).findByGenresContainingIgnoreCaseAndOriginalLanguageContainingIgnoreCase(anyString(), anyString(), any(PageRequest.class));
    }

    @Test
    void testGetMoviesByActor() {
        when(movieRepository.findByActors_Id(1L)).thenReturn(Collections.singletonList(movieEntity));

        List<Movie> movies = movieService.getMoviesByActor(1L);

        assertNotNull(movies);
        assertEquals(1, movies.size());
        assertEquals("Inception", movies.get(0).getTitle());
        verify(movieRepository, times(1)).findByActors_Id(1L);
    }

    @Test
    void testGetLeaderboardByGenre() {
        when(movieRepository.findByGenresGenreContainingIgnoreCaseOrderByOverallRatingDesc("Sci-Fi"))
                .thenReturn(Collections.singletonList(movieEntity));

        List<Movie> movies = movieService.getLeaderboardByGenre("Sci-Fi");

        assertNotNull(movies);
        assertEquals(1, movies.size());
        assertEquals("Inception", movies.get(0).getTitle());
        verify(movieRepository, times(1)).findByGenresGenreContainingIgnoreCaseOrderByOverallRatingDesc("Sci-Fi");
    }
}
