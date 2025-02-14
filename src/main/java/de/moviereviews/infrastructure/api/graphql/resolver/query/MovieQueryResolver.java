package de.moviereviews.infrastructure.api.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import de.moviereviews.infrastructure.api.dto.MovieDTO;
import de.moviereviews.infrastructure.api.dto.MoviePageDTO;
import de.moviereviews.domain.service.MovieService;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class MovieQueryResolver implements GraphQLQueryResolver {

    private final MovieService movieService;

    public MovieQueryResolver(MovieService movieService) {

        this.movieService = movieService;
    }

    public List<MovieDTO> getAllMovies() {
        return movieService.getAllMovieDTOs();
    }

    public MoviePageDTO getMovies(String genre, String director, String originalLanguage, int page, int size) {
        return movieService.getMoviesByFilters(genre, director, originalLanguage, page, size);
    }

    public List<MovieDTO> getMoviesByActor(Long actorId) {
        return movieService.getMoviesByActorDTO(actorId);
    }

    public List<MovieDTO> getLeaderboard(String genre) {
        return movieService.getLeaderboardByGenreDTO(genre);
    }
}
