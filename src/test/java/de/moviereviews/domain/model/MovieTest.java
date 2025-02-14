package de.moviereviews.domain.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

public class MovieTest {

    @Test
    public void testMovieCreationAndGettersSetters() {
        // Erstelle ein Movie-Objekt über den passenden Konstruktor
        Movie movie = new Movie(
                "Inception",
                "A mind-bending thriller",
                "trailerUrl",
                LocalDate.of(2010, 7, 16),
                148,
                "EN"
        );
        movie.setId(1L);
        movie.setOverallRating(8.8);

        // Setze leere Mengen für assoziierte Objekte
        movie.setActors(new HashSet<>());
        movie.setDirectors(new HashSet<>());
        movie.setReviews(new HashSet<>());
        movie.setWatchlist(new HashSet<>());

        // Überprüfe die Werte
        assertEquals(1L, movie.getId());
        assertEquals("Inception", movie.getTitle());
        assertEquals("A mind-bending thriller", movie.getSummary());
        assertEquals("trailerUrl", movie.getTrailer());
        // Für doubles immer ein Delta angeben:
        assertEquals(8.8, movie.getOverallRating(), 0.001);
        assertEquals(LocalDate.of(2010, 7, 16), movie.getPublishingDate());
        assertEquals(148, movie.getLength());
        assertEquals("EN", movie.getOriginalLanguage());
        assertNotNull(movie.getActors());
        assertNotNull(movie.getDirectors());
        assertNotNull(movie.getReviews());
        assertNotNull(movie.getWatchlist());
        assertNotNull(movie.getGenres());
    }
}
