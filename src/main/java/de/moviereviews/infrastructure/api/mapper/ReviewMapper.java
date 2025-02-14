package de.moviereviews.infrastructure.api.mapper;

import de.moviereviews.domain.model.Review;
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
}
