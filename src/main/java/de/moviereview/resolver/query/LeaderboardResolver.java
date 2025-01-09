package de.moviereview.resolver.query;

import de.moviereview.domain.model.Movie;
import de.moviereview.domain.service.LeaderboardService;
import graphql.kickstart.tools.GraphQLQueryResolver;

import java.util.List;

public class LeaderboardResolver implements GraphQLQueryResolver {

    private final LeaderboardService leaderboardService;

    public LeaderboardResolver(LeaderboardService leaderboardService) {
        this.leaderboardService = leaderboardService;
    }

    // Query: Get top movies by genre
    public List<Movie> getLeaderboard(String genre) {
        return leaderboardService.getTopMoviesByGenre(genre, 10);
    }

    // Query: Get overall top movies
    public List<Movie> getTopMoviesOverall() {
        return leaderboardService.getTopMoviesOverall(10);
    }
}
