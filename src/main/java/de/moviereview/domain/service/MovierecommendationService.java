package de.moviereview.domain.service;

import de.moviereview.domain.model.Movie;
import de.moviereview.domain.model.User;
import de.moviereview.infrastructure.persistence.repository.MovieRepository;
import de.moviereview.infrastructure.persistence.repository.UserRepository;
import de.moviereview.infrastructure.api.mapper.MovieMapper;
import de.moviereview.infrastructure.api.mapper.UserMapper;
import de.moviereview.infrastructure.persistence.entity.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

public class MovierecommendationService {

    private final UserRepository userRepository;
    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;
    private final UserMapper userMapper;

    public MovierecommendationService(UserRepository userRepository, MovieRepository movieRepository, MovieMapper movieMapper, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
        this.userMapper = userMapper;
    }

    // Recommend movies based on user's watchlist
    public List<Movie> recommendMoviesForUser(Long userId) {
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + userId));

        User user = userMapper.toModel(userEntity);

        return movieRepository.findAll().stream()
                .map(movieMapper::toModel) // Mapping MovieEntity -> Movie
                .filter(movie -> user.getWatchlist().getMovies().stream()
                        .noneMatch(watched -> watched.getId().equals(movie.getId())))
                .collect(Collectors.toList());
    }

    // Recommend popular movies if no user-specific data is available
    public List<Movie> recommendPopularMovies(int limit) {
        return movieRepository.findAll().stream()
                .map(movieMapper::toModel) // Mapping MovieEntity -> Movie
                .sorted((m1, m2) -> Double.compare(m2.getOverallRating(), m1.getOverallRating()))
                .limit(limit)
                .collect(Collectors.toList());
    }
}
