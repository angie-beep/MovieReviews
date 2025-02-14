package de.moviereviews.service;

import de.moviereviews.domain.model.Actor;
import de.moviereviews.domain.model.Director;
import de.moviereviews.domain.model.Movie;
import de.moviereviews.domain.service.MovieRankingService;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MovieRankingServiceTest {

    @Test
    void testGetTop3MoviesForActor() {
        // Arrange: Erstelle mehrere Filme mit unterschiedlichen overallRating
        Movie movie1 = new Movie("Movie 1", "Summary 1", "trailerUrl", LocalDate.now(), 100, "EN");
        movie1.setOverallRating(7.5);
        Movie movie2 = new Movie("Movie 2", "Summary 2", "trailerUrl", LocalDate.now(), 90, "EN");
        movie2.setOverallRating(8.2);
        Movie movie3 = new Movie("Movie 3", "Summary 3", "trailerUrl", LocalDate.now(), 110, "EN");
        movie3.setOverallRating(6.8);
        Movie movie4 = new Movie("Movie 4", "Summary 4", "trailerUrl", LocalDate.now(), 95, "EN");
        movie4.setOverallRating(9.1);

        Set<Movie> movies = new HashSet<>();
        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);
        movies.add(movie4);

        Actor actor = new Actor("Doe", "John", LocalDate.of(1990, 1, 1), "American", movies);

        // Instanziiere den Service (angenommen, er besitzt einen parameterlosen Konstruktor)
        MovieRankingService service = new MovieRankingService();

        // Act
        List<Movie> top3 = service.getTop3MoviesForActor(actor);

        // Assert: Es sollen genau 3 Filme zurückgegeben werden, sortiert absteigend nach overallRating.
        assertEquals(3, top3.size());
        // Erwartete Reihenfolge (höchste zuerst): movie4 (9.1), movie2 (8.2), movie1 (7.5)
        assertEquals("Movie 4", top3.get(0).getTitle());
        assertEquals("Movie 2", top3.get(1).getTitle());
        assertEquals("Movie 1", top3.get(2).getTitle());
    }

    @Test
    void testGetTop3MoviesForDirector() {
        // Arrange: Erstelle Filme für einen Director
        Movie movieA = new Movie("Movie A", "Summary A", "trailerUrl", LocalDate.now(), 100, "EN");
        movieA.setOverallRating(5.0);
        Movie movieB = new Movie("Movie B", "Summary B", "trailerUrl", LocalDate.now(), 100, "EN");
        movieB.setOverallRating(7.0);
        Movie movieC = new Movie("Movie C", "Summary C", "trailerUrl", LocalDate.now(), 100, "EN");
        movieC.setOverallRating(8.0);
        Movie movieD = new Movie("Movie D", "Summary D", "trailerUrl", LocalDate.now(), 100, "EN");
        movieD.setOverallRating(6.0);

        Set<Movie> movies = new HashSet<>();
        movies.add(movieA);
        movies.add(movieB);
        movies.add(movieC);
        movies.add(movieD);

        Director director = new Director("Smith", "Jane", LocalDate.of(1985, 5, 5), "British", movies);

        MovieRankingService service = new MovieRankingService();

        // Act
        List<Movie> top3 = service.getTop3MoviesForDirector(director);

        // Assert: Es sollen genau 3 Filme zurückgegeben werden, sortiert absteigend nach overallRating.
        assertEquals(3, top3.size());
        // Erwartete Reihenfolge: movieC (8.0), movieB (7.0), movieD (6.0)
        assertEquals("Movie C", top3.get(0).getTitle());
        assertEquals("Movie B", top3.get(1).getTitle());
        assertEquals("Movie D", top3.get(2).getTitle());
    }
}

