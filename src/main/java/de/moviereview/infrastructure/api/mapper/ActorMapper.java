package de.moviereview.infrastructure.api.mapper;

import de.moviereview.domain.model.Actor;
import de.moviereview.infrastructure.api.dto.ActorDTO;
import de.moviereview.infrastructure.persistence.entity.ActorEntity;

import java.util.stream.Collectors;

public class ActorMapper {

    public static Actor toModel(ActorEntity entity) {
        if (entity == null) {
            throw new IllegalArgumentException("ActorEntity cannot be null");
        }
        return new Actor(
                entity.getId(),
                entity.getLastName(),
                entity.getFirstName(),
                entity.getBirthday(),
                entity.getHeritage(),
                entity.getMovies() != null ? entity.getMovies().stream().map(MovieMapper::toModel).collect(Collectors.toSet()) : null
        );
    }

    public static ActorEntity toEntity(Actor model) {
        if (model == null) {
            throw new IllegalArgumentException("Actor model cannot be null");
        }
        ActorEntity entity = new ActorEntity();
        entity.setId(model.getId());
        entity.setLastName(model.getLastName());
        entity.setFirstName(model.getFirstName());
        entity.setBirthday(model.getBirthday());
        entity.setHeritage(model.getHeritage());
        entity.setMovies(model.getMovies() != null ? model.getMovies().stream().map(MovieMapper::toEntity).collect(Collectors.toSet()) : null);
        return entity;
    }

    public static ActorDTO toDto(Actor model) {
        if (model == null) {
            throw new IllegalArgumentException("Actor model cannot be null");
        }
        ActorDTO dto = new ActorDTO();
        dto.setId(model.getId());
        dto.setLastname(model.getLastName());
        dto.setFirstname(model.getFirstName());
        dto.setBirthday(model.getBirthday());
        dto.setHeritage(model.getHeritage());
        dto.setMovieIds(model.getMovies() != null ? model.getMovies().stream().map(movie -> movie.getId()).collect(Collectors.toSet()) : null);
        return dto;
    }

    public static Actor toModel(ActorDTO dto) {
        if (dto == null) {
            throw new IllegalArgumentException("ActorDTO cannot be null");
        }
        return new Actor(
                dto.getId(),
                dto.getLastname(),
                dto.getFirstname(),
                dto.getBirthday(),
                dto.getHeritage(),
                null // Mapping movie IDs to Movies should be handled separately
        );
    }
}
