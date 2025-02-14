package de.moviereviews.domain.model;

import de.moviereviews.domain.service.MovieRankingService;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ActorTest {

    @Test
    public void testActorCreationAndGetters() {
        Actor actor = new Actor(
                1L,
                "Doe",
                "John",
                LocalDate.of(1990, 5, 20),
                "American",
                new HashSet<>()
        );

        assertEquals(1L, actor.getId());
        assertEquals("Doe", actor.getLastName());
        assertEquals("John", actor.getFirstName());
        assertEquals(LocalDate.of(1990, 5, 20), actor.getBirthday());
        assertEquals("American", actor.getHeritage());
        assertTrue(actor.getMovies().isEmpty());
    }

    @Test
    public void testGetTop3MoviesUsingService() {
        // Erstelle Filme mit verschiedenen Bewertungen
        Movie movie1 = new Movie("Movie 1", "Summary 1", "trailerUrl", LocalDate.now(), 120, "EN");
        movie1.setOverallRating(7.0);
        Movie movie2 = new Movie("Movie 2", "Summary 2", "trailerUrl", LocalDate.now(), 120, "EN");
        movie2.setOverallRating(8.0);
        Movie movie3 = new Movie("Movie 3", "Summary 3", "trailerUrl", LocalDate.now(), 120, "EN");
        movie3.setOverallRating(9.0);
        Movie movie4 = new Movie("Movie 4", "Summary 4", "trailerUrl", LocalDate.now(), 120, "EN");
        movie4.setOverallRating(6.0);

        HashSet<Movie> movies = new HashSet<>();
        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);
        movies.add(movie4);

        Actor actor = new Actor("Doe", "John", LocalDate.of(1990, 1, 1), "American", movies);

        // Verwende den MovieRatingService
        MovieRankingService service = new MovieRankingService();
        List<Movie> top3 = actor.getTop3Movies(service);

        // Erwartet: 3 Filme, sortiert: movie3 (9.0), movie2 (8.0), movie1 (7.0)
        assertEquals(3, top3.size());
        assertEquals("Movie 3", top3.get(0).getTitle());
        assertEquals("Movie 2", top3.get(1).getTitle());
        assertEquals("Movie 1", top3.get(2).getTitle());
    }
}

