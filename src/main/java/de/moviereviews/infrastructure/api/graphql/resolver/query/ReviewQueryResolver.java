package de.moviereviews.infrastructure.api.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import de.moviereviews.domain.model.Review;
import de.moviereviews.domain.service.ReviewService;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ReviewQueryResolver implements GraphQLQueryResolver {

    private final ReviewService reviewService;

    public ReviewQueryResolver(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    public List<Review> getUserReviews(Long userId) {
        return reviewService.getReviewsByUserId(userId);
    }

    public List<Review> getReviewsByMovieId(Long movieId) {
        return reviewService.getReviewsByMovieId(movieId);
    }
}
