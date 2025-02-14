package de.moviereviews.infrastructure.api.mapper;

import de.moviereviews.domain.model.Watchlist;
import de.moviereviews.infrastructure.persistence.entity.WatchlistEntity;

public class WatchlistMapper {

    public static Watchlist toDomain(WatchlistEntity entity) {
        Watchlist watchlist = new Watchlist();
        watchlist.setId(entity.getId());
        watchlist.setPublic(entity.isPublic());
        return watchlist;
    }
}
