package de.moviereviews.infrastructure.mapper;

import de.moviereviews.domain.model.Movie;
import de.moviereviews.infrastructure.persistence.entity.MovieEntity;
import de.moviereviews.infrastructure.api.dto.MovieDTO;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.stream.Collectors;

public class MovieMapper {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static Movie toDomain(MovieEntity entity) {
        Movie movie = new Movie();
        movie.setId(entity.getId());
        movie.setTitle(entity.getTitle());
        movie.setSummary(entity.getSummary());
        movie.setTrailer(entity.getTrailer());
        movie.setOverallRating(entity.getOverallRating());
        movie.setPublishingDate(entity.getPublishingDate());
        movie.setLength(entity.getLength());
        movie.setOriginalLanguage(entity.getOriginalLanguage());
        return movie;
    }

    public static MovieDTO toDTO(Movie movie) {
        MovieDTO dto = new MovieDTO();
        dto.setId(movie.getId());
        dto.setTitle(movie.getTitle());
        dto.setSummary(movie.getSummary());
        dto.setTrailer(movie.getTrailer());
        dto.setOverallRating(movie.getOverallRating());
        dto.setLength(movie.getLength());
        dto.setOriginalLanguage(movie.getOriginalLanguage());
        dto.setPublishingDate(movie.getPublishingDate() != null ? movie.getPublishingDate().format(FORMATTER) : null);
        dto.setGenres(movie.getGenres() != null
                ? movie.getGenres().stream().map(GenreMapper::toDTO).collect(Collectors.toSet())
                : new HashSet<>());

        dto.setDirectors(movie.getDirectors() != null
                ? movie.getDirectors().stream().map(DirectorMapper::toDTO).collect(Collectors.toSet())
                : new HashSet<>());

        dto.setActors(movie.getActors() != null
                ? movie.getActors().stream().map(ActorMapper::toDTO).collect(Collectors.toSet())
                : new HashSet<>());

        dto.setReviews(movie.getReviews() != null
                ? movie.getReviews().stream().map(ReviewMapper::toDTO).collect(Collectors.toSet())
                : new HashSet<>());
        return dto;
    }

    public static MovieEntity toEntity(Movie movie) {
        MovieEntity entity = new MovieEntity();
        entity.setId(movie.getId());
        entity.setTitle(movie.getTitle());
        entity.setSummary(movie.getSummary());
        entity.setTrailer(movie.getTrailer());
        entity.setOverallRating(movie.getOverallRating());
        entity.setPublishingDate(movie.getPublishingDate());
        entity.setLength(movie.getLength());
        entity.setOriginalLanguage(movie.getOriginalLanguage());
        return entity;
    }

}
