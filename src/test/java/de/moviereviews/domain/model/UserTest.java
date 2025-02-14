package de.moviereviews.domain.model;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    public void testUserCreationAndGettersSetters() {
        // Erstelle ein Dummy-Watchlist-Objekt und eine leere Reviews-Sammlung
        Watchlist watchlist = new Watchlist();
        HashSet<Review> reviews = new HashSet<>();

        // Erstelle einen User
        User user = new User(1L, "jane_doe", "jane@example.com", true, watchlist, reviews);

        assertEquals(1L, user.getId());
        assertEquals("jane_doe", user.getUsername());
        assertEquals("jane@example.com", user.getEmail());
        assertTrue(user.isNotificationsEnabled());
        assertEquals(watchlist, user.getWatchlist());
        assertEquals(reviews, user.getReviews());

        // Teste den Setter
        user.setUsername("new_username");
        assertEquals("new_username", user.getUsername());
    }
}

