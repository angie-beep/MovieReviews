package de.moviereviews.domain.model;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

public class WatchlistTest {

    @Test
    public void testWatchlistCreationAndGettersSetters() {
        // Erstelle ein Dummy-User-Objekt und eine leere Menge für Filme
        User user = new User("john_doe", "john@example.com", true);
        HashSet<Movie> movies = new HashSet<>();

        Watchlist watchlist = new Watchlist(1L, true, user, movies);

        assertEquals(1L, watchlist.getId());
        assertTrue(watchlist.isPublic());
        assertEquals(user, watchlist.getUser());
        assertEquals(movies, watchlist.getMovies());

        // Teste den Setter für isPublic
        watchlist.setPublic(false);
        assertFalse(watchlist.isPublic());
    }
}

