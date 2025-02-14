package de.moviereviews.domain.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LeaderboardTest {

    @Test
    public void testLeaderboardCreationAndGettersSetters() {
        Leaderboard leaderboard = new Leaderboard("Action");
        leaderboard.setId(1L);

        assertEquals(1L, leaderboard.getId());
        assertEquals("Action", leaderboard.getGenre());

        leaderboard.setGenre("Drama");
        assertEquals("Drama", leaderboard.getGenre());
    }
}
