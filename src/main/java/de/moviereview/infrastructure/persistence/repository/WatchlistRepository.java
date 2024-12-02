package de.moviereview.infrastructure.persistence.repository;

import de.moviereview.domain.model.Watchlist;
import de.moviereview.infrastructure.persistence.entity.WatchlistEntity;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class WatchlistRepository {
    private final Map<Long, Watchlist> watchlistStorage = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    // Create or update a Watchlist
    public Watchlist save(Watchlist watchlist) {
        if (watchlist.getId() == null) {
            watchlist.setId(idGenerator.getAndIncrement());
        }
        watchlistStorage.put(watchlist.getId(), watchlist);
        return watchlist;
    }

    // Find a Watchlist by ID
    public Optional<Watchlist> findById(Long id) {
        return Optional.ofNullable(watchlistStorage.get(id));
    }

    // Get all Watchlists
    public List<Watchlist> findAll() {
        return new ArrayList<>(watchlistStorage.values());
    }

    // Delete a Watchlist by ID
    public boolean deleteById(Long id) {
        return watchlistStorage.remove(id) != null;
    }

    // Check if a Watchlist exists by ID
    public boolean existsById(Long id) {
        return watchlistStorage.containsKey(id);
    }
}
