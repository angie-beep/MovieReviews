package de.moviereview.adapter.controller.in;

import de.moviereview.domain.service.MovieService;
import de.moviereview.domain.entities.Movie;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.graphql.data.method.annotation.Argument;

import java.util.List;

@Controller
public class GraphQLController {

    private final MovieService movieService;

    public MovieGraphQLController(MovieService movieService) {
        this.movieService = movieService;
    }

    @QueryMapping
    public List<Movie> getMovies(@Argument String genre, @Argument int page, @Argument int size) {
        return movieService.getMoviesByGenre(genre, page, size);
    }

    @QueryMapping
    public Movie getMovieById(@Argument Long id) {
        return movieService.getMovieById(id);
    }
}

