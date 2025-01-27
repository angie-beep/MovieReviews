package de.moviereview.infrastructure.api.mapper;

import de.moviereview.domain.model.Movie;
import de.moviereview.infrastructure.api.dto.MovieDTO;
import de.moviereview.infrastructure.persistence.entity.MovieEntity;

import java.util.stream.Collectors;

public class MovieMapper {

    public static Movie toModel(MovieEntity entity) {
        if (entity == null) {
            throw new IllegalArgumentException("MovieEntity cannot be null");
        }
        return new Movie(
                entity.getId(),
                entity.getTitle(),
                entity.getSummary(),
                entity.getTrailer(),
                entity.getOverallRating(),
                entity.getPublishingDate(),
                entity.getLength(),
                entity.getOriginalLanguage(),
                entity.getActors() != null ? entity.getActors().stream().map(ActorMapper::toModel).collect(Collectors.toSet()) : null,
                entity.getDirectors() != null ? entity.getDirectors().stream().map(DirectorMapper::toModel).collect(Collectors.toSet()) : null,
                entity.getReviews() != null ? entity.getReviews().stream().map(ReviewMapper::toModel).collect(Collectors.toSet()) : null,
                entity.getWatchlist() != null ? entity.getWatchlist().stream().map(WatchlistMapper::toModel).collect(Collectors.toSet()) : null
        );
    }

    public static MovieEntity toEntity(Movie model) {
        if (model == null) {
            throw new IllegalArgumentException("Movie model cannot be null");
        }
        MovieEntity entity = new MovieEntity();
        entity.setId(model.getId());
        entity.setTitle(model.getTitle());
        entity.setSummary(model.getSummary());
        entity.setTrailer(model.getTrailer());
        entity.setOverallRating(model.getOverallRating());
        entity.setPublishingDate(model.getPublishingDate());
        entity.setLength(model.getLength());
        entity.setOriginalLanguage(model.getOriginalLanguage());
        entity.setActors(model.getActors() != null ? model.getActors().stream().map(ActorMapper::toEntity).collect(Collectors.toSet()) : null);
        entity.setDirectors(model.getDirectors() != null ? model.getDirectors().stream().map(DirectorMapper::toEntity).collect(Collectors.toSet()) : null);
        entity.setReviews(model.getReviews() != null ? model.getReviews().stream().map(ReviewMapper::toEntity).collect(Collectors.toSet()) : null);
        entity.setWatchlist(model.getWatchlist() != null ? model.getWatchlist().stream().map(WatchlistMapper::toEntity).collect(Collectors.toSet()) : null);
        return entity;
    }

    public static MovieDTO toDto(Movie model) {
        if (model == null) {
            throw new IllegalArgumentException("Movie model cannot be null");
        }
        MovieDTO dto = new MovieDTO();
        dto.setId(model.getId());
        dto.setTitle(model.getTitle());
        dto.setSummary(model.getSummary());
        dto.setTrailer(model.getTrailer());
        dto.setOverallRating(model.getOverallRating());
        dto.setPublishingDate(model.getPublishingDate());
        dto.setLength(model.getLength());
        dto.setOriginalLanguage(model.getOriginalLanguage());
        dto.setActorIds(model.getActors() != null ? model.getActors().stream().map(actor -> actor.getId()).collect(Collectors.toSet()) : null);
        dto.setDirectorIds(model.getDirectors() != null ? model.getDirectors().stream().map(director -> director.getId()).collect(Collectors.toSet()) : null);
        dto.setReviewIds(model.getReviews() != null ? model.getReviews().stream().map(review -> review.getId()).collect(Collectors.toSet()) : null);
        dto.setWatchlistIds(model.getWatchlist() != null ? model.getWatchlist().stream().map(watchlist -> watchlist.getId()).collect(Collectors.toSet()) : null);
        return dto;
    }

    public static Movie toModel(MovieDTO dto) {
        if (dto == null) {
            throw new IllegalArgumentException("MovieDTO cannot be null");
        }
        return new Movie(
                dto.getId(),
                dto.getTitle(),
                dto.getSummary(),
                dto.getTrailer(),
                dto.getOverallRating(),
                dto.getPublishingDate(),
                dto.getLength(),
                dto.getOriginalLanguage(),
                null, // Mapping actor IDs to Actors should be handled separately
                null, // Mapping director IDs to Directors should be handled separately
                null, // Mapping review IDs to Reviews should be handled separately
                null  // Mapping watchlist IDs to Watchlist should be handled separately
        );
    }
}
