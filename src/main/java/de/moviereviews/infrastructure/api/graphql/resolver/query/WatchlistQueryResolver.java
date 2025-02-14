package de.moviereviews.infrastructure.api.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import de.moviereviews.domain.model.Watchlist;
import de.moviereviews.domain.service.WatchlistService;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class WatchlistQueryResolver implements GraphQLQueryResolver {

    private final WatchlistService watchlistService;

    public WatchlistQueryResolver(WatchlistService watchlistService) {
        this.watchlistService = watchlistService;
    }

    public Watchlist getWatchlistById(Long id) {
        return watchlistService.getWatchlistById(id);
    }

    public List<Watchlist> getAllWatchlists() {
        return watchlistService.getAllWatchlists();
    }

    public List<Watchlist> getWatchlistsByUserId(Long userId) {
        return watchlistService.getWatchlistsByUserId(userId);
    }

    public List<Watchlist> getPublicWatchlists() {
        return watchlistService.getPublicWatchlists();
    }
}
