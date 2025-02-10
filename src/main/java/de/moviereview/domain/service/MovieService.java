package de.moviereview.domain.service;

import de.moviereview.domain.model.Movie;
import de.moviereview.infrastructure.persistence.entity.MovieEntity;
import de.moviereview.infrastructure.persistence.repository.MovieRepository;
import de.moviereview.infrastructure.api.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class MovieService {

    private final MovieRepository movieRepository;
    private final TMDbService tmdbService;
    private final MovieMapper movieMapper;

    @Autowired
    public MovieService(MovieRepository movieRepository, TMDbService tmdbService, MovieMapper movieMapper) {
        this.movieRepository = movieRepository;
        this.tmdbService = tmdbService;
        this.movieMapper = movieMapper;
    }

    // Import a movie from TMDb using its ID
    public Movie importMovieFromTMDb(Long tmdbId) {
        Movie movieFromTMDb = tmdbService.fetchMovieDetails(tmdbId);
        if (movieFromTMDb != null) {
            MovieEntity savedEntity = movieRepository.save(movieMapper.toEntity(movieFromTMDb));
            return movieMapper.toModel(savedEntity);
        }
        throw new IllegalArgumentException("Error: Could not import movie from TMDb.");
    }

    // Get all movies
    public List<Movie> getAllMovies() {
        return movieRepository.findAll().stream()
                .map(movieMapper::toModel)
                .collect(Collectors.toList());
    }

    // Get movies filtered by genre, language, or director
    public List<Movie> getMoviesByFilters(String genre, String director, String originalLanguage) {
        return movieRepository.findAll().stream()
                .map(movieMapper::toModel)
                .filter(movie -> (genre == null || movie.getGenres().stream().anyMatch(g -> g.getGenre().equalsIgnoreCase(genre))) &&
                        (director == null || movie.getDirectors().stream().anyMatch(d -> d.getLastName().equalsIgnoreCase(director))) &&
                        (originalLanguage == null || movie.getOriginalLanguage().equalsIgnoreCase(originalLanguage)))
                .collect(Collectors.toList());
    }

    // Save a movie
    public Movie saveMovie(Movie movie) {
        MovieEntity savedEntity = movieRepository.save(movieMapper.toEntity(movie));
        return movieMapper.toModel(savedEntity);
    }

    // Delete a movie by ID
    public Boolean deleteMovie(Long id) {
        if (!movieRepository.existsById(id)) {
            throw new IllegalArgumentException("Movie not found with ID: " + id);
        }
        movieRepository.deleteById(id);
        return null;
    }

    // Find a movie by ID
    public Optional<Movie> findMovieById(Long id) {
        return movieRepository.findById(id)
                .map(movieMapper::toModel);
    }

    public Movie addMovie(String title, String genre, String releaseDate, String director, String originalLanguage, int length) {
        return null;
    }

    public Movie updateMovie(Long id, String title, String genre, String releaseDate, String director, String originalLanguage, int length) {
        return null;
    }

    public List<Movie> getMoviesByActor(Long actorId) {
        return movieRepository.findByActorId(actorId).stream()
                .map(movieMapper::toModel) // Konvertierung von MovieEntity zu Movie
                .collect(Collectors.toList());
    }
}
