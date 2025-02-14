package de.moviereviews.infrastructure.persistence.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WatchlistEntityTest {

    @Test
    void testWatchlistEntity() {
        // Arrange & Act
        WatchlistEntity watchlist = new WatchlistEntity();
        watchlist.setId(1L);
        watchlist.setPublic(true);

        // Assert
        assertEquals(1L, watchlist.getId());
        assertTrue(watchlist.isPublic());
    }
}
