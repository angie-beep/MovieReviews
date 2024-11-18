package de.moviereview.infrastructure.api.mapper;

import de.moviereview.domain.model.Director;
import de.moviereview.infrastructure.api.dto.DirectorDTO;
import de.moviereview.infrastructure.persistence.entity.DirectorEntity;

import java.util.stream.Collectors;

public class DirectorMapper {

    public static Director toModel(DirectorEntity entity) {
        if (entity == null) {
            return null;
        }
        return new Director(
                entity.getId(),
                entity.getLastName(),
                entity.getFirstName(),
                entity.getBirthday(),
                entity.getHeritage(),
                entity.getMovies().stream().map(MovieMapper::toModel).collect(Collectors.toSet())
        );
    }

    public static DirectorEntity toEntity(Director model) {
        if (model == null) {
            return null;
        }
        DirectorEntity entity = new DirectorEntity();
        entity.setId(model.getId());
        entity.setLastName(model.getLastName());
        entity.setFirstName(model.getFirstName());
        entity.setBirthday(model.getBirthday());
        entity.setHeritage(model.getHeritage());
        entity.setMovies(model.getMovies().stream().map(MovieMapper::toEntity).collect(Collectors.toSet()));
        return entity;
    }

    public static DirectorDTO toDto(Director model) {
        if (model == null) {
            return null;
        }
        DirectorDTO dto = new DirectorDTO();
        dto.setId(model.getId());
        dto.setLastname(model.getLastName());
        dto.setFirstname(model.getFirstName());
        dto.setBirthday(model.getBirthday());
        dto.setHeritage(model.getHeritage());
        dto.setMovieIds(model.getMovies().stream().map(movie -> movie.getId()).collect(Collectors.toSet()));
        return dto;
    }

    public static Director toModel(DirectorDTO dto) {
        if (dto == null) {
            return null;
        }
        return new Director(
                dto.getId(),
                dto.getLastname(),
                dto.getFirstname(),
                dto.getBirthday(),
                dto.getHeritage(),
                null // Mapping movie IDs to Movie objects should be handled elsewhere
        );
    }
}
