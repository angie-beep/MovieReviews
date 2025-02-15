package de.moviereviews.infrastructure.mapper;

import de.moviereviews.domain.model.Watchlist;
import de.moviereviews.infrastructure.api.dto.UserDTO;
import de.moviereviews.infrastructure.api.dto.WatchlistDTO;
import de.moviereviews.infrastructure.persistence.entity.MovieEntity;
import de.moviereviews.infrastructure.persistence.entity.WatchlistEntity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class WatchlistMapper {

    public static Watchlist toDomain(WatchlistEntity entity) {
        Watchlist watchlist = new Watchlist();
        watchlist.setId(entity.getId());
        watchlist.setPublic(entity.isPublic());
        if (watchlist.getMovies() != null) {
            watchlist.setMovies(entity.getMovies().stream()
                    .map(MovieMapper::toDomain)
                    .collect(Collectors.toSet()));
        } else {
            watchlist.setMovies(new HashSet<>());
        }
        watchlist.setUser(UserMapper.toDomain(entity.getUser()));
        return watchlist;
    }

    public static WatchlistDTO toDTO(Watchlist watchlist) {
        WatchlistDTO dto = new WatchlistDTO();
        dto.setId(watchlist.getId());
        dto.setIsPublic(watchlist.isPublic());
        if (watchlist.getMovies() != null) {
            dto.setMovies(watchlist.getMovies().stream()
                    .map(MovieMapper::toDTO)
                    .collect(Collectors.toList()));
        } else {
            dto.setMovies(new ArrayList<>());
        }
        dto.setUser(watchlist.getUser() != null ? UserMapper.toDTO(watchlist.getUser()) : new UserDTO());
        return dto;
    }

    public static WatchlistEntity toEntity(Watchlist watchlist) {
        WatchlistEntity entity = new WatchlistEntity();
        entity.setId(watchlist.getId());
        entity.setPublic(watchlist.isPublic());
        if (watchlist.getMovies() != null) {
            entity.setMovies(watchlist.getMovies().stream()
                    .map(MovieMapper::toEntity)
                    .collect(Collectors.toSet()));
        } else {
            entity.setMovies( new HashSet<>());
        }
        entity.setUser(UserMapper.toEntity(watchlist.getUser()));
        return entity;
    }

}
