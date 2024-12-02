package de.moviereview.resolver.query;

import de.moviereview.domain.model.Watchlist;
import de.moviereview.infrastructure.persistence.repository.WatchlistRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;

import java.util.List;

public class WatchlistResolver implements GraphQLQueryResolver {

    private final WatchlistRepository watchlistRepository = new WatchlistRepository();

    // Fetch a Watchlist by ID
    public Watchlist getWatchlistById(Long id) {
        return watchlistRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Watchlist not found with ID: " + id));
    }

    // Fetch all Watchlists
    public List<Watchlist> getAllWatchlists() {
        return watchlistRepository.findAll();
    }

    // Fetch Watchlists by User ID
    public List<Watchlist> getWatchlistsByUserId(Long userId) {
        return watchlistRepository.findAll().stream()
                .filter(watchlist -> watchlist.getUser().getId().equals(userId))
                .toList();
    }

    // Fetch Public Watchlists
    public List<Watchlist> getPublicWatchlists() {
        return watchlistRepository.findAll().stream()
                .filter(watchlist -> !watchlist.isPublic())
                .toList();
    }
}
