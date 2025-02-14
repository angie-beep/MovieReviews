package de.moviereviews.infrastructure.persistence.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LeaderboardEntityTest {

    @Test
    void testLeaderboardEntity() {
        // Arrange & Act
        LeaderboardEntity leaderboard = new LeaderboardEntity();
        leaderboard.setId(1L);
        leaderboard.setGenre("Action");

        // Assert
        assertEquals(1L, leaderboard.getId());
        assertEquals("Action", leaderboard.getGenre());
    }
}
