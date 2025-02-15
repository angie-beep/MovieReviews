package de.moviereviews.infrastructure.mapper;

import de.moviereviews.domain.model.Review;
import de.moviereviews.infrastructure.api.dto.ReviewDTO;
import de.moviereviews.infrastructure.persistence.entity.ReviewEntity;

public class ReviewMapper {

    public static Review toDomain(ReviewEntity entity) {
        Review review = new Review();
        review.setId(entity.getId());
        review.setStarRating(entity.getStarRating());
        review.setComment(entity.getComment());
        review.setCreatedAt(entity.getCreatedAt());
        review.setUpdatedAt(entity.getUpdatedAt());
        return review;
    }

    public static ReviewDTO toDTO(Review review) {
        ReviewDTO dto = new ReviewDTO();
        dto.setId(review.getId());
        dto.setStarRating(review.getStarRating());
        dto.setComment(review.getComment());
        dto.setCreatedAt(review.getCreatedAt() != null ? review.getCreatedAt().toString() : null);
        dto.setUpdatedAt(review.getUpdatedAt() != null ? review.getUpdatedAt().toString() : null);
        return dto;
    }

    public static ReviewEntity toEntity(Review review) {
        ReviewEntity entity = new ReviewEntity();
        entity.setId(review.getId());
        entity.setStarRating(review.getStarRating());
        entity.setComment(review.getComment());
        entity.setCreatedAt(review.getCreatedAt());
        entity.setUpdatedAt(review.getUpdatedAt());
        return entity;
    }

}
