package de.moviereview.domain.service;

import de.moviereview.domain.model.Movie;
import de.moviereview.infrastructure.api.mapper.MovieMapper;
import de.moviereview.infrastructure.persistence.repository.MovieRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LeaderboardService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    public LeaderboardService(MovieRepository movieRepository, MovieMapper movieMapper) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
    }

    // Get top movies overall
    public List<Movie> getTopMoviesOverall(int limit) {
        return movieRepository.findAll().stream()
                .map(movieMapper::toModel) // Mapping von MovieEntity zu Movie
                .sorted(Comparator.comparingDouble(Movie::getOverallRating).reversed())
                .limit(limit)
                .collect(Collectors.toList());
    }

    // Get top movies by genre
    public List<Movie> getTopMoviesByGenre(String genre, int limit) {
        return movieRepository.findAll().stream()
                .map(movieMapper::toModel) // Mapping von MovieEntity zu Movie
                .filter(movie -> movie.getGenres().stream().anyMatch(g -> g.getGenre().equalsIgnoreCase(genre)))
                .sorted(Comparator.comparingDouble(Movie::getOverallRating).reversed())
                .limit(limit)
                .collect(Collectors.toList());
    }
}

