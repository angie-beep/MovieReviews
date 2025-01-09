package de.moviereview.domain.service;

import de.moviereview.domain.model.Movie;
import de.moviereview.domain.model.Review;
import de.moviereview.infrastructure.api.mapper.MovieMapper;
import de.moviereview.infrastructure.api.mapper.ReviewMapper;
import de.moviereview.infrastructure.persistence.entity.MovieEntity;
import de.moviereview.infrastructure.persistence.entity.ReviewEntity;

import de.moviereview.infrastructure.persistence.repository.MovieRepository;
import de.moviereview.infrastructure.persistence.repository.ReviewRepository;

import java.util.List;
import java.util.stream.Collectors;

public class MovieRatingService {

    private final MovieRepository movieRepository;
    private final ReviewRepository reviewRepository;
    private final MovieMapper movieMapper;
    private final ReviewMapper reviewMapper;

    public MovieRatingService(MovieRepository movieRepository, ReviewRepository reviewRepository, MovieMapper movieMapper, ReviewMapper reviewMapper) {
        this.movieRepository = movieRepository;
        this.reviewRepository = reviewRepository;
        this.movieMapper = movieMapper;
        this.reviewMapper = reviewMapper;
    }

    // Calculate average rating for a movie
    public double calculateAverageRating(Long movieId) {
        MovieEntity movieEntity = movieRepository.findById(movieId)
                .orElseThrow(() -> new IllegalArgumentException("Movie not found with ID: " + movieId));

        List<Review> reviews = reviewRepository.findByMovieId(movieId).stream()
                .map(reviewMapper::toModel) // Konvertierung von ReviewEntity zu Review
                .collect(Collectors.toList());

        return reviews.stream()
                .mapToInt(Review::getStarRating)
                .average()
                .orElse(0.0);
    }

    // Update the movie's rating
    public void updateMovieRating(Long movieId) {
        double averageRating = calculateAverageRating(movieId);
        MovieEntity movieEntity = movieRepository.findById(movieId)
                .orElseThrow(() -> new IllegalArgumentException("Movie not found with ID: " + movieId));

        movieEntity.setOverallRating(averageRating);
        movieRepository.save(movieEntity);
    }
}
