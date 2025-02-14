package de.moviereviews.domain.model;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

public class GenreTest {

    @Test
    public void testGenreCreationAndGettersSetters() {
        HashSet<Movie> movies = new HashSet<>();
        Genre genre = new Genre(1L, "Action", movies);

        assertEquals(1L, genre.getId());
        assertEquals("Action", genre.getGenre());
        assertEquals(movies, genre.getMovies());

        // Teste den Setter
        genre.setGenre("Adventure");
        assertEquals("Adventure", genre.getGenre());
    }
}

