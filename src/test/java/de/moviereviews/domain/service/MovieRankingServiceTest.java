package de.moviereviews.domain.service;

import de.moviereviews.domain.model.Actor;
import de.moviereviews.domain.model.Director;
import de.moviereviews.domain.model.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MovieRankingServiceTest {

    private MovieRankingService movieRankingService;
    private Actor actor;
    private Director director;

    @BeforeEach
    void setUp() {
        movieRankingService = new MovieRankingService();

        Movie movie1 = new Movie("Inception");
        movie1.setOverallRating(9.0);
        Movie movie2 = new Movie("Interstellar");
        movie2.setOverallRating(8.5);
        Movie movie3 = new Movie("Dunkirk");
        movie3.setOverallRating(8.2);
        Movie movie4 = new Movie("Tenet");
        movie4.setOverallRating(7.5);

        actor = new Actor("Leonardo", "DiCaprio");
        actor.setMovies(new HashSet<>(Arrays.asList(movie1, movie2, movie3, movie4)));
        director = new Director("Christopher", "Nolan");
        director.setMovies(new HashSet<>(Arrays.asList(movie1, movie2, movie3, movie4)));
    }

    @Test
    void testGetTop3MoviesForActor() {
        // Act
        List<Movie> topMovies = movieRankingService.getTop3MoviesForActor(actor);

        // Assert
        assertNotNull(topMovies);
        assertEquals(3, topMovies.size());
        assertEquals("Inception", topMovies.get(0).getTitle());
        assertEquals("Interstellar", topMovies.get(1).getTitle());
        assertEquals("Dunkirk", topMovies.get(2).getTitle());
    }

    @Test
    void testGetTop3MoviesForActor_NoMovies() {
        // Arrange
        Actor newActor = new Actor("Tom", "Hanks");

        // Act
        List<Movie> topMovies = movieRankingService.getTop3MoviesForActor(newActor);

        // Assert
        assertNotNull(topMovies);
        assertTrue(topMovies.isEmpty());
    }

    @Test
    void testGetTop3MoviesForDirector() {
        // Act
        List<Movie> topMovies = movieRankingService.getTop3MoviesForDirector(director);

        // Assert
        assertNotNull(topMovies);
        assertEquals(3, topMovies.size());
        assertEquals("Inception", topMovies.get(0).getTitle());
        assertEquals("Interstellar", topMovies.get(1).getTitle());
        assertEquals("Dunkirk", topMovies.get(2).getTitle());
    }

    @Test
    void testGetTop3MoviesForDirector_NoMovies() {
        // Arrange
        Director newDirector = new Director("Quentin", "Tarantino");

        // Act
        List<Movie> topMovies = movieRankingService.getTop3MoviesForDirector(newDirector);

        // Assert
        assertNotNull(topMovies);
        assertTrue(topMovies.isEmpty());
    }
}