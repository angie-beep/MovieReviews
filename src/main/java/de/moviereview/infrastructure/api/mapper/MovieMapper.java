package de.moviereview.infrastructure.api.mapper;

import de.moviereview.domain.model.*;
import de.moviereview.infrastructure.api.dto.MovieDTO;
import de.moviereview.infrastructure.persistence.entity.MovieEntity;

import java.util.stream.Collectors;

public class MovieMapper {

    public static Movie toModel(MovieEntity entity) {
        if (entity == null) {
            return null;
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
                entity.getActors().stream().map(ActorMapper::toModel).collect(Collectors.toSet()),
                entity.getDirector().stream().map(DirectorMapper::toModel).collect(Collectors.toSet()),
                entity.getReviews().stream().map(ReviewMapper::toModel).collect(Collectors.toSet()),
                entity.getWatchlist().stream().map(WatchlistMapper::toModel).collect(Collectors.toSet())
        );
    }

    public static MovieEntity toEntity(Movie model) {
        if (model == null) {
            return null;
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
        entity.setActors(model.getActors().stream().map(ActorMapper::toEntity).collect(Collectors.toSet()));
        entity.setDirectors(model.getDirector().stream().map(DirectorMapper::toEntity).collect(Collectors.toSet()));
        entity.setReviews(model.getReviews().stream().map(ReviewMapper::toEntity).collect(Collectors.toSet()));
        entity.setWatchlist(model.getWatchlist().stream().map(WatchlistMapper::toEntity).collect(Collectors.toSet()));
        return entity;
    }

    public static MovieDTO toDto(Movie model) {
        if (model == null) {
            return null;
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
        dto.setActorIds(model.getActors().stream().map(Actor::getId).collect(Collectors.toSet()));
        dto.setDirectorIds(model.getDirector().stream().map(Director::getId).collect(Collectors.toSet()));
        dto.setReviewIds(model.getReviews().stream().map(Review::getId).collect(Collectors.toSet()));
        dto.setWatchlistIds(model.getWatchlist().stream().map(Watchlist::getId).collect(Collectors.toSet()));
        return dto;
    }

    public static Movie toModel(MovieDTO dto) {
        if (dto == null) {
            return null;
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
