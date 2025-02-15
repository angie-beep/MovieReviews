package de.moviereviews.infrastructure.api.graphql.resolver.mutation;

import de.moviereviews.domain.model.Movie;
import de.moviereviews.infrastructure.api.dto.MovieDTO;
import de.moviereviews.infrastructure.mapper.MovieMapper;
import de.moviereviews.domain.service.MovieService;
import de.moviereviews.infrastructure.persistence.entity.ActorEntity;
import de.moviereviews.infrastructure.persistence.entity.DirectorEntity;
import de.moviereviews.infrastructure.persistence.entity.GenreEntity;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.Set;

@Controller
public class MovieMutationResolver {

    private final MovieService movieService;

    public MovieMutationResolver(MovieService movieService) {
        this.movieService = movieService;
    }
    @MutationMapping
    public MovieDTO addMovie(String title, Set<GenreEntity> genres, LocalDate publishingDate, Set<DirectorEntity> directors, Set<ActorEntity> actors,
                             String originalLanguage, Integer length, Float overallRating) {
        Movie movie = movieService.addMovie(title, genres, publishingDate, directors, actors, originalLanguage, length, overallRating);
        return MovieMapper.toDTO(movie);
    }
    @MutationMapping
    public MovieDTO updateMovie(Long id, String title, Set<GenreEntity> genres, LocalDate publishingDate, Set<DirectorEntity> directors, Set<ActorEntity> actors,
                                String originalLanguage, Integer length, Float overallRating) {
        Movie movie = movieService.updateMovie(id, title, genres, publishingDate, directors, actors, originalLanguage, length, overallRating);
        return MovieMapper.toDTO(movie);
    }
    @MutationMapping
    public Boolean deleteMovie(Long id) {
        return movieService.deleteMovie(id);
    }
}
