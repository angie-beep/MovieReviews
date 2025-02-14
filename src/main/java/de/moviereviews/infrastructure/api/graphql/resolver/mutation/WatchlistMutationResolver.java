package de.moviereviews.infrastructure.api.graphql.resolver.mutation;

import de.moviereviews.domain.model.Watchlist;
import de.moviereviews.domain.service.WatchlistService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

@Component
public class WatchlistMutationResolver implements GraphQLMutationResolver {

    private final WatchlistService watchlistService;

    public WatchlistMutationResolver(WatchlistService watchlistService) {
        this.watchlistService = watchlistService;
    }

    public Watchlist createWatchlist(Long userId, Boolean isPublic) {
        return watchlistService.createWatchlist(userId, isPublic);
    }

    public Watchlist addMovieToWatchlist(Long watchlistId, Long movieId) {
        return watchlistService.addMovieToWatchlist(watchlistId, movieId);
    }

    public Watchlist removeMovieFromWatchlist(Long watchlistId, Long movieId) {
        return watchlistService.removeMovieFromWatchlist(watchlistId, movieId);
    }

    public Watchlist setWatchlistPublicity(Long watchlistId, Boolean isPublic) {
        return watchlistService.setWatchlistPublicity(watchlistId, isPublic);
    }

    public Boolean deleteWatchlist(Long id) {
        return watchlistService.deleteWatchlist(id);
    }
}
