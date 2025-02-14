package de.moviereviews.infrastructure.api.mapper;

import de.moviereviews.domain.model.Movie;
import de.moviereviews.infrastructure.persistence.entity.MovieEntity;
import de.moviereviews.infrastructure.api.dto.MovieDTO;
import java.time.format.DateTimeFormatter;

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
        dto.setRating(movie.getOverallRating());
        dto.setLength(movie.getLength());
        dto.setOriginalLanguage(movie.getOriginalLanguage());
        dto.setReleaseDate(movie.getPublishingDate() != null ? movie.getPublishingDate().format(FORMATTER) : null);
        return dto;
    }
}
