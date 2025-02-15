package de.moviereviews.infrastructure.api.graphql.resolver.mutation;

import de.moviereviews.domain.model.Watchlist;
import de.moviereviews.domain.service.WatchlistService;
import de.moviereviews.infrastructure.api.dto.WatchlistDTO;
import de.moviereviews.infrastructure.mapper.WatchlistMapper;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller
public class WatchlistMutationResolver {

    private final WatchlistService watchlistService;

    public WatchlistMutationResolver(WatchlistService watchlistService) {
        this.watchlistService = watchlistService;
    }
    @MutationMapping
    public WatchlistDTO createWatchlist(Long userId, Boolean isPublic) {
        return WatchlistMapper.toDTO(watchlistService.createWatchlist(userId, isPublic));
    }
    @MutationMapping
    public WatchlistDTO addMovieToWatchlist(Long watchlistId, Long movieId) {
        return WatchlistMapper.toDTO(watchlistService.addMovieToWatchlist(watchlistId, movieId));
    }
    @MutationMapping
    public WatchlistDTO removeMovieFromWatchlist(Long watchlistId, Long movieId) {
        return WatchlistMapper.toDTO(watchlistService.removeMovieFromWatchlist(watchlistId, movieId));
    }
    @MutationMapping
    public WatchlistDTO setWatchlistPublicity(Long watchlistId, Boolean isPublic) {
        return WatchlistMapper.toDTO(watchlistService.setWatchlistPublicity(watchlistId, isPublic));
    }
    @MutationMapping
    public Boolean deleteWatchlist(Long id) {
        return watchlistService.deleteWatchlist(id);
    }
}
