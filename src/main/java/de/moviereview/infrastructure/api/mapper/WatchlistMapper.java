package de.moviereview.infrastructure.api.mapper;

import de.moviereview.domain.model.Watchlist;
import de.moviereview.infrastructure.api.dto.WatchlistDTO;
import de.moviereview.infrastructure.persistence.entity.WatchlistEntity;

import java.util.stream.Collectors;

public class WatchlistMapper {

    public static Watchlist toModel(WatchlistEntity entity) {
        if (entity == null) {
            throw new IllegalArgumentException("WatchlistEntity cannot be null");
        }
        return new Watchlist(
                entity.getId(),
                entity.isPublic(),
                entity.getUser() != null ? UserMapper.toModel(entity.getUser()) : null,
                entity.getMovies() != null ? entity.getMovies().stream().map(MovieMapper::toModel).collect(Collectors.toSet()) : null
        );
    }

    public static WatchlistEntity toEntity(Watchlist model) {
        if (model == null) {
            throw new IllegalArgumentException("Watchlist model cannot be null");
        }
        WatchlistEntity entity = new WatchlistEntity();
        entity.setId(model.getId());
        entity.setPublic(model.isPublic());
        entity.setUser(model.getUser() != null ? UserMapper.toEntity(model.getUser()) : null);
        entity.setMovies(model.getMovies() != null ? model.getMovies().stream().map(MovieMapper::toEntity).collect(Collectors.toSet()) : null);
        return entity;
    }

    public static WatchlistDTO toDto(Watchlist model) {
        if (model == null) {
            throw new IllegalArgumentException("Watchlist model cannot be null");
        }
        WatchlistDTO dto = new WatchlistDTO();
        dto.setId(model.getId());
        dto.setPublic(model.isPublic());
        dto.setUserId(model.getUser() != null ? model.getUser().getId() : null);
        dto.setMovieIds(model.getMovies() != null ? model.getMovies().stream().map(movie -> movie.getId()).collect(Collectors.toSet()) : null);
        return dto;
    }

    public static Watchlist toModel(WatchlistDTO dto) {
        if (dto == null) {
            throw new IllegalArgumentException("WatchlistDTO cannot be null");
        }
        return new Watchlist(
                dto.getId(),
                dto.isPublic(),
                null, // Mapping userId to User should be handled elsewhere
                null  // Mapping movieIds to Movie objects should be handled elsewhere
        );
    }
}
