package de.moviereviews.infrastructure.api.graphql.resolver.mutation;

import de.moviereviews.domain.model.Watchlist;
import de.moviereviews.domain.service.WatchlistService;
import de.moviereviews.infrastructure.api.dto.WatchlistDTO;
import de.moviereviews.infrastructure.mapper.WatchlistMapper;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

@Component
public class WatchlistMutationResolver implements GraphQLMutationResolver {

    private final WatchlistService watchlistService;

    public WatchlistMutationResolver(WatchlistService watchlistService) {
        this.watchlistService = watchlistService;
    }

    public WatchlistDTO createWatchlist(Long userId, Boolean isPublic) {
        return WatchlistMapper.toDTO(watchlistService.createWatchlist(userId, isPublic));
    }

    public WatchlistDTO addMovieToWatchlist(Long watchlistId, Long movieId) {
        return WatchlistMapper.toDTO(watchlistService.addMovieToWatchlist(watchlistId, movieId));
    }

    public WatchlistDTO removeMovieFromWatchlist(Long watchlistId, Long movieId) {
        return WatchlistMapper.toDTO(watchlistService.removeMovieFromWatchlist(watchlistId, movieId));
    }

    public WatchlistDTO setWatchlistPublicity(Long watchlistId, Boolean isPublic) {
        return WatchlistMapper.toDTO(watchlistService.setWatchlistPublicity(watchlistId, isPublic));
    }

    public Boolean deleteWatchlist(Long id) {
        return watchlistService.deleteWatchlist(id);
    }
}
