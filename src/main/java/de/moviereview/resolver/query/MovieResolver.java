package de.moviereview.resolver.query;

import de.moviereview.domain.model.Movie;
import de.moviereview.domain.service.MovieService;
import graphql.kickstart.tools.GraphQLQueryResolver;

import java.util.List;

public class MovieResolver implements GraphQLQueryResolver {

    private final MovieService movieService;

    public MovieResolver(MovieService movieService) {
        this.movieService = movieService;
    }

    // Query: Fetch all movies
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    // Query: Fetch movies with filters
    public List<Movie> getMovies(String genre, String director, String originalLanguage) {
        return movieService.getMoviesByFilters(genre, director, originalLanguage);
    }

    // Query: Fetch movies by actor
    public List<Movie> getMoviesByActor(Long actorId) {
        return movieService.getMoviesByActor(actorId);
    }
}

