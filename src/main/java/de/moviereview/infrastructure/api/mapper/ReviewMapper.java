package de.moviereview.infrastructure.api.mapper;

import de.moviereview.domain.model.Review;
import de.moviereview.infrastructure.api.dto.ReviewDTO;
import de.moviereview.infrastructure.persistence.entity.ReviewEntity;

public class ReviewMapper {

    public static Review toModel(ReviewEntity entity) {
        if (entity == null) {
            return null;
        }
        return new Review(
                entity.getId(),
                UserMapper.toModel(entity.getUser()),
                MovieMapper.toModel(entity.getMovie()),
                entity.getStarRating(),
                entity.getComment(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    public static ReviewEntity toEntity(Review model) {
        if (model == null) {
            return null;
        }
        ReviewEntity entity = new ReviewEntity();
        entity.setId(model.getId());
        entity.setUser(UserMapper.toEntity(model.getUser()));
        entity.setMovie(MovieMapper.toEntity(model.getMovie()));
        entity.setStarRating(model.getStarRating());
        entity.setComment(model.getComment());
        entity.setCreatedAt(model.getCreatedAt());
        entity.setUpdatedAt(model.getUpdatedAt());
        return entity;
    }

    public static ReviewDTO toDto(Review model) {
        if (model == null) {
            return null;
        }
        ReviewDTO dto = new ReviewDTO();
        dto.setId(model.getId());
        dto.setUserId(model.getUser().getId());
        dto.setMovieId(model.getMovie().getId());
        dto.setStarRating(model.getStarRating());
        dto.setComment(model.getComment());
        dto.setCreatedAt(model.getCreatedAt());
        dto.setUpdatedAt(model.getUpdatedAt());
        return dto;
    }

    public static Review toModel(ReviewDTO dto) {
        if (dto == null) {
            return null;
        }
        return new Review(
                dto.getId(),
                null, // Mapping userId to User should be handled elsewhere
                null, // Mapping movieId to Movie should be handled elsewhere
                dto.getStarRating(),
                dto.getComment(),
                dto.getCreatedAt(),
                dto.getUpdatedAt()
        );
    }
}
