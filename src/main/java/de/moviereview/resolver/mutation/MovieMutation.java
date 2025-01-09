package de.moviereview.resolver.mutation;

import de.moviereview.domain.model.Movie;
import de.moviereview.domain.service.MovieService;
import graphql.kickstart.tools.GraphQLMutationResolver;

public class MovieMutation implements GraphQLMutationResolver {

    private final MovieService movieService;

    // Constructor-based dependency injection
    public MovieMutation(MovieService movieService) {
        this.movieService = movieService;
    }

    // Add a new movie
    public Movie addMovie(String title, String genre, String releaseDate, String director, String originalLanguage, int length) {
        return movieService.saveMovie(movieService.addMovie(title, genre, releaseDate, director, originalLanguage, length));
    }

    // Update an existing movie
    public Movie updateMovie(Long id, String title, String genre, String releaseDate, String director, String originalLanguage, int length) {
        return movieService.updateMovie(id, title, genre, releaseDate, director, originalLanguage, length);
    }

    // Delete a movie
    public Boolean deleteMovie(Long id) {
        return movieService.deleteMovie(id);
    }
}

