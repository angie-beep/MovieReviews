package de.moviereview.resolver.query;

import de.moviereview.domain.model.Watchlist;
import de.moviereview.domain.service.WatchlistService;
import de.moviereview.infrastructure.api.mapper.WatchlistMapper;
import graphql.kickstart.tools.GraphQLQueryResolver;

import java.util.List;
import java.util.stream.Collectors;

public class WatchlistResolver implements GraphQLQueryResolver {

    private final WatchlistService watchlistService;

    public WatchlistResolver(WatchlistService watchlistService) {
        this.watchlistService = watchlistService;
    }

    // Fetch a Watchlist by ID
    public Watchlist getWatchlistById(Long id) {
        return watchlistService.findWatchlistById(id);
    }

    // Fetch all Watchlists
    public List<Watchlist> getAllWatchlists() {
        return (List<Watchlist>) watchlistService.findAllWatchlists().stream();
    }

    // Fetch Watchlists by User ID
    public List<Watchlist> getWatchlistsByUserId(Long userId) {
        return (List<Watchlist>) watchlistService.findWatchlistsByUserId(userId).stream();

    }

    // Fetch Public Watchlists
    public List<Watchlist> getPublicWatchlists() {
        return (List<Watchlist>) watchlistService.findPublicWatchlists().stream();

    }
}
