package de.moviereviews.infrastructure.api.graphql.resolver.mutation;
import org.springframework.graphql.data.method.annotation.MutationMapping;

import de.moviereviews.domain.model.Review;
import de.moviereviews.domain.service.ReviewService;
import de.moviereviews.infrastructure.api.dto.MovieDTO;
import de.moviereviews.infrastructure.api.dto.ReviewDTO;
import de.moviereviews.infrastructure.api.dto.UserDTO;
import de.moviereviews.infrastructure.mapper.ReviewMapper;
import de.moviereviews.infrastructure.persistence.entity.MovieEntity;
import de.moviereviews.infrastructure.persistence.entity.UserEntity;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller
public class ReviewMutationResolver {

    private final ReviewService reviewService;

    public ReviewMutationResolver(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
    @MutationMapping
    public ReviewDTO createReview(MovieEntity movie, UserEntity user, int rating, String comment) {
        Review review = reviewService.createReview(movie, user, rating, comment);
        return ReviewMapper.toDTO(review);
    }
    @MutationMapping
    public ReviewDTO updateReview(Long id, Integer rating, String comment) {
        Review review = reviewService.updateReview(id, rating, comment);
        return ReviewMapper.toDTO(review);
    }
    @MutationMapping
    public Boolean deleteReview(Long id) {
        return reviewService.deleteReview(id);
    }
}
