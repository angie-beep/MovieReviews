package de.moviereview.resolver.query;

import de.moviereview.domain.model.Review;
import de.moviereview.domain.service.ReviewService;
import de.moviereview.infrastructure.api.mapper.ReviewMapper;
import graphql.kickstart.tools.GraphQLQueryResolver;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ReviewResolver implements GraphQLQueryResolver {

    private final ReviewService reviewService;


    public ReviewResolver(ReviewService reviewService, ReviewMapper reviewMapper) {
        this.reviewService = reviewService;

    }

    // Fetch a Review by ID
    public Optional<Review> getReviewById(Long id) {
        return reviewService.findReviewById(id);
    }

    // Fetch all Reviews
    public List<Review> getAllReviews() {
        return (List<Review>) reviewService.findAllReviews().stream();
    }

    // Fetch Reviews by Movie ID
    public List<Review> getReviewsByMovieId(Long movieId) {
        return (List<Review>) reviewService.findReviewsByMovieId(movieId).stream();
    }

    // Fetch Reviews by User ID
    public List<Review> getReviewsByUserId(Long userId) {
        return (List<Review>) reviewService.findReviewsByUserId(userId).stream();
    }
}
