package de.moviereview.infrastructure.persistence.dao;

import de.moviereview.infrastructure.persistence.entity.MovieEntity;
import de.moviereview.infrastructure.persistence.entity.WatchlistEntity;

import java.util.List;

public interface WatchlistDao {
    WatchlistEntity read(long watchlistId);

    void updatePublic();
    void addMovie(MovieEntity movie);

    void deleteMovie(long watchlistId);
    void clearWatchlist(long watchlistId);
}