package de.moviereview.infrastructure.api.mapper;

import de.moviereview.domain.model.User;
import de.moviereview.infrastructure.api.dto.UserDTO;
import de.moviereview.infrastructure.persistence.entity.UserEntity;

import java.util.stream.Collectors;

public class UserMapper {

    public static User toModel(UserEntity entity) {
        if (entity == null) {
            return null;
        }
        return new User(
                entity.getId(),
                entity.getUsername(),
                entity.getEmail(),
                entity.isNotificationsEnabled(),
                WatchlistMapper.toModel(entity.getWatchlist()),
                entity.getReviews().stream().map(ReviewMapper::toModel).collect(Collectors.toSet())
        );
    }

    public static UserEntity toEntity(User model) {
        if (model == null) {
            return null;
        }
        UserEntity entity = new UserEntity();
        entity.setId(model.getId());
        entity.setUsername(model.getUsername());
        entity.setEmail(model.getEmail());
        entity.setNotificationsEnabled(model.isNotificationsEnabled());
        entity.setWatchlist(WatchlistMapper.toEntity(model.getWatchlist()));
        entity.setReviews(model.getReviews().stream().map(ReviewMapper::toEntity).collect(Collectors.toSet()));
        return entity;
    }

    public static UserDTO toDto(User model) {
        if (model == null) {
            return null;
        }
        UserDTO dto = new UserDTO();
        dto.setId(model.getId());
        dto.setUsername(model.getUsername());
        dto.setEmail(model.getEmail());
        dto.setNotificationsEnabled(model.isNotificationsEnabled());
        dto.setWatchlistId(model.getWatchlist() != null ? model.getWatchlist().getId() : null);
        dto.setReviewIds(model.getReviews().stream().map(review -> review.getId()).collect(Collectors.toSet()));
        return dto;
    }

    public static User toModel(UserDTO dto) {
        if (dto == null) {
            return null;
        }
        return new User(
                dto.getId(),
                dto.getUsername(),
                dto.getEmail(),
                dto.isNotificationsEnabled(),
                null, // Mapping watchlistId to Watchlist should be handled elsewhere
                null  // Mapping reviewIds to Reviews should be handled elsewhere
        );
    }
}
