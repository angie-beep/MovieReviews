package de.moviereviews.domain.model;

import de.moviereviews.domain.service.MovieRankingService;
import de.moviereviews.domain.service.MovieRankingServiceTest;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DirectorTest {

    @Test
    public void testDirectorCreationAndGetters() {
        Director director = new Director(
                1L,
                "Smith",
                "Jane",
                LocalDate.of(1985, 5, 5),
                "British",
                new HashSet<>()
        );

        assertEquals(1L, director.getId());
        assertEquals("Smith", director.getLastName());
        assertEquals("Jane", director.getFirstName());
        assertEquals(LocalDate.of(1985, 5, 5), director.getBirthday());
        assertEquals("British", director.getHeritage());
        assertTrue(director.getMovies().isEmpty());
    }

    @Test
    public void testGetTop3MoviesUsingService() {
        // Erstelle Filme für den Director
        Movie movieA = new Movie("Movie A", "Summary A", "trailerUrl", LocalDate.now(), 100, "EN");
        movieA.setOverallRating(6.5);
        Movie movieB = new Movie("Movie B", "Summary B", "trailerUrl", LocalDate.now(), 100, "EN");
        movieB.setOverallRating(8.0);
        Movie movieC = new Movie("Movie C", "Summary C", "trailerUrl", LocalDate.now(), 100, "EN");
        movieC.setOverallRating(7.5);
        Movie movieD = new Movie("Movie D", "Summary D", "trailerUrl", LocalDate.now(), 100, "EN");
        movieD.setOverallRating(5.5);

        HashSet<Movie> movies = new HashSet<>();
        movies.add(movieA);
        movies.add(movieB);
        movies.add(movieC);
        movies.add(movieD);

        Director director = new Director("Smith", "Jane", LocalDate.of(1985, 5, 5), "British", movies);

        MovieRankingService service = new MovieRankingService();
        List<Movie> top3 = director.getTop3Movies(service);

        // Erwartet: 3 Filme, sortiert: movieB (8.0), movieC (7.5), movieA (6.5)
        assertEquals(3, top3.size());
        assertEquals("Movie B", top3.get(0).getTitle());
        assertEquals("Movie C", top3.get(1).getTitle());
        assertEquals("Movie A", top3.get(2).getTitle());
    }
}
