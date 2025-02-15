package de.moviereviews.infrastructure.mapper;

import de.moviereviews.domain.model.Watchlist;
import de.moviereviews.infrastructure.api.dto.WatchlistDTO;
import de.moviereviews.infrastructure.persistence.entity.WatchlistEntity;

public class WatchlistMapper {

    public static Watchlist toDomain(WatchlistEntity entity) {
        Watchlist watchlist = new Watchlist();
        watchlist.setId(entity.getId());
        watchlist.setPublic(entity.isPublic());
        return watchlist;
    }

    public static WatchlistDTO toDTO(Watchlist watchlist) {
        WatchlistDTO dto = new WatchlistDTO();
        dto.setId(watchlist.getId());
        dto.setIsPublic(watchlist.isPublic());
        return dto;
    }

    public static WatchlistEntity toEntity(Watchlist watchlist) {
        WatchlistEntity entity = new WatchlistEntity();
        entity.setId(watchlist.getId());
        entity.setPublic(watchlist.isPublic());
        return entity;
    }

}
