package de.moviereviews.infrastructure.api.graphql.resolver.mutation;

import de.moviereviews.domain.model.Review;
import de.moviereviews.domain.service.ReviewService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

@Component
public class ReviewMutationResolver implements GraphQLMutationResolver {

    private final ReviewService reviewService;

    public ReviewMutationResolver(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    public Review createReview(Long movieId, Long userId, int rating, String comment) {
        return reviewService.createReview(movieId, userId, rating, comment);
    }

    public Review updateReview(Long id, Integer rating, String comment) {
        return reviewService.updateReview(id, rating, comment);
    }

    public Boolean deleteReview(Long id) {
        return reviewService.deleteReview(id);
    }
}
