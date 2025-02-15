package de.moviereviews.infrastructure.api.graphql.resolver.query;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import graphql.kickstart.tools.GraphQLQueryResolver;
import de.moviereviews.infrastructure.api.dto.MovieDTO;
import de.moviereviews.infrastructure.api.dto.MoviePageDTO;
import de.moviereviews.domain.service.MovieService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;

@Controller
public class MovieQueryResolver{

    private final MovieService movieService;

    public MovieQueryResolver(MovieService movieService) {

        this.movieService = movieService;
    }
    @QueryMapping
    public List<MovieDTO> getAllMovies() {
        List<MovieDTO> movies = movieService.getAllMovieDTOs();
        return movies != null ? movies : new ArrayList<>();
    }
    @QueryMapping
    public MoviePageDTO getMovies(String genre, String director, String originalLanguage, int page, int size) {
        return movieService.getMoviesByFilters(genre, director, originalLanguage, page, size);
    }
    @QueryMapping
    public List<MovieDTO> getMoviesByActor(Long actorId) {
        return movieService.getMoviesByActorDTO(actorId);
    }
    @QueryMapping
    public List<MovieDTO> getLeaderboard(String genre) {
        return movieService.getLeaderboardByGenreDTO(genre);
    }
}
