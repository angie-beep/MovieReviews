package de.moviereviews.domain.service;

import de.moviereviews.domain.model.Review;
import de.moviereviews.infrastructure.mapper.ReviewMapper;
import de.moviereviews.infrastructure.persistence.entity.ReviewEntity;
import de.moviereviews.infrastructure.persistence.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ReviewService {
@Autowired
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }


    public Review createReview(Long movieId, Long userId, int rating, String comment) {
        ReviewEntity entity = new ReviewEntity();
        entity.setStarRating(rating);
        entity.setComment(comment);
        entity.setCreatedAt(LocalDateTime.now());
        ReviewEntity saved = reviewRepository.save(entity);
        return ReviewMapper.toDomain(saved);
    }

    public Review updateReview(Long id, Integer rating, String comment) {
        Optional<ReviewEntity> entityOpt = reviewRepository.findById(id);
        if (!entityOpt.isPresent()) {
            return null;
        }
        ReviewEntity entity = entityOpt.get();
        if (rating != null) {
            entity.setStarRating(rating);
        }
        if (comment != null) {
            entity.setComment(comment);
        }
        entity.setUpdatedAt(LocalDateTime.now());
        ReviewEntity saved = reviewRepository.save(entity);
        return ReviewMapper.toDomain(saved);
    }

    public Boolean deleteReview(Long id) {
        reviewRepository.deleteById(id);
        return true;
    }

    public List<Review> getReviewsByUserId(Long userId) {
        return reviewRepository.findByUserId(userId).stream()
                .map(ReviewMapper::toDomain)
                .collect(Collectors.toList());
    }

    public List<Review> getReviewsByMovieId(Long movieId) {
        return reviewRepository.findByMovieId(movieId).stream()
                .map(ReviewMapper::toDomain)
                .collect(Collectors.toList());
    }
}
