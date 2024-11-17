package de.moviereview.infrastructure.persistence.dao;

import de.moviereview.infrastructure.persistence.entity.WatchlistEntity;

import java.util.List;

public interface WatchlistDao {
    void create(WatchlistEntity watchlistEntity);

    WatchlistEntity read(long watchlistId);

    void update(WatchlistEntity watchlistEntity);

    void delete(long watchlistId);


}