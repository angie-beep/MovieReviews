package de.moviereview.resolver.mutation;
import de.moviereview.infrastructure.api.dto.ReviewDTO;
import de.moviereview.infrastructure.persistence.repository.ReviewRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import de.moviereview.domain.model.Review;
import de.moviereview.domain.model.User;
import de.moviereview.domain.model.Movie;
import de.moviereview.infrastructure.persistence.repository.UserRepository;
import de.moviereview.infrastructure.persistence.repository.MovieRepository;

public class ReviewMutation implements GraphQLMutationResolver {
    private final ReviewRepository reviewRepository = new ReviewRepository();
    private final UserRepository userRepository = new UserRepository();
    private final MovieRepository movieRepository = new MovieRepository();

    public Review createReview(String comment, int starRating, Long userId, Long movieId) {
        Review review = new Review();
        review.setComment(comment);
        review.setStarRating(starRating);

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + userId));
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new IllegalArgumentException("Movie not found with ID: " + movieId));

        review.setUser(user);
        review.setMovie(movie);

        return reviewRepository.save(review);
    }

    public Review updateReview(ReviewDTO reviewInput) {
        Review review = reviewRepository.findById(reviewInput.getId())
                .orElseThrow(() -> new IllegalArgumentException("Review not found with ID: " + reviewInput.getId()));

        review.setComment(reviewInput.getComment());
        review.setStarRating(reviewInput.getStarRating());

        return reviewRepository.save(review);
    }

    public Boolean deleteReview(Long id) {
        if (!reviewRepository.existsById(id)) {
            throw new IllegalArgumentException("Review not found with ID: " + id);
        }
        return reviewRepository.deleteById(id);
    }
}
