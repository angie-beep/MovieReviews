package de.moviereview.resolver.mutation;
import de.moviereview.domain.service.ReviewService;
import de.moviereview.infrastructure.api.dto.ReviewDTO;

import graphql.kickstart.tools.GraphQLMutationResolver;
import de.moviereview.domain.model.Review;


public class ReviewMutation implements GraphQLMutationResolver {
    private final ReviewService reviewService;

    public ReviewMutation(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    public Review createReview(String comment, int starRating, Long userId, Long movieId) {
        return reviewService.addReview(comment, starRating, userId, movieId);
    }

    public Review updateReview(String comment, int starRating, Long userId, Long movieId) {
        return reviewService.updateReview(comment, starRating, userId, movieId);
    }


    public void deleteReview(Long id) {
        reviewService.deleteReview(id);
    }


}
