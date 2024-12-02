package de.moviereview.infrastructure.persistence.repository;
import de.moviereview.domain.model.Movie;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class MovieRepository {
    private final Map<Long, Movie> movieStorage = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    // Create or update a movie
    public Movie save(Movie movie) {
        if (movie.getId() == null) {
            movie.setId(idGenerator.getAndIncrement());
        }
        movieStorage.put(movie.getId(), movie);
        return movie;
    }

    // Find a movie by ID
    public Optional<Movie> findById(Long id) {
        return Optional.ofNullable(movieStorage.get(id));
    }

    // Get all movies
    public List<Movie> findAll() {
        return new ArrayList<>(movieStorage.values());
    }

    // Delete a movie by ID
    public boolean deleteById(Long id) {
        return movieStorage.remove(id) != null;
    }

    // Check if a movie exists by ID
    public boolean existsById(Long id) {
        return movieStorage.containsKey(id);
    }
}
