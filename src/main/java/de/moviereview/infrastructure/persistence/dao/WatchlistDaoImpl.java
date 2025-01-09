package de.moviereview.infrastructure.persistence.dao;

import de.moviereview.infrastructure.persistence.entity.MovieEntity;
import de.moviereview.infrastructure.persistence.entity.WatchlistEntity;

public class WatchlistDaoImpl extends BaseDao implements WatchlistDao {

    @Override
    public WatchlistEntity read(long id) {
        return em.find(WatchlistEntity.class, id);
    }

    @Override
    public void updatePublic() {
        // Implement logic for updating public field if needed
    }

    @Override
    public void addMovie(MovieEntity movie) {
        beginTransaction();
        em.merge(movie);
        commitTransaction();
    }

    @Override
    public void deleteMovie(long watchlistId) {
        beginTransaction();
        WatchlistEntity watchlist = em.find(WatchlistEntity.class, watchlistId);
        if (watchlist != null) {
            em.remove(watchlist);
        }
        commitTransaction();
    }

    @Override
    public void clearWatchlist(long watchlistId) {
        beginTransaction();
        WatchlistEntity watchlist = em.find(WatchlistEntity.class, watchlistId);
        if (watchlist != null) {
            watchlist.getMovies().clear();
            em.merge(watchlist);
        }
        commitTransaction();
    }
}
