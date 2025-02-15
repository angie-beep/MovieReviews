package de.moviereviews.infrastructure.api.graphql.resolver.query;

import de.moviereviews.domain.model.Actor;
import de.moviereviews.infrastructure.api.dto.ReviewDTO;
import de.moviereviews.infrastructure.mapper.ActorMapper;
import de.moviereviews.infrastructure.mapper.ReviewMapper;
import graphql.kickstart.tools.GraphQLQueryResolver;
import de.moviereviews.domain.model.Review;
import de.moviereviews.domain.service.ReviewService;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ReviewQueryResolver  {

    private final ReviewService reviewService;

    public ReviewQueryResolver(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
    @QueryMapping
    public Set<ReviewDTO> getUserReviews(Long userId) {
        List<Review> review = reviewService.getReviewsByUserId(userId);
        return review.stream()
                .map(ReviewMapper::toDTO)
                .collect(Collectors.toSet());
    }
    @QueryMapping
    public List<ReviewDTO> getReviewsByMovieId(Long movieId) {
        List<Review> review = reviewService.getReviewsByMovieId(movieId);
        return  review.stream()
                .map(ReviewMapper::toDTO)
                .collect(Collectors.toList());
    }
}
