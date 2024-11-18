package de.moviereview.infrastructure.api.mapper;

import de.moviereview.domain.model.Watchlist;
import de.moviereview.infrastructure.api.dto.WatchlistDTO;
import de.moviereview.infrastructure.persistence.entity.WatchlistEntity;

import java.util.stream.Collectors;

public class WatchlistMapper {

    public static Watchlist toModel(WatchlistEntity entity) {
        if (entity == null) {
            return null;
        }
        return new Watchlist(
                entity.getId(),
                entity.isPublic(),
                UserMapper.toModel(entity.getUser()),
                entity.getMovies().stream().map(MovieMapper::toModel).collect(Collectors.toSet())
        );
    }

    public static WatchlistEntity toEntity(Watchlist model) {
        if (model == null) {
            return null;
        }
        WatchlistEntity entity = new WatchlistEntity();
        entity.setId(model.getId());
        entity.setPublic(model.isPublic());
        entity.setUser(UserMapper.toEntity(model.getUser()));
        entity.setMovies(model.getMovies().stream().map(MovieMapper::toEntity).collect(Collectors.toSet()));
        return entity;
    }

    public static WatchlistDTO toDto(Watchlist model) {
        if (model == null) {
            return null;
        }
        WatchlistDTO dto = new WatchlistDTO();
        dto.setId(model.getId());
        dto.setPublic(model.isPublic());
        dto.setUserId(model.getUser().getId());
        dto.setMovieIds(model.getMovies().stream().map(movie -> movie.getId()).collect(Collectors.toSet()));
        return dto;
    }

    public static Watchlist toModel(WatchlistDTO dto) {
        if (dto == null) {
            return null;
        }
        return new Watchlist(
                dto.getId(),
                dto.isPublic(),
                null, // Mapping userId to User should be handled elsewhere
                null  // Mapping movieIds to Movie objects should be handled elsewhere
        );
    }
}
