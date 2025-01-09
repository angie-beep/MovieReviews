package de.moviereview.domain.service;

import de.moviereview.domain.model.Watchlist;
import de.moviereview.infrastructure.api.mapper.WatchlistMapper;
import de.moviereview.infrastructure.persistence.entity.WatchlistEntity;
import de.moviereview.infrastructure.persistence.repository.WatchlistRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class WatchlistService {

    private final WatchlistRepository watchlistRepository;
    private final WatchlistMapper watchlistMapper;

    // Constructor
    public WatchlistService(WatchlistRepository watchlistRepository, WatchlistMapper watchlistMapper) {
        this.watchlistRepository = watchlistRepository;
        this.watchlistMapper = watchlistMapper;
    }

    // Find a watchlist by ID
    public Watchlist findWatchlistById(Long watchlistId) {
        return watchlistRepository.findById(watchlistId)
                .map(watchlistMapper::toModel) // Mapping WatchlistEntity -> Watchlist
                .orElseThrow(() -> new IllegalArgumentException("Watchlist not found with ID: " + watchlistId));
    }


    // Find all watchlists
    public List<Watchlist> findAllWatchlists() {
        return watchlistRepository.findAll().stream()
                .map(watchlistMapper::toModel) // Convert each WatchlistEntity to Watchlist
                .collect(Collectors.toList());
    }

    // Create or update a watchlist
    public Watchlist saveWatchlist(Watchlist watchlist) {
        WatchlistEntity savedEntity = watchlistRepository.save(watchlistMapper.toEntity(watchlist)); // Convert Watchlist to WatchlistEntity
        return watchlistMapper.toModel(savedEntity); // Convert back to Watchlist
    }

    // Delete a watchlist by ID
    public void deleteWatchlist(Long watchlistId) {
        if (!watchlistRepository.existsById(watchlistId)) {
            throw new IllegalArgumentException("Watchlist not found with ID: " + watchlistId);
        }
        watchlistRepository.deleteById(watchlistId);
    }

    // Find watchlists by user ID
    public List<Watchlist> findWatchlistsByUserId(Long userId) {
        return watchlistRepository.findAll().stream()
                .filter(watchlist -> watchlist.getUser() != null && watchlist.getUser().getId().equals(userId))
                .map(watchlistMapper::toModel) // Convert WatchlistEntity to Watchlist
                .collect(Collectors.toList());
    }

    // Find all public watchlists
    public List<Watchlist> findPublicWatchlists() {
        return watchlistRepository.findAll().stream()
                .filter(WatchlistEntity::isPublic)
                .map(watchlistMapper::toModel) // Convert WatchlistEntity to Watchlist
                .collect(Collectors.toList());
    }
}

