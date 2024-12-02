package de.moviereview.resolver.query;

import de.moviereview.domain.model.Review;
import de.moviereview.infrastructure.persistence.repository.ReviewRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;

import java.util.List;

public class ReviewResolver implements GraphQLQueryResolver {

    private final ReviewRepository reviewRepository = new ReviewRepository();

    // Fetch a Review by ID
    public Review getReviewById(Long id) {
        return reviewRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Review not found with ID: " + id));
    }

    // Fetch all Reviews
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    // Fetch Reviews by Movie ID
    public List<Review> getReviewsByMovieId(Long movieId) {
        return reviewRepository.findAll().stream()
                .filter(review -> review.getMovie().getId().equals(movieId))
                .toList();
    }

    // Fetch Reviews by User ID
    public List<Review> getReviewsByUserId(Long userId) {
        return reviewRepository.findAll().stream()
                .filter(review -> review.getUser().getId().equals(userId))
                .toList();
    }
}
