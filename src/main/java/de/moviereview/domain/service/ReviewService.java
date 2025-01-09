package de.moviereview.domain.service;

import de.moviereview.domain.model.Movie;
import de.moviereview.domain.model.Review;
import de.moviereview.infrastructure.persistence.entity.ReviewEntity;
import de.moviereview.infrastructure.persistence.entity.MovieEntity;
import de.moviereview.infrastructure.persistence.repository.MovieRepository;
import de.moviereview.infrastructure.persistence.repository.ReviewRepository;
import de.moviereview.infrastructure.api.mapper.MovieMapper;
import de.moviereview.infrastructure.api.mapper.ReviewMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ReviewService {

    private final MovieRepository movieRepository;
    private final ReviewRepository reviewRepository;
    private final MovieMapper movieMapper;
    private final ReviewMapper reviewMapper;

    // Constructor to initialize repositories and mappers
    public ReviewService(MovieRepository movieRepository, ReviewRepository reviewRepository, MovieMapper movieMapper, ReviewMapper reviewMapper) {
        this.movieRepository = movieRepository;
        this.reviewRepository = reviewRepository;
        this.movieMapper = movieMapper;
        this.reviewMapper = reviewMapper;
    }

    // Update the average rating of a movie
    public void updateAverageRating(Long movieId) {
        MovieEntity movieEntity = movieRepository.findById(movieId)
                .orElseThrow(() -> new IllegalArgumentException("Movie not found with ID: " + movieId));

        List<Review> reviews = reviewRepository.findByMovieId(movieId).stream()
                .map(reviewMapper::toModel) // Mapping ReviewEntity -> Review
                .collect(Collectors.toList());

        double averageRating = reviews.stream()
                .mapToDouble(Review::getStarRating)
                .average()
                .orElse(0.0);

        movieEntity.setOverallRating(averageRating);
        movieRepository.save(movieEntity);
    }

    // Add a review and update the movie's average rating
    public Review addReview(Review review) {
        ReviewEntity savedReviewEntity = reviewRepository.save(reviewMapper.toEntity(review)); // Mapping Review -> ReviewEntity
        updateAverageRating(review.getMovie().getId());
        return reviewMapper.toModel(savedReviewEntity); // Mapping ReviewEntity -> Review
    }

    public Review updateReview(Review review) {
        ReviewEntity savedReviewEntity = reviewRepository.save(reviewMapper.toEntity(review)); // Mapping Review -> ReviewEntity
        updateAverageRating(review.getMovie().getId());
        return reviewMapper.toModel(savedReviewEntity); // Mapping ReviewEntity -> Review
    }

    // Delete a review and update the movie's average rating
    public void deleteReview(Long reviewId) {
        ReviewEntity reviewEntity = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new IllegalArgumentException("Review not found with ID: " + reviewId));

        reviewRepository.deleteById(reviewId);
        updateAverageRating(reviewEntity.getMovie().getId());
    }

    // Fetch a Review by ID
    public Optional<Review> findReviewById(Long reviewId) {
        return reviewRepository.findById(reviewId)
                .map(reviewMapper::toModel);
    }

    // Fetch all Reviews
    public List<Review> findAllReviews() {
        return reviewRepository.findAll().stream()
                .map(reviewMapper::toModel)
                .collect(Collectors.toList());
    }

    // Fetch Reviews by Movie ID
    public List<Review> findReviewsByMovieId(Long movieId) {
        return reviewRepository.findByMovieId(movieId).stream()
                .map(reviewMapper::toModel)
                .collect(Collectors.toList());
    }

    // Fetch Reviews by User ID
    public List<Review> findReviewsByUserId(Long userId) {
        return reviewRepository.findByUserId(userId).stream()
                .map(reviewMapper::toModel)
                .collect(Collectors.toList());
    }
}
